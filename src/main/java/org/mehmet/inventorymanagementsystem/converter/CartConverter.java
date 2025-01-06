package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.cart.CartCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.cart.CartResponseDTO;
import org.mehmet.inventorymanagementsystem.model.Cart;

public class CartConverter {

    public static Cart toCart(CartCreateRequestDTO cartCreateRequestDTO) {
        return new Cart(
                0, // Id sıfır, çünkü yeni bir kayıt oluşturulacak
                cartCreateRequestDTO.getRetailerId(),
                cartCreateRequestDTO.getProductId(),
                cartCreateRequestDTO.getQuantity()
        );
    }

    public static CartResponseDTO toCartResponseDTO(Cart cart) {
        return new CartResponseDTO(
                cart.getId(),
                cart.getRetailerId(),
                cart.getProductId(),
                cart.getQuantity()
        );
    }
}
