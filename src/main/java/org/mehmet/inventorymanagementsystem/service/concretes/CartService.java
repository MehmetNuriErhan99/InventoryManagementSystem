package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.ICartDAO;
import org.mehmet.inventorymanagementsystem.dto.cart.CartCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.cart.CartResponseDTO;
import org.mehmet.inventorymanagementsystem.converter.CartConverter;
import org.mehmet.inventorymanagementsystem.model.Cart;
import org.mehmet.inventorymanagementsystem.service.abstr.ICartService;

import java.util.List;
import java.util.stream.Collectors;

public class CartService implements ICartService {

    private ICartDAO cartDAO = null;

    public CartService() {
        this.cartDAO = cartDAO;
    }

    @Override
    public void addProductToCart(CartCreateRequestDTO cartCreateRequestDTO) throws Exception {
        Cart cart = CartConverter.toCart(cartCreateRequestDTO);
        cartDAO.addProductToCart(cart);
    }

    @Override
    public void updateCart(CartCreateRequestDTO cartCreateRequestDTO) throws Exception {
        Cart cart = CartConverter.toCart(cartCreateRequestDTO);
        cartDAO.updateCart(cart);
    }

    @Override
    public void removeProductFromCart(int id) throws Exception {
        cartDAO.removeProductFromCart(id);
    }

    @Override
    public List<CartResponseDTO> getCartByRetailerId(int retailerId) throws Exception {
        List<Cart> cartItems = cartDAO.getCartByRetailerId(retailerId);
        return cartItems.stream()
                .map(CartConverter::toCartResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void clearCartByRetailerId(int retailerId) throws Exception {
        cartDAO.clearCartByRetailerId(retailerId);
    }
}
