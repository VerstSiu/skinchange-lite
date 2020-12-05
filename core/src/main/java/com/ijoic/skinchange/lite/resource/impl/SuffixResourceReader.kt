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
package com.ijoic.skinchange.lite.resource.impl

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.resource.constants.ResCategory

/**
 * Suffix resource reader
 *
 * @author verstsiu created at 2020-12-03 11:32
 */
internal class SuffixResourceReader(
  private val suffix: String,
  context: Context
) : ResourceReader(context) {

  override fun getBoolOrNull(resId: Int): Boolean? {
    val resultId = measureResIdOrNull(resId, ResCategory.BOOL) ?: return null
    return fetchBoolOrNull(resultId)
  }

  override fun getColorOrNull(resId: Int): Int? {
    val resultId = measureResIdOrNull(resId, ResCategory.COLOR) ?: return null
    return fetchColorOrNull(resultId)
  }

  override fun getColorListOrNull(resId: Int): ColorStateList? {
    val resultId = measureResIdOrNull(resId, ResCategory.COLOR_LIST) ?: return null
    return fetchColorListOrNull(resultId)
  }

  override fun getDrawableOrNull(resId: Int): Drawable? {
    val resultId = measureResIdOrNull(resId, ResCategory.DRAWABLE) ?: return null
    return fetchDrawableOrNull(resultId)
  }

  override fun getDrawableResId(resId: Int): Int {
    return measureResIdOrNull(resId, ResCategory.DRAWABLE) ?: resId
  }

  override fun wrapResName(resName: String): String {
    return "${resName}_$suffix"
  }
}