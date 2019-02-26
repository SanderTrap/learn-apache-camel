package com.learncamel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorWithCompletionTimeoutRouteTest extends CamelTestSupport {

    private static final String ENDPOINT_URI = "direct:simpleAggregator";
    private static final String AGGREGATION_ID = "aggregatorId";

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorWithCompletionTimeoutRoute();
    }

    @Test
    public void aggregateTimeoutTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived("12");

        template.sendBodyAndHeader(ENDPOINT_URI, "1", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "2", AGGREGATION_ID, 1);
        Thread.sleep(5000);
        template.sendBodyAndHeader(ENDPOINT_URI, "4", AGGREGATION_ID, 2);
        template.sendBodyAndHeader(ENDPOINT_URI, "3", AGGREGATION_ID, 1);

        assertMockEndpointsSatisfied();
    }
}