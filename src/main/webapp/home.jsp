<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 05.08.2021
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Social Network</title>

    <%@include file="links.jsp"%>
</head>
<body style="background-color: #f0f2f5" onload="loadPosts()">
<%@include file="navbar.jsp"%>

<div class="container mt-2 d-flex" >

    <div class="col-3 me-3">
        <div class="list-group">
            <a href="/mypage" class="list-group-item list-group-item-action ">Моя Страница</a>
            <a href="/home" class="list-group-item list-group-item-action active">Новости</a>
            <a href="/followers" class="list-group-item list-group-item-action">Подписчики</a>
            <a href="/userslist" class="list-group-item list-group-item-action">Все пользователи</a>

        </div>
    </div>

    <div class="col-8 home-content-news">
        <div id="postsList">

        </div>
    </div>

</div>










<script type="text/javascript">
    function loadPosts(){

        $.ajax({
            url: "/ajaxhome?id=<%=user.getId()%>",
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
