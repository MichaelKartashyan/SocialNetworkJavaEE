<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 07.08.2021
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Users userProfile = (Users) request.getAttribute("user");%>
<html>
<head>
    <title>Page</title>
    <%@include file="links.jsp"%>
</head>
<body style="background-color: #f0f2f5" onload="loadPosts()">
<%@include file="navbar.jsp"%>

<div class="container mt-2 d-flex" >

    <div class="col-3 me-3">
        <div class="list-group">
            <a href="/mypage" class="list-group-item list-group-item-action ">Моя Страница</a>
            <a href="/home" class="list-group-item list-group-item-action ">Новости</a>
            <a href="/followers" class="list-group-item list-group-item-action">Подписчики</a>
            <a href="/userslist" class="list-group-item list-group-item-action">Все пользователи</a>

        </div>
    </div>










    <div class="col-8 mypage-content-news">
        <div class="container">
            <div class="main-body">

                <!-- /Breadcrumb -->

                <div class="row gutters-sm mt-2">
                    <div class="col-md-4 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-column align-items-center text-center">
                                    <img src="<%=userProfile.getImagePath()%>" alt="Admin" class="" width="150" style="border-radius: 10px">
                                    <div class="mt-3">
                                        <h4><%=userProfile.getName()%> <%=userProfile.getSurname()%></h4>
                                        <p class="text-secondary mb-1"><b>О себе: </b> <%=userProfile.getAbout()%></p>
                                        <p class="text-muted font-size-sm"><b>Город: </b><%=userProfile.getCity()%></p>
                                       <% if(userProfile.getId()!=user.getId()){ %>
                                        <div id="follow-btn">
                                            <% int follow = (int) request.getAttribute("follow");
                                                if(follow==0){
                                            %>
                                                    <button class="btn btn-primary"  onclick="follow()">Подписаться</button>
                                              <%  }else{ %>

                                            <button class= 'btn btn-danger '  onclick= ' follow() ' >Отписаться</button>
                                            <% } %>
                                        </div>
                                       <% } %>
                                        <%--                                        <button class="btn btn-outline-primary">Message</button>--%>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Имя и фамилия</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <%=userProfile.getName()%> <%=userProfile.getSurname()%>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <%=userProfile.getEmail()%>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Телефон</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <%=userProfile.getPhone()%>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Адрес</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <%=userProfile.getCity()%>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
<%--                                    <div class="col-sm-12">--%>
<%--                                        <a class="btn btn-info " href="/editmyprofile">Редактировать профиль</a>--%>
<%--                                    </div>--%>
                                </div>
                            </div>
                        </div>



                    </div>



                </div>
            </div>

        </div>

    </div>
</div>











<div class="container  offset-3 mt-4 mypage-add-post pt-2 pb-2" >
    <div class="  d-flex justify-content-between ">
        <div class="input-group">
            <input class="form-control" placeholder="Что у вас нового?" type="text" id="textPost" name="textPost">
            <span class="input-group-addon">
            <a onclick="addPost()" style="cursor: pointer"><i class="fa fa-edit"></i></a>
        </span>
        </div>
    </div>


    <div id="postsList">

    </div>



</div>

</div>







<script>
    function likePost(idPost){
        $.ajax({
            type:"GET",
            url: "/likePost?id="+idPost,
            success: function (){
                loadPosts();
            },

        });
    }
</script>

<script type="text/javascript">
    function addPost(){

        let postText = document.getElementById("textPost");

        $.ajax({
            type:"POST",
            url: "/addpost",
            data: {
                textPost:  postText.value,
                id:<%=user.getId()%>,
                forUsers: <%=userProfile.getId()%>
            },
            success: function (){
                loadPosts();
            },

        });


    }

    function deletePost(postId){
        $.ajax({
            type:"GET",
            url:"/deletepost?id="+postId,
            success:function (){
                loadPosts();
            }
        });
    }


    function addComment(postId){
        let commentText = document.getElementById("textComment"+postId).value;

        $.post("/addcomment", {
            textComment:  commentText,
            postId: postId
        }, function (){
            commentText.value = "";
            loadPosts();
        });

    }

    function deleteComment(commentId){
        $.ajax({
            type:"GET",
            url:"/deleteComment?id="+commentId,
            success:function (){
                loadPosts();
            }
        });
    }

    function follow(){
        $.ajax({
            type:"POST",
            url:"/follow",
            data: {
                id: <%=userProfile.getId()%>
            },
            success:function (result){
                console.log(result)
                let divFollowBtn = document.getElementById("follow-btn");
                let followBTN = " <button class='btn btn-primary'  onclick='follow()'>Подписаться</button>";
                let UnfollowBTN = "<button class= 'btn btn-danger '  onclick= ' follow() ' >Отписаться</button>"
                if(result){
                    divFollowBtn.innerHTML = "";
                    divFollowBtn.innerHTML = UnfollowBTN;
                }else{
                    divFollowBtn.innerHTML = followBTN;
                }


            },
            dataType: "json"
        });
    }
