<!DOCTYPE html>

<%@ page import="library.model.Book" %>


<html>
  <head>
   
    <title>Book edit page</title>
 
  </head>
  
  <%
	Book book = (Book)request.getAttribute("book");
        String isAvailable;
        if (book.isAvailable())
            isAvailable = "checked";
        else
            isAvailable = "";
  %>
  
  <body>
	<form name="edit" action="BookCreate" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td><b>Author:</b></td>
					<td><input type="text" name="author" value="<%=book.getAuthor()%>" /></td>		
					</tr><tr>		
					<td><b>Title:</b></td>	
					<td><input type="text" name="title" value="<%=book.getTitle()%>" /></td>
					</tr><tr>
					<td><b>Available:</b></td>
					<td><input type="checkbox" name="available" value="true" <%= isAvailable %> /></td>
					</tr><tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Save" /></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="id" value="<%=book.getId()%>" />
	</form>
  </body>
</html>
