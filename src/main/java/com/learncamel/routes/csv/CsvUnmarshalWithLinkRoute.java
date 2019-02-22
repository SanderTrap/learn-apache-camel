package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvUnmarshalWithLinkRoute extends RouteBuilder {

    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("file:data/csv/input?fileName=file-with-address.txt&noop=true")
                .unmarshal(bindy)
                .log("Unmarshaled message is: ${body}")
                .to("direct:output");
    }
}
