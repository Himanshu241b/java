package com.example.crud.service;

import com.example.crud.entity.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    //Constructor injection of productRepository
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /**
     * method to add a new product
     * @param product new product entity
     * @return saved product entity
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    /**
     * method to add a list of products to database
     * @param products list of products
     * @return saved products entity list
     */
    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    /**
     * method to get all products of product table
     * @return all products of product table
     */
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    /**
     *method to get a product searching by its id
     * @param id id of product to search
     * @return Product entity if found or null if no product found
     */
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    /**
     * method to get a product by its name
     * @param name name of product
     * @return product entity of found product
     */
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    /**
     * method to delete product in product table
     * @param id id of product to delete
     */
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product deleted successfully" + id;
    }

    /**
     * method to update a product
     * @param product product entity to update
     * @return updated product
     */
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }
}
