package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IProductDAO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.converter.ProductConverter;
import org.mehmet.inventorymanagementsystem.model.Product;
import org.mehmet.inventorymanagementsystem.service.abstr.IProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {

    private final IProductDAO productDAO;

    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO) {
        // CreateRequestDTO'yu Product modeline dönüştür
        Product product = ProductConverter.toModel(productCreateRequestDTO);

        boolean isCreated = productDAO.createProduct(product);

        return isCreated ? ProductConverter.toResponse(product) : null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productDAO.getAllProducts();

        return products.stream()
                .map(ProductConverter::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        Product product = productDAO.getProductById(id);

        return product != null ? ProductConverter.toResponse(product) : null;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO) {
        // UpdateRequestDTO'yu Product modeline dönüştür
        Product product = ProductConverter.toModel(productUpdateRequestDTO);

        boolean isUpdated = productDAO.updateProduct(product);

        return isUpdated ? ProductConverter.toResponse(product) : null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }
}
