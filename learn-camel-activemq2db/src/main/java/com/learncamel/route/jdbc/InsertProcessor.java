package com.learncamel.route.jdbc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String input = (String) exchange.getIn().getBody();
        System.out.println("Input to be persisted: " + input);

        String insertQuery = "INSERT INTO messages values ('1','" + input + "')";
        System.out.println("Insert Query is: " + insertQuery);
        exchange.getIn().setBody(insertQuery);
    }
}
