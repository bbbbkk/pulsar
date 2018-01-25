/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pulsar.functions.composition.windowing;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class EventImpl<T> implements Event<T> {
    private final T event;
    private final long ts;
    private final byte[] messageId;
    private final String topic;

    EventImpl(T event, long ts, byte[] messageId, String topic) {
        this.event = event;
        this.ts = ts;
        this.messageId = messageId;
        this.topic = topic;
    }

    @Override
    public long getTimestamp() {
        return ts;
    }

    @Override
    public T get() {
        return event;
    }

    @Override
    public boolean isWatermark() {
        return false;
    }

    @Override
    public byte[] getMessageId() {
        return messageId;
    }

    @Override
    public String getTopic() {
        return topic;
    }
}
