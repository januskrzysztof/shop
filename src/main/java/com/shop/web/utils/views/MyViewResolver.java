package com.shop.web.utils.views;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.util.Locale;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
public class MyViewResolver extends InternalResourceViewResolver {
    private String layout;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        MyView view = (MyView) super.resolveViewName(layout, locale);
        view.setPage(getPrefix()+viewName+getSuffix());

        return view;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
}
