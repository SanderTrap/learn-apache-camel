package com.learncamel.routes;

import com.learncamel.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.sql.SQLException;

public class OnExceptionHandlerRoute extends RouteBuilder {

    public void configure() throws Exception {

        onException(RuntimeException.class, Exception.class).maximumRedeliveries(2).redeliveryDelay(5000).backOffMultiplier(2).log(LoggingLevel.INFO, "Exception in Bean caught here");
        onException(SQLException.class).log(LoggingLevel.ERROR, "Some SQL exception");


        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
