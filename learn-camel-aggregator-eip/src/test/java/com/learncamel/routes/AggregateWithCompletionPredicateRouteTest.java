package com.learncamel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregateWithCompletionPredicateRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregateWithCompletionPredicateRoute();
    }

    @Test
    public void predicateTest() throws InterruptedException {
        String orderCreate = "12345,samsung-phone,order-created";
        String orderConfirm = "12345,samsing-phone,order-confirm";

        String expectedOutput = orderCreate.concat(":").concat(orderConfirm);

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedOutput);

        template.sendBodyAndHeader("direct:completionPredicate", orderCreate, "aggregatorId", 12345);
        template.sendBodyAndHeader("direct:completionPredicate", orderConfirm, "aggregatorId", 12345);

        assertMockEndpointsSatisfied();
    }
}