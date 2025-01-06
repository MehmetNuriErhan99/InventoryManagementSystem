<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sepet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
        }

        .card {
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .table-container {
            margin-top: 30px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        .empty-cart {
            text-align: center;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Sayfa Başlığı -->
        <h1 class="text-center mb-4">Sepetiniz</h1>

        <!-- Ürün Ekleme Formu -->
        <div class="card p-4">
            <h3 class="mb-3">Ürün Ekle</h3>
            <form action="/cart" method="post">
                <input type="hidden" name="retailerId" value="1">
                <div class="mb-3">
                    <label for="productId" class="form-label">Ürün ID</label>
                    <input type="number" name="productId" id="productId" class="form-control" placeholder="Ürün ID giriniz" required>
                </div>
                <div class="mb-3">
                    <label for="quantity" class="form-label">Miktar</label>
                    <input type="number" name="quantity" id="quantity" class="form-control" placeholder="Miktar giriniz" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Sepete Ekle</button>
                </div>
            </form>
        </div>

        <!-- Sepetteki Ürünler -->
        <div class="table-container mt-4">
            <h3 class="text-center mb-3">Sepetteki Ürünler</h3>
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>Ürün ID</th>
                        <th>Miktar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cartItem" items="${cartItems}">
                        <tr>
                            <td>${cartItem.productId}</td>
                            <td>${cartItem.quantity}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty cartItems}">
                        <tr>
                            <td colspan="2" class="empty-cart">Sepetinizde ürün bulunmamaktadır.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
