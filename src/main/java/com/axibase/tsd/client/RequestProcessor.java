/*
* Copyright 2015 Axibase Corporation or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License").
* You may not use this file except in compliance with the License.
* A copy of the License is located at
*
* https://www.axibase.com/atsd/axibase-apache-2.0.pdf
*
* or in the "license" file accompanying this file. This file is distributed
* on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
* express or implied. See the License for the specific language governing
* permissions and limitations under the License.
*/
package com.axibase.tsd.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.axibase.tsd.util.AtsdUtil.JSON;

/**
 * @author Nikolay Malevanny.
 */
class RequestProcessor<T> {
    private Type type;
    private T command;

    private RequestProcessor(Type type, T command) {
        this.type = type;
        this.command = command;
    }

    public Response process(Invocation.Builder request) {
        return request.accept(JSON).method(type.name(), Entity.entity(command, JSON));
    }

    public static enum Type {
        POST,
        PUT,
        DELETE
    }

    public static <T> RequestProcessor<T> post(T command) {
        return new RequestProcessor<T>(Type.POST, command);
    }

    public static <T> RequestProcessor<T> put(T command) {
        return new RequestProcessor<T>(Type.PUT, command);
    }

    public static <T> RequestProcessor<T> delete(T command) {
        return new RequestProcessor<T>(Type.DELETE, command);
    }
}
