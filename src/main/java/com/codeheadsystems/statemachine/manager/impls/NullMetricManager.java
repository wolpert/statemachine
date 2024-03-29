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

package com.codeheadsystems.statemachine.manager.impls;

import com.codeheadsystems.statemachine.manager.MetricManager;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Use this metric manager to avoid all internal metrics.
 */
@Singleton
public class NullMetricManager implements MetricManager {

  /**
   * Instantiates a new Null metric manager.
   */
  @Inject
  public NullMetricManager() {

  }

  @Override
  public void meter(final String metricName,
                    final long value) {
    // empty.
  }

  @Override
  public <R> R time(final String metricName, final Supplier<R> supplier) {
    return supplier.get();
  }
}
