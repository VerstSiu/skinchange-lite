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
import androidx.annotation.AnyRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Resource reader
 *
 * @author verstsiu created at 2020-12-03 11:22
 */
internal abstract class ResourceReader(private val context: Context) {

  private val idCache = mutableMapOf<Int, Int>()
  private val boolCache = mutableMapOf<Int, Boolean>()
  private val colorCache = mutableMapOf<Int, Int>()

  /**
   * Returns boolean value of [resId]
   */
  abstract fun getBool(@BoolRes resId: Int): Boolean?

  /**
   * Returns color value of [resId]
   */
  abstract fun getColor(@ColorRes resId: Int): Int?

  /**
   * Returns mapped drawable resId
   */
  abstract fun getDrawableResId(@DrawableRes resId: Int): Int

  /**
   * Returns fetched bool or null
   */
  protected fun fetchBoolOrNull(@BoolRes resId: Int): Boolean? {
    if (resId == 0) {
      return null
    }
    var bool = boolCache[resId]

    if (bool == null) {
      bool = context.resources?.runCatching { getBoolean(resId) }?.getOrNull()
        ?.also { boolCache[resId] = it }
    }
    return bool
  }

  /**
   * Returns fetched color or null
   */
  protected fun fetchColorOrNull(@ColorRes resId: Int): Int? {
    if (resId == 0) {
      return null
    }
    var color = colorCache[resId]

    if (color == null) {
      color = context.resources?.runCatching { getColor(resId) }?.getOrNull()
        ?.also { colorCache[resId] = it }
    }
    return color
  }

  /**
   * Returns measured suffix resId or null
   */
  protected fun measureSuffixResIdOrNull(suffix: String, @AnyRes resId: Int, vararg defTypes: String): Int? {
    val measuredId = idCache[resId]
    if (measuredId != null) {
      return measuredId
    }
    val resources = context.resources ?: return null
    var resultId = 0

    try {
      val resName = resources.getResourceName(resId)?.let { "${it}_$suffix" } ?: return null
      when(defTypes.size) {
        0 -> {
          resultId = resources.getIdentifier(resName, null, context.packageName)
        }
        1 -> {
          resultId = resources.getIdentifier(resName, defTypes.first(), context.packageName)
        }
        else -> {
          lookupResultResId@for (type in defTypes) {
            resultId = resources.getIdentifier(resName, type, context.packageName)
            if (resultId != 0) {
              break@lookupResultResId
            }
          }
          if (resultId == 0) {
            resultId = resources.getIdentifier(resName, null, context.packageName)
          }
        }
      }

    } catch (e: Exception) {
      // ignore exception
    }

    if (resultId != 0) {
      idCache[resId] = resultId
      return resultId
    }
    return null
  }
}