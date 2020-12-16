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

import android.content.Context
import android.widget.Switch
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * Switch context
 *
 * @author verstsiu created at 2020-12-05 20:38
 */
object SwitchContext {
  /**
   * Inject switch text appearance with [resId]
   */
  fun <T: Switch> InjectContext<T>.injectSwitchTextAppearance(context: Context, @StyleRes resId: Int): InjectContext<T> {
    val resultId = reader.getStyleResId(resId)
    component.setSwitchTextAppearance(context, resultId)
    return this
  }

  /**
   * Inject thumb with [resId]
   */
  fun <T: Switch> InjectContext<T>.injectThumb(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setThumbResource(resultId)
    return this
  }

  /**
   * Inject track with [resId]
   */
  fun <T: Switch> InjectContext<T>.injectTrack(@DrawableRes resId: Int): InjectContext<T> {
    val resultId = reader.getDrawableResId(resId)
    component.setTrackResource(resultId)
    return this
  }
}