package com.learncamel.routes.jms;

import org.apache.camel.builder.RouteBuilder;

public class JmsReadRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("activemq:queue:testQueue?username=admin&password=admin")
                .streamCaching()
                .to("log:?level=INFO&showBody=true")
                .to("direct:readQueue");
    }
}
