package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvUnMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(Employee.class);

        from("file:data/csv/input?fileName=file1.txt&noop=true")
                .unmarshal(bindy)
                .log("unMarshaled Message is: ${body}")
                .to("direct:output");
    }
}
