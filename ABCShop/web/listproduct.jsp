<%-- 
    Document   : listproduct
    Created on : Aug 24, 2018, 7:16:16 PM
    Author     : duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Price</td>
                <td>Quantity</td>
            </tr>
                <c:forEach items="${datas}" var="p">
                    <tr>
                        <td><c:out value="${p.name}"></c:out></td>
                        <td><c:out value="${p.price}"></c:out></td>
                        <td><c:out value="${p.quantity}"></c:out></td>
                        <td><input name="quantity" type="number" min="1"/></td>
                        <td><a href="sell?id=<c:out value="${p.id}"></c:out>">Sell</a></td>
                    </tr>
                </c:forEach>
        </table>
         <form action="create" method="POST">
                <div class="inset">
                    <p>
                        <label for="">Name</label>
                        <input type="text" name="name" placeholder="" required/>
                    </p>
                    <p>
                        <label for="">Price</label>
                        <input type="number" min="0" placeholder="" name="price" required/>
                    </p>
                    <p>
                        <label for="">Quantity</label>
                        <input type="number" min="0" placeholder="" name="quantity" required/>
                    </p>
                </div> 
                    <input type="submit" value="Create"></p>
            </form>
    </body>
</html>
