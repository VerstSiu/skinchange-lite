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

import androidx.annotation.DrawableRes
import androidx.appcompat.app.ActionBar
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * ActionBar context
 *
 * @author verstsiu created at 2020-12-05 19:46
 */
class ActionBarContext {
  /**
   * Inject background drawable with [resId]
   */
  fun <T: ActionBar> InjectContext<T>.injectBackgroundDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setBackgroundDrawable(drawable)
    }
    return this
  }

  /**
   * Inject icon with [resId]
   */
  fun <T: ActionBar> InjectContext<T>.injectIcon(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setIcon(resultId)
    return this
  }

  /**
   * Inject logo with [resId]
   */
  fun <T: ActionBar> InjectContext<T>.injectLogo(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setLogo(resultId)
    return this
  }

  /**
   * Inject home as up indicator with [resId]
   */
  fun <T: ActionBar> InjectContext<T>.injectHomeAsUpIndicator(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setHomeAsUpIndicator(resultId)
    return this
  }

  /**
   * Inject split background drawable with [resId]
   */
  fun <T: ActionBar> InjectContext<T>.injectSplitBackgroundDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setSplitBackgroundDrawable(drawable)
    }
    return this
  }

  /**
   * Inject stacked background drawable with [resId]
   */
  fun <T: ActionBar> InjectContext<T>.injectStackedBackgroundDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setStackedBackgroundDrawable(drawable)
    }
    return this
  }
}