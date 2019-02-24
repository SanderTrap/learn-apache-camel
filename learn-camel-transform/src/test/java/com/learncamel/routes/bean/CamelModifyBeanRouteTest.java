package com.learncamel.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTest() {
        String expected = "123*Sander*19FEB2019";
        String input = "123,Sander,19FEB2019";

        String actual = (String) template.requestBody("direct:beanInput", input);

        assertEquals(expected, actual);
    }
}