/*
 * Copyright 2023 Marissa
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

/** A utility for checking what platform Scala is running on. */
object Platform {

  /** Whether or not Scala is running on the JVM */
  final val isJVM = true

  /** Whether or not Scala is running on JavaScript */
  final val isJS = false

  /** Whether or not Scala is running natively */
  final val isNative = false
}
