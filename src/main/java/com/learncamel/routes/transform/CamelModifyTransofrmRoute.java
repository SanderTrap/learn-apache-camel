package com.learncamel.routes.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransofrmRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:transFormInput")
                .transform(body().regexReplaceAll(",", "*"))
                .to("mock:output");
    }
}
