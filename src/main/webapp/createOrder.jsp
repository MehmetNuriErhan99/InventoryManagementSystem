<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Yeni Sipariş Oluştur</title>
</head>
<body>
    <h1>Yeni Sipariş Oluştur</h1>

    <form action="/order" method="post">
        <label for="productId">Ürün ID:</label>
        <input type="number" id="productId" name="productId" required><br>

        <label for="quantity">Miktar:</label>
        <input type="number" id="quantity" name="quantity" required><br>

        <label for="retailerId">Satıcı ID:</label>
        <input type="number" id="retailerId" name="retailerId" required><br>

        <label for="price">Fiyat:</label>
        <input type="number" id="price" name="price" required><br>

        <button type="submit">Siparişi Oluştur</button>
    </form>
</body>
</html>
