package com.learncamel.routes.rest;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RestRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RestRoute();
    }

    @Test
    public void restCallNlTest() {
        String response = template.requestBody("direct:restCall", "NL", String.class);
        System.out.println("Response: " + response);
        assertNotNull(response);
    }
}