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

import androidx.annotation.DrawableRes
import com.google.android.material.appbar.AppBarLayout
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * AppBarLayout context
 *
 * @author verstsiu created at 2020-12-05 19:46
 */
object AppBarLayoutContext {

  /**
   * Inject status bar foreground with [resId]
   */
  fun <T: AppBarLayout> InjectContext<T>.injectStatusBarForeground(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setStatusBarForegroundResource(resultId)
    return this
  }

}