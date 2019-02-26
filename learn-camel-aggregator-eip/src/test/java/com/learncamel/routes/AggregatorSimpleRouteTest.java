package com.learncamel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorSimpleRouteTest extends CamelTestSupport {

    private static final String ENDPOINT_URI = "direct:simpleAggregator";
    private static final String AGGREGATION_ID = "aggregatorId";

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorSimpleRoute();
    }

    @Test
    public void aggregateSimpleTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived("123");

        template.sendBodyAndHeader(ENDPOINT_URI, "1", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "2", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "4", AGGREGATION_ID, 2);
        template.sendBodyAndHeader(ENDPOINT_URI, "3", AGGREGATION_ID, 1);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMultipleMessagesTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");

        List<String> expectedValueList = new ArrayList<String>();
        expectedValueList.add("123");
        expectedValueList.add("567");
        mockEndpoint.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader(ENDPOINT_URI, "1", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "2", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "4", AGGREGATION_ID, 2);
        template.sendBodyAndHeader(ENDPOINT_URI, "3", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "5", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "6", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "7", AGGREGATION_ID, 1);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMultipleMessagesDifferentAggregatorIdsTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");

        List<String> expectedValueList = new ArrayList<String>();
        expectedValueList.add("123");
        expectedValueList.add("555");
        mockEndpoint.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader(ENDPOINT_URI, "1", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "2", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "3", AGGREGATION_ID, 1);
        template.sendBodyAndHeader(ENDPOINT_URI, "5", AGGREGATION_ID, 2);
        template.sendBodyAndHeader(ENDPOINT_URI, "5", AGGREGATION_ID, 2);
        template.sendBodyAndHeader(ENDPOINT_URI, "5", AGGREGATION_ID, 2);

        assertMockEndpointsSatisfied();
    }
}