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
package com.ijoic.skinchange.lite.context

import android.view.View
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.ViewManager

/**
 * Inject context
 *
 * @author verstsiu created at 2020-12-02 20:16
 */
class InjectContext<T> internal constructor(
  private val viewManager: ViewManager,
  val component: T,
  val reader: ResourceReader
) {

  /**
   * Inject with [component]
   */
  fun <R> injectWith(component: R): InjectContext<R> {
    return InjectContext(viewManager, component, reader)
  }

  /**
   * Inject [view]
   */
  fun injectView(view: View): InjectContext<T> {
    viewManager.inject(view, reader)
    return this
  }

  /**
   * Inject optional with [component] and [func] callback
   */
  fun <R> injectOptional(component: R?, func: InjectContext<R>.() -> Unit): InjectContext<T> {
    if (component != null) {
      func.invoke(InjectContext(viewManager, component, reader))
    }
    return this
  }

  /**
   * Inject optional with [view]
   */
  fun injectOptional(view: View?): InjectContext<T> {
    if (view != null) {
      viewManager.inject(view, reader)
    }
    return this
  }
}