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

package com.codeheadsystems.statemachine.exceptions;

import com.codeheadsystems.statemachine.model.StateMachine;

/**
 * The type Transition exception.
 */
public class TransitionException extends StateMachineException {

  /**
   * Instantiates a new Transition exception.
   *
   * @param stateMachine the state machine
   * @param message      the message
   */
  public TransitionException(final StateMachine stateMachine, final String message) {
    super(stateMachine, message);
  }
}
