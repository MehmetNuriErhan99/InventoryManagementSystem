package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;

import java.util.List;



import java.util.List;

public interface IProductService {
    void createProduct(ProductCreateRequestDTO dto) throws Exception;
    ProductResponseDTO getProductById(int id) throws Exception;
    List<ProductResponseDTO> getAllProducts() throws Exception;
    void updateProduct(ProductUpdateRequestDTO dto) throws Exception;
    void deleteProduct(int id) throws Exception;
    List<ProductResponseDTO> getProductsByName(String name) throws Exception;

}

