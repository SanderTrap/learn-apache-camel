package com.learncamel.routes.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2JSONRoute();
    }

    @Test
    public void marsalEmployeeJson2Xml() {
        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Sander</name><joinDate>19FEB2019</joinDate></employee>";
        String expected = "{\"id\":\"123\",\"name\":\"Sander\",\"joinDate\":\"19FEB2019\"}";

        String response = template.requestBody("direct:marshalEmployeeXml2json", input, String.class);

        assertEquals(expected, response);
    }

    @Test
    public void unmarshalEmployeeJson2Xml(){
        String input = "{\"id\":\"123\",\"name\":\"Sander\",\"joinDate\":\"19FEB2019\"}";
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123</id><joinDate>19FEB2019</joinDate><name>Sander</name></Employee>\r\n";

        String response = template.requestBody("direct:unMarshalEmployeeJson2xml", input, String.class);

        assertEquals(expected, response);
    }
}