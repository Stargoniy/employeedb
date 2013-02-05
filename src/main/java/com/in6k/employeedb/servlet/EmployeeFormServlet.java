package com.in6k.employeedb.servlet;

import com.in6k.employeedb.dao.EmployeeDao;
import com.in6k.employeedb.entity.Employee;
import com.in6k.employeedb.form.EmployeeForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class EmployeeFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            Employee employee = EmployeeDao.findEmployeeById(new Integer(req.getParameter("id")));
            EmployeeForm employeeForm = new EmployeeForm();
            employeeForm.setId(employee.getId());
            employeeForm.setFirstName(employee.getFirstName());
            employeeForm.setLastName(employee.getLastName());
            employeeForm.setEmail(employee.getEmail());
            employeeForm.setPassword(employee.getPassword());
            employeeForm.setPasswordConfirmation(employee.getPassword());
            employeeForm.setBirhdate(employee.getBirhdate());
            req.setAttribute("employeeform", employeeForm);
        }
        req.getRequestDispatcher("/employeeform.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = new Integer(req.getParameter("id"));
        Employee employee;
        if (id != -1) {
            employee = EmployeeDao.findEmployeeById(id);
        } else {
            employee = new Employee();
        }
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setId(id);
        employeeForm.setFirstName(req.getParameter("firstName"));
        employeeForm.setLastName(req.getParameter("lastName"));
        employeeForm.setEmail(req.getParameter("email"));
        employeeForm.setPassword(req.getParameter("password"));
        employeeForm.setPasswordConfirmation(req.getParameter("passwordConfirmation"));
        employeeForm.setBirhdate(req.getParameter("birhdate"));

        Set<String> errors = employeeForm.validate();
        boolean HAS_ERROR = !errors.isEmpty();

        if (HAS_ERROR) {
            req.setAttribute("employeeform", employeeForm);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/employeeform.jsp").include(req, resp);
        } else {
            employee.setFirstName(employeeForm.getFirstName());
            employee.setLastName(employeeForm.getLastName());
            employee.setEmail(employeeForm.getEmail());
            employee.setPassword(employeeForm.getPassword());
            employee.setBirhdate(employeeForm.getBirhdate());
            EmployeeDao.save(employee);
            resp.sendRedirect("/userlist");
        }
    }
}
