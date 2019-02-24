package com.learncamel.eip.contentbasedrouter;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBasedRouerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ContentBasedRouerRoute();
    }

    @Test
    public void contentBasedRouteTest() throws InterruptedException {
        Thread.sleep(5000);

        File file = new File("output/html");
        assertTrue(file.isDirectory());

        File file1 = new File("output/text");
        assertTrue(file1.isDirectory());

        File file2 = new File("output/json");
        assertTrue(file2.isDirectory());

        File file3 = new File("output/other");
        assertTrue(file3.isDirectory());

        File filelAll = new File("output/all");
        assertTrue(filelAll.isDirectory());
    }
}