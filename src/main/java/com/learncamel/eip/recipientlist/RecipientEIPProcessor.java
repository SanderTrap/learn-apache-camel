package com.learncamel.eip.recipientlist;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RecipientEIPProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String employeeType = exchange.getIn().getHeader("type", String.class);

        if (employeeType.equals("junior")) {
            exchange.getIn().setHeader("type", "file:xmloutput/junior");
        } else if (employeeType.equals("medior")) {
            exchange.getIn().setHeader("type", "file:xmloutput/medior");
        } else if (employeeType.equals("senior")) {
            exchange.getIn().setHeader("type", "file:xmloutput/senior");
        } else {
            exchange.getIn().setHeader("type", "file:xmloutput/other");
        }
    }
}
