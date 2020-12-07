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

import android.view.View
import com.ijoic.skinchange.lite.resource.ResourceReader

/**
 * Attribute type
 *
 * @author verstsiu created at 2020-12-04 22:17
 */
interface AttrType {
  /**
   * Inject [view] with [resName] and [reader]
   */
  fun inject(view: View, resName: String, reader: ResourceReader): Boolean
}