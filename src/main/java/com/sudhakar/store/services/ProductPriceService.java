package com.sudhakar.store.services;
import static org.springframework.data.cassandra.repository.support.BasicMapId.id;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import com.sudhakar.store.domain.Productprice;
import com.sudhakar.store.repository.ProductPriceRepository;


@Service
public class ProductPriceService {
	
	    @Autowired
	    private ProductPriceRepository productPriceRepository;


	    public Productprice findProductById(String product_id){
	        MapId id = id("product_id", product_id);
	        return productPriceRepository.findOne(id);
	    }

	    public List<Productprice> getProductPrice(){
	        return (List<Productprice>) productPriceRepository.findAll();
	    }

	    public Productprice editProductPrice(Productprice productPrice){
	        return productPriceRepository.save(productPrice);
	    }

	    public boolean exitsProductPrice(String product_id){
	        MapId id = id("product_id", product_id);
	        return productPriceRepository.exists(id);
	    }


}
