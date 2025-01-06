<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kullanıcı Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f9f9f9;
        }

        .profile-card {
            background: linear-gradient(135deg, #007bff, #6c63ff);
            color: white;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .profile-card img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            border: 3px solid white;
            margin-bottom: 15px;
        }

        .dashboard-actions {
            margin-top: 30px;
        }

        .dashboard-actions a {
            display: block;
            margin: 10px 0;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 12px 15px;
            border-radius: 10px;
            font-weight: bold;
            transition: all 0.3s ease;
        }

        .dashboard-actions a:hover {
            background-color: #0056b3;
        }

        .dashboard-actions a.btn-secondary {
            background-color: #6c757d;
        }

        .dashboard-actions a.btn-info {
            background-color: #17a2b8;
        }

        .dashboard-actions a.btn-danger {
            background-color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="profile-card">
                    <img src="https://via.placeholder.com/100" alt="Kullanıcı Profil Resmi">
                    <h2>Merhaba, <c:out value="${sessionScope.loggedUser.name}"/>!</h2>
                    <p>Rol: <c:out value="${sessionScope.role}"/></p>
                </div>
            </div>
        </div>

        <div class="row dashboard-actions text-center mt-4">
            <!-- Satıcı Dashboard'u -->
            <c:if test="${sessionScope.role == 'Retailer'}">
                <div class="col-md-4">
                    <a href="product_add.jsp" class="btn btn-primary">Ürün Ekle</a>
                </div>
                <div class="col-md-4">
                    <a href="cart_view.jsp" class="btn btn-secondary">Sepeti Görüntüle</a>
                </div>
                <div class="col-md-4">
                    <a href="product_search.jsp" class="btn btn-info">Ürün Ara</a>
                </div>
            </c:if>

            <!-- Tedarikçi Dashboard'u -->
            <c:if test="${sessionScope.role == 'Supplier'}">
                <div class="col-md-6">
                    <a href="order_list.jsp" class="btn btn-warning">Siparişleri Görüntüle</a>
                </div>
                <div class="col-md-6">
                    <a href="order_update.jsp" class="btn btn-danger">Stok Güncelle</a>
                </div>
            </c:if>
        </div>

        <!-- Genel İşlemler -->
        <div class="row mt-5">
            <div class="col-md-12 text-center">
                <a href="logout" class="btn btn-danger">Çıkış Yap</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
