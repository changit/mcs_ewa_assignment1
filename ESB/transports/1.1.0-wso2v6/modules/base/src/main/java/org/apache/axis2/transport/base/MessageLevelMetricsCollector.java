/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.axis2.transport.base;

public interface MessageLevelMetricsCollector {

    public void incrementMessagesReceived();

    public void incrementFaultsReceiving(int errorCode);

    public void incrementTimeoutsReceiving();

    public void incrementBytesReceived(long size);

    public void incrementMessagesSent();

    public void incrementFaultsSending(int errorCode);

    public void incrementTimeoutsSending();

    public void incrementBytesSent(long size);

    public void notifyReceivedMessageSize(long size);

    public void notifySentMessageSize(long size);

    public void reportReceivingFault(int errorCode);

    public void reportSendingFault(int errorCode);

    public void reportResponseCode(int respCode);
}
