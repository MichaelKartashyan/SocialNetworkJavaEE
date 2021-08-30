<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 07.08.2021
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Page</title>
    <%@include file="links.jsp"%>
</head>
<body style="background-color: #f0f2f5">
<%@include file="navbar.jsp"%>

<div class="container mt-2 d-flex" >

    <div class="col-3 me-3">
        <div class="list-group">
            <a href="/mypage" class="list-group-item list-group-item-action active">Моя Страница</a>
            <a href="/home" class="list-group-item list-group-item-action ">Новости</a>
            <a href="/followers" class="list-group-item list-group-item-action">Подписчики</a>
            <a href="/userslist" class="list-group-item list-group-item-action">Все пользователи</a>

        </div>
    </div>










    <div class="col-8 mypage-content-news">
        <%if(request.getAttribute("errorMessage")!=null) { %>
        <div class="alert alert-danger" role="alert">
            <%=request.getAttribute("errorMessage")%>
        </div>

        <% } %>

        <%if(request.getAttribute("successMessage")!=null) { %>
        <div class="alert alert-success" role="alert">
            <%=request.getAttribute("successMessage")%>
        </div>

        <% } %>
        <form method="post" action="/editmyprofile">
        <div class="container mt-3 mb-3">
            <div class="main-body">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-column align-items-center text-center">
                                    <img src="<%=user.getImagePath()%>" alt="Admin" class="rounded-circle p-1 bg-primary" width="110">
                                    <div class="mt-3">
                                        <h4><%=user.getName()%> <%=user.getSurname()%></h4>
                                        <p class="text-muted font-size-sm"><b>Город: </b><%=user.getCity()%></p>
<%--                                        <button class="btn btn-primary">Follow</button>--%>
                                        <%--<button class="btn btn-outline-primary">Message</button>--%>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="col-lg-8">
                        <div class="card">
                            <div class="card-body">
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Имя</h6>
                                    </div>

                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="uName" value="<%=user.getName()%>">
                                        <input type="hidden" name="id" value="<%=user.getId()%>">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Фамилия</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="surname" value="<%=user.getSurname()%>">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">О себе</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="about" value="<%=user.getAbout()%>">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="email" value="<%=user.getEmail()%>">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Телефон</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="number" class="form-control" name="phone" value="<%=user.getPhone()%>">
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Адрес</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="city" value="<%=user.getCity()%>">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Место учебы</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="university" value="<%=user.getUniversity()%>">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-9 text-secondary">
                                        <button type="submit" class="btn btn-primary px-4" >Сохранить изменения</button>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>

        </div>
        </form>





        <form method="post" action="/editavatare">
            <div class="col-lg-8 offset-4">
                <div class="card">
                    <div class="card-body">
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Изменить Аватар</h6>
                            </div>

                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" name="avatar" >
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-9 text-secondary">
                                <button type="submit" class="btn btn-primary px-4" >Сохранить Новый аватар </button>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </form>






        <form method="post" action="/editpassword">
            <div class="col-lg-8 offset-4">
                <div class="card">
                    <div class="card-body">
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Изменить пароль: новый пароль</h6>
                            </div>

                            <div class="col-sm-9 text-secondary">
                                <input type="password" class="form-control" name="password" >
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Повторите новый пароль</h6>
                            </div>

                            <div class="col-sm-9 text-secondary">
                                <input type="password" class="form-control" name="repassword" >
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-9 text-secondary">
                                <button type="submit" class="btn btn-primary px-4" >Сохранить Новый пароль </button>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </form>
        </div>
</div>



<%@include file="script.jsp"%>
</body>
</html>
