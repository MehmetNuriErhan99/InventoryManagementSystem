<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Siparişler</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f9f9f9;
        }

        .table-container {
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .table thead {
            background-color: #007bff;
            color: white;
        }

        .table th {
            text-align: center;
        }

        .table td {
            text-align: center;
        }

        .btn-approve {
            background-color: #28a745;
            color: white;
        }

        .btn-approve:hover {
            background-color: #218838;
        }

        .btn-reject {
            background-color: #dc3545;
            color: white;
        }

        .btn-reject:hover {
            background-color: #c82333;
        }

        h2 {
            margin: 20px 0;
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Siparişler</h2>
        <div class="table-container">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tedarikçi ID</th>
                        <th>Satıcı ID</th>
                        <th>Ürün ID</th>
                        <th>Miktar</th>
                        <th>Durum</th>
                        <th>Tarih</th>
                        <th>İşlemler</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.supplierId}</td>
                            <td>${order.retailerId}</td>
                            <td>${order.productId}</td>
                            <td>${order.amount}</td>
                            <td>
                                <span class="badge
                                    <c:choose>
                                        <c:when test="${order.orderStatus == 'APPROVED'}">bg-success</c:when>
                                        <c:when test="${order.orderStatus == 'REJECTED'}">bg-danger</c:when>
                                        <c:otherwise>bg-warning text-dark</c:otherwise>
                                    </c:choose>">
                                    ${order.orderStatus}
                                </span>
                            </td>
                            <td>${order.createdAt}</td>
                            <td>
                                <form action="orders" method="post" class="d-inline">
                                    <input type="hidden" name="orderId" value="${order.id}">
                                    <button type="submit" name="action" value="approve" class="btn btn-approve btn-sm">Onayla</button>
                                </form>
                                <form action="orders" method="post" class="d-inline">
                                    <input type="hidden" name="orderId" value="${order.id}">
                                    <button type="submit" name="action" value="reject" class="btn btn-reject btn-sm">Reddet</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
