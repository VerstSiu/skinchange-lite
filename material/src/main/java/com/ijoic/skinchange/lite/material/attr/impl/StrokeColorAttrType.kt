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
package com.ijoic.skinchange.lite.material.attr.impl

import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.attr.AttrType

/**
 * Stroke color attribute type
 *
 * @author verstsiu created at 2020-12-07 21:12
 */
internal object StrokeColorAttrType : AttrType {
  override fun inject(view: View, resName: String, reader: ResourceReader): Boolean {
    when(view) {
      is MaterialButton -> {
        val resId = reader.getColorListResIdOrNull(resName) ?: return false
        view.setStrokeColorResource(resId)
        return true
      }
      is MaterialCardView -> {
        val colorList = reader.getColorListOrNull(resName)
        if (colorList != null) {
          view.setStrokeColor(colorList)
        } else {
          val color = reader.getColorOrNull(resName)
          color?.let(view::setStrokeColor)
        }
      }
    }
    return false
  }
}