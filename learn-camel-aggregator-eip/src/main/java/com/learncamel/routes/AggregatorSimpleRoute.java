package com.learncamel.routes;

import com.learncamel.aggregate.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorSimpleRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received Message is ${body} and key is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy()).completionSize(3)
                .log("Aggregated Message is ${body} and key is ${header.aggregatorId}")
                .to("mock:output");
    }
}
