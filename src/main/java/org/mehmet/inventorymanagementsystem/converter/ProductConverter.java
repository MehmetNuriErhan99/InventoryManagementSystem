package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Product;

public class ProductConverter {

    // ProductCreateRequestDTO -> Product
    public static Product toModel(ProductCreateRequestDTO productCreateRequestDTO) {
        if (productCreateRequestDTO == null) {
            throw new IllegalArgumentException("ProductCreateRequestDTO cannot be null");
        }
        return new Product(
                0, // ID veritabanı tarafından atanacak
                productCreateRequestDTO.getName(),
                productCreateRequestDTO.getStockQuantity(),
                productCreateRequestDTO.getPrice(),
                productCreateRequestDTO.getDiscount()
        );
    }

    // Product -> ProductResponseDTO
    public static ProductResponseDTO toResponse(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        // ProductResponseDTO'da statü gibi ek bilgileri manuel olarak belirleyebilirsiniz.
        String status = product.getStockQuantity() > 0 ? "In Stock" : "Out of Stock";
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                status
        );
    }

    // ProductUpdateRequestDTO -> Product
    public static Product toModel(ProductUpdateRequestDTO productUpdateRequestDTO) {
        if (productUpdateRequestDTO == null) {
            throw new IllegalArgumentException("ProductUpdateRequestDTO cannot be null");
        }
        return new Product(
                productUpdateRequestDTO.getId(),
                productUpdateRequestDTO.getName(),
                productUpdateRequestDTO.getStockQuantity(),
                productUpdateRequestDTO.getPrice(),
                productUpdateRequestDTO.getDiscount()
        );
    }
}
