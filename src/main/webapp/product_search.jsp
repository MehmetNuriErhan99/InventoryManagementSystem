<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ürün Arama</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">Ürün Arama</h1>
    <form method="get" action="${pageContext.request.contextPath}/products" class="mb-4">
        <div class="input-group">
            <input type="hidden" name="action" value="search">
            <input type="text" name="name" class="form-control" placeholder="Ürün adını girin..." required>
            <button type="submit" class="btn btn-primary">Ara</button>
        </div>
    </form>

    <c:if test="${not empty products}">
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Ad</th>
                    <th>Stok</th>
                    <th>Fiyat</th>
                    <th>İndirim</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.stockQuantity}</td>
                        <td>${product.price}</td>
                        <td>${product.discount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty products}">
        <p class="text-center text-danger">Hiç ürün bulunamadı.</p>
    </c:if>
</div>
</body>
</html>
