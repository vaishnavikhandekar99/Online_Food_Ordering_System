package com.qsp.food_app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.food_app.dao.MenuDao;
import com.qsp.food_app.dto.Menu;

@WebServlet("/delete")
public class DeleteMenuController extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		MenuDao dao = new MenuDao();
		boolean result = dao.deleteMenu(id);
		if (result) {
			List<Menu> menus = dao.getAllMenus();
			req.setAttribute("menus", menus);
			RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
			dispatcher.forward(req, resp);
		}
	}


}
