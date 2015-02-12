package com.shop;

import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dao.repository.UserRepository;
import com.shop.models.Cart;
import com.shop.models.Product;
import com.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static com.shop.models.Cart.*;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
public class MainApp {


    public static void main(String[] args) {
       /* Cart cart = new Cart();
        Product product = new Product();
        product.setId(1);
        product.setName("asd");
        product.setNetPrice(1223);
        cart.addProduct(product);

        product = new Product();
        product.setId(2);
        product.setName("asd");
        product.setNetPrice(1223);
        cart.addProduct(product);

        cart.setCartProductQuantity(product, 20);

        System.out.println(cart);

*/

       // User u = ur.findUserByLastName("Chuchla");


    }
}
