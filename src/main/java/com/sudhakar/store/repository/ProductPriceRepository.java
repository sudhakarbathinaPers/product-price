package com.sudhakar.store.repository;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.sudhakar.store.domain.Productprice;

public interface ProductPriceRepository extends CassandraRepository<Productprice>{
}
