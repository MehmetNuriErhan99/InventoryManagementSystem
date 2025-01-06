<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Supplier List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Supplier List</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<org.mehmet.inventorymanagementsystem.dto.supplier.SupplierResponseDTO> suppliers =
                        (List<org.mehmet.inventorymanagementsystem.dto.supplier.SupplierResponseDTO>) request.getAttribute("suppliers");
                if (suppliers != null) {
                    for (org.mehmet.inventorymanagementsystem.dto.supplier.SupplierResponseDTO supplier : suppliers) {
            %>
                <tr>
                    <td><%= supplier.getId() %></td>
                    <td><%= supplier.getName() %></td>
                    <td><%= supplier.getPhoneNumber() %></td>
                    <td><%= supplier.getEmailAddress() %></td>
                    <td>
                        <a href="suppliers?action=getById&id=<%= supplier.getId() %>" class="btn btn-info btn-sm">View</a>
                        <a href="suppliers?action=update&id=<%= supplier.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                        <a href="suppliers?action=delete&id=<%= supplier.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
        <a href="suppliers?action=create" class="btn btn-primary">Add New Supplier</a>
    </div>
</body>
</html>
