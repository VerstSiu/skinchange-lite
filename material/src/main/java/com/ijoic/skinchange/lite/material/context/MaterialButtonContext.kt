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
package com.ijoic.skinchange.lite.material.context

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.google.android.material.button.MaterialButton
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * MaterialButton context
 *
 * @author verstsiu created at 2020-12-07 21:00
 */
object MaterialButtonContext {

  /**
   * Inject icon resource with [resId]
   */
  fun <T: MaterialButton> InjectContext<T>.injectIconResource(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setIconResource(resultId)
    return this
  }

  /**
   * Inject icon tint resource with [resId]
   */
  fun <T: MaterialButton> InjectContext<T>.injectIconTintResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setIconTintResource(resultId)
    return this
  }

  /**
   * Inject ripple color resource with [resId]
   */
  fun <T: MaterialButton> InjectContext<T>.injectRippleColorResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setRippleColorResource(resultId)
    return this
  }

  /**
   * Inject stroke color resource with [resId]
   */
  fun <T: MaterialButton> InjectContext<T>.injectStrokeColorResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setStrokeColorResource(resultId)
    return this
  }

}