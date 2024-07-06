package com.qsp.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.food_app.dao.ItemsDao;
import com.qsp.food_app.dto.Items;

@WebServlet("/updateorder")
public class UpdateOrderController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		ItemsDao dao = new ItemsDao();
		Items items = dao.getItemsById(id);

		if (items != null) {
			req.setAttribute("items", items);
			RequestDispatcher dispatcher = req.getRequestDispatcher("updateorder.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
