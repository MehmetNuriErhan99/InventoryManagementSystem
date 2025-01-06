<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Supplier</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Update Supplier</h1>
        <form action="suppliers" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" id="name" name="name" class="form-control" value="<%= request.getParameter("name") %>" required>
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" value="<%= request.getParameter("phoneNumber") %>" required>
            </div>
            <div class="mb-3">
                <label for="emailAddress" class="form-label">Email Address</label>
                <input type="email" id="emailAddress" name="emailAddress" class="form-control" value="<%= request.getParameter("emailAddress") %>" required>
            </div>
            <button type="submit" class="btn btn-warning">Update</button>
        </form>
    </div>
</body>
</html>
