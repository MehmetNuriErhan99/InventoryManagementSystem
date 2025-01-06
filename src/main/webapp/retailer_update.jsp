<%@ page import="org.mehmet.inventorymanagementsystem.dto.retailer.RetailerResponseDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Retailer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Update Retailer</h1>
    <%
        RetailerResponseDTO retailer = (RetailerResponseDTO) request.getAttribute("retailer");
        if (retailer != null) {
    %>
    <form method="post" action="${pageContext.request.contextPath}/retailers">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= retailer.getId() %>">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= retailer.getName() %>" required>
        </div>
        <div class="mb-3">
            <label for="phoneNumber" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="<%= retailer.getPhoneNumber() %>">
        </div>
        <div class="mb-3">
            <label for="emailAddress" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="emailAddress" name="emailAddress" value="<%= retailer.getEmailAddress() %>" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="<%= retailer.getPassword() %>" required>
        </div>
        <div class="mb-3">
            <label for="photo" class="form-label">Photo</label>
            <input type="text" class="form-control" id="photo" name="photo" value="<%= retailer.getPhoto() %>">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
    <%
        } else {
            out.println("Retailer not found.");
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
