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
package com.ijoic.skinchange.lite.resource

import android.content.Context
import com.ijoic.skinchange.lite.SkinManager
import com.ijoic.skinchange.lite.resource.impl.DefaultResourceReader
import com.ijoic.skinchange.lite.resource.impl.SuffixResourceReader

/**
 * Resource manager
 *
 * @author verstsiu created at 2020-12-03 11:25
 */
internal class ResourceManager(private val context: Context) {
  private val readerMap = mutableMapOf<String, ResourceReader>()

  /**
   * Returns reader instance of skin [suffix]
   */
  fun getReader(suffix: String): ResourceReader {
    return readerMap.getOrPut(suffix) {
      if (suffix == SkinManager.DEFAULT_SKIN_SUFFIX) {
        DefaultResourceReader(context)
      } else {
        SuffixResourceReader(suffix, context)
      }
    }
  }
}