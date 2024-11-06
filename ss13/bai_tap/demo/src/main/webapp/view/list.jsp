<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DANH SÁCH</title>

    <!-- Liên kết Bootstrap 4.5.2 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Liên kết DataTables Bootstrap 5 CSS (nếu cần) -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/datatables.net-bs5@1.11.5/css/datatables.bootstrap5.min.css"/>

</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">DANH SÁCH PHÒNG TRỌ</h1>

    <!-- Form tìm kiếm -->
    <form action="/phongtro?action=timTheoTen" method="post" class="form-inline mb-4">
        <input type="text" name="tenNguoiThue" class="form-control mr-2" placeholder="Tìm kiếm...">
        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
    </form>

    <!-- Liên kết Thêm mới -->
    <a href="/view/add.jsp" class="btn btn-success mb-4">Thêm mới</a>

    <!-- Bảng danh sách -->
    <table class="table table-bordered table-striped" id="phongtroTable">
        <thead class="thead-dark">
        <tr>
            <th>Mã</th>
            <th>Tên người thuê</th>
            <th>Số điện thoại</th>
            <th>Ngày thuê</th>
            <th>Hình thức</th>
            <th>Ghi chú</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phongTro" items="${phongTros}">
            <tr>
                <td>${phongTro.maPhongTro}</td>
                <td>${phongTro.tenNguoiThue}</td>
                <td>${phongTro.soDienThoai}</td>
                <td>${phongTro.ngayThue}</td>
                <td>${phongTro.hinhThucThue}</td>
                <td>${phongTro.ghiChu}</td>
                <td><a href="/phongtro?action=xoa&ma=${phongTro.maPhongTro}" class="btn btn-danger btn-sm">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Liên kết JS Bootstrap và DataTables -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/datatables.net@1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/datatables.net-bs5@1.11.5/js/dataTables.bootstrap5.min.js"></script>

<!-- Kích hoạt DataTables -->
<script>
    $(document).ready(function() {
        $('#phongtroTable').DataTable();
    });
</script>
</body>
</html>