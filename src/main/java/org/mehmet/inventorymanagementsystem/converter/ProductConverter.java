package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Product;

public class ProductConverter {
    public Product toEntity(ProductCreateRequestDTO dto) {
        return new Product(
                0, // ID is auto-generated
                dto.getName(),
                dto.getStockQuantity(),
                dto.getPrice(),
                dto.getDiscount()
        );
    }

    public ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getStockQuantity(),
                product.getPrice(),
                product.getDiscount()
        );
    }

    public Product toEntity(ProductUpdateRequestDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getStockQuantity(),
                dto.getPrice(),
                dto.getDiscount()
        );
    }
}
