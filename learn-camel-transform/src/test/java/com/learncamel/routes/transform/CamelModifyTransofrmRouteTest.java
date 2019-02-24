package com.learncamel.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransofrmRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransofrmRoute();
    }

    @Test
    public void transformTest() {
        String expected = "123*Sander*19FEB2019";
        String input = "123,Sander,19FEB2019";

        String actual = (String) template.requestBody("direct:transFormInput", input);

        assertEquals(expected, actual);
    }

    @Test
    public void transformUsingMockTest() throws InterruptedException {
        String expected = "123*Sander*19FEB2019";
        String input = "123,Sander,19FEB2019";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.requestBody("direct:transFormInput", input);

        assertMockEndpointsSatisfied();
    }
}