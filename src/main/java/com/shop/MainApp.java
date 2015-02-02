package com.shop;

import com.shop.models.Category;
import com.shop.repository.CategoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Category category = new Category();
        category.setName("asd");

        CategoryRepository repository = (CategoryRepository) context.getBean("categoryRepository");
        repository.insert(category);
    }
}
