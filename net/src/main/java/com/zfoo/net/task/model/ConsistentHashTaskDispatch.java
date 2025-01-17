/*
 * Copyright (C) 2020 The zfoo Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.zfoo.net.task.model;

import com.zfoo.net.task.TaskManager;

import java.util.concurrent.ExecutorService;

/**
 * @author jaysunxiao
 * @version 3.0
 */
public class ConsistentHashTaskDispatch extends AbstractTaskDispatch {

    private static ConsistentHashTaskDispatch INSTANCE = new ConsistentHashTaskDispatch();

    public static ConsistentHashTaskDispatch getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public ExecutorService getExecutor(ReceiveTask receiveTask) {
        var packetAttachment = receiveTask.getPacketAttachment();

        if (packetAttachment == null) {
            return SessionIdTaskDispatch.getInstance().getExecutor(receiveTask);
        }

        return TaskManager.getInstance().getExecutorByConsistentHash(packetAttachment.executorConsistentHash());
    }

}
