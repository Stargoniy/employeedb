package com.in6k.employeedb.servlet;

import com.in6k.employeedb.dao.EmployeeDao;
import com.in6k.employeedb.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = EmployeeDao.findAllEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/userlist.jsp").include(req, resp);
    }
}
