/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus;

import java.util.function.Predicate;

import org.reaktivity.nukleus.function.CommandHandler;
import org.reaktivity.nukleus.function.MessagePredicate;
import org.reaktivity.nukleus.route.RouteKind;
import org.reaktivity.nukleus.stream.StreamFactoryBuilder;

public interface NukleusBuilder
{
    NukleusBuilder routeHandler(
        RouteKind kind,
        MessagePredicate handler);

    NukleusBuilder allowZeroSourceRef(
            Predicate<RouteKind> predicate);

    NukleusBuilder allowZeroTargetRef(
            Predicate<RouteKind> predicate);

    NukleusBuilder streamFactory(
        RouteKind kind,
        StreamFactoryBuilder builder);

    NukleusBuilder inject(
        Nukleus component);

    NukleusBuilder commandHandler(
        int msgTypeId,
        CommandHandler handler);

    NukleusBuilder layoutSource(
            Predicate<RouteKind> layoutSource);

    NukleusBuilder layoutTarget(
            Predicate<RouteKind> layoutTarget);

    Nukleus build();
}
