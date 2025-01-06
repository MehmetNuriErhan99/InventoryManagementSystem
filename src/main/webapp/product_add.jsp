<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ürün Ekle</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">Yeni Ürün Ekle</h1>
    <form method="post" action="${pageContext.request.contextPath}/products">
        <input type="hidden" name="action" value="create">
        <div class="mb-3">
            <label for="name" class="form-label">Ürün Adı</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="stockQuantity" class="form-label">Stok Miktarı</label>
            <input type="number" class="form-control" id="stockQuantity" name="stockQuantity" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Fiyat</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required>
        </div>
        <div class="mb-3">
            <label for="discount" class="form-label">İndirim</label>
            <input type="number" step="0.01" class="form-control" id="discount" name="discount" required>
        </div>
        <button type="submit" class="btn btn-success">Ekle</button>
    </form>
</div>
</body>
</html>
