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
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.AnyRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import com.ijoic.skinchange.lite.resource.constants.ResCategory

/**
 * Resource reader
 *
 * @author verstsiu created at 2020-12-03 11:22
 */
abstract class ResourceReader internal constructor(private val context: Context) {

  /* Get Resource by resId */

  /**
   * Returns boolean value of [resId]
   */
  abstract fun getBoolOrNull(@BoolRes resId: Int): Boolean?

  /**
   * Returns color value of [resId]
   */
  abstract fun getColorOrNull(@ColorRes resId: Int): Int?

  /**
   * Returns color list value of [resId]
   */
  abstract fun getColorListOrNull(@ColorRes resId: Int): ColorStateList?

  /**
   * Returns drawable value of [resId]
   */
  abstract fun getDrawableOrNull(@DrawableRes resId: Int): Drawable?

  /* Get Resource by resId :END */

  /* Get Resource by resName */

  /**
   * Returns color value of [resName]
   */
  fun getColorOrNull(resName: String): Int? {
    val resId = measureResIdOrNull(wrapResName(resName), ResCategory.COLOR) ?: return null
    return fetchColorOrNull(resId)
  }

  /**
   * Returns color value of [resName]
   */
  fun getColorListOrNull(resName: String): Int? {
    val resId = measureResIdOrNull(wrapResName(resName), ResCategory.COLOR) ?: return null
    return fetchColorOrNull(resId)
  }

  /**
   * Returns drawable value of [resName]
   */
  fun getDrawableOrNull(resName: String): Drawable? {
    val resId = measureResIdOrNull(resName, ResCategory.DRAWABLE) ?: return null
    return fetchDrawableOrNull(resId)
  }

  /* Get Resource by resName :END */

  /* Get Resource ID by resId */

  /**
   * Returns mapped drawable resId
   */
  abstract fun getDrawableResId(@DrawableRes resId: Int): Int

  /* Get Resource ID by resId :END */

  /* Get Resource ID by resName */

  /**
   * Returns mapped drawable resId
   */
  fun getDrawableResIdOrNull(resName: String): Int? {
    return measureResIdOrNull(wrapResName(resName), ResCategory.DRAWABLE)
  }

  /* Get Resource ID by resName :END */

  /* Fetch Resource */

  private val boolCache = mutableMapOf<Int, Boolean>()
  private val colorCache = mutableMapOf<Int, Int>()

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
      val resources = context.resources ?: return null
      color = this.runCatching { ResourcesCompat.getColor(resources, resId, null) }.getOrNull()
        ?.also { colorCache[resId] = it }
    }
    return color
  }

  /**
   * Returns fetched color list or null
   */
  protected fun fetchColorListOrNull(@ColorRes resId: Int): ColorStateList? {
    if (resId == 0) {
      return null
    }
    return this.runCatching { AppCompatResources.getColorStateList(context, resId) }.getOrNull()
  }

  /**
   * Returns fetched drawable or null
   */
  protected fun fetchDrawableOrNull(@DrawableRes resId: Int): Drawable? {
    if (resId == 0) {
      return null
    }
    return this.runCatching { AppCompatResources.getDrawable(context, resId) }.getOrNull()
  }

  /**
   * Returns measured suffix resId or null
   */
  private fun measureResIdOrNull(resName: String, category: String, vararg defTypes: String): Int? {
    val cacheId = readResIdFromCache(resName, category)
    if (cacheId != null) {
      return cacheId
    }
    val resources = context.resources ?: return null
    var resultId = 0

    try {
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
      writeResIdToCache(resName, category, resultId)
      return resultId
    }
    return null
  }

  /* Fetch Resource :END */

  /* Measure Resource ID */

  private val idCache = mutableMapOf<Int, Int>()
  private val resCache = mutableMapOf<String, MutableMap<String, Int>>()

  /**
   * Returns measured suffix resId or null
   */
  internal fun measureResIdOrNull(@AnyRes resId: Int, category: ResCategory): Int? {
    if (resId == 0) {
      return null
    }
    val measuredId = idCache[resId]
    if (measuredId != null) {
      return measuredId
    }
    val resources = context.resources ?: return null
    val resName = resources.runCatching { getResourceName(resId) }.getOrNull()?.let(this::wrapResName) ?: return null
    val resultId = measureResIdOrNull(resName, category)

    if (resultId != null) {
      idCache[resId] = resultId
      return resultId
    }
    return null
  }

  private fun measureResIdOrNull(resName: String, category: ResCategory): Int? {
    return measureResIdOrNull(resName, category.name, *category.defTypes)
  }

  private fun readResIdFromCache(resName: String, category: String): Int? {
    return resCache[category]?.get(resName)
  }

  private fun writeResIdToCache(resName: String, category: String, resId: Int) {
    val cacheMap = resCache.getOrPut(category) { mutableMapOf() }
    cacheMap[resName] = resId
  }

  /* Measure Resource ID :END */

  /**
   * Wrap [resName]
   */
  protected abstract fun wrapResName(resName: String): String

}