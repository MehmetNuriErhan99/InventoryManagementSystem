package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;

import java.util.List;

public interface IProductService {

    ProductResponseDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(int id);

    ProductResponseDTO updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO);

    boolean deleteProduct(int id);
}
