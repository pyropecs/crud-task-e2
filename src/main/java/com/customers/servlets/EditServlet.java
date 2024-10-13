package com.customers.servlets;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customers.FetchCustomers;
import com.customers.beanclasses.Customer;
@WebServlet("edit")
public class EditServlet extends HttpServlet {

public void doGet(HttpServletRequest req,HttpServletResponse res){
         int id = Integer.parseInt(req.getParameter("id"));
        FetchCustomers fetchCustomers = new FetchCustomers();
        List<Customer> customerResult = fetchCustomers.getCustomers(id);
        req.setAttribute("resultForm", customerResult);
}

}
