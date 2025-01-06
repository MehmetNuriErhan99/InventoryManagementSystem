package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.cart.CartCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.cart.CartResponseDTO;

import java.util.List;

public interface ICartService {

    void addProductToCart(CartCreateRequestDTO cartCreateRequestDTO) throws Exception;

    void updateCart(CartCreateRequestDTO cartCreateRequestDTO) throws Exception;

    void removeProductFromCart(int id) throws Exception;

    List<CartResponseDTO> getCartByRetailerId(int retailerId) throws Exception;

    void clearCartByRetailerId(int retailerId) throws Exception;
}
