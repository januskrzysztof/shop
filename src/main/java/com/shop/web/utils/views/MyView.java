package com.shop.web.utils.views;

import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
public class MyView extends JstlView {
    private String page;

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("page", page);
        super.render(model, request, response);
    }

    public void setPage(String page) {
        this.page = page;
    }
}
