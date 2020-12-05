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
package com.ijoic.skinchange.lite.view.attr.base

import android.view.View
import android.widget.TextView
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.attr.AttrType

/**
 * Compound drawable attribute type
 *
 * @author verstsiu created at 2020-12-05 16:39
 */
internal abstract class CompoundDrawableAttrType(private val compoundIndex: Int) : AttrType {

  override fun inject(view: View, resName: String, reader: ResourceReader) {
    if (view !is TextView) {
      return
    }
    val drawable = reader.getDrawableOrNull(resName) ?: return
    val drawables = view.compoundDrawables

    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    drawables[compoundIndex] = drawable

    view.setCompoundDrawables(
      drawables[INDEX_LEFT],
      drawables[INDEX_TOP],
      drawables[INDEX_RIGHT],
      drawables[INDEX_BOTTOM]
    )
  }

  protected companion object {
    const val INDEX_LEFT = 0
    const val INDEX_TOP = 1
    const val INDEX_RIGHT = 2
    const val INDEX_BOTTOM = 3
  }
}