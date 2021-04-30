package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import model.User;
import utils.PathConst;
import utils.UrlConst;

@WebServlet(urlPatterns = { UrlConst.USER_DASHBOARD, UrlConst.USER_ADD, UrlConst.USER_EDIT, UrlConst.USER_DELETE })
public class UserServlet extends HttpServlet {

	private UserController userController;
	private String message;
	private String username;

	@Override
	public void init() throws ServletException {
		userController = new UserController();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		System.out.println("Path : " + servletPath);

		switch (servletPath) {
		case UrlConst.USER_DASHBOARD: // Show user list
			showDashboard(req, resp);
			break;

		case UrlConst.USER_ADD: // Add a user
			req.getRequestDispatcher(PathConst.USER_ADD).forward(req, resp);
			break;

		case UrlConst.USER_EDIT: // Edit a user
			username = req.getParameter("username");

			User curUser = userController.findByUsername(username);

			if (username == null) {
				showDashboard(req, resp);
			} else {
				req.setAttribute("curUser", curUser);
				req.getRequestDispatcher(PathConst.USER_EDIT).forward(req, resp);
			}
			break;

		case UrlConst.USER_DELETE: // Delete a user
			username = req.getParameter("username");
			userController.delete(username);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		switch (servletPath) {
		case UrlConst.USER_ADD: // Add a user
			User newUser = null;

			try {

				newUser = getValueFromRequest(req);

			} catch (NumberFormatException e) {
				System.out.println("Number invalid at : " + e);
				message = "Number is invalid format!";
				returnAddPage(req, resp, newUser);
			}

			int resultUpdate = userController.add(newUser);
			validateForm(req, resp, newUser, resultUpdate);
			break;

		case UrlConst.USER_EDIT: // Edit a user
			User updateUser = null;

			try {

				updateUser = getValueFromRequest(req);

			} catch (NumberFormatException e) {
				System.out.println("Number invalid at : " + e);
				message = "Number is invalid format!";
				returnAddPage(req, resp, updateUser);
			}

			updateUser = getValueFromRequest(req);
			int resultEdit = userController.update(updateUser, updateUser.getUsername());
			validateForm(req, resp, updateUser, resultEdit);
			break;
		}
	}

	private void validateForm(HttpServletRequest req, HttpServletResponse resp, User newUser, int result)
			throws IOException, ServletException {
		switch (result) {
		case 1: // Add a user successfully
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);
			break;

		case 2: // Username already used
			message = "Username already used!";
			returnAddPage(req, resp, newUser);
			break;

		case 3: // Full name can not null
			message = "Enter full name";
			returnAddPage(req, resp, newUser);
			break;

		case 4: // Username can not null
			message = "Enter username";
			returnAddPage(req, resp, newUser);
			break;

		case 5: // Password can not null
			message = "Enter password";
			returnAddPage(req, resp, newUser);
			break;
		}
	}

	private void showDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = userController.findAll();
		req.setAttribute("userList", userList);
		req.getRequestDispatcher(PathConst.USER_DASHBOARD).forward(req, resp);
	}

	private void returnAddPage(HttpServletRequest req, HttpServletResponse resp, User newUser)
			throws ServletException, IOException {
		req.setAttribute("errMsg", message);
		req.setAttribute("curUser", newUser);
		doGet(req, resp);
	}

	private User getValueFromRequest(HttpServletRequest req) throws NumberFormatException {
		String fullName = req.getParameter("fullName").trim();
		int birthYear = Integer.parseInt(req.getParameter("birthYear"));
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		int role = Integer.parseInt(req.getParameter("role"));

		System.out.println("[Full name = " + fullName + ", Birth year = " + birthYear + ", Username = " + username
				+ ", Password = " + password + ", Role = " + role);

		User newUser = new User(fullName, birthYear, username, password, role);
		return newUser;
	}
}
