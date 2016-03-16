package library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.model.BookFactory;


@WebServlet(name = "BookDeleteServlet", urlPatterns = {"/BookDelete"})
public class BookDeleteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        BookFactory simulateDB;
        simulateDB = (BookFactory)session.getAttribute("bookDB");

        if(request.getParameter("id") != null) {
            Long id = null;
            id = Long.valueOf(request.getParameter("id"));        
            simulateDB.deleteBook(id.longValue());
        }

        response.sendRedirect(request.getContextPath() + "/BookList");        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
