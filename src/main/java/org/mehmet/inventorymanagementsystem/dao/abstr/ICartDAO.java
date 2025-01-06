package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Cart;

import java.util.List;

public interface ICartDAO {

    void addProductToCart(Cart cart) throws Exception;

    void updateCart(Cart cart) throws Exception;

    void removeProductFromCart(int id) throws Exception;

    List<Cart> getCartByRetailerId(int retailerId) throws Exception;

    void clearCartByRetailerId(int retailerId) throws Exception;
}
