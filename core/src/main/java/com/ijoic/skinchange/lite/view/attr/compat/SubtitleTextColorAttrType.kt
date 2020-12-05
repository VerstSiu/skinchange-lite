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
package com.ijoic.skinchange.lite.view.attr.compat

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.attr.AttrType

/**
 * Subtitle text color attribute type
 *
 * @author verstsiu created at 2020-12-05 21:55
 */
internal object SubtitleTextColorAttrType : AttrType {
  override fun inject(view: View, resName: String, reader: ResourceReader) {
    if (view !is Toolbar) {
      return
    }
    val colorList = reader.getColorListOrNull(resName)
    if (colorList != null) {
      view.setSubtitleTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resName) ?: return
      view.setSubtitleTextColor(color)
    }
  }
}