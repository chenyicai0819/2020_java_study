<%@ page import="java.util.List" %>
<%@ page import="cn.edu.guet.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  bean.User: swagg
  Date: 2021/6/6
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍信息</title>
    <style>
        table, th, tr, td {
            border: 1px solid red;
            border-collapse: collapse;
        }
    </style>

    <script language="javascript">
        window.onload = function () {
            var del = document.getElementsByClassName("delete1");
            for (var i = 0; i < del.length; i++) {
                del[i].index = i;
                del[i].onclick = function () {
                    var rowNum=this.index;
                    console.log(rowNum);
                    var delID = document.getElementById("test").rows [rowNum+1].cells[0].innerHTML;
                    console.log(delID);
                    window.location="delete.do?delID="+delID;
                }
            }

            var up = document.getElementsByClassName("update1");
            for (var i = 0; i < up.length; i++) {
                up[i].index = i;
                up[i].onclick = function () {
                    var rowNum=this.index;
                    console.log(rowNum);
                    var upID = document.getElementById("test").rows [rowNum+1].cells[0].innerHTML;
                    var upName = document.getElementById("test").rows [rowNum+1].cells[2].innerHTML;
                    var upBauthor = document.getElementById("test").rows [rowNum+1].cells[3].innerHTML;
                    var upHome = document.getElementById("test").rows [rowNum+1].cells[4].innerHTML;
                    window.location="update.html?upID="+upID+"&upName="+upName+"&upBauthor="+upBauthor+"&upHome="+upHome;
                    //window.location="update.html?upID="+upID;
                }
            }
            document.getElementById("insertbooks").onclick=function (){
                console.log("jadd");
                window.location.href="/WebDel_war/insert.html";
            }

        }
    </script>
</head>
<body>
<%
    String selete1="";
    String selete= (String) request.getAttribute("selete");
    if(selete!=null){
        selete1=selete;
    }
%>
<form action="user.do" method="get" id="selete1">
    <input type="text" name="selete" placeholder="请输入想查找的书名" value="<%=selete1%>">
    <input type="submit" value="查找">
</form>
<table id="test">
    <thead>
    <tr>
        <th>ID</th>
        <th>状态</th>
        <th>书名</th>
        <th>作者</th>
        <th>地址</th>
        <th>删除</th>
        <th>修改</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        for (int i = 0; i < userList.size(); i++) {
    %>
    <tr id="tr1">
        <td><%=userList.get(i).getBid()%>
        </td>
        <td><%=userList.get(i).getSname()%>
        </td>
        <td><%=userList.get(i).getBname()%>
        </td>
        <td><%=userList.get(i).getBauthor()%>
        </td>
        <td><%=userList.get(i).getBhome()%>
        </td>
        <td class="delete1"><a href="javascript:void(0)">删除</a></td>
        <td class="update1"><a href="update.html?upID=<%=userList.get(i).getBid()%>&upName=<%=userList.get(i).getBname()%>&upBauthor=<%=userList.get(i).getBauthor()%>">修改</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<div >
    <input type="button" name="Button" value="添加图书" id="insertbooks">
</div>
</body>
</html>
