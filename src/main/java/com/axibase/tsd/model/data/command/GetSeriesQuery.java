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
package com.axibase.tsd.model.data.command;

import com.axibase.tsd.model.data.SeriesType;
import com.axibase.tsd.model.data.series.Join;
import com.axibase.tsd.model.data.series.Rate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

/**
 * @author Nikolay Malevanny.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSeriesQuery {
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private Boolean last;
    @JsonProperty("entity")
    private final String entityName;
    @JsonProperty("metric")
    private final String metricName;
    private MultivaluedMap<String, String> tags = new MultivaluedHashMap<String, String>();
    private SeriesType type;
    private Join join;
    private Rate rate;
    @JsonProperty("aggregate")
    private SimpleAggregateMatcher aggregateMatcher;
    private String requestId;

    /**
     * @param entityName an entity's name of the requested time series. User defined values (case insensitive).
     * @param metricName a metric name of the requested time series. User defined values (case insensitive).
     */
    public GetSeriesQuery(String entityName, String metricName) {
        this.entityName = entityName;
        this.metricName = metricName;
    }

    /**
     * @param entityName an entity's name of the requested time series. User defined values (case insensitive).
     * @param metricName a metric name of the requested time series. User defined values (case insensitive).
     * @param tags Object key is a tag name and a value is an array of possible tag values
     */
    public GetSeriesQuery(String entityName, String metricName, MultivaluedMap<String, String> tags) {
        this.entityName = entityName;
        this.metricName = metricName;
        this.tags = tags;
    }

    /**
     * @param entityName an entity's name of the requested time series. User defined values (case insensitive).
     * @param metricName a metric name of the requested time series. User defined values (case insensitive).
     * @param tags Object key is a tag name and a value is an array of possible tag values
     */
    public GetSeriesQuery(String entityName, String metricName, Map<String, String> tags) {
        this.entityName = entityName;
        this.metricName = metricName;
        this.tags = new MultivaluedHashMap<String, String>(tags);
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Integer getLimit() {
        return limit;
    }

    public Boolean getLast() {
        return last;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getMetricName() {
        return metricName;
    }

    public MultivaluedMap<String, String> getTags() {
        return tags;
    }

    public SeriesType getType() {
        return type;
    }

    public Join getJoin() {
        return join;
    }

    public Rate getRate() {
        return rate;
    }

    public SimpleAggregateMatcher getAggregateMatcher() {
        return aggregateMatcher;
    }

    public String getRequestId() {
        return requestId;
    }

    /**
     * @param startTime start of the selection interval. Unix milliseconds.
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * @param endTime end of the selection interval. Unix milliseconds.
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * @param limit maximum number of data samples returned.
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @param last if true: Performs GET instead of scan. Retrieves only 1 most recent value.
     */
    public void setLast(Boolean last) {
        this.last = last;
    }

    /**
     * @param tags Object key is a tag name and a value is an array of possible tag values.
     *             User defined values ( keys: case insensitive, values: case sensitive )
     */
    public void setTags(MultivaluedMap<String, String> tags) {
        this.tags = tags;
    }

    /**
     * @param type specifies source for underlying data
     */
    public void setType(SeriesType type) {
        this.type = type;
    }

    /**
     * @param join Merges multiple time series into one serie.
     */
    public void setJoin(Join join) {
        this.join = join;
    }

    /**
     * @param rate Computes difference between consecutive samples per unit of time (rate interval).
     */
    public void setRate(Rate rate) {
        this.rate = rate;
    }

    /**
     * @param aggregateMatcher Computes statistics for the specified time intervals.
     */
    public void setAggregateMatcher(SimpleAggregateMatcher aggregateMatcher) {
        this.aggregateMatcher = aggregateMatcher;
    }

    /**
     * To associate 'series' object (one) in request with 'series' objects (many) in response, the client can
     * optionally specify a unique 'requestId' property in each series object in request.
     *  For example, the client can set requestId to series object's index in the request.
     *  The server echos requestId for each series in the response.
     *
     * @param requestId Optional identifier used to associate 'series' object in request with 'series'
     *                  objects in response. Any string (case sensitive).
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "GetSeriesQuery{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", limit=" + limit +
                ", last=" + last +
                ", entityName='" + entityName + '\'' +
                ", metricName='" + metricName + '\'' +
                ", tags=" + tags +
                ", type=" + type +
                ", join=" + join +
                ", rate=" + rate +
                ", aggregateMatcher=" + aggregateMatcher +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}