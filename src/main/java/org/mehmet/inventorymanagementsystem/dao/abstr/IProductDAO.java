package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Product;

import java.util.List;



public interface IProductDAO {
    void createProduct(Product product) throws Exception;
    Product getProductById(int id) throws Exception;
    List<Product> getAllProducts() throws Exception;
    void updateProduct(Product product) throws Exception;
    void deleteProduct(int id) throws Exception;

    List<Product> getProductsByName(String name) throws Exception;

    List<Product> searchProductsByName(String name) throws Exception;
}
