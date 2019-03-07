# learn-camel-rest2db
This is a repo which holds example code of an apache camel route that connects a Rest endpoint to a database.

This endpoint was built using [RestCountries.eu](http://restcountries.eu).

Also make sure you have PostgreSQL installed and create a `localdb` databse  with the following query executed:
```postgresql
CREATE TABLE country_capital (
  countryName text,
  capital     text,
  create_date timestamp without time zone DEFAULT now()
)
```
