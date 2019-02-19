package com.learncamel.routes.bean;

import com.learncamel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {

    public void configure() throws Exception {
            from("direct:beanInput")
                    .log("Before bean is: ${body}")
                    .bean(new CamelBean(), "map")
                    .log("After bean Message is: ${body}")
                    .to("mock:output");
    }
}
