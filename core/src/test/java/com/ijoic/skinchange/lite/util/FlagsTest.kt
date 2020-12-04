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
package com.ijoic.skinchange.lite.util

import org.junit.Test

/**
 * Flags test
 *
 * @author verstsiu created at 2020-12-04 09:04
 */
internal class FlagsTest {
  @Test
  fun testAttachFlag() {
    assert(Flags.attach(0b0001, 0b0010) == 0b0011)
    assert(Flags.attach(0b0011, 0b0010) == 0b0011)
    assert(Flags.attach(0b1001, 0b0010) == 0b1011)
    assert(Flags.attach(0b0001, 0b0110) == 0b0111)
  }

  @Test
  fun testDetachFlag() {
    assert(Flags.detach(0b0011, 0b0010) == 0b0001)
    assert(Flags.detach(0b0001, 0b0010) == 0b0001)
    assert(Flags.detach(0b1001, 0b0010) == 0b1001)
    assert(Flags.detach(0b0011, 0b0110) == 0b0001)
    assert(Flags.detach(0b0111, 0b0110) == 0b0001)
  }
}