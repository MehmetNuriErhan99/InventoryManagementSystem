<%@ page import="org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Ürün Güncelle</h1>
    <%
        ProductResponseDTO product = (ProductResponseDTO) request.getAttribute("product");
        if (product != null) {
    %>
    <form method="post" action="${pageContext.request.contextPath}/products?action=update">
        <input type="hidden" id="id" name="id" value="<%= product.getId() %>">

        <div class="mb-3">
            <label for="name" class="form-label">Ürün Adı:</label>
            <input type="text" id="name" name="name" class="form-control" value="<%= product.getName() %>" required>
        </div>

        <div class="mb-3">
            <label for="stockQuantity" class="form-label">Stok Miktarı:</label>
            <input type="number" id="stockQuantity" name="stockQuantity" class="form-control" value="<%= product.getStockQuantity() %>" required>
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Fiyat:</label>
            <input type="number" step="0.01" id="price" name="price" class="form-control" value="<%= product.getPrice() %>" required>
        </div>

        <div class="mb-3">
            <label for="discount" class="form-label">İndirim:</label>
            <input type="number" step="0.01" id="discount" name="discount" class="form-control" value="<%= product.getDiscount() %>" required>
        </div>

        <button type="submit" class="btn btn-primary">Güncelle</button>
        <a href="${pageContext.request.contextPath}/products" class="btn btn-secondary">İptal</a>
    </form>
    <%
        } else {
            out.println("<div class='alert alert-danger'>Ürün bulunamadı!</div>");
        }
    %>
</div>
</body>
</html>
