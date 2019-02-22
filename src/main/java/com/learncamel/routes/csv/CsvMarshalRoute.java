package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(Employee.class);

        from("direct:objInput")
                .log("Received Message is ${body}")
                .marshal(bindy)
                .log("Marshaled Message is ${body}")
                .to("file:data/csv/output?fileName=output.txt");
    }
}
