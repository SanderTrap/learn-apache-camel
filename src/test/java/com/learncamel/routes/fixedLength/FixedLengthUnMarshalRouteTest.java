package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class FixedLengthUnMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalRoute();
    }

    @Test
    public void unMarshalFixedLengthFile() {
        Exchange exchange = consumer.receive("direct:output");

        List<EmployeeWithFixedLength> employeeWithFixedLengthList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();

        assertNotNull(employeeWithFixedLengthList);
        assertEquals("Sander", employeeWithFixedLengthList.get(0).getName());
        assertEquals("Zhen", employeeWithFixedLengthList.get(1).getName());
    }
}