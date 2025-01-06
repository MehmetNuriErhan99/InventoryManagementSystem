<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f9f9f9;
        }

        .card {
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border: none;
        }

        .card-header {
            background-color: #007bff;
            color: white;
            font-size: 1.5rem;
        }

        .table th {
            width: 40%;
            text-align: left;
        }

        .table td {
            text-align: left;
        }

        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }

        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header text-center">
                Order Details
            </div>
            <div class="card-body">
                <c:if test="${order != null}">
                    <table class="table table-borderless">
                        <tr>
                            <th>Order ID:</th>
                            <td>${order.id}</td>
                        </tr>
                        <tr>
                            <th>Order Status:</th>
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
                        </tr>
                        <tr>
                            <th>Created At:</th>
                            <td>${order.createdAt}</td>
                        </tr>
                        <tr>
                            <th>Supplier Name:</th>
                            <td>${order.supplierName}</td>
                        </tr>
                        <tr>
                            <th>Supplier Email:</th>
                            <td>${order.supplierEmail}</td>
                        </tr>
                        <tr>
                            <th>Retailer Name:</th>
                            <td>${order.retailerName}</td>
                        </tr>
                        <tr>
                            <th>Retailer Email:</th>
                            <td>${order.retailerEmail}</td>
                        </tr>
                        <tr>
                            <th>Product Name:</th>
                            <td>${order.productName}</td>
                        </tr>
                        <tr>
                            <th>Amount:</th>
                            <td>${order.amount}</td>
                        </tr>
                        <tr>
                            <th>Price:</th>
                            <td>${order.price} TL</td>
                        </tr>
                        <tr>
                            <th>Discount:</th>
                            <td>${order.discount}%</td>
                        </tr>
                    </table>
                </c:if>
                <c:if test="${order == null}">
                    <p class="text-center text-danger">Order details not available.</p>
                </c:if>
            </div>
            <div class="card-footer text-center">
                <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">Back to Orders</a>
            </div>
        </div>
    </div>
</body>
</html>
