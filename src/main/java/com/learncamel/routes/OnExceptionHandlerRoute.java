package com.learncamel.routes;

import com.learncamel.bean.DataModifier;
import com.learncamel.processor.GenerateErrorResponseProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.sql.SQLException;

public class OnExceptionHandlerRoute extends RouteBuilder {

    public void configure() throws Exception {

        onException(ArrayIndexOutOfBoundsException.class).continued(true).maximumRedeliveries(2).redeliveryDelay(5000).backOffMultiplier(2).log(LoggingLevel.INFO, "Exception in Bean caught here");
        onException(SQLException.class).log(LoggingLevel.ERROR, "Some SQL exception");
        onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new GenerateErrorResponseProcessor()).log(LoggingLevel.WARN, "Exception in Processor caught here");

        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
