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

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.ijoic.skinchange.lite.context.InjectContext
import com.ijoic.skinchange.lite.util.TextViewHelper

/**
 * TextView context
 *
 * @author verstsiu created at 2020-12-05 20:21
 */
class TextViewContext {

  /**
   * Inject error with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectError(error: CharSequence, @DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      component.setError(error, drawable)
    }
    return this
  }

  /**
   * Inject drawable left with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectDrawableLeft(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      TextViewHelper.setCompoundDrawable(drawable, component, TextViewHelper.INDEX_LEFT)
    }
    return this
  }

  /**
   * Inject drawable top with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectDrawableTop(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      TextViewHelper.setCompoundDrawable(drawable, component, TextViewHelper.INDEX_TOP)
    }
    return this
  }

  /**
   * Inject drawable right with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectDrawableRight(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      TextViewHelper.setCompoundDrawable(drawable, component, TextViewHelper.INDEX_RIGHT)
    }
    return this
  }

  /**
   * Inject drawable bottom with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectDrawableBottom(@DrawableRes resId: Int): InjectContext<T> {
    val drawable = reader.getDrawableOrNull(resId)
    if (drawable != null) {
      TextViewHelper.setCompoundDrawable(drawable, component, TextViewHelper.INDEX_BOTTOM)
    }
    return this
  }

  /**
   * Inject shadow color with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectShadowColor(@ColorRes resId: Int): InjectContext<T> {
    val color = reader.getColorOrNull(resId)
    if (color != null) {
      component.setShadowLayer(component.shadowRadius, component.shadowDx, component.shadowDy, color)
    }
    return this
  }

  /**
   * Inject text color with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectTextColor(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setTextColor)
    }
    return this
  }

  /**
   * Inject text color highlight with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectTextColorHighlight(@ColorRes resId: Int): InjectContext<T> {
    val color = reader.getColorOrNull(resId)
    color?.let(component::setHighlightColor)
    return this
  }

  /**
   * Inject text color hint with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectTextColorHint(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setHintTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setHintTextColor)
    }
    return this
  }

  /**
   * Inject text color link with [resId]
   */
  fun <T: TextView> InjectContext<T>.injectTextColorLink(@ColorRes resId: Int): InjectContext<T> {
    val colorList = reader.getColorListOrNull(resId)
    if (colorList != null) {
      component.setLinkTextColor(colorList)
    } else {
      val color = reader.getColorOrNull(resId)
      color?.let(component::setLinkTextColor)
    }
    return this
  }

}