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
package com.ijoic.skinchange.lite.util

import android.graphics.drawable.Drawable
import android.widget.TextView

/**
 * TextView helper
 *
 * @author verstsiu created at 2020-12-05 20:25
 */
internal object TextViewHelper {

  const val INDEX_LEFT = 0
  const val INDEX_TOP = 1
  const val INDEX_RIGHT = 2
  const val INDEX_BOTTOM = 3

  /**
   * Set compound [drawable] with [view] and [compoundIndex]
   */
  fun setCompoundDrawable(drawable: Drawable, view: TextView, compoundIndex: Int) {
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

}