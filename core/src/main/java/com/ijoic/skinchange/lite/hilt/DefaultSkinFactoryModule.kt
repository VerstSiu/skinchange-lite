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
package com.ijoic.skinchange.lite.hilt

import com.ijoic.skinchange.lite.view.attr.AttrTypeFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Default skin factory module
 *
 * @author verstsiu created at 2020-12-08 09:46
 */
@Module
@InstallIn(ApplicationComponent::class)
object DefaultSkinFactoryModule {

  @DefaultSkinFactory
  @Provides
  @Singleton
  fun provideAttrFactory(): AttrTypeFactory {
    return AttrTypeFactory()
  }

}