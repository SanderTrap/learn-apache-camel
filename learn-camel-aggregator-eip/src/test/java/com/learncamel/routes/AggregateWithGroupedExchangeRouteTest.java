package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class AggregateWithGroupedExchangeRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregateWithGroupedExchangeRoute();
    }

    @Test
    public void groupExchangeTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:grpAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:grpAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:grpAggregator", "3", "aggregatorId", 1);

        assertMockEndpointsSatisfied();

        Exchange exchange = mockEndpoint.getExchanges().get(0);
        List<Exchange> exchangeList = (List<Exchange>) exchange.getProperty(Exchange.GROUPED_EXCHANGE);

        for (Exchange e : exchangeList) {
            System.out.println("Exchange Body is: " + e.getIn().getBody());
        }
    }
}