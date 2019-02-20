package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingXstream();
    }

    @Test
    public void unMarshalXstreamTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setJoinDate("19FEB2019");
        employee.setId("123");
        employee.setName("Sander");

        String xmlInput = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Sander</name><joinDate>19FEB2019</joinDate></employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(employee.toString());

        template.sendBody("direct:xmlInput", xmlInput);

        assertMockEndpointsSatisfied();
    }
}