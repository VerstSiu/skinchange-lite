/*
 *
 *  Copyright(c) 2020-2021 VerstSiu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.ijoic.skinchange.lite.view.attr

import com.ijoic.skinchange.lite.view.attr.base.MultiMatchAttrType

/**
 * Attribute type factory
 *
 * @author verstsiu created at 2020-12-04 22:17
 */
class AttrTypeFactory(vararg extraModules: AttrModule) {

  private val typeCache: Map<String, AttrType>

  init {
    val defaultTypeMap = DefaultAttrModule.typeMap

    if (extraModules.isEmpty()) {
      typeCache = defaultTypeMap
    } else {
      val cacheMap = mutableMapOf<String, MutableList<AttrType>>()

      for (module in extraModules) {
        for ((attr, type) in module.typeMap) {
          var typeItems = cacheMap[attr]
          if (typeItems == null) {
            typeItems = mutableListOf()
            defaultTypeMap[attr]?.let(typeItems::add)
            cacheMap[attr] = typeItems
          }
          typeItems.add(type)
        }
      }
      val resultTypeMap = mutableMapOf<String, AttrType>()
      resultTypeMap.putAll(defaultTypeMap)

      for ((attr, typeItems) in cacheMap) {
        when(typeItems.size) {
          0 -> continue
          1 -> resultTypeMap[attr] = typeItems.first()
          else -> resultTypeMap[attr] = MultiMatchAttrType(typeItems)
        }
      }
      typeCache = resultTypeMap
    }
  }

  /**
   * Returns attr type instance of attribute [name]
   */
  internal fun getAttrTypeOrNull(name: String): AttrType? {
    return typeCache[name]
  }

}