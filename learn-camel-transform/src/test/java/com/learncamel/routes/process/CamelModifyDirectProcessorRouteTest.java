package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest() {
        String expected = "123: Sander: 19OCT1990";
        String input = "123, Sander, 19OCT1990";

        String output = (String) template.requestBody("direct:processorInput", input);

        assertEquals(expected, output);
    }

    @Test
    public void processorDirectUsingMock() throws InterruptedException {
        String expected = "123: Sander: 19OCT1990";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        String input = "123, Sander, 19OCT1990";
        template.sendBody("direct:processorInput", input);

        assertMockEndpointsSatisfied();
    }
}