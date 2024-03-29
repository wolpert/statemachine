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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import org.immutables.value.Value;

/**
 * Purpose: A state of a specific state machine.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableState.class)
@JsonDeserialize(builder = ImmutableState.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface State {

  /**
   * Name string.
   *
   * @return the string
   */
  @JsonProperty("name")
  String name();

  /**
   * Transitions map.
   *
   * @return the map
   */
  @JsonProperty("transitions")
  Map<String, Transition> transitions();

  /**
   * Has transition boolean.
   *
   * @param transition the transition
   * @return the boolean
   */
  @JsonIgnore
  default boolean hasTransition(final Transition transition) {
    return hasTransition(transition.name());
  }

  /**
   * Has transition boolean.
   *
   * @param name the name
   * @return the boolean
   */
  @JsonIgnore
  default boolean hasTransition(final String name) {
    return transitions().containsKey(name);
  }

}
