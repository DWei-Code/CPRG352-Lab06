<%-- 
    Document   : register
    Created on : Jun 26, 2021, 4:33:26 PM
    Author     : 861349
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST" action="ShoppingList">
            <input type="text" name="username">
            <input type="hidden" name="action" value ="register">
            <input type="submit" value="Register">
        </form>
    </body>
</html>
