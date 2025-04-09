package com.platzi.platzi_market.persistence;

import com.platzi.platzi_market.domain.Product;
import com.platzi.platzi_market.domain.repository.ProductRepository;
import com.platzi.platzi_market.persistence.crud.ProductoCrudRepository;
import com.platzi.platzi_market.persistence.entity.Productos;
import com.platzi.platzi_market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Productos> productos = (List<Productos>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Productos> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Productos>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        productoCrudRepository.findById(productId);
        return productoCrudRepository.findById(productId).map(productos -> mapper.toProduct(productos));
    }

    @Override
    public Product save(Product product) {
        Productos producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productID){
        productoCrudRepository.deleteById(productID);
    }
}
