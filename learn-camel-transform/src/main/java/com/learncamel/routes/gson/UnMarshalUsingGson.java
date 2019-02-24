package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnMarshalUsingGson extends RouteBuilder {

    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:unMarshalGSON")
                .log("Recieved Message is: ${body}")
                .unmarshal(gsonDataFormat)
                .log("UnMarshaled Message is: ${body}");
    }
}
