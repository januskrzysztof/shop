package com.shop.models;

import com.shop.exceptions.CartException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by apbudzinski on 2015-02-05.
 */
public class Cart implements Serializable {
    private Set<CartProduct> cartProducts = new LinkedHashSet<>();

    public void addProduct(Product product) {
        if (hasProduct(product)) {
            getCartProductByProduct(product).add();
        } else {
            if (product == null) {
                throw new IllegalArgumentException("Product cannot be null!");
            }

            cartProducts.add(new CartProduct(product));
        }
    }

    public void removeProduct(Product product) {
        if (hasProduct(product)) {
            cartProducts.remove(getCartProductByProduct(product));
        } else {
            throw CartException.createCartProductNotFound(product);
        }
    }

    public void setCartProductQuantity(Product product, int quantity) {
        if (hasProduct(product)) {
            getCartProductByProduct(product).setQuantity(quantity);
        } else {
            throw CartException.createCartProductNotFound(product);
        }
    }

    public boolean hasProduct(Product product) {
        return getCartProductByProduct(product) != null;
    }

    public void clear() {
        cartProducts = new LinkedHashSet<>();
    }

    private CartProduct getCartProductByProduct(Product product) {
        for (CartProduct cartProduct : cartProducts) {
            if (cartProduct.getProduct().equals(product)) {
                return  cartProduct;
            }
        }

        return null;
    }

    /**
     * Additional class
     */
    private static class CartProduct {
        private Product product;
        private int quantity;

        public CartProduct(Product product) {
            this.product = product;
            quantity = 1;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            if (quantity <= 0) {
                throw new CartException("Quantity cannot be less then 0.");
            }

            this.quantity = quantity;
        }

        public void add() {
            ++quantity;
        }

        public void remove() {
            if (quantity == 1) {
                throw new CartException("Cannot remove product. Quantity is min(1). ");
            }
            --quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CartProduct that = (CartProduct) o;

            if (!product.equals(that.product)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return product.hashCode();
        }

        @Override
        public String toString() {
            return "CartProduct{" +
                    "product=" + product +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + cartProducts +
                '}';
    }
}
