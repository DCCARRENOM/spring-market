package com.daniel.market.domain.service;

import com.daniel.market.domain.Product;
import com.daniel.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired//A pesar de ser interfaz al anotar asi spring sabe que debe crear
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId){
       /* if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }una forma*/


        return getProduct(productId).map(product ->{
            productRepository.delete(productId);
            return true;
        }).orElse(false);//OTRA FORMA
    }
}
