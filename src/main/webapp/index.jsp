<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
    <%@include file="links.jsp"%>
</head>
<body >

<div class="container">


    <div class="b-popup" id="popUp">

        <div class="b-popup-content">

            <div class="popup-header-3">
                <h1>Регистрация</h1>

                <img onclick="hide()" src="image/2.png">
            </div>

            <form class="index-form-popup-4" method="post" action="/register">
                <div class="d-flex mt-4">
                    <div class="mb-3 index-form-div ms-2 me-3">
                        <input type="text" class="form-control" id="name" placeholder="Имя" name="name" required>
                    </div>

                    <div class="mb-3 index-form-div">
                        <input type="text" class="form-control" id="surname" placeholder="Фамилия" name="surname" required>
                    </div>

                </div>


                <div class="mb-3 ms-2 me-3">

                    <input type="text" class="form-control" id="email" name="email" placeholder="эл.адрес" required>
                </div>

                <div class="mb-3 ms-2 me-3">

                    <input type="password" class="form-control" id="password" name="password" placeholder="Новый пароль" required>
                </div>

                <div class="mb-3 ms-2 me-3 index-bday-5">
                    <label > Дата рождения</label>
                    <select name="day">
                        <option selected>День</option>

                        <% for (int i =1 ; i<32;i++){ %>
                        <option ><%=i%></option>
                       <% } %>

                    </select>

                    <select name="month">
                        <option>Месяц</option>
                        <option selected>Янв</option>
                        <option>Фев</option>
                        <option>Мар</option>
                        <option>Апр</option>
                        <option>Мая</option>
                        <option>Июн</option>
                        <option>Июл</option>
                        <option>Авг</option>
                        <option>Сен</option>
                        <option>Окт</option>
                        <option>Ноя</option>
                        <option>Дек</option>
                    </select>

                    <select name="year">
                        <option selected>Год</option>
                        <%
                            int num = 2021;
                        for(int i = 1;i<118;i++){ %>
                            <option ><%=num%></option>
                        <% num-- ;%>
                       <% } %>

                    </select>
                </div>

                <div class="mb-3 ms-2 me-3 index-bday-5">
                    <label > Пол</label>
                    <div class="d-flex">
                        <span class="index-radio">
                            <label>Женщина</label>
                            <input type="radio" name="sex" value="Женский" checked>
                        </span>

                        <span class="index-radio">
                            <label>Мужчина</label>
                            <input type="radio" name="sex" value="Мужской">
                        </span>

                    </div>

                </div>


                <div style="text-align: center"><button type="submit" class="index-register-button" >Регистрация</button></div>
            </form>
        </div>
    </div>









    <div class="col-12 d-flex mt-5">
        <div class="col-7">
        <div class="index-text">
            <img src="image/sn3.jpg" width="550px" height="450px">

        </div>
        </div>

        <div class="col-5 float-end">
            <div class="index-form-container">
                <form action="/auth" method="post">
                    <div class="mb-3 pt-3">

                        <input type="email" class="form-control" name="email">
                    </div>
                    <div class="mb-3">

                        <input type="password" class="form-control" name="password">
                    </div>

                    <% if(request.getAttribute("errorMessage")!=null) { %>
                    <div class="alert alert-danger" role="alert">
                        <%=request.getAttribute("errorMessage")%>
                    </div>

                    <% } %>

                    <button type="submit" class="face-button">Вход</button>
                </form>
                <div class="index-create-2">
                    <a role="button" onclick="show();">Создать аккаунт</a>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    function show(){
        document.getElementById("popUp").style.display = "block";
    }
    function hide(){
        document.getElementById("popUp").style.display = "none";
    }
</script>
<%@include file="script.jsp"%>
</body>
</html>