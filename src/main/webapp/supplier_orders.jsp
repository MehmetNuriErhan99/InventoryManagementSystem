<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supplier Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">Tedarikçi Siparişleri</h1>
    <table class="table table-bordered table-striped mt-4">
        <thead>
            <tr>
                <th>Sipariş ID</th>
                <th>Ürün Adı</th>
                <th>Miktar</th>
                <th>Durum</th>
                <th>Oluşturulma Tarihi</th>
                <th>Eylemler</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.productName}</td>
                    <td>${order.amount}</td>
                    <td>${order.orderStatus}</td>
                    <td>${order.createdAt}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/supplier/orders">
                            <input type="hidden" name="orderId" value="${order.id}">
                            <button type="submit" class="btn btn-success btn-sm">Onayla</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
