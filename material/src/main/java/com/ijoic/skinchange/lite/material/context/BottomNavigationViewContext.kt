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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * BottomNavigationView context
 *
 * @author verstsiu created at 2020-12-07 20:41
 */
object BottomNavigationViewContext {

  /**
   * Inject item text appearance active with [resId]
   */
  fun <T: BottomNavigationView> InjectContext<T>.injectItemTextAppearanceActive(@StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.itemTextAppearanceActive = resultId
    return this
  }

  /**
   * Inject item text appearance inactive with [resId]
   */
  fun <T: BottomNavigationView> InjectContext<T>.injectItemTextAppearanceInactive(@StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.itemTextAppearanceInactive = resultId
    return this
  }

  /**
   * Inject item background with [resId]
   */
  fun <T: BottomNavigationView> InjectContext<T>.injectItemBackground(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.itemBackgroundResource = resultId
    return this
  }

  /**
   * Inject item icon tint list with [resId]
   */
  fun <T: BottomNavigationView> InjectContext<T>.injectItemIconTintList(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.itemIconTintList = colorList
    }
    return this
  }

  /**
   * Inject item text color with [resId]
   */
  fun <T: BottomNavigationView> InjectContext<T>.injectItemTextColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.itemTextColor = colorList
    }
    return this
  }

  /**
   * Inject item ripple color with [resId]
   */
  fun <T: BottomNavigationView> InjectContext<T>.injectItemRippleColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.itemRippleColor = colorList
    }
    return this
  }

}