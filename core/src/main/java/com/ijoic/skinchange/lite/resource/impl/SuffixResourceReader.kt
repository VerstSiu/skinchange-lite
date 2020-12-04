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
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.resource.constants.DefTypes

/**
 * Suffix resource reader
 *
 * @author verstsiu created at 2020-12-03 11:32
 */
internal class SuffixResourceReader(
  private val suffix: String,
  context: Context
) : ResourceReader(context) {

  override fun getBool(resId: Int): Boolean? {
    val resultId = measureSuffixResIdOrNull(suffix, resId, DefTypes.BOOL) ?: return null
    return fetchBoolOrNull(resultId)
  }

  override fun getColor(resId: Int): Int? {
    val resultId = measureSuffixResIdOrNull(suffix, resId, DefTypes.COLOR) ?: return null
    return fetchColorOrNull(resultId)
  }

  override fun getDrawableResId(resId: Int): Int {
    if (resId == 0) {
      return resId
    }
    return measureSuffixResIdOrNull(suffix, resId, DefTypes.MIPMAP, DefTypes.DRAWABLE, DefTypes.COLOR) ?: resId
  }
}