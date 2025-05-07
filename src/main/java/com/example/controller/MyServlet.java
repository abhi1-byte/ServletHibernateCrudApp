package com.example.controller;

import com.example.dto.Student;
import com.example.service.IStudentService;
import com.example.servicefactory.StudentServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller/*")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Request Path: " + request.getPathInfo());
        IStudentService studentService = StudentServiceFactory.getStudentService();
        if (request.getRequestURI().endsWith("addform")) {
            Student s = new Student();
            s.setSage(Integer.parseInt(request.getParameter("sage")));
            s.setSname(request.getParameter("sname"));
            s.setSaddress(request.getParameter("saddress"));
            int status = studentService.save(s);
            request.setAttribute("status", status);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/insertResult.jsp");
            rd.forward(request, response);
        }
        if (request.getRequestURI().endsWith("searchform")) {
            Integer sid = (Integer.parseInt(request.getParameter("sid")));
            Student student = studentService.getById(sid);
            request.setAttribute("student", student);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/display.jsp");
            rd.forward(request, response);
        }
        if (request.getRequestURI().endsWith("deleteform")) {
            Integer sid = (Integer.parseInt(request.getParameter("sid")));
            int status = studentService.deleteById(sid);
            request.setAttribute("status", status);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/deleteResult.jsp");
            rd.forward(request, response);
        }
        if (request.getRequestURI().endsWith("editform")) {
            String sid = request.getParameter("sid");
            Student student = studentService.getById(Integer.parseInt(sid));
            request.setAttribute("student", student);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/editform.jsp");
            rd.forward(request, response);
        }

        if (request.getRequestURI().endsWith("updateRecord")) {
            Student s = new Student();
            s.setSid((Integer.parseInt(request.getParameter("sid"))));
            s.setSage(Integer.parseInt(request.getParameter("sage")));
            s.setSname(request.getParameter("sname"));
            s.setSaddress(request.getParameter("saddress"));
            int status = studentService.updateById(s);
            request.setAttribute("status", status);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/updateResult.jsp");
            rd.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            processRequest(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}