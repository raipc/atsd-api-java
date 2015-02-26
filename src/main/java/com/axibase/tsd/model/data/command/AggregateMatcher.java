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

import com.axibase.tsd.model.data.series.AggregateType;
import com.axibase.tsd.model.data.series.Interpolate;
import com.axibase.tsd.model.data.series.Interval;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains data to compute statistics for the specified time intervals.
 *
 * @author Nikolay Malevanny.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AggregateMatcher {
    @JsonProperty("type")
    private List<AggregateType> types;
    private Interval interval;
    private Interpolate interpolate;

    public AggregateMatcher() {
    }

    public AggregateMatcher(Interval interval, Interpolate interpolate, AggregateType type, AggregateType... types) {
        this.types = new ArrayList<AggregateType>();
        this.types.add(type);
        this.types.addAll(Arrays.asList(types));
        this.interval = interval;
        this.interpolate = interpolate;
    }

    /**
     * An array of statistical functions DETAIL,COUNT, MIN, MAX, AVG, SUM, PERCENTILE_999, PERCENTILE_995,
     * PERCENTILE_99, PERCENTILE_95, PERCENTILE_90, PERCENTILE_75, PERCENTILE_50, STANDARD_DEVIATION, FIRST,
     * LAST, DELTA, WAVG, WTAVG
     */
    public List<AggregateType> getTypes() {
        return types;
    }

    /**
     * interval for computing statistics.
     */
    public Interval getInterval() {
        return interval;
    }

    /**
     * Generates missing aggregation intervals using interpolation if enabled: NONE, LINEAR, STEP
     */
    public Interpolate getInterpolate() {
        return interpolate;
    }

    public void setTypes(List<AggregateType> types) {
        this.types = types;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public void setInterpolate(Interpolate interpolate) {
        this.interpolate = interpolate;
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "types=" + types +
                ", interval=" + interval +
                ", interpolate=" + interpolate +
                '}';
    }
}