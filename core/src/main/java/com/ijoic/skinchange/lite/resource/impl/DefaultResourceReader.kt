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

/**
 * Default resource reader
 *
 * @author verstsiu created at 2020-12-03 11:23
 */
internal class DefaultResourceReader(context: Context) : ResourceReader(context) {

  override fun getBoolOrNull(resId: Int): Boolean? {
    return fetchBoolOrNull(resId)
  }

  override fun getColorOrNull(resId: Int): Int? {
    return fetchColorOrNull(resId)
  }

  override fun getColorListOrNull(resId: Int): ColorStateList? {
    return fetchColorListOrNull(resId)
  }

  override fun getDrawableOrNull(resId: Int): Drawable? {
    return fetchDrawableOrNull(resId)
  }

  override fun getAttrResId(resId: Int): Int {
    return resId
  }

  override fun getColorResId(resId: Int): Int {
    return resId
  }

  override fun getColorListResId(resId: Int): Int {
    return resId
  }

  override fun getDrawableResId(resId: Int): Int {
    return resId
  }

  override fun getLayoutResId(resId: Int): Int {
    return resId
  }

  override fun getMenuResId(resId: Int): Int {
    return resId
  }

  override fun getStyleResId(resId: Int): Int {
    return resId
  }

  override fun wrapResName(resName: String): String {
    return resName
  }

}