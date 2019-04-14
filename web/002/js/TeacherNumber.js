/**
 * Created by lin on 2019/3/2.
 */
var Go=document.getElementById("Go");
var TeacherNumber=document.getElementById("TeacherNumber");
//var TeacherNumberValue=TeacherNumber.value;
var errorMessage = "网络传输有问题，请检查网络连接或刷新页面再次进行操作";
//点击实现登录
Go.onclick=function(){
    var TeacherNumberValue=TeacherNumber.value;
    go(TeacherNumberValue);
    /*if(getSuccess.success!="yes"){
        alert("登录失败，请检查工号是否正确！")
    }*/
}
//回车实现登录
document.onkeydown = function(e){
    var e = window.event ? window.event:e;
    if(e.keyCode == 13){
        Go.onclick();
      //  go(TeacherNumberValue);
    }
}
function  go(TeacherNumberValue){
    $.ajax({
        url:'/servlet/login',   //路径
        type:'POST',               //方法
        cache:false,               //是否缓存
        dataType:'json',           //返回值类型
        data:{                     //传给后端的数据
            'TeacherNumberValue':2017012
        },
        success:function(){
            window.location="/TeacherSum/html/TeacherSum.html"//成功时
        },
        error:function(){                //失败
            //alert(errorMessage);
            window.location="/TeacherSum/html/TeacherSum.html"
        }
    })
}


var getSuccess={
    "success":yes
}