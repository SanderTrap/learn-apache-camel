package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CSVUnMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnMarshalRoute();
    }

    @Test
    public void csvUnMarshalRoute() throws InterruptedException {
        Exchange exchange  = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<Employee> employeeList = (List<Employee>) exchange.getIn().getBody();

        assertEquals("Sander", employeeList.get(0).getFirstName());
        assertEquals("Nazeem", employeeList.get(1).getFirstName());
        assertEquals("Werner", employeeList.get(2).getFirstName());
    }
}