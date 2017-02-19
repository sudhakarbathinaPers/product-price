package com.sudhakar.store.domain;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


@Table
public class Productprice {

    @PrimaryKeyColumn(name = "product_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String product_id;

    @Column
    private String price;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


}
