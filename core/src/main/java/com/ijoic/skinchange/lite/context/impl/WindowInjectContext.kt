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

import android.app.Activity
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Window inject context
 *
 * @author verstsiu created at 2020-12-02 20:16
 */
object WindowInjectContext {
  /**
   * Inject status bar color with [resId]
   */
  fun <T: Activity> InjectContext<T>.injectStatusBarColor(@ColorRes resId: Int): InjectContext<T> {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
      val window = component.window
      if (window != null) {
        val color = reader.getColor(resId)
        if (color != null) {
          window.statusBarColor = color
        }
      }
    }
    return this
  }

  /**
   * Inject status bar color with [resId]
   */
  fun <T: Activity> InjectContext<T>.injectWindowBackground(@DrawableRes resId: Int): InjectContext<T> {
    component.window?.decorView?.setBackgroundResource(reader.getDrawableResId(resId))
    return this
  }
}