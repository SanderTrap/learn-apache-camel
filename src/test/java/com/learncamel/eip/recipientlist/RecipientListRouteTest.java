package com.learncamel.eip.recipientlist;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class RecipientListRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RecipientListRoute();
    }

    @Test
    public void receipientListTest() throws InterruptedException {
        Thread.sleep(5000);

        File fileMedior = new File("xmloutput/medior");
        assertTrue(fileMedior.isDirectory());

        File filSenior = new File("xmloutput/senior");
        assertTrue(filSenior.isDirectory());
    }
}