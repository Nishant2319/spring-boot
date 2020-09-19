package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@Autowired
	private ClientDao cd;

	@Autowired
	private Student st;

	@Autowired
	private Service ser;

	@GetMapping("/")
	public String loginPage() {
		return "login.html";
	}

	@GetMapping("logout")
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession ses = req.getSession();
		ses.removeAttribute("name");
		ses.removeAttribute("pass");
		resp.sendRedirect("/");
	}

	@GetMapping("home")
	public String home() {
		return "home.html";
	}

	@PostMapping("fetchClient")
	public void fetchClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("upassword");

		boolean test = false;
		try {
			test = cd.check(name, pass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (test) {
			HttpSession sess = req.getSession();
			sess.setAttribute("name", name);
			sess.setAttribute("pass", pass);
			resp.sendRedirect("/home");
		} else {
			resp.sendRedirect("/");
		}
	}

	@PostMapping("addClient")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("upassword");
		HttpSession sess = req.getSession();

		sess.setAttribute("name", name);
		sess.setAttribute("pass", pass);
		cd.set(name, pass);
		resp.sendRedirect("/home");
	}

	@PostMapping("/fetch/{a}")
	public void fetch(@PathVariable int a, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Student> temp = null;
		if (a == 1) {
			temp = ser.getAll();
		} else if (a == 2) {

			temp = ser.getAll().stream().filter(i -> i.name.equals(req.getParameter("name")))
					.collect(Collectors.toList());
		} else {
			temp = ser.getAll().stream().filter(i -> i.roll == Integer.valueOf(req.getParameter("roll")))
					.collect(Collectors.toList());
		}

		req.getSession().setAttribute("result", temp);
		resp.sendRedirect("/viewStudent.jsp");
	}

	@PostMapping("add")
	public void add1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		st.name = req.getParameter("name");
		st.roll = Integer.valueOf(req.getParameter("roll"));
		st.age = Integer.valueOf(req.getParameter("age"));

		ser.add(st);

		resp.sendRedirect("/home");
	}

	@PostMapping("delete/{a}")
	public void delete1(@PathVariable int a, HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (a == 1) {
			if (ser.getById(Integer.valueOf(req.getParameter("roll"))) != null) {
				ser.delete(Integer.valueOf(req.getParameter("roll")));
				req.getSession().setAttribute("result", "successfully deleted ");
			} else {

				req.getSession().setAttribute("result", "Nothing to Delete");
				
			}
		} else if (a == 2) {
			if (ser.getByName(req.getParameter("name")).size() != 0) {
				ser.deleteName(req.getParameter("name"));
				req.getSession().setAttribute("result", "successfully deleted");
			} else {
				req.getSession().setAttribute("result", "Nothing to Delete");
			}

		} else {
			ser.deleteAll();
			req.getSession().setAttribute("result", "successfully deleted All record");
		}
		resp.sendRedirect("/viewStudent.jsp");
	}

}
