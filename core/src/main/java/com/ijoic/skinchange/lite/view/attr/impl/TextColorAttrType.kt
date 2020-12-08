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
package com.ijoic.skinchange.lite.view.attr.impl

import android.view.View
import android.widget.TextView
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.attr.AttrType

/**
 * Text color attribute type
 *
 * @author verstsiu created at 2020-12-05 13:13
 */
internal object TextColorAttrType : AttrType {
  override fun inject(view: View, resName: String, reader: ResourceReader): Boolean {
    if (view !is TextView) {
      return false
    }
    val colorList = reader.getColorListOrNull(resName)
    if (colorList != null) {
      view.setTextColor(colorList)
      return true
    }
    val color = reader.getColorOrNull(resName) ?: return false
    view.setTextColor(color)
    return true
  }
}