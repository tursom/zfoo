/*
 * Copyright (C) 2020 The zfoo Authors
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.zfoo.boot;

import com.zfoo.scheduler.SchedulerContext;
import com.zfoo.scheduler.schema.SchedulerRegisterProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaysunxiao
 * @version 3.0
 */
@Configuration(proxyBeanMethods = false)
public class SchedulerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SchedulerRegisterProcessor schedulerRegisterProcessor() {
        return new SchedulerRegisterProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    public SchedulerContext schedulerContext() {
        return new SchedulerContext();
    }

}
