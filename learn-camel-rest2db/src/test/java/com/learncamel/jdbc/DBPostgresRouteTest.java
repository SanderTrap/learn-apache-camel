package com.learncamel.jdbc;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

public class DBPostgresRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DBPostgresRoute();
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/localdb";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource", dataSource);
        
        CamelContext context = new DefaultCamelContext(registry);
        return context;
    }

    @Test
    public void insertData() {
        String inputJson = "{\"name\":\"Netherlands\",\"topLevelDomain\":[\".nl\"],\"alpha2Code\":\"NL\",\"alpha3Code\":\"NLD\",\"callingCodes\":[\"31\"],\"capital\":\"Amsterdam\",\"altSpellings\":[\"NL\",\"Holland\",\"Nederland\"],\"region\":\"Europe\",\"subregion\":\"Western Europe\",\"population\":17019800,\"latlng\":[52.5,5.75],\"demonym\":\"Dutch\",\"area\":41850.0,\"gini\":30.9,\"timezones\":[\"UTC-04:00\",\"UTC+01:00\"],\"borders\":[\"BEL\",\"DEU\"],\"nativeName\":\"Nederland\",\"numericCode\":\"528\",\"currencies\":[{\"code\":\"EUR\",\"name\":\"Euro\",\"symbol\":\"€\"}],\"languages\":[{\"iso639_1\":\"nl\",\"iso639_2\":\"nld\",\"name\":\"Dutch\",\"nativeName\":\"Nederlands\"}],\"translations\":{\"de\":\"Niederlande\",\"es\":\"Países Bajos\",\"fr\":\"Pays-Bas\",\"ja\":\"オランダ\",\"it\":\"Paesi Bassi\",\"br\":\"Holanda\",\"pt\":\"Países Baixos\",\"nl\":\"Nederland\",\"hr\":\"Nizozemska\",\"fa\":\"پادشاهی هلند\"},\"flag\":\"https://restcountries.eu/data/nld.svg\",\"regionalBlocs\":[{\"acronym\":\"EU\",\"name\":\"European Union\",\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"NED\"}";
        ArrayList responseList = template.requestBody("direct:dbInput", inputJson, ArrayList.class);
        System.out.println("responseList: " + responseList.size());

        assertNotEquals(0, responseList.size());
    }

    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("postgres");
        ds.setUrl(connectURI);
        return ds;
    }
}