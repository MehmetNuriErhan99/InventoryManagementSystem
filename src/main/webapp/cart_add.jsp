<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ürün Sepete Ekle</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-4">
        <h2>Ürün Sepete Ekle</h2>

        <form action="addToCart" method="POST">
            <div class="form-group">
                <label for="productId">Ürün ID:</label>
                <input type="number" id="productId" name="productId" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="quantity">Miktar:</label>
                <input type="number" id="quantity" name="quantity" class="form-control" min="1" required>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Sepete Ekle</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
