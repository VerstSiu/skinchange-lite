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

import android.widget.Spinner
import androidx.annotation.DrawableRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Spinner context
 *
 * @author verstsiu created at 2020-12-05 20:45
 */
object SpinnerContext {
  /**
   * Inject popup background with [resId]
   */
  fun <T: Spinner> InjectContext<T>.injectPopupBackground(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setPopupBackgroundResource(resultId)
    return this
  }
}