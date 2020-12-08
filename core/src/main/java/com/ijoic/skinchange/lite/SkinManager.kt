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
package com.ijoic.skinchange.lite

import android.content.Context
import android.view.View
import com.ijoic.skinchange.lite.context.InjectContext
import com.ijoic.skinchange.lite.resource.ResourceManager
import com.ijoic.skinchange.lite.view.ViewManager
import com.ijoic.skinchange.lite.view.attr.AttrTypeFactory
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
 * Skin manager
 *
 * @author verstsiu created at 2020-12-02 20:10
 */
class SkinManager @Inject constructor(
  @ActivityContext context: Context,
  factory: AttrTypeFactory
) {

  private val resourceManager = ResourceManager(context)
  private val viewManager = ViewManager(factory)

  private var suffix: String = DEFAULT_SKIN_SUFFIX

  /**
   * Bind skin [suffix]
   */
  fun bindSuffix(suffix: String): SkinManager {
    this.suffix = suffix
    return this
  }

  /**
   * Inject with [component]
   */
  fun <T> injectWith(component: T): InjectContext<T> {
    val reader = resourceManager.getReader(suffix)
    return InjectContext(viewManager, component, reader)
  }

  /**
   * Inject [view] with current skin suffix
   */
  fun injectView(view: View): SkinManager {
    val suffix = this.suffix.takeIf { it != DEFAULT_SKIN_SUFFIX } ?: return this
    val reader = resourceManager.getReader(suffix)
    viewManager.inject(view, reader)
    return this
  }

  /**
   * Inject optional with [component] and [func] callback
   */
  fun <T> injectOptional(component: T?, func: (InjectContext<T>) -> Unit): SkinManager {
    if (component != null) {
      val reader = resourceManager.getReader(suffix)
      func.invoke(InjectContext(viewManager, component, reader))
    }
    return this
  }

  /**
   * Inject optional with [view]
   */
  fun injectOptional(view: View?): SkinManager {
    view?.let(this::injectView)
    return this
  }

  companion object {
    internal const val DEFAULT_SKIN_SUFFIX = ""
  }
}