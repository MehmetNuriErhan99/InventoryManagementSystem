<%@ page import="java.util.List" %>
<%@ page import="org.mehmet.inventorymanagementsystem.dto.retailer.RetailerResponseDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Retailer List</h1>
    <a href="${pageContext.request.contextPath}/retailer_register.jsp" class="btn btn-success mb-3">Add New Retailer</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="retailer" items="${retailers}">
            <tr>
                <td>${retailer.id}</td>
                <td>${retailer.name}</td>
                <td>${retailer.phoneNumber}</td>
                <td>${retailer.emailAddress}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/retailers?action=edit&id=${retailer.id}" class="btn btn-warning btn-sm">Edit</a>
                    <form method="post" action="${pageContext.request.contextPath}/retailers" style="display: inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${retailer.id}">
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
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
