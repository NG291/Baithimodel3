<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premises Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<style>
    .table {
        font-size: 13px;
    }

    a:hover {
        text-decoration: none;
        color: #fff;
    }

    .img-style {
        border-radius: 10px;
        width: 80px;
    }

    .middle {
        /* Any additional styling can go here */
    }
</style>
<script>
    function confirmDelete(floorCode) {
        var confirmAction = confirm("Bạn có chắc chắn muốn xóa mặt bằng với mã số " + floorCode + " không?");
        if (confirmAction) {
            window.location.href = "${pageContext.request.contextPath}/floors?action=delete&floorCode="+ floorCode;
        }
    }
</script>
<body>

<div class="container mt-4">
    <h1>Premises Management</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Premises Code</th>
            <th>Area(m^2)</th>
            <th>Status</th>
            <th>Type</th>
            <th>Price</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${floors}" var="floor">
            <tr class="middle">
                <td><c:out value="${floor.floorCode}"/></td>
                <td><c:out value="${floor.area}"/></td>
                <td><c:out value="${floor.status}"/></td>
                <td><c:out value="${floor.officeType}"/></td>
                <td><c:out value="${floor.price}"/></td>
                <td><c:out value="${floor.startDate}"/></td>
                <td><c:out value="${floor.endDate}"/></td>

                <td>
                    <a href="#" onclick="confirmDelete('${floor.floorCode}')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/floors?action=create" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>