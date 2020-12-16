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

import android.view.Window
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Window context
 *
 * @author verstsiu created at 2020-12-07 16:13
 */
object WindowContext {

  /**
   * Inject content view with [resId]
   */
  fun <T: Window> InjectContext<T>.injectContentView(@LayoutRes resId: Int): InjectContext<T> {
    val resultId = reader.getLayoutResId(resId)
    component.setContentView(resultId)
    return this
  }

  /**
   * Inject background drawable with [resId]
   */
  fun <T: Window> InjectContext<T>.injectBackgroundDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setBackgroundDrawableResource(resultId)
    return this
  }

  /**
   * Inject feature drawable with [resId]
   */
  fun <T: Window> InjectContext<T>.injectFeatureDrawable(featureId: Int, @DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setFeatureDrawableResource(featureId, resultId)
    return this
  }

  /**
   * Inject status bar color with [resId]
   */
  fun <T: Window> InjectContext<T>.injectStatusBarColor(@ColorRes resId: Int): InjectContext<T> {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
      val color = reader.getColorOrNull(resId)
      if (color != null) {
        component.statusBarColor = color
      }
    }
    return this
  }

  /**
   * Inject navigation bar color with [resId]
   */
  fun <T: Window> InjectContext<T>.injectNavigationBarColor(@ColorRes resId: Int): InjectContext<T> {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
      val color = reader.getColorOrNull(resId)
      if (color != null) {
        component.navigationBarColor = color
      }
    }
    return this
  }

  /**
   * Inject child drawable with [resId]
   */
  fun <T: Window> InjectContext<T>.injectChildDrawable(featureId: Int, @DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setChildDrawable(featureId, drawable)
    }
    return this
  }

}