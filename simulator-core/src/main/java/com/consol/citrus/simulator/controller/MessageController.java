/*
 * Copyright 2006-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.simulator.controller;

import com.consol.citrus.simulator.model.Message;
import com.consol.citrus.simulator.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    public Collection<Message> getMessages(
            @RequestParam(value = "fromDate", required = false) Date fromDate,
            @RequestParam(value = "toDate", required = false) Date toDate,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        return messageService.getMessagesByDateBetween(fromDate, toDate, page, size);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/message")
    public void clearMessages() {
        messageService.clearMessages();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/message/{id}")
    public Message getMessageById(@PathVariable("id") Long id) {
        return messageService.getMessageById(id);
    }

}