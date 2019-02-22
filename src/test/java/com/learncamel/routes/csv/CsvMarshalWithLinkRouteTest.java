package com.learncamel.routes.csv;

import com.learncamel.domain.Address;
import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class CsvMarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvMarshalWithLinkRoute();
    }

    @Test
    public void marshalCsvWithLinkRouteTest() throws InterruptedException {
        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress();
        employeeWithAddress.setId("1");
        employeeWithAddress.setFirstName("Sander");
        employeeWithAddress.setLastName("Trap");
        Address address = new Address();
        address.setAddressLine("123 Test Street");
        address.setCity("Amsterdam");
        address.setCountry("The Netherlands");
        address.setState("North Holland");
        address.setZip("1234 AA");
        employeeWithAddress.setAddress(address);

        template.sendBody("direct:objInput", employeeWithAddress);

        Thread.sleep(3000);
        File file = new File("data/csv/output/outputWithAddress.txt");
        assertTrue(file.exists());
    }
}