package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.converter.ProductConverter;
import org.mehmet.inventorymanagementsystem.dao.abstr.IProductDAO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.exception.NotFoundException;
import org.mehmet.inventorymanagementsystem.model.Product;
import org.mehmet.inventorymanagementsystem.service.abstr.IProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    private final IProductDAO productDAO;
    private final ProductConverter productConverter;

    public ProductService(IProductDAO productDAO, ProductConverter productConverter) {
        this.productDAO = productDAO;
        this.productConverter = productConverter;
    }

    @Override
    public void createProduct(ProductCreateRequestDTO dto) throws Exception {
        Product product = productConverter.toEntity(dto);
        productDAO.createProduct(product);
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws Exception {
        Product product = productDAO.getProductById(id);
        if (product == null) {
            throw new NotFoundException("Product not found with ID: " + id);
        }
        return productConverter.toDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() throws Exception {
        List<Product> products = productDAO.getAllProducts();
        return products.stream().map(productConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public void updateProduct(ProductUpdateRequestDTO dto) throws Exception {
        Product product = productConverter.toEntity(dto);
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) throws Exception {
        Product product = productDAO.getProductById(id);
        if (product == null) {
            throw new NotFoundException("Product not found with ID: " + id);
        }
        productDAO.deleteProduct(id);
    }
    @Override
    public List<ProductResponseDTO> getProductsByName(String name) throws Exception {
        List<Product> products = productDAO.getProductsByName(name);
        return products.stream().map(productConverter::toDTO).collect(Collectors.toList());
    }
    public List<Product> searchProductsByName(String name) throws Exception {
        return productDAO.searchProductsByName(name);
    }


}
