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

@WebServlet(name="BookEdit", urlPatterns={"/BookEdit"})
public class BookEditServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

        HttpSession session = request.getSession();

        BookFactory simulateDB;
        simulateDB = (BookFactory)session.getAttribute("bookDB");


        Long id = null;
        if(request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));


        Book book = new Book();
        if(id != null)
            book = simulateDB.findBook(id.longValue());

        request.setAttribute("book", book);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookEdit.jsp");

        dispatcher.forward(request, response);	


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        processRequest(request, response);

    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        processRequest(request, response);

    }    
}
