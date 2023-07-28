/*
 *    Copyright (c) 2022 Ned Wolpert <ned.wolpert@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.codeheadsystems.statemachine;

/**
 * The interface Hook.
 */
public interface Hook {

  /**
   * The interface Pending transition.
   */
  @FunctionalInterface
  interface PendingTransition {
    /**
     * Transition.
     *
     * @param <T>            the type parameter
     * @param object         the object
     * @param transitionName the transition name
     */
    <T> void transition(T object, String transitionName);
  }

  /**
   * The interface Post transition.
   */
  @FunctionalInterface
  interface PostTransition {
    /**
     * Transition.
     *
     * @param <T>            the type parameter
     * @param object         the object
     * @param transitionName the transition name
     */
    <T> void transition(T object, String transitionName);
  }
}
