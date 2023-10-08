function checkregname() {
    var name = document.getElementById("name").value;
    var reg = /^[\u4e00-\u9fa5a-zA-Z]{2,4}$/;
    if(name==''){
        document.getElementById("cw").style.backgroundImage=" url(image/im1.png)";
        document.getElementById("cw").className="wrong";
        document.getElementById("cw").innerText="请输入用户名";
        document.getElementById("jc").innerText=" ";

    } else{

        if (reg.test(name)) {
            document.getElementById("jc").innerHTML="<img src='im2.png'/>";
            document.getElementById("cw").innerText=" ";
            return true;
        } else {
            document.getElementById("cw").style.backgroundImage=" url(image/im1.png)";
            document.getElementById("cw").className="wrong";
            document.getElementById("cw").innerText="请输入有效的用户名";
            document.getElementById("jc").innerText=" ";

        }

    }


}
function checkregpass() {
    var pass1 = document.getElementById("pass1").value;
    var reg = /^[0-9a-zA-Z]{6,12}$/;

    if (reg.test(pass1)) {
        document.getElementById("jc1").innerHTML="<img src='im2.png'/>";
        document.getElementById("cw1").innerText=" ";
        return true;
    } else {
        document.getElementById("cw1").className="wrong";
        document.getElementById("cw1").innerText="密码长度为6—12位";
        document.getElementById("jc1").innerText=" ";

    }

}
function checkregpassw() {
    var pass1 = document.getElementById("pass1").value;
    var pass2 = document.getElementById("pass2").value;
    if (pass2==pass1&&pass2!='') {
        document.getElementById("cw2").innerText=" ";
        return true;
    } else {
        document.getElementById("cw2").className="wrong";
        document.getElementById("cw2").innerText="请再次输入密码";
        document.getElementById("jc2").innerText=" ";

    }

}


function checkmail() {
    var mail= document.getElementById("mail").value;
    var reg = /^\w{1,}@\w{1,}(.\w{1,}){1,}$/;
    if(mail!=''){
        if (reg.test(mail)) {
            document.getElementById("cw5").innerText=" ";
            return true;
        } else {
            document.getElementById("cw5").className="wrong";
            document.getElementById("cw5").innerText="请输入有效的邮箱";
            document.getElementById("jc5").innerText=" ";

        }
    }else{
        document.getElementById("cw5").className="wrong";
        document.getElementById("cw5").innerText="请输入邮箱";
        document.getElementById("jc5").innerText=" ";

    }
}
function check(){
    var now=new Date();
    var hour=now.getHours();
    var minute=now.getMinutes();
    var second=now.getSeconds();
    var week=now.getDay();
    var a=['日','一','二','三','四','五','六'];
    var str="现在是："+hour+":"+minute+":"+second+",星期"+a[week];
    if( checkregname()==true&&checkregpass()==true&&checkregpassw()==true&&checkmail()==true){
        alert(str+"注册成功!");
        location.href="login.html";
    }else{
        alert("注册失败！");
        return false;
    }
}