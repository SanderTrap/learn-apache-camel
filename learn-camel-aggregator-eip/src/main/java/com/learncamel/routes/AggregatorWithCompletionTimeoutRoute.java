package com.learncamel.routes;

import com.learncamel.aggregate.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorWithCompletionTimeoutRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received Message is ${body} and the headers are ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy())
                .completionSize(3).completionTimeout(3000)
                .log("Aggregated Message is ${body}")
                .to("mock:output");
    }
}
