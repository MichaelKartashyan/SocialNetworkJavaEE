<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 08.08.2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подписки</title>
    <%@include file="links.jsp"%>
</head>
<body style="background-color: #f0f2f5">
<%@include file="navbar.jsp"%>
<% ArrayList<Users> users = (ArrayList<Users>) request.getAttribute("users"); %>

<div class="container mt-2 d-flex" >

    <div class="col-3 me-3">
        <div class="list-group">
            <a href="/mypage" class="list-group-item list-group-item-action ">Моя Страница</a>
            <a href="/home" class="list-group-item list-group-item-action ">Новости</a>
            <a href="/followers" class="list-group-item list-group-item-action active">Подписки</a>
            <a href="/userslist" class="list-group-item list-group-item-action ">Все пользователи</a>

        </div>
    </div>

    <div class="col-8 home-content-news">



        <div class="container mt-3 mb-4">

                        <div class="user-dashboard-info-box table-responsive mb-0 bg-white p-4 shadow-sm">
                            <table class="table manage-candidates-top mb-0">
                                <thead>
                                <tr>
                                    <th>Имя</th>
<%--                                    <th class="text-center">Status</th>--%>
<%--                                    <th class="action text-right">Action</th>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <% for(Users u: users) { %>
                                <tr class="candidates-list">
                                    <td class="title">
                                        <div class="thumb">
                                            <img class="img-fluid" src="<%=u.getImagePath()%>" alt="">
                                        </div>
                                        <div class="candidate-list-details">
                                            <div class="candidate-list-info">
                                                <div class="candidate-list-title">
                                                    <h5 class="mb-0"><a href="/userprofile?id=<%=u.getId()%>"><%=u.getName()%> <%=u.getSurname()%></a></h5>
                                                </div>
<%--                                                <div class="candidate-list-option">--%>
<%--                                                    <ul class="list-unstyled">--%>
<%--                                                        <li><i class="fas fa-filter pr-1"></i>Information Technology</li>--%>
<%--                                                        <li><i class="fas fa-map-marker-alt pr-1"></i>Rolling Meadows, IL 60008</li>--%>
<%--                                                    </ul>--%>
<%--                                                </div>--%>
                                            </div>
                                        </div>
                                    </td>
<%--                                    <td class="candidate-list-favourite-time text-center">--%>
<%--                                        <a class="candidate-list-favourite order-2 text-danger" href="#"><i class="fas fa-heart"></i></a>--%>
<%--                                        <span class="candidate-list-time order-1">Shortlisted</span>--%>
<%--                                    </td>--%>
<%--                                    <td>--%>
<%--                                        <ul class="list-unstyled mb-0 d-flex justify-content-end">--%>
<%--                                            <li><a href="#" class="text-primary" data-toggle="tooltip" title="" data-original-title="view"><i class="far fa-eye"></i></a></li>--%>
<%--                                            <li><a href="#" class="text-info" data-toggle="tooltip" title="" data-original-title="Edit"><i class="fas fa-pencil-alt"></i></a></li>--%>
<%--                                            <li><a href="#" class="text-danger" data-toggle="tooltip" title="" data-original-title="Delete"><i class="far fa-trash-alt"></i></a></li>--%>
<%--                                        </ul>--%>
<%--                                    </td>--%>
                                </tr>
                                <% } %>
                                </tbody>
                            </table>

                        </div>

        </div>
    </div>

</div>





















<%@include file="script.jsp"%>
</body>
</html>
