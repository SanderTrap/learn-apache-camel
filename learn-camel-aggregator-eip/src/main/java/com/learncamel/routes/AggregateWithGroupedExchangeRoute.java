package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class AggregateWithGroupedExchangeRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:grpAggregator")
                .log("Received Message is ${body} and headers are ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                    .completionSize(3)
                .log("Aggregated Messages are ${body}")
                .to("mock:output");
    }
}
