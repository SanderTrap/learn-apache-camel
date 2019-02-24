package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expectedValue = "123: Sander: 19OCT1990\n" +
                "456: Zhen: 1AUG1991\n";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);

        File file = new File("data/output");
        assertTrue(file.isDirectory());
    }
}