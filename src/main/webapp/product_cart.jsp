<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sepet Yönetimi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">Sepet Yönetimi</h1>

    <!-- Ürün Listeleme -->
    <c:forEach var="product" items="${products}">
        <div class="row mb-3">
            <div class="col-md-8">
                <h5>${product.name}</h5>
                <p>Fiyat: ${product.price} | Stok: ${product.stockQuantity}</p>
            </div>
            <div class="col-md-4 text-end">
                <form method="post" action="${pageContext.request.contextPath}/cart">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="number" name="quantity" min="1" max="${product.stockQuantity}" class="form-control mb-2" required>
                    <button type="submit" class="btn btn-primary">Sepete Ekle</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
