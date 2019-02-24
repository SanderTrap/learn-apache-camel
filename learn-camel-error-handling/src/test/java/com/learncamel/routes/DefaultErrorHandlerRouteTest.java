package com.learncamel.routes;

import com.learncamel.routes.defaulterrorhandler.DefaultErrorHandlerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck() throws InterruptedException {
        String expectedOutput = "123*Sander*23FEB19";
        String input = null;

        String output = template.requestBody("direct:exception", input, String.class);

        assertEquals(expectedOutput, output);
    }
}