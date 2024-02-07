package com.example.laba_6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int count = Integer.parseInt(request.getParameter("collectionSize"));
        request.getSession().setAttribute("count",count);
        request.setAttribute("count", count);
        request.getRequestDispatcher("process.jsp").forward(request, response);
    }
}