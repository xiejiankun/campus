window.onload=function(){
    document.getElementById("loginbutton").onclick=function(){
        var flag1=checkusername();
        var flag2=checkpassword(); 
        let tishi=document.getElementById("tishi");
        if(!(flag1||flag2))
        {
            tishi.style.display="none";
            return false;
        }
        if(!flag1||!flag2){
            return false;
        }
        else return flag1&&flag2;
        
    } 
    document.getElementById("username").onblur=checkusername;
    document.getElementById("password").onblur=checkpassword;
    function checkusername(){
        let username=document.getElementById("username").value;
        if(!username){
            tishi.innerText="用户名不能为空！";
            tishi.style.display="block";
        }
        return username;
    }
    function checkpassword(){
        let password=document.getElementById("password").value;
        if(!password){
            tishi.innerText="密码不能为空!";
            tishi.style.display="block";
        }
        return password;
    }
}