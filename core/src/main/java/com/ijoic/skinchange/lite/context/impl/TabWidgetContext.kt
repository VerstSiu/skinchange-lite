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

import android.widget.TabWidget
import androidx.annotation.DrawableRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * TabWidget context
 *
 * @author verstsiu created at 2020-12-07 17:54
 */
class TabWidgetContext {
  /**
   * Inject divider drawable with [resId]
   */
  fun <T: TabWidget> InjectContext<T>.injectDividerDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setDividerDrawable(resultId)
    return this
  }

  /**
   * Inject left scrip drawable with [resId]
   */
  fun <T: TabWidget> InjectContext<T>.injectLeftStripDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setLeftStripDrawable(resultId)
    return this
  }

  /**
   * Inject right scrip drawable with [resId]
   */
  fun <T: TabWidget> InjectContext<T>.injectRightStripDrawable(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setRightStripDrawable(resultId)
    return this
  }
}