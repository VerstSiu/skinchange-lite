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
package com.ijoic.skinchange.lite.material.attr

import com.ijoic.skinchange.lite.material.attr.impl.*
import com.ijoic.skinchange.lite.view.attr.AttrModule
import com.ijoic.skinchange.lite.view.attr.AttrType

/**
 * Material attribute module
 *
 * @author verstsiu created at 2020-12-07 11:13
 */
object MaterialAttrModule : AttrModule {

  private const val CARD_BACKGROUND_COLOR = "cardBackgroundColor"
  private const val CARD_FOREGROUND_COLOR = "cardForegroundColor"
  private const val CHECKED_ICON = "checkedIcon"
  private const val CHECKED_ICON_TINT = "checkedIconTint"
  private const val CHIP_BACKGROUND_COLOR = "chipBackgroundColor"
  private const val CHIP_ICON = "chipIcon"
  private const val CHIP_ICON_TINT = "chipIconTint"
  private const val CHIP_STROKE_COLOR = "chipStrokeColor"
  private const val CLOSE_ICON = "closeIcon"
  private const val CLOSE_ICON_TINT = "closeIconTint"
  private const val CONTENT_SCRIM = "contentScrim"
  private const val COLLAPSED_TITLE_TEXT_APPEARANCE = "collapsedTitleTextAppearance"
  private const val EXPANDED_TITLE_TEXT_APPEARANCE = "expandedTitleTextAppearance"
  private const val ICON = "icon"
  private const val ICON_TINT = "iconTint"
  private const val ITEM_BACKGROUND = "itemBackground"
  private const val ITEM_ICON_TINT = "itemIconTint"
  private const val ITEM_RIPPLE_COLOR = "itemRippleColor"
  private const val ITEM_TEXT_COLOR = "itemTextColor"
  private const val RIPPLE_COLOR = "rippleColor"
  private const val STATUS_BAR_FOREGROUND = "statusBarForeground"
  private const val STATUS_BAR_SCRIM = "statusBarScrim"
  private const val STROKE_COLOR = "strokeColor"
  private const val TEXT_APPEARANCE = "textAppearance"

  override val typeMap: Map<String, AttrType> = mapOf(
    CARD_BACKGROUND_COLOR to CardBackgroundColorAttrType,
    CARD_FOREGROUND_COLOR to CardForegroundColorAttrType,
    CHECKED_ICON to CheckedIconAttrType,
    CHECKED_ICON_TINT to CheckedIconTintAttrType,
    CHIP_BACKGROUND_COLOR to ChipBackgroundColorAttrType,
    CHIP_ICON to ChipIconAttrType,
    CHIP_ICON_TINT to ChipIconTintAttrType,
    CHIP_STROKE_COLOR to ChipStrokeColorAttrType,
    CLOSE_ICON to CloseIconAttrType,
    CLOSE_ICON_TINT to CloseIconTintAttrType,
    CONTENT_SCRIM to ContentScrimAttrType,
    COLLAPSED_TITLE_TEXT_APPEARANCE to CollapsedTitleTextAppearanceAttrType,
    EXPANDED_TITLE_TEXT_APPEARANCE to ExpandedTitleTextAppearanceAttrType,
    ICON to IconAttrType,
    ICON_TINT to IconTintAttrType,
    ITEM_BACKGROUND to ItemBackgroundAttrType,
    ITEM_ICON_TINT to ItemIconTintAttrType,
    ITEM_RIPPLE_COLOR to ItemRippleColorAttrType,
    ITEM_TEXT_COLOR to ItemTextColorAttrType,
    RIPPLE_COLOR to RippleColorAttrType,
    STATUS_BAR_FOREGROUND to StatusBarForegroundAttrType,
    STATUS_BAR_SCRIM to StatusBarScrimAttrType,
    STROKE_COLOR to StrokeColorAttrType,
    TEXT_APPEARANCE to TextAppearanceAttrType
  )
}