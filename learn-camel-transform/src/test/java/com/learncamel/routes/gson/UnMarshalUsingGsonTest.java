package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingGson();
    }

    @Test
    public void unMarshalJsonTest() {
        Employee employee = new Employee();
        String input = "{\"id\":\"1\",\"name\":\"Sander\",\"joinDate\":\"20FEB2019\"}";

        employee = template.requestBody("direct:unMarshalGSON", input, Employee.class);

        assertEquals("1", employee.getId());
    }
}