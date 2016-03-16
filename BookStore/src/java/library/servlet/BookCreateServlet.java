package library.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.model.Book;
import library.model.BookFactory;

@WebServlet(name = "BookCreateServlet", urlPatterns = {"/BookCreate"})
public class BookCreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        HttpSession session = request.getSession();

        BookFactory simulateDB;
        simulateDB = (BookFactory)session.getAttribute("bookDB");

        long id = 0;

        try {
            String str = request.getParameter("id");
            if (str != null) {
                id = Long.parseLong(request.getParameter("id")); 
            }

        } catch(NumberFormatException e){
            RequestDispatcher rd;
            rd = (RequestDispatcher)this.getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
            return;
        }

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Boolean available = Boolean.valueOf(request.getParameter("available"));

        Book book = new Book(id, author, title, available.booleanValue());

        if (id == 0) {            
            simulateDB.createBook(book);
        } else {
            simulateDB.updateBook(book);
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
