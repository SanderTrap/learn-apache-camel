package com.learncamel.routes.rest2db;

import com.learncamel.routes.exception.ExceptionProcessor;
import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

public class Rest2DBRoute extends RouteBuilder {

    public void configure() throws Exception {
        onException(PSQLException.class, Exception.class).handled(true).log("Exception in the route.").process(new ExceptionProcessor());

        from("timer:learnTimer?period=10s")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("http://restcountries.eu/rest/v2/alpha/nl"))
                .to("http://restcountries.eu/rest/v2/alpha/${body}").convertBodyTo(String.class)
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from country_capital?dataSource=#myDataSource")
                .to("direct:dbOutput");
    }
}
