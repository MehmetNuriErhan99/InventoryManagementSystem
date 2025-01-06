<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Envanter Yönetim Sistemi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f9f9f9;
        }

        .navbar-brand {
            font-weight: bold;
            font-size: 1.8rem;
        }

        .carousel-caption {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 10px;
            border-radius: 5px;
        }

        .carousel-inner img {
            height: 350px;
            object-fit: cover;
        }

        .search-form input[type="text"] {
            border-radius: 30px;
            padding: 15px;
            font-size: 1.1rem;
        }

        .search-form button {
            border-radius: 30px;
            padding: 12px 20px;
            font-size: 1.1rem;
        }

        .card-img-top {
            height: 250px;
            object-fit: cover;
            border-radius: 10px;
        }

        .card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2);
        }

        footer {
            background-color: #343a40;
            color: white;
            padding: 20px 0;
        }

        footer p {
            margin: 0;
            font-size: 0.9rem;
        }

        .btn-primary {
            background: linear-gradient(90deg, #007bff, #0056b3);
            border: none;
        }

        .btn-primary:hover {
            background: linear-gradient(90deg, #0056b3, #007bff);
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">EYS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="user_login.jsp">Giriş Yap</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="user_register.jsp">Kayıt Ol</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="product_index.jsp">Ürün Listesi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/orders">Sipariş Yönetimi</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Slider -->
    <div id="mainCarousel" class="carousel slide mt-3" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://isodeck.com/wp-content/uploads/2024/11/tedarikci-yonetimi-1024x341.png" class="d-block w-100" alt="Slide 1">
                <div class="carousel-caption">
                    <h5>Envanterinizi Kolayca Yönetin</h5>
                    <p>Stoklarınızı ve ürünlerinizi daha etkili yönetin.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgh8Rzqw4hgUIVFIHY3i7YJWuCoZi1rdUI6Q&s" class="d-block w-100" alt="Slide 2">
                <div class="carousel-caption">
                    <h5>Siparişlerinizi Kolayca Takip Edin</h5>
                    <p>Satıcılar ve tedarikçiler arasında hızlı sipariş yönetimi.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcwQNpXHT6lQNu8jk3wO11i2VYH046n_Sq0w&s" class="d-block w-100" alt="Slide 3">
                <div class="carousel-caption">
                    <h5>Raporlama ve Analiz</h5>
                    <p>Performansınızı analiz edin ve iyileştirin.</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#mainCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#mainCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- Main Content -->
    <main class="container my-5">
        <!-- Arama Formu -->
        <div class="row justify-content-center mb-4">
            <form action="product_index.jsp" method="get" class="d-flex col-md-8 search-form">
                <input type="text" name="searchQuery" class="form-control me-2" placeholder="Ürün Ara" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Ara</button>
            </form>
        </div>

        <!-- Ürünler -->
        <h2 class="text-center mb-4">Ürünler</h2>
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-lg-4 col-md-6 mb-4"> <!-- Yan yana 3 ürün için col-lg-4 -->
                    <div class="card h-100">
                        <img src="https://cdn03.ciceksepeti.com/cicek/kcm79306861-1/L/simsek-araba-isikli-uzaktan-kumandali-full-fonksiyon-oyuncak-araba-kcm79306861-1-c6c002e56a0a44aa87344766c739f259.jpg" class="card-img-top" alt="${product.name}">
                        <div class="card-body text-center">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <p class="card-text fw-bold">Fiyat: ${product.price} TL</p>
                            <form action="${pageContext.request.contextPath}/cart_add.jsp" method="post">
                                <input type="hidden" name="productId" value="${product.id}">
                                <input type="number" name="quantity" min="1" value="1" class="form-control mb-2" required>
                                <button type="submit" class="btn btn-primary">Sepete Ekle</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Sepet -->
        <h2 class="text-center mt-5">Alışveriş Sepeti</h2>
        <div class="row">
            <c:if test="${not empty cartItems}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Ürün Adı</th>
                            <th>Adet</th>
                            <th>Fiyat</th>
                            <th>Toplam</th>
                            <th>Aksiyon</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cartItems}">
                            <tr>
                                <td>${item.productName}</td>
                                <td>${item.quantity}</td>
                                <td>${item.price} TL</td>
                                <td>${item.totalPrice} TL</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/cart_remove.jsp" method="post">
                                        <input type="hidden" name="productId" value="${item.productId}">
                                        <button type="submit" class="btn btn-danger btn-sm">Kaldır</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty cartItems}">
                <p class="text-center">Sepetinizde ürün bulunmamaktadır.</p>
            </c:if>
        </div>
    </main>

    <!-- Footer -->
    <footer class="text-center">
        <p>&copy; 2025 Envanter Yönetim Sistemi. Tüm hakları saklıdır.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
