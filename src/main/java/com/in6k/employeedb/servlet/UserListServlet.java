package com.in6k.employeedb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        File[] employeesFiles = new File(Config.getUsersDir()).listFiles();
//        List<EmployeeModel> employeeModels = new ArrayList<EmployeeModel>();
//
//        for (File f : employeesFiles) {
//            EmployeeModel employeeModel = new EmployeeModel(ProviderFactory.ProviderType.XML);
//            employeeModel.load(f);
//            employeeModels.add(employeeModel);
//        }
//        req.setAttribute("employees", employeeModels);
        req.getRequestDispatcher("/userlist.jsp").include(req, resp);
    }
}
