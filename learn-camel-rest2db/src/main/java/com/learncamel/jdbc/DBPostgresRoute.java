package com.learncamel.jdbc;

import org.apache.camel.builder.RouteBuilder;

public class DBPostgresRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:dbInput")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from country_capital?dataSource=#myDataSource")
                .to("log:?level=INFO&showBody=true");
    }
}
