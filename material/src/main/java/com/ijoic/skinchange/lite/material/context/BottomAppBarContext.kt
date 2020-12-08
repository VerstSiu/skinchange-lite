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
import androidx.annotation.MenuRes
import com.google.android.material.bottomappbar.BottomAppBar
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * BottomAppBar context
 *
 * @author verstsiu created at 2020-12-07 20:29
 */
object BottomAppBarContext {

  /**
   * Inject replace menu with [resId]
   */
  fun <T: BottomAppBar> InjectContext<T>.injectReplaceMenu(@MenuRes resId: Int): InjectContext<T> {
    val resultId = reader.getMenuResId(resId)
    component.replaceMenu(resultId)
    return this
  }

  /**
   * Inject background tint with [resId]
   */
  fun <T: BottomAppBar> InjectContext<T>.injectBackgroundTint(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.backgroundTint = colorList
    }
    return this
  }

}