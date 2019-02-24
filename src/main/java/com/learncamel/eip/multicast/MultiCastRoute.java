package com.learncamel.eip.multicast;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRoute extends RouteBuilder {

    public void configure() throws Exception {
            from("file:input?noop=true")
                    .multicast()
                    .stopOnException()
                    .parallelProcessing()
                        .to("file:output1", "file:output2");
    }
}
