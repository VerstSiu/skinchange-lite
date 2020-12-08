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

import com.ijoic.skinchange.lite.view.attr.compat.*
import com.ijoic.skinchange.lite.view.attr.impl.*

/**
 * Default attribute module
 *
 * @author verstsiu created at 2020-12-07 09:57
 */
internal object DefaultAttrModule : AttrModule {

  private const val BACKGROUND = "background"
  private const val BACKGROUND_TINT = "backgroundTint"
  private const val BUTTON = "button"
  private const val CHECK_MARK = "checkMark"
  private const val COLLAPSE_ICON = "collapseIcon"
  private const val DIVIDER = "divider"
  private const val DRAWABLE_LEFT = "drawableLeft"
  private const val DRAWABLE_TOP = "drawableTop"
  private const val DRAWABLE_RIGHT = "drawableRight"
  private const val DRAWABLE_BOTTOM = "drawableBottom"
  private const val INDETERMINATE_DRAWABLE = "indeterminateDrawable"
  private const val LIST_SELECTOR = "listSelector"
  private const val LOGO = "logo"
  private const val NAVIGATION_ICON = "navigationIcon"
  private const val POPUP_BACKGROUND = "popupBackground"
  private const val PROGRESS_DRAWABLE = "progressDrawable"
  private const val SHADOW_COLOR = "shadowColor"
  private const val SRC = "src"
  private const val SUBTITLE_TEXT_COLOR = "subtitleTextColor"
  private const val SWITCH_TEXT_APPEARANCE = "switchTextAppearance"
  private const val TAB_STRIP_LEFT = "tabStripLeft"
  private const val TAB_STRIP_RIGHT = "tabStripRight"
  private const val TEXT_COLOR = "textColor"
  private const val TEXT_COLOR_HIGHLIGHT = "textColorHighlight"
  private const val TEXT_COLOR_HINT = "textColorHint"
  private const val TEXT_COLOR_LINK = "textColorLink"
  private const val THUMB = "thumb"
  private const val TITLE_TEXT_COLOR = "titleTextColor"
  private const val TRACK = "track"

  override val typeMap = mapOf(
    BACKGROUND to BackgroundAttrType,
    BACKGROUND_TINT to BackgroundTintAttrType,
    BUTTON to ButtonAttrType,
    CHECK_MARK to CheckMarkAttrType,
    COLLAPSE_ICON to CollapseIconAttrType,
    DIVIDER to DividerAttrType,
    DRAWABLE_LEFT to DrawableLeftAttrType,
    DRAWABLE_TOP to DrawableTopAttrType,
    DRAWABLE_RIGHT to DrawableRightAttrType,
    DRAWABLE_BOTTOM to DrawableBottomAttrType,
    INDETERMINATE_DRAWABLE to IndeterminateDrawableAttrType,
    LIST_SELECTOR to ListSelectorAttrType,
    LOGO to LogoAttrType,
    NAVIGATION_ICON to NavigationIconAttrType,
    POPUP_BACKGROUND to PopupBackgroundAttrType,
    PROGRESS_DRAWABLE to ProgressDrawableAttrType,
    SHADOW_COLOR to ShadowColorAttrType,
    SRC to SrcAttrType,
    SUBTITLE_TEXT_COLOR to SubtitleTextColorAttrType,
    SWITCH_TEXT_APPEARANCE to SwitchTextAppearanceAttrType,
    TAB_STRIP_LEFT to TabStripLeftAttrType,
    TAB_STRIP_RIGHT to TabStripRightAttrType,
    TEXT_COLOR to TextColorAttrType,
    TEXT_COLOR_HIGHLIGHT to TextColorHighlightAttrType,
    TEXT_COLOR_HINT to TextColorHintAttrType,
    TEXT_COLOR_LINK to TextColorLinkAttrType,
    THUMB to ThumbAttrType,
    TITLE_TEXT_COLOR to TitleTextColorAttrType,
    TRACK to TrackAttrType
  )

}