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
package com.ijoic.skinchange.lite.app.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ijoic.skinchange.lite.SkinManager
import com.ijoic.skinchange.lite.app.R
import com.ijoic.skinchange.lite.app.databinding.ActivityViewBaseBinding
import com.ijoic.skinchange.lite.context.impl.ActivityInjectContext.injectStatusBarColor
import com.ijoic.skinchange.lite.context.impl.ActivityInjectContext.injectStatusBarThemeLight
import com.ijoic.skinchange.lite.context.impl.ActivityInjectContext.injectWindowBackground
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * View base activity
 *
 * @author verstsiu created at 2020-12-05 09:05
 */
@AndroidEntryPoint
internal class ViewBaseActivity : AppCompatActivity() {

  @Inject
  lateinit var skinManager: SkinManager

  private lateinit var binding: ActivityViewBaseBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityViewBaseBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val suffix = intent?.getStringExtra(EXTRA_SKIN_SUFFIX).orEmpty()
    skinManager.bindSuffix(suffix)
    skinManager.injectWith(this)
      .injectStatusBarColor(R.color.view_base_toolbar_background)
      .injectStatusBarThemeLight(R.bool.view_base_status_bar_text_light)
      .injectWindowBackground(R.color.view_base_window_background_color)
    skinManager.injectView(binding.root)
  }

  companion object {
    const val EXTRA_SKIN_SUFFIX = "skin_suffix"
  }
}