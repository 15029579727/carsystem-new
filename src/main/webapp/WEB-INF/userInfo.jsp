<!DOCTYPE html>
<html lang="en">
<%@page  contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keyword" content="">
    <title>ユーザー管理</title>
    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="/static/css/style.css" rel="stylesheet">
    <link href="/static/css/style-responsive.css" rel="stylesheet">
</head>
<body>
<section id="container" >
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="" onclick="location.href='<c:url value='/index' />'" class="logo"><b>Rental Vehicles System</b></a>
        <!--logo end-->
        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="#" onclick="logout();">ログアウト</a></li>
            </ul>
        </div>
    </header>
    <!--header end-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <ul class="sidebar-menu" id="nav-accordion">
                <p class="centered"><img src="/static/img/ui-sam.jpg" class="img-circle" width="60"></p>
                <h5 class="centered">Rental Vehicles System</h5>
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-desktop"></i>
                        <span>ユーザー管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href=""　onclick="javascript:window.location.href='/user/getUserInfo'">ユーザー情報</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-book"></i>
                        <span>オーダー管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="#">オーダー一覧</a></li>
                        <li><a  href="#">注文履歴</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-tasks"></i>
                        <span>車両管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="" onclick="carSearch()">車両情報</a></li>
                    </ul>
                    <ul class="sub">
                        <li><a  href="#" onclick="">プランド情報</a></li>
                    </ul>
                    <ul class="sub">
                        <li><a  href="#" onclick="">モデル情報</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </aside>
    <!--sidebar end-->
    　<!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <h3><i class="fa fa-angle-right"></i>ユーザー一覧</h3>
            <div class="row mt">
                <div class="col-md-12">
                    <div class="content-panel">
                        <form action="/car/getCarList" method="get">
                            <table class="table table-striped table-advance table-hover">
                                <tr>
                                    <td style="text-align:center;vertical-align:middle;">車のブランド</td>
                                    <td>
                                        <input type="text" class="form-control round-form" name="carBrandName" value="${carBrandName}">
                                    </td>
                                    <td  style="text-align:center;vertical-align:middle;">車のモデル</td>
                                    <td>
                                        <input type="text" class="form-control round-form" name="carModelName" value="${carModelName}">
                                    </td>
                                    <td></td>
                                    <td style="align-content: center">
                                        <button type="submit" class="btn btn-theme" style="width: 70px;">検索</button>
                                        &emsp;&emsp;
                                        <button type="button" class="btn btn-theme" style="width: 70px;" onclick="doReset()">クリア</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                        <table class="table table-striped table-advance table-hover">
                            <h4>
                                <button type="button" class="btn btn-theme" style="width: 70px;" onclick="toInsertPage()">作成</button>&emsp;
                                <button type="button" class="btn btn-theme" style="width: 70px;" onclick="doDelete()">削除</button>&emsp;
                                <button type="button" class="btn btn-theme" style="width: 70px;" onclick="doUpdate()">更新</button>
                            </h4>
                            <div>
                                <p style="margin-left:10px;color: red;font-weight:bold;font-size: 18px" id="tips"></p>
                            </div>
                            <hr>
                            <thead>
                            <tr>
                                <th class="text-center" style="width: 120px"></i>チェックボックス</th>
                                <th class="text-center"></i>ユーザー名</th>
                                <th class="text-center">アカウント</th>
                                <th class="text-center">ユーザータイプ</th>
                                <th class="text-center"></i>電話番号</th>
                                <th class="text-center">最終ログイン時刻</th>
                            </tr>
                            </thead>
                            <c:forEach items="${userList.list}" var="c">
                                <tr class="danger" >
                                    <td class="text-center">
                                        <label>
                                            <input  type="checkbox"  id="id"  name="id" value="${c.id}">
                                        </label>
                                    </td>
                                    <td id="carCode" class="text-center">${c.userName} </td>
                                    <td id="carBrandName" class="text-center">${c.userAccount} </td>
                                    <td id="carModelName" class="text-center">${c.userType} </td>
                                    <td id="carNumbers" class="text-center">${c.userMobile} </td>
                                    <td id="carStatus" class="text-center">${c.lastLoginTime} </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <div class="center-block">
                <br />
                <div>
                    ${userList.pageNum}&emsp;ページ，合計&emsp;${userList.pages}&emsp;ページ，合計&emsp;${userList.total}&emsp;件
                </div>
                <ul class="pagination">
                    <li class="active"><a href="/user/getUserInfo?page=1">第一ページ</a></li>
                    <c:if test="${userList.pageNum == 1 }">
                        <li><a href="/user/getUserInfo?page=1">&laquo;</a></li>
                    </c:if>
                    <c:if test="${userList.pageNum != 1 }">
                        <li><a href="/user/getUserInfo?page=${carList.pageNum-1}">&laquo;</a></li>
                    </c:if>
                    <c:forEach items="${userList.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == userList.pageNum }">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != userList.pageNum }">
                            <li><a href="/user/getUserInfo?page=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${userList.pageNum == userList.pages }">
                        <li><a href="/user/getUserInfo?page=${userList.pages}">&raquo;</a></li>
                    </c:if>
                    <c:if test="${userList.pageNum != userList.pages }">
                        <li><a href="/user/getUserInfo?page=${userList.pageNum+1}">&raquo;</a></li>
                    </c:if>
                    <li class="active"><a href="/user/getUserInfo?page=${userList.pages}">最後のページ</a></li>
                </ul>
            </div>
        </section>
    </section>
</section>
<!-- js placed at the end of the document so the pages load faster -->
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="/static/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/static/js/jquery.scrollTo.min.js"></script>
<script src="/static/js/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="/static/js/common-scripts.js"></script>
<!--script for this page-->
<script type="application/javascript">
    function doDelete() {
        var deleteId = $("input[name='id']:checked");
        if(deleteId.length == 0){
            document.getElementById("tips").innerHTML="削除のデータが選択されていません!";
            return;
        }
        if(confirm("本当に削除しますか？")){
            var deleteList = new Array();
            $("input[name='id']:checked").each(function(){
                deleteList.push($(this).val());
            });
            $.ajax({
                type:"POST",
                url:'/car/deleteCarInfo',
                data:{id:deleteList.toString()},
                success:function(data){
                    $("[name='id']:checkbox").attr("id",false);
                    location.reload();
                },
                error:function(data){
                    document.getElementById("tips").innerHTML="削除に失敗しました!";
                }
            });
        }else{
            window.event.returnValue = false;
        }
    }

    function doReset() {
        var tips = document.getElementsByTagName("input");
        for( var i = 0; i < tips.length; i++ )
        {
            if( tips[i].type == "text")
            {
                tips[i].value = "";
            }
        }
    }

    function toInsertPage() {
        window.self.location.href="/car/toInsertPage";
    }

    function doUpdate() {
        var updateId = $("input[name='id']:checked");
        if(updateId.length == 0){
            document.getElementById("tips").innerHTML="更新のデータが選択されていません!";
            return;
        }else if(updateId.length > 1){
            document.getElementById("tips").innerHTML="複数のデータを選択することはできません!";
            return;
        }else{
            var ids = "";
            $("input[name='id']:checked").each(function(){
                ids = ids + $(this).val() + ",";
            });
            window.self.location.href="/car/toCarUpdatePage?updateId="+ ids +"";
        }
    }

    function carSearch() {
        window.self.location.href="/car/getCarList";
    }

    function logout() {
        window.self.location.href="/login/logout";
    }
</script>
</body>
</html>