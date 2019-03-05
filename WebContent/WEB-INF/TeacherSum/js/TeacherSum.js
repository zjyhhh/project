window.onload= function () {
    var errorMessage = "网络传输有问题，请检查网络连接或刷新页面再次进行操作";

    //兼容ie8的获取class
    function getDomsByClass(className) {
        if (document.getElementsByClassName) {
            return document.getElementsByClassName(className);
        }
        else {
            var lists = [];
            if (document.all !== undefined) {
                // 适用于IE / Chrome / Safari，但不适用于Firefox。
                var allElements = document.all;
            }
            else {
                //适用于IE / Firefox / Opera，但不适用于Chrome和Safari。
                var allElements = document.getElementsByTagName("*");
            }
            for (var i = 0; i < allElements.length; i++) {
                if (allElements[i].className == className) {
                    lists.push(allElements[i]);
                }
            }
            return lists;
        }
    }
    //点击下拉打开的函数
    function  Openselect(Eng,Choose) {
        Eng.onclick = function () {
            if (Choose.style.display == "none" || Choose.style.display == "") {
                Choose.style.display = "block";
                Eng.style.borderBottomLeftRadius = "0";
                Eng.style.borderBottomRightRadius = "0";
            }
            else {
                Choose.style.display = "none";
                Eng.style.borderBottomLeftRadius = "5px";
                Eng.style.borderBottomRightRadius = "5px";
            }
        }
    }
   // alert("dg");
    //选中工作量种类
    var TeacherKinds=getDomsByClass("TeacherKinds");
    var imgClick=getDomsByClass("imgClick");
    var ChooseTurn=getDomsByClass("ChooseTurn");
    //var CousrseMain=document.getElementById("CousrseMain");
    for(var p=0;p<imgClick.length;p++) {
       imgClick[p].index=p;
        imgClick[p].onclick = function () {
            var i;
            i=this.index;
            if ( ChooseTurn[i].style.display =="none"||ChooseTurn[i].style.display=="") {
                ChooseTurn[i].style.display = "block";
            }
            else
                ChooseTurn[i].style.display = "none";
        }
    }
    for (var q=0;q<TeacherKinds.length;q++) {
        TeacherKinds[q].index=q;
        TeacherKinds[q].onclick=function () {
           // alert(j);
            var j;
            j=this.index;
            //alert(j);
            if ( ChooseTurn[j].style.display =="none"||ChooseTurn[j].style.display=="") {
                ChooseTurn[j].style.display = "block";
                TeacherKinds[j].style.color = "red";
            }
            else {
                ChooseTurn[j].style.display = "none";
                TeacherKinds[j].style.color = "black";
            }
        }
    }
    //所教课程
    var close=document.getElementById("close");
    var open=document.getElementById("open");
    var CousrseSingle=document.getElementById("CousrseSingle");
    var cousrese=document.getElementById("cousrese");
    close.onclick=function(){
        if ( open.style.display =="none"||open.style.display=="") {
            open.style.display = "block";
            close.style.display="none";
            CousrseSingle.style.display="block";
            cousrese.style.borderBottomLeftRadius="0";
            cousrese.style.borderBottomRightRadius="0";
        }
        //当选择课程后，出现要进行的操作
        var CousrseSingleLis=CousrseSingle.getElementsByTagName("li");
        for (var i=0;i<CousrseSingleLis.length;i++){
            CousrseSingleLis[i].index=i;
            CousrseSingleLis[i].onclick=function(){
                var s=this.index;
                cousrese.value=CousrseSingleLis[s].innerHTML;
                open.style.display = "none";
                close.style.display="block";
                CousrseSingle.style.display="none";
                cousrese.style.borderBottomLeftRadius="5px";
                cousrese.style.borderBottomRightRadius="5px";
                //当选择后变红表示已选择过
                CousrseSingleLis[s].style.color="red";
                //学时，学分
                var HourCousrese=getDomsByClass("HourCousrese");
                for(var j=0;j<HourCousrese.length;j++){
                    HourCousrese[j].index=j;
                    HourCousrese[j].innerHTML=cousrese.value;
                }
            }
        }
    }
    open.onclick=function(){
        if(open.style.display="block"){
            open.style.display = "none";
            close.style.display="block";
            CousrseSingle.style.display="none";
            cousrese.style.borderBottomLeftRadius="5px";
            cousrese.style.borderBottomRightRadius="5px";
        }
    }

    //改作业权重系数
    var EnglishB=document.getElementById("EnglishB");
    var ChooseB=document.getElementById("ChooseB");
    Openselect(EnglishB,ChooseB);
    var ChooseBLis=ChooseB.getElementsByTagName("li");
    for(var i=0;i<ChooseBLis.length;i++){
        ChooseBLis[i].index=i;
        ChooseBLis[i].onclick=function(){
            var j=this.index;
            EnglishB.value=ChooseBLis[j].innerHTML;
            ChooseB.style.display = "none";
            EnglishB.style.borderBottomLeftRadius="5px";
            EnglishB.style.borderBottomRightRadius="5px";
        }
    }

    //选择是否是外语授课
    var English=document.getElementById("English");
    var ChooseEnglish=document.getElementById("ChooseEnglish");
    Openselect(English,ChooseEnglish);
    //当点击选择后关闭
    var ChooseEnglishLis=ChooseEnglish.getElementsByTagName("li");
    for(var i=0;i<ChooseEnglishLis.length;i++){
        ChooseEnglishLis[i].index=i;
        ChooseEnglishLis[i].onclick=function(){
            var j=this.index;
            English.value=ChooseEnglishLis[j].innerHTML;
            ChooseEnglish.style.display = "none";
            English.style.borderBottomLeftRadius="5px";
            English.style.borderBottomRightRadius="5px";
            //if(English.value=="是")
                TrueEng(English.value);
        }
    }

    //当外语授课选择为是的时候打开k2系数进行选择
    function TrueEng(val) {
       // alert(val);
        var ClassEnglishTrue = document.getElementById("ClassEnglishTrue");
        if (val == "是") {
            var EnglishTrue = document.getElementById("EnglishTrue");
            var ChooseEnglishTrue = document.getElementById("ChooseEnglishTrue");
            var ChooseEnglishTrueLis = ChooseEnglishTrue.getElementsByTagName("li");
            ClassEnglishTrue.style.display = "block";
            //alert(ClassEnglishTrue.style.display);
            for (var i = 0; i < ChooseEnglishTrueLis.length; i++) {
                ChooseEnglishTrueLis[i].index = i;
                ChooseEnglishTrueLis[i].onclick = function () {
                    var j = this.index;
                    EnglishTrue.value = ChooseEnglishTrueLis[j].innerHTML;
                    ChooseEnglishTrue.style.display = "none";
                }
            }
            EnglishTrue.onclick=function(){
                ChooseEnglishTrue.style.display = "block";
            }
        }
        else{
            ClassEnglishTrue.style.display="none";
        }
    }

    //打开实验课讲授的改作业权重系数(B)
    var Experiment=document.getElementById("Experiment");
    var ExperimentB=document.getElementById("ExperimentB");
    Openselect(Experiment,ExperimentB);
    var ExperimentBLis=ExperimentB.getElementsByTagName("li");
    for(var i=0;i<ExperimentBLis.length;i++){
        ExperimentBLis[i].index=i;
        ExperimentBLis[i].onclick=function(){
            var j=this.index;
            Experiment.value=ChooseBLis[j].innerHTML;
            ExperimentB.style.display = "none";
            Experiment.style.borderBottomLeftRadius="5px";
            Experiment.style.borderBottomRightRadius="5px";
        }
    }

    //添加理论教学的课程
    function createClass(getClassResult) {
        alert("创建");
        var Hour=document.getElementById("Hour");
        var Socre=document.getElementById("Socre");
        var GuidName=document.getElementById("GuidName");
        while (CousrseSingle.hasChildNodes()) {
            CousrseSingle.removeChild(CousrseSingle.firstChild);
        }
        //所教课程的下拉表
        for (var i = 0; i < getClassResult.classList.length; i++) {
            var classes_li = document.createElement("li");
            var liText = document.createTextNode(getClassResult.classList[i].lessonName);
            classes_li.appendChild(liText);
            CousrseSingle.appendChild(classes_li);
        }
        //学时
        Hour.innerHTML=getClassResult.classHour;
        //学分
        Socre.innerHTML=getClassResult.classScore;
        //指导课程设计大作业
        GuidName.innerHTML=getClassResult.GuideTestName;
    }
    //返回数据给后台
    var submit=document.getElementById("submit");
    submit.onclick=function() {
        var People = document.getElementById("People");
        var ClassEnglishK = document.getElementById("ClassEnglishTrue");
        var GuidePeople=document.getElementById("GuidePeople");
        var GraduationPeople=document.getElementById("GraduationPeople");
        var GradePracticePeople=document.getElementById("GradePracticePeople");
        var GradeInnovationPeople=document.getElementById("GradeInnovationPeople");
        var LessonPeople = People.value;
        var LessonEnglishB = EnglishB.value;
        var GuideTestPeople=GuidePeople.value;
        var GraduationPeopleValue=GraduationPeople.value;
        var GradePracticePeopleValue=GradePracticePeople.value;
        var ExperimentValue=Experiment.value;
        var GradeInnovationPeopleValue=GradeInnovationPeople.value;
        if (ChooseEnglish.value == "是"&&LessonPeople!=""&&LessonEnglishB!=""&&GuideTestPeople!=""&&GraduationPeopleValue!=""&&GradePracticePeopleValue!=""&&ExperimentValue!=""&&GradeInnovationPeopleValue!="") {
            var LessonK2 = ClassEnglishK.value;
            getClassName(LessonPeople, LessonEnglishB, LessonK2,GuideTestPeople,GraduationPeopleValue,GradePracticePeopleValue,ExperimentValue,GradeInnovationPeople);
        }
        else {

        }
    }
    getClassName();
    function  getClassName(){
        $.ajax({
            url:'SelectAllClass.do',   //路径
            type:'POST',               //方法
            cache:false,               //是否缓存
            dataType:'json',           //返回值类型
            data:{                     //传给后端的数据
               // 'grade':grade
            },
            success:function(getClassResult){      //成功时
                if(getClassResult.applyStatus.status=="ok"){
                    createClass(getClassResult);
                }
            },
            error:function(){                //失败
                // alert(message);
                if(getClassResult.applyStatus.status=="ok"){
                    //alert("afa");
                    createClass(getClassResult);
                }
            }
        })
    }


    var getClassResult=
    {
        "applyStatus": {
            "status": "ok",
            "hint": "成功获取"
        },
        "classHour":36,
        "classScore":4,
        "GuideTestName":"java大作业",
        "classList": [
            {
                "lessonName": "Java EE框架应用开发"
            },
            {
                "lessonName": "计算机科学与"
            },
            {
                "lessonName": "软件工程"
            },
            {
                "lessonName": "Python语言"
            }
        ]
    }



}