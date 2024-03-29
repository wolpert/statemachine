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

package com.codeheadsystems.statemachine.model;

import org.immutables.value.Value;

/**
 * Purpose: Holds onto an active StateMachine, with the invocation model for its target.  Not serializable.
 *
 * @param <T> the type parameter
 */
@Value.Immutable
public interface ActiveStateMachine<T> {

  /**
   * State machine state machine.
   *
   * @return the state machine
   */
  StateMachine stateMachine();

  /**
   * Invocation model invocation model.
   *
   * @return the invocation model
   */
  InvocationModel<T> invocationModel();

}
