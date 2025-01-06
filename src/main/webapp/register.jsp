<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h4>Register</h4>
                </div>
                <div class="card-body">
                    <p class="text-center">Please select your role to register.</p>
                    <div class="d-flex justify-content-around mt-4">
                        <a href="${pageContext.request.contextPath}/retailers?action=register" class="btn btn-success btn-lg">
                            Register as Retailer
                        </a>
                        <a href="${pageContext.request.contextPath}/suppliers?action=register" class="btn btn-info btn-lg">
                            Register as Supplier
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
