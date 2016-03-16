<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<%@page import="library.model.BookFactory" %>
<%@page import="library.model.Book" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>


<html>
    <head>    
        <title>Book list page</title>
    </head>

    <%
        Collection<Book> books;
        BookFactory bookDB = (BookFactory) session.getAttribute("bookDB");
        if((BookFactory) session.getAttribute("letter")!=null){
             books = bookDB.getBooksn();
        }else{
            books= bookDB.getBooks();
        }
        
    %>  
    <body>
        <a href="BookList?l=a">a</a>
        <a href="">b</a>
        <a href="">c</a>
        <a href="">d</a>
        <a href="">e</a>
        <a href="">f</a>
        <a href="">g</a>
        <a href="">h</a>
        <a href="">i</a>
        <a href="">j</a>
        <a href="">k</a>
        <a href="">l</a>
        <a href="">m</a>
        <a href="">n</a>
        <a href="">ñ</a>
        <a href="">o</a>
        <a href="">p</a>
        <a href="">q</a>
        <a href="">r</a>
        <a href="">s</a>
        <a href="">t</a>
        <a href="">u</a>
        <a href="">v</a>
        <a href="">w</a>
         <a href="">x</a>
        <a href="">y</a>
        <a href="">z</a>
        
        
        <table border="1">
            <tbody>
                <tr>
                    <td><b>Contact</b></td>
                    <td><b>Phone</b></td>
                    <td><b>Movile</b></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <%
                    for (Book libro : books) {
                %>
                <tr>
                    <td><%= libro.getAuthor()%> </td>
                    <td><%= libro.getTitle()%> </td>
                    <%
                        if (libro.isAvailable()) {
                    %>

                    <td><input type="checkbox" name="available" value="true" disabled checked /></td>
                        <%
                        } else {
                        %>
                    <td><input type="checkbox" name="available" value="true" disabled /></td>

                    <%
                        }
                    %>                    
                    <td><a href="BookEdit?id=<%= libro.getId()%>" >Edit</a></td>
                    <td><a href="BookDelete?id=<%= libro.getId()%>">Delete</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <br>
        <a href="bookAdd.jsp">Añadir contacto</a>
    </body>
</html>
