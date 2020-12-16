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

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.Toolbar
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Toolbar context
 *
 * @author verstsiu created at 2020-12-05 21:51
 */
object ToolbarContext {

  /**
   * Inject popup theme with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectPopupTheme(@StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.popupTheme = resultId
    return this
  }

  /**
   * Inject title text appearance with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectTitleTextAppearance(context: Context, @StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.setTitleTextAppearance(context, resultId)
    return this
  }

  /**
   * Inject subtitle text appearance with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectSubtitleTextAppearance(context: Context, @StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.setSubtitleTextAppearance(context, resultId)
    return this
  }

  /**
   * Inject menu with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectMenu(@MenuRes resId: Int): InjectContext<T> {
    val resultId = reader.getMenuResId(resId)
    component.inflateMenu(resultId)
    return this
  }

  /**
   * Inject logo with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectLogo(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setLogo(resultId)
    return this
  }

  /**
   * Inject navigation icon with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectNavigationIcon(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setNavigationIcon(resultId)
    return this
  }

  /**
   * Inject collapse icon with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectCollapseIcon(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setCollapseIcon(resultId)
    return this
  }

  /**
   * Inject overflow icon with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectOverflowIcon(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.overflowIcon = drawable
    }
    return this
  }

  /**
   * Inject title text color with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectTitleTextColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setTitleTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setTitleTextColor)
    }
    return this
  }

  /**
   * Inject subtitle text color with [resId]
   */
  fun <T: Toolbar> InjectContext<T>.injectSubtitleTextColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setSubtitleTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setSubtitleTextColor)
    }
    return this
  }

}