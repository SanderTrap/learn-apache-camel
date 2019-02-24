package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedLengthMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthMarshalRoute();
    }

    @Test
    public void fixedLengthMarshalTest() throws InterruptedException {
        EmployeeWithFixedLength employeeWithFixedLength = new EmployeeWithFixedLength();
        employeeWithFixedLength.setId(1);
        employeeWithFixedLength.setName("Sander");
        employeeWithFixedLength.setRole("Java Developer");
        employeeWithFixedLength.setJoiningDate(LocalDate.now());
        employeeWithFixedLength.setGender("Male");
        employeeWithFixedLength.setSalary(new BigDecimal("100000.00"));

        template.sendBody("direct:input", employeeWithFixedLength);

        Thread.sleep(2000);

        File file = new File("data/fixedlength/output");
        assertTrue(file.isDirectory());
    }
}