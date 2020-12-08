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
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * CollapsingToolbarLayout context
 *
 * @author verstsiu created at 2020-12-07 11:31
 */
object CollapsingToolbarLayoutContext {

  /**
   * Inject content scrim with [resId]
   */
  fun <T: CollapsingToolbarLayout> InjectContext<T>.injectContentScrim(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setContentScrimResource(resultId)
    return this
  }

  /**
   * Inject status bar scrim with [resId]
   */
  fun <T: CollapsingToolbarLayout> InjectContext<T>.injectStatusBarScrim(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setStatusBarScrimResource(resultId)
    return this
  }

  /**
   * Inject collapsed title text appearance with [resId]
   */
  fun <T: CollapsingToolbarLayout> InjectContext<T>.injectCollapsedTitleTextAppearance(@StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.setCollapsedTitleTextAppearance(resultId)
    return this
  }

  /**
   * Inject collapsed title text color with [resId]
   */
  fun <T: CollapsingToolbarLayout> InjectContext<T>.injectCollapsedTitleTextColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setCollapsedTitleTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setCollapsedTitleTextColor)
    }
    return this
  }

  /**
   * Inject expanded title text appearance with [resId]
   */
  fun <T: CollapsingToolbarLayout> InjectContext<T>.injectExpandedTitleTextAppearance(@StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.setExpandedTitleTextAppearance(resultId)
    return this
  }

  /**
   * Inject expanded title text color with [resId]
   */
  fun <T: CollapsingToolbarLayout> InjectContext<T>.injectExpandedTitleTextColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setExpandedTitleTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setExpandedTitleColor)
    }
    return this
  }

}