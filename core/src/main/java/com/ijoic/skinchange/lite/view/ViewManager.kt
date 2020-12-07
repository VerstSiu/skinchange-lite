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
package com.ijoic.skinchange.lite.view

import android.view.View
import android.view.ViewGroup
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.attr.AttrTypeFactory

/**
 * View manager
 *
 * @author verstsiu created at 2020-12-04 22:17
 */
internal class ViewManager(private val factory: AttrTypeFactory) {

  /**
   * Inject [view] with resource [reader]
   */
  fun inject(view: View, reader: ResourceReader) {
    performSkinChange(view, reader)

    if (view is ViewGroup && view.childCount > 0) {
      for (index in 0 until view.childCount) {
        inject(view.getChildAt(index), reader)
      }
    }
  }

  private fun performSkinChange(view: View, reader: ResourceReader) {
    val tag = view.tag?.toString() ?: return
    val segments = tag.split("|")
      .filter { it.isNotEmpty() }
      .takeIf { it.isNotEmpty() } ?: return

    for (segment in segments) {
      val params = segment.split(":")
      if (params.size < MIN_PARAM_SIZE || params[0] != SCOPE_BASE) {
        continue
      }
      val type = params[2].takeIf { it.isNotEmpty() } ?: continue
      val attr = factory.getAttrTypeOrNull(type) ?: continue
      val resName = params[1].takeIf { it.isNotEmpty() } ?: continue

      attr.inject(view, resName, reader)
    }
  }

  private companion object {
    private const val SCOPE_BASE = "skin"
    private const val MIN_PARAM_SIZE = 3
  }
}