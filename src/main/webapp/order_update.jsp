<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Update</title>
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

        .btn-primary {
            background-color: #007bff;
            border: none;
        }

        .btn-primary:hover {
            background-color: #0056b3;
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
                Update Order
            </div>
            <div class="card-body">
                <c:if test="${order != null}">
                    <form action="${pageContext.request.contextPath}/updateOrder" method="post">
                        <input type="hidden" name="orderId" value="${order.id}">
                        <div class="mb-3">
                            <label for="orderId" class="form-label">Order ID:</label>
                            <input type="text" class="form-control" id="orderId" value="${order.id}" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="currentStatus" class="form-label">Current Status:</label>
                            <input type="text" class="form-control" id="currentStatus" value="${order.orderStatus}" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="newStatus" class="form-label">New Status:</label>
                            <select class="form-select" id="newStatus" name="newStatus" required>
                                <option value="" disabled selected>Select a status</option>
                                <option value="APPROVED">Approved</option>
                                <option value="REJECTED">Rejected</option>
                                <option value="PENDING">Pending</option>
                            </select>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Update Order</button>
                            <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">Cancel</a>
                        </div>
                    </form>
                </c:if>
                <c:if test="${order == null}">
                    <p class="text-center text-danger">Order details not found.</p>
                </c:if>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
