<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Yeni Retailer Ekle</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Yeni Retailer Ekle</h1>
    <form method="post" action="${pageContext.request.contextPath}/retailers">
        <input type="hidden" name="action" value="create">
        <div class="mb-3">
            <label for="name" class="form-label">Ad</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="phoneNumber" class="form-label">Telefon</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
        </div>
        <div class="mb-3">
            <label for="emailAddress" class="form-label">E-posta</label>
            <input type="email" class="form-control" id="emailAddress" name="emailAddress" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Şifre</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="mb-3">
            <label for="photo" class="form-label">Fotoğraf URL</label>
            <input type="text" class="form-control" id="photo" name="photo">
        </div>
        <button type="submit" class="btn btn-primary">Ekle</button>
    </form>
</div>
</body>
</html>
