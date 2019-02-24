package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        assertEquals(LocalDate.of(1990, 10, 19), employeeWithFixedLengthList.get(0).getJoiningDate());
        assertEquals("Male", employeeWithFixedLengthList.get(0).getGender());
        assertEquals(new BigDecimal("80000.00"), employeeWithFixedLengthList.get(0).getSalary());

        assertEquals("Zhen", employeeWithFixedLengthList.get(1).getName());
        assertEquals(LocalDate.of(1991, 8, 1), employeeWithFixedLengthList.get(1).getJoiningDate());
        assertEquals("Female", employeeWithFixedLengthList.get(1).getGender());
        assertEquals(new BigDecimal("90000.00"), employeeWithFixedLengthList.get(1).getSalary());

    }
}