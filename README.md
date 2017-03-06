# product-price
## Introduction
This is a Restful microservice which provide product price information as shown below:
`[  
{    "product_id": "789",    "price": "60"  },
{    "product_id": "123",    "price": "30"  },
{    "product_id": "456",    "price": "40"  }
]`

## Technology Stack
* Java 8
* SpringBoot
* SpringDataJPA
* SpringDataCassandra
* Maven
* Docker

## Dependency
### Apache cassandra
It requires the database up and running at node mentioned in application.properties. At present it uses EC2 instance.If not please create the below keyspace, table info and provide cassandra host info as part of cassandra.contactpoints in application.properties

`create KEYSPACE product WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
create table productprice (product_id text, price text, PRIMARY KEY (product_id) );
sample insert statement: INSERT INTO productprice (product_id, price) values ('123','30');`

## Running app

./mvnw package && java -jar target/product-price-0.0.1-SNAPSHOT.jar

## To build docker image

./mvnw package docker:build   - This command builds a docker image with name: sudhakarbathina/product-price:latest

## Running docker image

docker run -p 9004:9004 -t sudhakarbathina/product-price   

## Routes

[list all routes that this service supports]

| Method | Route | Class | Description
| ------ | ----- | ----- | -----------
| GET | /item/price/v1 | ProductPriceController.products | Lists all ItemIds available along with their price
| GET | /item/price/v1/{id} | ProductPriceController.productPriceById | Provides requested Itemid and price
| PUT | /item/price/v1 | ProductPriceController.editProductPrice | updates price for a input Itemid
