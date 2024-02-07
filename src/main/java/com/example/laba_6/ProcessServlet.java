package com.example.laba_6;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet( value = "/processGrades")
public class ProcessServlet extends HttpServlet {
   @EJB
    MyEjb myEjb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentCount = (int) request.getSession().getAttribute("count");

        for (int i = 1; i <= studentCount; i++) {
            String surname = request.getParameter("name" + i);
            String grades = request.getParameter("grades" + i);

            String[] gradesArray = grades.split(",");

            System.out.println("Студент " + i + ": Фамилия - " + surname + ", Оценки - " + grades);
            myEjb.addStudentGrades(surname, gradesArray);
        }
        Map<String, String[]> gradesWithErrors = myEjb.getGradesWithErrorsMap();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Оценки с ошибками:</h2>");
        if (gradesWithErrors.isEmpty()) {
            out.println("<p>Нет оценок с ошибками.</p>");
        } else {
            for (Map.Entry<String, String[]> entry : gradesWithErrors.entrySet()) {
                String surname = entry.getKey();
                String[] grades = entry.getValue();
                out.println("<p>Студент: " + surname + "</p>");
                out.println("<p>Оценки: ");
                for (String grade : grades) {
                    out.print(grade + " ");
                }
                out.println("</p>");
            }
        }
        out.println("</body></html>");


        }


    }

