<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>

<div class="container mt-4">
    <h1>Premises Management</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Premises Code</th>
            <th>Status</th>
            <th>Area (m²)</th>
            <th>Floor</th>
            <th>Type</th>
            <th>Price</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${floors}" var="premises">
            <tr class="middle">
                <td><c:out value="${count}"/></td>
                <td><c:out value="${premises.floorCode}"/></td>
                <td><c:out value="${premises.status}"/></td>
                <td><c:out value="${premises.area}"/></td>
                <td><c:out value="${premises.floorType}"/></td>
                <td><c:out value="${premises.officeType}"/></td>
                <td><c:out value="${premises.price}"/></td>
                <td><c:out value="${premises.startDate}"/></td>
                <td><c:out value="${premises.endDate}"/></td>

                <td>
                    <a href="${pageContext.request.contextPath}/delete-premises-form?id=${premises.id}"
                       class="btn btn-danger btn-sm">Delete</a>
                    <a href="${pageContext.request.contextPath}/edit-premises-form?id=${premises.id}"
                       class="btn btn-warning btn-sm ml-2">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/create-premises-form" class="btn btn-primary">Add New</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>