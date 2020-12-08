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
import androidx.annotation.StyleRes
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Chip context
 *
 * @author verstsiu created at 2020-12-07 21:38
 */
object ChipContext {

  /**
   * Inject text appearance resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectTextAppearanceResource(@StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.setTextAppearanceResource(resultId)
    return this
  }

  /**
   * Inject ripple color resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectRippleColorResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setRippleColorResource(resultId)
    return this
  }

  /**
   * Inject checked icon resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectCheckedIconResource(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setCheckedIconResource(resultId)
    return this
  }

  /**
   * Inject checked icon tint resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectCheckedIconTintResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setCheckedIconTintResource(resultId)
    return this
  }

  /**
   * Inject close icon resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectCloseIconResource(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setCloseIconResource(resultId)
    return this
  }

  /**
   * Inject close icon tint resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectCloseIconTintResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setCloseIconTintResource(resultId)
    return this
  }

  /**
   * Inject chip icon resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectChipIconResource(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setChipIconResource(resultId)
    return this
  }

  /**
   * Inject chip icon tint resource with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectChipIconTintResource(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setChipIconTintResource(resultId)
    return this
  }

  /**
   * Inject chip drawable with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectChipDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null && drawable is ChipDrawable) {
      component.setChipDrawable(drawable)
    }
    return this
  }

  /**
   * Inject chip background color with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectChipBackgroundColor(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setChipBackgroundColorResource(resultId)
    return this
  }

  /**
   * Inject chip stroke color with [resId]
   */
  fun <T: Chip> InjectContext<T>.injectChipStrokeColor(@ColorRes resId: Int): InjectContext<T> {
    val resultId = reader.getColorListResId(resId)
    component.setChipStrokeColorResource(resultId)
    return this
  }

}