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
package com.ijoic.skinchange.lite.view.attr.impl

import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import com.ijoic.skinchange.lite.resource.ResourceReader
import com.ijoic.skinchange.lite.view.attr.AttrType

/**
 * Popup background attribute type
 *
 * @author verstsiu created at 2020-12-05 18:30
 */
internal object PopupBackgroundAttrType : AttrType {
  override fun inject(view: View, resName: String, reader: ResourceReader): Boolean {
    when (view) {
      is AutoCompleteTextView -> {
        val resId = reader.getDrawableResIdOrNull(resName) ?: return false
        view.setDropDownBackgroundResource(resId)
        return true
      }
      is Spinner -> {
        val resId = reader.getDrawableResIdOrNull(resName) ?: return false
        view.setPopupBackgroundResource(resId)
        return true
      }
    }
    return false
  }
}