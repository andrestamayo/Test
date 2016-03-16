<!DOCTYPE html>
<html>
  <head>    
    <title>Book edit page</title>
  </head>
  <body>
	<form name="edit" action="BookCreate" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td><b>Author:</b></td>
					<td><input type="text" name="author" value=""/></td>		
					</tr><tr>		
					<td><b>Title:</b></td>	
					<td><input type="text" name="title" value=""/></td>
					</tr><tr>
					<td><b>Available:</b></td>
					<td><input type="checkbox" name="available" value="true"/></td>
					</tr><tr>	
					<td colspan="2"><input type="submit" name="btnSave" value="Save"/></td>
				</tr>
			</tbody>
		</table>
	</form>
  </body>
</html>
