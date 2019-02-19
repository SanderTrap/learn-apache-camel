package com.learncamel.routes.process;

import com.learncamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .process(new CamelFileExampleProcessor())
                .log("Read file is ${body} and headers are ${headers}")
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
