package com.controller;

import java.io.IOException;

import com.dao.ShoppingCartDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RemoveItemServlet")
public class RemoveItemServlet extends HttpServlet {

    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ShoppingCartDAO dao = new ShoppingCartDAO();
        dao.deleteItem(id);

        response.sendRedirect("index.jsp");
    }

}