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
package com.ijoic.skinchange.lite.context.impl

import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Image view context
 *
 * @author verstsiu created at 2020-12-05 20:17
 */
class ImageViewContext {
  /**
   * Inject image resource with [resId]
   */
  fun <T: ImageView> InjectContext<T>.injectImageResource(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setImageResource(resultId)
    return this
  }

  /**
   * Inject image resource with [resId]
   */
  fun <T: ImageView> InjectContext<T>.injectColorFilter(@ColorRes resId: Int, mode: PorterDuff.Mode? = null): InjectContext<T> {
    val color = reader.getColorOrNull(resId)
    if (color != null) {
      if (mode != null) {
        component.setColorFilter(color, mode)
      } else {
        component.setColorFilter(color)
      }
    }
    return this
  }
}