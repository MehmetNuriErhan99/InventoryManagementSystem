package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Product;
import java.util.List;

public interface IProductDAO {
    boolean createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
}
