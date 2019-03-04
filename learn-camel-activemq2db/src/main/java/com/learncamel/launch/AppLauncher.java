package com.learncamel.launch;

import com.learncamel.route.jms2jdbc.Jms2DBRoute;
import org.apache.camel.main.Main;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class AppLauncher {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/localdb";

        Main main = new Main();
        main.bind("myDataSource", setupDataSource(url));
        main.addRouteBuilder(new Jms2DBRoute());

        System.out.println("Starting Camel JSM to DB ROute.");

        main.run();
    }

    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(connectURI);
        return ds;
    }


}
