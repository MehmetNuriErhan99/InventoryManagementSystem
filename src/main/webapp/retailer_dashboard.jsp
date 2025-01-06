<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Oturum kontrolü: Eğer session yoksa ya da role veya userId bilgileri eksikse, login sayfasına yönlendir.
    if (session == null || !"Retailer".equals(session.getAttribute("role"))) {
        response.sendRedirect(request.getContextPath() + "/user_login.jsp");
        return; // Buradan sonra işlem yapılmaz, login sayfasına yönlendirilir.
    }

    // Kullanıcı bilgilerini session'dan alıyoruz.
    String username = (String) session.getAttribute("username");
    int userId = (int) session.getAttribute("userId");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Satıcı Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <header class="bg-primary text-white text-center py-4">
        <h1>Satıcı Dashboard</h1>
        <p>Hoş geldiniz, <strong><%= username %></strong>!</p>
    </header>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">EYS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/orders">Sipariş Yönetimi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<%= request.getContextPath() %>/user_login.jsp">Çıkış Yap</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Ürün Arama ve Listeleme -->
    <div class="container my-5">
        <h2>Ürün Arama</h2>
        <form action="<%= request.getContextPath() %>/searchProducts.jsp" method="get">
            <input type="text" name="searchQuery" class="form-control" placeholder="Ürün Ara" required>
            <button type="submit" class="btn btn-primary mt-2">Ara</button>
        </form>
    </div>

    <!-- Sepet -->
    <div class="container my-5">
        <h2>Sepetim</h2>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Ürün Adı</th>
                    <th>Adet</th>
                    <th>Fiyat</th>
                    <th>Toplam</th>
                    <th>İşlemler</th>
                </tr>
            </thead>
            <tbody>
                <!-- Sepetteki ürünler dinamik olarak buraya eklenecek -->
                <c:forEach var="product" items="${cartItems}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.quantity}</td>
                        <td>${product.price}</td>
                        <td>${product.quantity * product.price}</td>
                        <td>
                            <!-- Sepetten ürün çıkarma -->
                            <form action="<%= request.getContextPath() %>/removeFromCart" method="post" style="display:inline;">
                                <input type="hidden" name="productId" value="${product.id}">
                                <button type="submit" class="btn btn-danger btn-sm">Çıkar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="<%= request.getContextPath() %>/createOrder.jsp" method="post">
            <button type="submit" class="btn btn-success">Siparişi Ver</button>
        </form>
    </div>

    <!-- Sipariş Durumu Takibi -->
    <div class="container my-5">
        <h2>Sipariş Durumları</h2>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Sipariş ID</th>
                    <th>Ürün ID</th>
                    <th>Adet</th>
                    <th>Durum</th>
                    <th>Oluşturulma Tarihi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.productId}</td>
                        <td>${order.amount}</td>
                        <td>${order.orderStatus}</td>
                        <td>${order.createdAt}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2025 Envanter Yönetim Sistemi. Tüm hakları saklıdır.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
