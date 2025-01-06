<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // HttpSession zaten otomatik olarak tanımlıdır, tekrar tanımlamanıza gerek yok.
    if (session == null || !"Supplier".equals(session.getAttribute("role"))) {
        response.sendRedirect(request.getContextPath() + "/user_login.jsp");
        return;
    }

    String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tedarikçi Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <header class="bg-primary text-white text-center py-4">
        <h1>Tedarikçi Dashboard</h1>
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
                        <!-- Link'i "order_list.jsp" olarak güncelledik -->
                        <a class="nav-link" href="<%= request.getContextPath() %>/order_list.jsp">Sipariş Yönetimi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<%= request.getContextPath() %>/user_login.jsp">Çıkış Yap</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main class="container my-5">
        <div class="row">
            <div class="col-md-6">
                <h2>Siparişler</h2>
                <ul>
                    <li>Siparişleri Görüntüle</li>
                    <li>Sipariş Onayla</li>
                    <li>Ürün Stoğunu Güncelle</li>
                </ul>
                <!-- Sipariş Yönetimi butonunu "order_list.jsp" sayfasına yönlendirdik -->
                <a class="btn btn-primary" href="<%= request.getContextPath() %>/order_list.jsp">Sipariş Yönetimine Git</a>
            </div>
        </div>
    </main>

    <footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2025 Envanter Yönetim Sistemi. Tüm hakları saklıdır.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
