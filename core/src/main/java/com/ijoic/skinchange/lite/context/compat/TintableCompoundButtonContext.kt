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
package com.ijoic.skinchange.lite.context.compat

import android.content.res.ColorStateList
import androidx.annotation.ColorRes
import androidx.core.widget.TintableCompoundButton
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * TintableCompoundButton context
 *
 * @author verstsiu created at 2020-12-07 19:48
 */
object TintableCompoundButtonContext {

  /**
   * Inject background tint list with [resId]
   */
  fun <T: TintableCompoundButton> InjectContext<T>.injectBackgroundTintList(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.supportButtonTintList = colorList
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let { component.supportButtonTintList = ColorStateList.valueOf(it) }
    }
    return this
  }

}