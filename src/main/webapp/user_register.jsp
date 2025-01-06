<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-body">
            <h2 class="text-center mb-4">Register</h2>
            <form action="${pageContext.request.contextPath}/users" method="post">
                <input type="hidden" name="action" value="register">
                <div class="mb-3">
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-select" id="role" name="role" required>
                        <option value="Retailer">Retailer</option>
                        <option value="Supplier">Supplier</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                </div>
                <div class="mb-3">
                    <label for="photo" class="form-label">Photo (URL)</label>
                    <input type="text" class="form-control" id="photo" name="photo">
                </div>
                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form>
            <h1 class="mb-4">Anasayfa</h1>
                                    <a href="index.jsp" class="btn btn-outline-primary">Anasayfaya Git</a>
        </div>
    </div>
</div>
</body>
</html>
