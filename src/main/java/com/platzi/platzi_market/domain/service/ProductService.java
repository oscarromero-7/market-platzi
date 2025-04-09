package com.platzi.platzi_market.domain.service;

import com.platzi.platzi_market.domain.Product;
import com.platzi.platzi_market.domain.repository.ProductRepository;
import com.platzi.platzi_market.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productoRepository;

    public List<Product> getAll(){
        return productoRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productoRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productoRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productoRepository.save(product);
    }

    public Boolean delete(int productID){
        return getProduct(productID).map(product -> {
            productoRepository.delete(productID);
            return true;
        }).orElse(false);
    }
}