</script>



<script type="text/javascript">
    function loadPosts(){

        $.ajax({
            url: "/ajaxReadPosts?id=<%=userProfile.getId()%>",
            success: function (result){

                let postsList = result;
                //console.log(result);
                let htmlCode = "";


                for(let i=0; i<postsList.length;i++) {
                    htmlCode += `<div class="container bootstrap snippets bootdey">
                                    <div class="my-3">
                                        <div class="panel panel-white post panel-shadow">
                                            <div class="post-heading" style="position:relative;">
                                                <a style="cursor: pointer" onclick="deletePost(`+postsList[i].id +`)"><img class="mypage-button-del"  src="image/2.png"></a>
                                                <div class="pull-left image">
                                                    <img src="`+postsList[i].user.imagePath+`" class="img-circle avatar" alt="user profile image">
                                                </div>
                                                <div class="pull-left meta">
                                                    <div class="title h5">
                                                        <a href="/userprofile?id=`+postsList[i].user.id+`"><b>`+postsList[i].user.name+" "+postsList[i].user.surname +`</b></a>
                                                        made a post.
                                                    </div>
                                                    <h6 class="text-muted time">`+postsList[i].date +`</h6>
                                                </div>
                                            </div>
                                            <div class="post-description">
                                                <p>`+ postsList[i].postText +`</p>
                                                <div class="stats">
                                                    <a style="cursor: pointer" onclick="likePost(`+postsList[i].id+`)" class="btn btn-default stat-item">
                                                        <i class="fa fa-thumbs-up icon"></i>`+postsList[i].countLike+`
                                                    </a>
<!--                                                    <a href="#" class="btn btn-default stat-item">-->
<!--                                                        <i class="fa fa-share icon"></i>-->
<!--                                                    </a>-->
                                                </div>
                                            </div>
                                        <!--Comments-->
                                            <div class="post-footer">
                                                <div class="input-group">
                                                    <input class="form-control" placeholder="Напишите ваш комментарий" id="textComment`+ postsList[i].id +`" name="textComment" type="text">
                                                    <span class="input-group-addon">
                                                    <a style="cursor: pointer" onclick="addComment(`+ postsList[i].id +`)"><i class="fa fa-edit"></i></a>
                                                </span>
                                                </div>
                                                <ul class="comments-list">`
                    if(postsList[i].comments.length>0) {
                        for (let x = 0; x < postsList[i].comments.length; x++) {
                            htmlCode += `<li class="comment" style="position: relative">
                                                        <a style="cursor: pointer" onclick="deleteComment(` + postsList[i].comments[x].id+`)"><img class="mypage-button-del"  src="image/2.png"></a>
                                                        <a class="pull-left" href="/userprofile?id=` + postsList[i].comments[x].user.id + `">
                                                            <img class="avatar" src="` + postsList[i].comments[x].user.imagePath + `" alt="avatar">
                                                        </a>
                                                        <div class="comment-body">
                                                            <div class="comment-heading">
                                                                <h4 class="user">` + postsList[i].comments[x].user.name + " " + postsList[i].comments[x].user.surname + `</h4>
                                                                <h5 class="time">` + postsList[i].comments[x].date + `</h5>
                                                            </div>
                                                            <p>` + postsList[i].comments[x].comment + `</p>
                                                        </div>
                                                        </li>`
                        }
                    }

                    htmlCode += `    </ul>
                                                            </div>
                                                                     </div>
                                                                </div>
                                                                </div>`
                }

                document.getElementById("postsList").innerHTML = htmlCode;
            },
            dataType: "json"
        });
    }


</script>

<%@include file="script.jsp"%>
</body>
</html>
