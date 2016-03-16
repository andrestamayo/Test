<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<%@page import="library.model.BookFactory" %>
<%@page import="library.model.Book" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>


<html>
    <style>
        .m{
             margin: auto;
             width: 80%;
             
            
        } 
        .r{
             background-color: rgba(245, 0,0, 0.4)!important;
             
            
        } 
    </style>
    <head>    
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/script.js"></script>
        <title>Book list page</title>
    </head>

    <body>
        
                   
        
    <%
        BookFactory bookDB = (BookFactory) session.getAttribute("bookDB");
        Collection<Book> books = bookDB.getBooks();
    %>  
    <div class="panel panel-default m  ">
        <div class="panel-heading r ">Agenda</div>
         <div class="panel-body">
    <div class="container ">
        <table  class="table ">
            <tbody>
                <tr>
                    <td><b>Contacto</b></td>
                    <td><b>Telefono</b></td>
                    <td><b>Movil</b></td>
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
            <a href="ServletName?id=A">a</a>
        <a href="ServletName?id=B">b</a>
        <a href="ServletName?id=C">c</a>
        <a href="ServletName?id=D">d</a>
        <a href="ServletName?id=E">e</a>
        <a href="ServletName?id=F">f</a>
        <a href="ServletName?id=G">g</a>
        <a href="ServletName?id=H">h</a>
        <a href="ServletName?id=I">i</a>
        <a href="ServletName?id=J">j</a>
        <a href="ServletName?id=K">k</a>
        <a href="ServletName?id=L">l</a> 
        <a href="ServletName?id=M">m</a>
        <a href="ServletName?id=N">n</a>
        <a href="ServletName?id=Ñ">ñ</a>
        <a href="ServletName?id=O">o</a>
        <a href="ServletName?id=P">p</a>
        <a href="ServletName?id=Q">q</a>
        <a href="ServletName?id=R">r</a>
        <a href="ServletName?id=S">s</a>
        <a href="ServletName?id=T">t</a> 
        <a href="ServletName?id=U">u</a>
        <a href="ServletName?id=V">v</a>
        <a href="ServletName?id=W">w</a>
        <a href="ServletName?id=X">x</a>
        <a href="ServletName?id=Y">y</a>
        <a href="ServletName?id=Z">z</a>
        
        <a href="BookList?id=bg">#</a>
            </div>
            </div>
            </div>
            
        <br>
        <a href="bookAdd.jsp">Add a new book</a>
    </body>
</html>
