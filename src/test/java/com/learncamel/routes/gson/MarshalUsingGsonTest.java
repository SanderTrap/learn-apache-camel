package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGson() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Sander");
        employee.setJoinDate("20FEB2019");

        String expected = "{\"id\":\"1\",\"name\":\"Sander\",\"joinDate\":\"20FEB2019\"}";

        String employeeJson = template.requestBody("direct:marshalGSON", employee, String.class);

        assertEquals(expected, employeeJson);
    }
}