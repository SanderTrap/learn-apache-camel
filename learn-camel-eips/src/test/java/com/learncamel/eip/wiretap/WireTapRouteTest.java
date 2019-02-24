package com.learncamel.eip.wiretap;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class WireTapRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new WireTapRoute();
    }

    @Test
    public void wireTapRouteTest() throws InterruptedException {
        Thread.sleep(5000);

        File debugFile = new File("debug");
        assertTrue(debugFile.isDirectory());

        File allFile = new File("all");
        assertTrue(allFile.isDirectory());
    }
}