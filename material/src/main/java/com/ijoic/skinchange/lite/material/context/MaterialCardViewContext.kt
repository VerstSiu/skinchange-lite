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
import com.google.android.material.card.MaterialCardView
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * MaterialCardView context
 *
 * @author verstsiu created at 2020-12-07 21:16
 */
object MaterialCardViewContext {

  /**
   * Inject checked icon resource with [resId]
   */
  fun <T: MaterialCardView> InjectContext<T>.injectCheckedIcon(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setCheckedIconResource(resultId)
    return this
  }

  /**
   * Inject checked icon tint with [resId]
   */
  fun <T: MaterialCardView> InjectContext<T>.injectCheckedIconTint(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.checkedIconTint = colorList
    }
    return this
  }

  /**
   * Inject card foreground color with [resId]
   */
  fun <T: MaterialCardView> InjectContext<T>.injectCardForegroundColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setCardForegroundColor(colorList)
    }
    return this
  }

  /**
   * Inject card background color with [resId]
   */
  fun <T: MaterialCardView> InjectContext<T>.injectCardBackgroundColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setCardBackgroundColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setCardBackgroundColor)
    }
    return this
  }

  /**
   * Inject stroke color with [resId]
   */
  fun <T: MaterialCardView> InjectContext<T>.injectStrokeColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setStrokeColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setStrokeColor)
    }
    return this
  }

  /**
   * Inject ripple color resource with [resId]
   */
  fun <T: MaterialCardView> InjectContext<T>.injectRippleColorResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setRippleColorResource(resultId)
    return this
  }

}