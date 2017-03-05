package com.sudhakar.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudhakar.store.domain.Productprice;
import com.sudhakar.store.services.ProductPriceService;

@Controller
@RequestMapping("/item/price/v1")
public class ProductPriceController {

    @Autowired
    private ProductPriceService service;

    @RequestMapping( method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<List<Productprice>> getProducts(){
        return new ResponseEntity(service.getProductPrice(), HttpStatus.OK);
    }
    
    @RequestMapping( path = "/{id}", method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<Productprice> getProductPriceById(@PathVariable String id){
        if(!service.exitsProductPrice(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Productprice productPrice = service.findProductById(id);
        return new ResponseEntity(productPrice,HttpStatus.ACCEPTED);
    }

    @RequestMapping(  method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Productprice> editProductPrice(@RequestBody Productprice productPrice){
        if(productPrice.getProduct_id() == null || !service.exitsProductPrice(productPrice.getProduct_id())){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Productprice priceEdited = service.editProductPrice(productPrice);
        return new ResponseEntity(priceEdited, HttpStatus.ACCEPTED);
}    

}

