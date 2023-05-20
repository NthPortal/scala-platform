/*
 * Copyright 2023 April Hyacinth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lgbt.princess.platform

import munit.FunSuite

class PlatformConsistentAPITest extends FunSuite {
  test("Platform has a consistent API across all platforms") {
    assertEquals(
      Seq(Platform.isJVM, Platform.isJS, Platform.isNative).count(identity),
      1
    )
  }

  test("Platform check methods are stable") {
    // should compile and not throw a `MatchError`
    true match {
      case Platform.isJVM | Platform.isJS | Platform.isNative => assert(true)
      case _                                                  => fail("should be unreachable")
    }
  }
}
