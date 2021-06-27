<%-- 
    Document   : shoppingList
    Created on : Jun 26, 2021, 4:34:00 PM
    Author     : 861349
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>

        <form method="POST" action="">       
            <h2>Add Item</h2>
            <input type="text" name="item">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
            <p>${addItemText}</p>
        </form>

        <form method="POST" action="">
            <c:forEach items="${itemList}" var="shoppingList">
                <input type="radio" name="item" value="${shoppingList}"><c:out value="${shoppingList}" />
                <br>
                </c:forEach>
            <br>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>

    </body>
</html>
