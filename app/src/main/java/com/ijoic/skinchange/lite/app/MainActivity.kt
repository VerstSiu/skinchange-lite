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
package com.ijoic.skinchange.lite.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ijoic.skinchange.lite.SkinManager
import com.ijoic.skinchange.lite.app.databinding.ActivityMainBinding
import com.ijoic.skinchange.lite.context.impl.WindowInjectContext.injectStatusBarColor
import com.ijoic.skinchange.lite.context.impl.WindowInjectContext.injectWindowBackground
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Main activity
 *
 * @author verstsiu created at 2020-11-24 11:17
 */
@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

  @Inject lateinit var skinManager: SkinManager

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    skinManager.bindSuffix("s2")
    skinManager.injectWith(this)
      .injectStatusBarColor(R.color.common_status_bar_color)
      .injectWindowBackground(R.color.common_window_background_color)

    binding.actionToggleSkin.setOnClickListener {

    }
  }
}