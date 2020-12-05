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
package com.ijoic.skinchange.lite.view.attr

import com.ijoic.skinchange.lite.view.attr.impl.*
import com.ijoic.skinchange.lite.view.attr.impl.BackgroundAttrType
import com.ijoic.skinchange.lite.view.attr.impl.IndeterminateDrawableAttrType
import com.ijoic.skinchange.lite.view.attr.impl.ProgressDrawableAttrType
import com.ijoic.skinchange.lite.view.attr.impl.SrcAttrType
import com.ijoic.skinchange.lite.view.attr.impl.TextColorAttrType

/**
 * Attribute type factory
 *
 * @author verstsiu created at 2020-12-04 22:17
 */
internal object AttrTypeFactory {

  private const val BACKGROUND = "background"
  private const val BUTTON = "button"
  private const val CHECK_MARK = "checkMark"
  private const val DIVIDER = "divider"
  private const val DRAWABLE_LEFT = "drawableLeft"
  private const val DRAWABLE_TOP = "drawableTop"
  private const val DRAWABLE_RIGHT = "drawableRight"
  private const val DRAWABLE_BOTTOM = "drawableBottom"
  private const val INDETERMINATE_DRAWABLE = "indeterminateDrawable"
  private const val LIST_SELECTOR = "listSelector"
  private const val POPUP_BACKGROUND = "popupBackground"
  private const val PROGRESS_DRAWABLE = "progressDrawable"
  private const val SHADOW_COLOR = "shadowColor"
  private const val SRC = "src"
  private const val TEXT_COLOR = "textColor"
  private const val TEXT_COLOR_HIGHLIGHT = "textColorHighlight"
  private const val TEXT_COLOR_HINT = "textColorHint"
  private const val TEXT_COLOR_LINK = "textColorLink"
  private const val THUMB = "thumb"
  private const val TRACK = "track"

  private val attrMap = mutableMapOf(
    BACKGROUND to BackgroundAttrType,
    BUTTON to ButtonAttrType,
    CHECK_MARK to CheckMarkAttrType,
    DIVIDER to DividerAttrType,
    DRAWABLE_LEFT to DrawableLeftAttrType,
    DRAWABLE_TOP to DrawableTopAttrType,
    DRAWABLE_RIGHT to DrawableRightAttrType,
    DRAWABLE_BOTTOM to DrawableBottomAttrType,
    INDETERMINATE_DRAWABLE to IndeterminateDrawableAttrType,
    LIST_SELECTOR to ListSelectorAttrType,
    POPUP_BACKGROUND to PopupBackgroundAttrType,
    PROGRESS_DRAWABLE to ProgressDrawableAttrType,
    SHADOW_COLOR to ShadowColorAttrType,
    SRC to SrcAttrType,
    TEXT_COLOR to TextColorAttrType,
    TEXT_COLOR_HIGHLIGHT to TextColorHighlightAttrType,
    TEXT_COLOR_HINT to TextColorHintAttrType,
    TEXT_COLOR_LINK to TextColorLinkAttrType,
    THUMB to ThumbAttrType,
    TRACK to TrackAttrType
  )

  /**
   * Returns attr type instance of attribute [name]
   */
  fun getAttrTypeOrNull(name: String): AttrType? {
    return attrMap[name]
  }
}