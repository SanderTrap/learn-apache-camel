package com.learncamel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test
    public void onExceptionCheck() {
        String request = "short";
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is: " + response);
    }

    @Test
    public void onExceptionCheck_handled() {
        String request = null;
        String expected = "Exception happened in the route.";
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is: " + response);
        assertEquals(expected, response);
    }
}