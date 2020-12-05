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
package com.ijoic.skinchange.lite.resource.constants

/**
 * Resource category
 *
 * @author verstsiu created at 2020-12-05 11:41
 */
internal enum class ResCategory(
  val defTypes: Array<String>
) {

  /**
   * Drawable
   */
  DRAWABLE(arrayOf(DefTypes.MIPMAP, DefTypes.DRAWABLE, DefTypes.COLOR)),

  /**
   * Color list
   */
  COLOR_LIST(arrayOf(DefTypes.DRAWABLE, DefTypes.COLOR)),

  /**
   * Color
   */
  COLOR(arrayOf(DefTypes.COLOR)),

  /**
   * Bool
   */
  BOOL(arrayOf(DefTypes.BOOL))

}