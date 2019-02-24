package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvMarshalRoute();
    }

    @Test
    public void csvMarshalRouteTest() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("Sander");
        employee.setLastName("Trap");

        Employee employee1 = new Employee();
        employee1.setId("2");
        employee1.setFirstName("Nazeem");
        employee1.setLastName("Soeltan");

        List<Employee> employeeList = Arrays.asList(employee, employee1);

        template.sendBody("direct:objInput", employeeList);

        File file = new File("data/csv/output");
        assertTrue(file.isDirectory());
    }
}