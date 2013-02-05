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
//            EmployeeModel em = new EmployeeModel(ProviderFactory.ProviderType.XML);
//            em.load(new File(Config.getUsersDir() + req.getParameter("email") + ".xml"));
//            req.setAttribute("employee", em);
        }
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setFirstName(setFieldParam(req, "name"));
        employeeForm.setLastName(setFieldParam(req, "surname"));
        employeeForm.setEmail(setFieldParam(req, "email"));
        employeeForm.setPassword(setFieldParam(req, "password"));
        employeeForm.setPasswordConfirmation(setFieldParam(req, "passwordConfirmation"));
        employeeForm.setBirhdate(setFieldParam(req, "birhdate"));
        req.setAttribute("employeeform", employeeForm);

        req.getRequestDispatcher("/employeeform.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setFirstName(req.getParameter("firstName"));
        employeeForm.setLastName(req.getParameter("lastName"));
        employeeForm.setEmail(req.getParameter("email"));
        employeeForm.setPassword(req.getParameter("password"));
        employeeForm.setPasswordConfirmation(req.getParameter("passwordConfirmation"));
        employeeForm.setBirhdate(req.getParameter("birhdate"));

        Set<String> errors = employeeForm.validate();
        boolean HAS_ERROR = !errors.isEmpty();

        if (HAS_ERROR) {
//            employeeForm.setName(setFieldParam(req, "name"));
//            employeeForm.setSurname(setFieldParam(req, "surname"));
//            employeeForm.setEmail(setFieldParam(req, "email"));
//            employeeForm.setPassword(setFieldParam(req, "password"));
//            employeeForm.setPasswordConfirmation(setFieldParam(req, "passwordConfirmation"));
//            employeeForm.setBirhdate(setFieldParam(req, "birhdate"));
//            req.setAttribute("employeeform", employeeForm);

            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/employeeform.jsp").include(req, resp);
        } else {
            Employee employee = new Employee();
            employee.setFirstName(employeeForm.getFirstName());
            employee.setLastName(employeeForm.getLastName());
            employee.setEmail(employeeForm.getEmail());
            employee.setPassword(employeeForm.getPassword());
            employee.setBirhdate(employeeForm.getBirhdate());
            EmployeeDao.save(employee);
//            EmployeeModel em = new EmployeeModel(employeeForm, ProviderFactory.ProviderType.DB);
//            em.save();
            resp.sendRedirect("/userlist");
        }
    }

    private String setFieldParam(HttpServletRequest request, String value) {
        String result = "";
//        EmployeeModel employee;
//        if (request.getAttribute("employee") != null) {
//            employee = (EmployeeModel)request.getAttribute("employee");
//            if (value.equals("name")) {
//                result = employee.getName();
//            } else if (value.equals("surname")) {
//                result = employee.getSurname();
//            } else if (value.equals("email")) {
//                result = employee.getEmail();
//            } else if (value.equals("password") || value.equals("passwordConfirmation")) {
//                result = employee.getPassword();
//            } else if (value.equals("birhdate")) {
//                result = employee.getBirhdate();
//            }
//        } else if (request.getParameter(value) != null) {
//            result = request.getParameter(value);
//        }
        return result;
    }
}
