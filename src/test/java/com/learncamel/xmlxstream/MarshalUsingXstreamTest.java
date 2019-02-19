package com.learncamel.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {
        String input = "123,Sander,19FEB2019";

        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Sander</name><joinDate>19FEB2019</joinDate></employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);

        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();
    }
}