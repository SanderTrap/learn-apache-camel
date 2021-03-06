package com.learncamel.routes;

import com.learncamel.aggregate.AggregatorPredicateStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregateWithCompletionPredicateRoute extends RouteBuilder {

    public void configure() throws Exception {
            from("direct:completionPredicate")
                    .log("Received Message is ${body} and the header is ${header.aggregatorId}")
                    .aggregate(header("aggregatorId"), new AggregatorPredicateStrategy())
                        .completionPredicate(body().contains("order-confirm")).eagerCheckCompletion()
                    .log("Final Message is: ${body}")
                    .to("mock:output");
    }
}
