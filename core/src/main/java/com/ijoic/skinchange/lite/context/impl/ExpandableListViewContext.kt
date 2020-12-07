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

import android.widget.ExpandableListView
import androidx.annotation.DrawableRes
import com.ijoic.skinchange.lite.context.InjectContext

/**
 * ExpandableListView context
 *
 * @author verstsiu created at 2020-12-07 17:02
 */
class ExpandableListViewContext {
  /**
   * Inject child divider with [resId]
   */
  fun <T: ExpandableListView> InjectContext<T>.injectChildDivider(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setChildDivider(drawable)
    }
    return this
  }

  /**
   * Inject child indicator with [resId]
   */
  fun <T: ExpandableListView> InjectContext<T>.injectChildIndicator(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setChildIndicator(drawable)
    }
    return this
  }

  /**
   * Inject group indicator with [resId]
   */
  fun <T: ExpandableListView> InjectContext<T>.injectGroupIndicator(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setGroupIndicator(drawable)
    }
    return this
  }
}