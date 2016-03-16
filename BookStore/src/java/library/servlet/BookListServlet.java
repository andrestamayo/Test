package library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.model.BookFactory;

@WebServlet(name="BookList", urlPatterns={"/BookList"})
public class BookListServlet extends HttpServlet {


    public void processRequest(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

        HttpSession session = request.getSession();

        BookFactory books;

        books = (BookFactory)session.getAttribute("bookDB");
        if (books == null) {
            if(request.getAttribute("l")!=null){
                System.out.println(request.getAttribute("l").toString());
                books = new BookFactory(request.getAttribute("l").toString());
                session.setAttribute("letter", books);
                
            }else{
                books = new BookFactory();
            }
            
            session.setAttribute("bookDB", books);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookList.jsp");
        dispatcher.forward(request, response);		
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

            this.processRequest(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

            this.processRequest(request, response);
    }    
}
