/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okio

/**
 * A collection of unused segments, necessary to avoid GC churn and zero-fill.
 * This pool is a thread-safe static singleton.
 */
internal expect object SegmentPool {
  val MAX_SIZE: Long

  /** For testing only. Returns a snapshot of the number of bytes currently in the pool. */
  val byteCount: Long

  /** Return a segment for the caller's use. */
  fun take(): Segment

  /** Recycle a segment that the caller no longer needs. */
  fun recycle(segment: Segment)
}
