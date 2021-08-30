<%@ page import="Models.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Users user = (Users) request.getSession().getAttribute("auth");%>
<div class="container-fluid p-0" style="height: 59px;">
    <nav class="navbar  navbar-white bg-white pb-0 position-fixed col-12" style="z-index: 999;">
        <div class="container-fluid navbar-contain mx-0">
            <a class="navbar-brand" href="/home"><img src="image/logo.png" class="navbar-logo" ></a>
            <input type="search" class="navbar-search">

        </div>

        <div class="navbar-user">
            <a  onclick="show()"><img src="<%=user.getImagePath()%>"><%=user.getName()%></a>

        </div>
        <div class="navbar-user-popup" id="userPopup">
            <p ><a href="/editmyprofile">Редактировать пользователя</a></p>
            <div style="border-bottom: 1px solid #dadde1" ></div>
            <p><a href="/logOut">Выйти</a></p>

        </div>
    </nav>

</div>
<script>
function show(){
    let x = document.getElementById('userPopup');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}
</script>