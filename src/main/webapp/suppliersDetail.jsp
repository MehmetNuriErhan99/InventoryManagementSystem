<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Supplier Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Supplier Details</h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Name: <%= request.getAttribute("supplier.name") %></h5>
                <p class="card-text">Phone Number: <%= request.getAttribute("supplier.phoneNumber") %></p>
                <p class="card-text">Email Address: <%= request.getAttribute("supplier.emailAddress") %></p>
                <p class="card-text">Password: <%= request.getAttribute("supplier.password") %></p>
                <a href="suppliers?action=getAll" class="btn btn-primary">Back to List</a>
            </div>
        </div>
    </div>
</body>
</html>
