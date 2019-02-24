package com.learncamel.eip.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouerRoute extends RouteBuilder {

    private static final String HEADER_NAME = "CamelFileNameConsumed";

    public void configure() throws Exception {
        from("file:input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                    .when(header(HEADER_NAME).endsWith(".html"))
                        .to("file:output/html")
                    .when(header(HEADER_NAME).endsWith(".txt"))
                        .to("file:output/text")
                    .when(header(HEADER_NAME).endsWith(".json"))
                        .to("file:output/json")
                    .otherwise()
                        .to("file:output/other");
    }
}
