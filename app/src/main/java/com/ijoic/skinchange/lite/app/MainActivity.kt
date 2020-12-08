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

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ijoic.skinchange.lite.app.databinding.ActivityMainBinding
import com.ijoic.skinchange.lite.app.view.ViewBaseActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

/**
 * Main activity
 *
 * @author verstsiu created at 2020-11-24 11:17
 */
@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private var suffix = ""
  private var suffixIndex = 0
  private var suffixList = mutableListOf("", "night")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    updateSkinInfo()

    binding.actionToggleSkin.setOnClickListener {
      suffixIndex = (++suffixIndex).takeIf { it <= suffixList.size } ?: 0
      suffix = suffixList.getOrNull(suffixIndex).orEmpty()
      updateSkinInfo()
    }
    binding.caseViewBase.setOnClickListener {
      val intent = Intent(this, ViewBaseActivity::class.java)
      intent.putExtra(ViewBaseActivity.EXTRA_SKIN_SUFFIX, suffix)
      startActivity(intent)
    }
  }

  private fun updateSkinInfo() {
    val skin = suffix.takeIf { it.isNotEmpty() } ?: "day"
    binding.skinInfo.text = getString(R.string.format_skin_info, skin.toUpperCase(Locale.getDefault()))
  }
}