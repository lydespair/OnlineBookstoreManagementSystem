
 <!-- 检查用户名 -->
function checkname() {
    var name = document.getElementById("username").value;
    var reg = /^[\u4e00-\u9fa5a-zA-Z]{2,4}$/;
    if(name==''){
        document.getElementById("text").className="wrong";
        document.getElementById("text").innerText="用户名不能为空!";
        return false;
    } else{
        if (reg.test(name)) {
            document.getElementById("text").innerText=" ";
            return true;
        } else {
            document.getElementById("text").className="wrong";
            document.getElementById("text").innerText="请输入有效的用户名";
            return false;
        }

    }
}
 <!-- 检查密码 -->
function checkpass() {
    var pass = document.getElementById("password").value;
    var reg = /^[0-9a-zA-Z]{6,12}$/;
    if(pass==''){
        document.getElementById("password").className="wrong";
        document.getElementById("password").innerText="密码不能为空!";
        return false;
    }
    else{
        if (reg.test(pass)) {
            document.getElementById("password").innerText=" ";
            return true;
        } else {
            document.getElementById("password").className="wrong";
            document.getElementById("password").innerText="密码长度为6—12位";
            return false;
        }
    }
}
function checkall(){
    let xmlhttp;
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
        }
    }
    let data = {
        "userName": "",
        "userPassword": ""
    }
    xmlhttp.open("POST","http://localhost:8080/login",true);
    xmlhttp.send(JSON.stringify(data));






    var now=new Date();
    var hour=now.getHours();
    var minute=now.getMinutes();
    var second=now.getSeconds();
    var week=now.getDay();
    var a=['日','一','二','三','四','五','六'];
    var str="现在是："+hour+":"+minute+":"+second+",星期"+a[week];
    if(checkname()==true&&checkpass()==true){
        alert(str+"，登录成功！");
        location.href="index.html";
    }else{
        alert("登录失败！");
        return false;
    }

}