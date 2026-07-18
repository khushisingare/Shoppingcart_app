package com.controller;

import java.io.IOException;

import com.dao.ShoppingCartDAO;
import com.model.ShoppingCartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1548269116180425891L;

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        ShoppingCartItem item = new ShoppingCartItem();
        item.setName(name);
        item.setPrice(price);

        ShoppingCartDAO dao = new ShoppingCartDAO();
        dao.addItem(item);

        response.sendRedirect("index.jsp");
    }

}