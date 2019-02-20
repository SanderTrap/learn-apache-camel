package com.learncamel.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder {

    private static final String LOGGER = "log:?level=INFO&showBody=true";

    public void configure() throws Exception {
        from("direct:marshalEmployeeXml2json")
                .to(LOGGER)
                .marshal().xmljson()
                .to(LOGGER);

        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("Employee");

        from("direct:unMarshalEmployeeJson2xml")
                .to(LOGGER)
                //.unmarshal().xmljson()
                .unmarshal(xmlJsonDataFormat)
                .to(LOGGER);
    }
}
