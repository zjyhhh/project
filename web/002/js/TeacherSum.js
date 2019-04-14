window.onload= function () {
    var errorMessage = "网络传输有问题，请检查网络连接或刷新页面再次进行操作";

    //兼容ie8的获取class
    //赋值
    var y1=0.0,y3=0.0,y6=0.0;
    function getDomsByClass(className) {
        if (document.getElementsByClassName) {
            return document.getElementsByClassName(className);
        }
        else {
            var lists = [];
            if (document.all !== undefined) {
                // 适用于IE / Chrom / Safari，但不适用于Firefox。
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

    //点击返回上页页面
    var Return=document.getElementById("Return");
    Return.onclick=function(){
        history.back(-1);
    }
   // alert("dg");
    //选中工作量种类
    var TeacherKinds=getDomsByClass("TeacherKinds");
    var imgClick=getDomsByClass("imgClick");
    var ChooseTurn=getDomsByClass("ChooseTurn");
    var CousrseMain=document.getElementById("CousrseMain");
    var GuideClassPeople=document.getElementById("GuideClassPeople");
    var GuideGraduationPeople=document.getElementById("GuideGraduationPeople");
    for(var p=0;p<imgClick.length;p++) {
       imgClick[p].index=p;
        imgClick[p].onclick = function () {
            var i;
            i=this.index;
            if ( ChooseTurn[i].style.display =="none"||ChooseTurn[i].style.display=="") {
                ChooseTurn[i].style.display = "block";
                TeacherKindKinds[i].style.color = "red";
                //实现点击不同的公平工作种类出现相应内容
               // alert("afa");
                alert(i);
                switch(i){
                    case 0:
                    {
                        alert("gdgdg");
                        if ( CousrseMain.style.display =="none"||CousrseMain.style.display=="") {
                            CousrseMain.style.display = "block";
                        }
                        else
                            CousrseMain.style.display = "none";
                    }
                        break;
                    case 1:
                    {
                        if ( GuideClassPeople.style.display =="none"||GuideClassPeople.style.display=="") {
                            GuideClassPeople.style.display = "block";
                        }
                        else
                            GuideClassPeople.style.display = "none";
                    }
                        break;
                    case 2:
                    {
                        if ( GuideGraduationPeople.style.display =="none"||GuideGraduationPeople.style.display=="") {
                            GuideGraduationPeople.style.display = "block";
                            //alert("毕业设计");
                            //点击指导毕业设计的计算
                            var GraduationSubmit=document.getElementById("GraduationSubmit");
                            GraduationSubmit.onclick=function(){
                                //y6指导大学生创新创业训练项目
                                //alert("进了");
                                var GraduationPeople=document.getElementById("GraduationPeople");
                                var GraduationPeopleScoreValue=document.getElementById("GraduationPeopleScore").value;
                                var GraduationPeopleValue=document.getElementById("GraduationPeople").value;
                                var GradeInnovationPeopleValueNum=parseFloat(GraduationPeopleValue);
                                var x6,text;
                                if (GradeInnovationPeopleValueNum<=6){
                                    x6=parseFloat(GraduationPeopleScoreValue)*GradeInnovationPeopleValueNum*1.2;
                                    text="y6"+"="+parseFloat(GraduationPeopleScoreValue)+"*"+GradeInnovationPeopleValueNum+"*"+"1.2"+"="+x6;
                                    createFormula(text);
                                    formulaOut.style.display="block";
                                    y6=Number(y6)+Number(x6);
                                }
                                else if(GradeInnovationPeopleValueNum<=10)
                                {
                                    x6 = parseFloat(GraduationPeopleScoreValue) * (6 * 1.2 + (GradeInnovationPeopleValueNum - 6) * 1);
                                    text="y6"+"="+parseFloat(GraduationPeopleScoreValue)+"("+"6"+"*"+"1.2"+"+"+(GradeInnovationPeopleValueNum - 6)+"*"+"1"+")"+"="+x6;
                                    createFormula(text);
                                    formulaOut.style.display="block";
                                    y6=Number(y6)+Number(x6);
                                }
                                else if(GradeInnovationPeopleValueNum>10){
                                    x6=parseFloat(GraduationPeopleScoreValue) * (6 * 1.2 + 4*1+(GradeInnovationPeopleValueNum - 10) * 0.5);
                                    text="y6"+"="+parseFloat(GraduationPeopleScoreValue)+"*"+"("+"6"+"*"+"1.2"+"+"+"4"+"*"+"1"+"+"+(GradeInnovationPeopleValueNum - 10)+"*"+"0.5"+")"+"="+x6;
                                    createFormula(text);
                                    formulaOut.style.display="block";
                                    y6=Number(y6)+Number(x6);
                                }
                            }
                        }
                        else
                            GuideGraduationPeople.style.display = "none";
                    }
                }
            }
            else {
                ChooseTurn[i].style.display = "none";
                TeacherKinds[i].style.color = "black";
                CousrseMain.style.display = "none";
                GuideClassPeople.style.display = "none";
                GuideGraduationPeople.style.display = "none";
            }
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
                //实现点击不同的公平工作种类出现相应内容
                // alert("afa");
                alert(j);
                switch (j) {
                    case 0:
                    {
                      //  alert("gdgdg");
                        if (CousrseMain.style.display == "none" || CousrseMain.style.display == "") {
                            CousrseMain.style.display = "block";
                        }
                        else
                            CousrseMain.style.display = "none";
                    }
                        break;
                    case 1:
                    {
                        if (GuideClassPeople.style.display == "none" || GuideClassPeople.style.display == "") {
                            GuideClassPeople.style.display = "block";
                        }
                        else
                            GuideClassPeople.style.display = "none";
                    }
                        break;
                    case 2:
                    {
                        if (GuideGraduationPeople.style.display == "none" || GuideGraduationPeople.style.display == "") {
                            GuideGraduationPeople.style.display = "block";
                            //点击指导毕业设计的计算
                            var GraduationSubmit=document.getElementById("GraduationSubmit");
                            GraduationSubmit.onclick=function(){
                                //y6指导大学生创新创业训练项目
                                //alert("进了");
                                var GraduationPeople=document.getElementById("GraduationPeople");
                                var GraduationPeopleScoreValue=document.getElementById("GraduationPeopleScore").value;
                                var GraduationPeopleValue=document.getElementById("GraduationPeople").value;
                                var GradeInnovationPeopleValueNum=parseFloat(GraduationPeopleValue);
                                var x6,text;
                                if (GradeInnovationPeopleValueNum<=6){
                                    x6=parseFloat(GraduationPeopleScoreValue)*GradeInnovationPeopleValueNum*1.2;
                                    text="y6"+"="+parseFloat(GraduationPeopleScoreValue)+"*"+GradeInnovationPeopleValueNum+"*"+"1.2"+"="+x6;
                                    createFormula(text);
                                    formulaOut.style.display="block";
                                    y6=Number(y6)+Number(x6);
                                }
                                else if(GradeInnovationPeopleValueNum<=10)
                                {
                                    x6 = parseFloat(GraduationPeopleScoreValue) * (6 * 1.2 + (GradeInnovationPeopleValueNum - 6) * 1);
                                    text="y6"+"="+parseFloat(GraduationPeopleScoreValue)+"("+"6"+"*"+"1.2"+"+"+(GradeInnovationPeopleValueNum - 6)+"*"+"1"+")"+"="+x6;
                                    createFormula(text);
                                    formulaOut.style.display="block";
                                    y6=Number(y6)+Number(x6);
                                }
                                else if(GradeInnovationPeopleValueNum>10){
                                    x6=parseFloat(GraduationPeopleScoreValue) * (6 * 1.2 + 4*1+(GradeInnovationPeopleValueNum - 10) * 0.5);
                                    text="y6"+"="+parseFloat(GraduationPeopleScoreValue)+"*"+"("+"6"+"*"+"1.2"+"+"+"4"+"*"+"1"+"+"+(GradeInnovationPeopleValueNum - 10)+"*"+"0.5"+")"+"="+x6;
                                    createFormula(text);
                                    formulaOut.style.display="block";
                                    y6=Number(y6)+Number(x6);
                                }
                            }
                        }
                        else
                            GuideGraduationPeople.style.display = "none";
                    }
                }
            }
            else {
                ChooseTurn[j].style.display = "none";
                TeacherKinds[j].style.color = "black";
                CousrseMain.style.display = "none";
                GuideClassPeople.style.display = "none";
                GuideGraduationPeople.style.display = "none";
            }
        }
    }
    //所教课程
    var close=document.getElementById("close");
    var open=document.getElementById("open");
    var CousrseSingle=document.getElementById("CousrseSingle");
    var cousrese=document.getElementById("cousrese");
    function courseClose(getClassResult) {
        close.onclick = function () {
            if (open.style.display == "none" || open.style.display == "") {
                open.style.display = "block";
                close.style.display = "none";
                CousrseSingle.style.display = "block";
                cousrese.style.borderBottomLeftRadius = "0";
                cousrese.style.borderBottomRightRadius = "0";
            }
            //当选择课程后，出现要进行的操作
            var CousrseSingleLis = CousrseSingle.getElementsByTagName("li");
            var Hour=document.getElementById("Hour");
            var Socre=document.getElementById("Socre");
            for (var i = 0; i < CousrseSingleLis.length; i++) {
                CousrseSingleLis[i].index = i;
                CousrseSingleLis[i].onclick = function () {
                    //alert(getClassResult.code);
                    var s = this.index;
                    cousrese.value = CousrseSingleLis[s].innerHTML;
                    open.style.display = "none";
                    close.style.display = "block";
                    CousrseSingle.style.display = "none";
                    cousrese.style.borderBottomLeftRadius = "5px";
                    cousrese.style.borderBottomRightRadius = "5px";

                    //当选择后变红表示已选择过
                    CousrseSingleLis[s].style.color = "red";
                    //添加课程名
                    var HourCousrese = getDomsByClass("HourCousrese");
                    for (var j = 0; j < HourCousrese.length; j++) {
                        HourCousrese[j].index = j;
                        HourCousrese[j].innerHTML = cousrese.value;
                    }
                    //学时

                    Hour.innerHTML=getClassResult.items[s].annualSchoolingHours;
                    //学分
                    Socre.innerHTML=getClassResult.items[s].annualProgramCredit;
                    //调用关联函数
                   //relation(getClassResult, s);

                    //关联教学种类并出现相应选择,为点击计算添加方式
                    buttonClick(getClassResult,s);
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

    //添加理论教学的课程
    function createClass(getClassResult) {
        //alert("创建");
        //var Hour=document.getElementById("Hour");
        //var Socre=document.getElementById("Socre");
        var GuidName=document.getElementById("GuidName");

        //所教课程的下拉表
        alert(getClassResult.items.length)
        for (var i = 0; i < getClassResult.items.length; i++) {
            var classes_li = document.createElement("li");
            var liText = document.createTextNode(getClassResult.items[i].subjectname);
            classes_li.appendChild(liText);
            CousrseSingle.appendChild(classes_li);
        }
        //计算出结果
    }
    //当点击计算的时候，添加计算公式并列出来
    function createFormula(Text){
        var formula=document.getElementById("formula");
        var sum_li = document.createElement("li");
        var Sum_liText = document.createTextNode(Text);
        sum_li.appendChild(Sum_liText);
        formula.appendChild(sum_li);
    }
    //计算理论课程的工作量
    function buttonClick(getClassResult,i) {
       // alert("我来计算啦！");
        //关联教学种类并出现相应选择
        if(getClassResult.items[i].panduan==0){
            // var ChooseTurn=getDomsByClass("ChooseTurn");
            //使理论教学关联起来
            ChooseTurn[0].style.display = "block";
            TeacherKinds[0].style.color = "red";
            //关联出现的计算输入(其余隐藏)
            GuideClassPeople.style.display="none";
            CousrseMain.style.display = "block";
            //点击计算理论教学的按钮
            var submit = document.getElementById("submit");
            //var EnglishB=document.getElementById("EnglishB");
            var EnglishTrue = document.getElementById("EnglishTrue");
            submit.onclick = function () {
                //系数B
                var EnglishB = document.getElementById("EnglishB");
                var LessonEnglishB = EnglishB.value;
                //系数K2
                var EnglishTrueValue = EnglishTrue.value;
                //计算公式列表
                var formulaOut=document.getElementById("formulaOut");

                var text,x;
                if(LessonEnglishB!="点击选择") {
                    x = (getClassResult.items[i].annualSchoolingHours * (parseFloat(LessonEnglishB)) + 7) * getClassResult.items[i].k0 * (getClassResult.items[i].k1 + parseFloat(EnglishTrueValue)) * (1 + getClassResult.items[i].c);
                    x= x.toFixed(2);
                    text = "y1=" + "(" + getClassResult.items[i].annualSchoolingHours + "*" + "(" + LessonEnglishB + ")" + ")" + "+" + "7" + ")" + "*" + getClassResult.items[i].k0 + "*" + "(" + getClassResult.items[i].k1 + "+" + EnglishTrueValue + ")" + "*" + "(" + "1" + "+" + getClassResult.items[i].c + ")" + "=" + x;
                    createFormula(text);
                    formulaOut.style.display="block";
                    y1=Number(y1)+Number(x);
                }
                else
                    alert("改作业权重系数（B）未进行选择！");
            }
        }
        else if(getClassResult.items[i].panduan=1){
            //使指导课程设计关联起来
            ChooseTurn[1].style.display = "block";
            TeacherKinds[1].style.color = "red";
            //关联出现的计算输入(其余隐藏)
            CousrseMain.style.display = "none";
            GuideClassPeople.style.display="block";
            //点击计算指导课程设计的按钮
            var GuideSubmit=document.getElementById("GuideSubmit");
            document.getElementById("GuidePeopleScore").value=getClassResult.items[i].annualProgramCredit;
            GuideSubmit.onclick=function(){
                //alert("大作业啊");
                var  x3;
                //指导课程设计的年计划学分
               // document.getElementById("GuidePeopleScore").value=getClassResult.item[i].annualProgramCredit;
                var GuidePeopleValue=document.getElementById("GuidePeople").value;//人数
                //把学分添加到input中
               // GuidePeopleScoreValue=getClassResult.item[i].annualProgramCredit;
                var GuidePeopleScoreValue=document.getElementById("GuidePeopleScore").value;
                //y3指导类学生的计算
                var peoNum=parseFloat(GuidePeopleValue) ;
                var text;
                if (peoNum<=20.0) {
                    x3 = parseFloat(GuidePeopleScoreValue) *getClassResult.items[i].k1* (peoNum * 1 )* 0.5;
                    x3=x3.toFixed(2);
                    text = "y3"+"="+parseFloat(GuidePeopleScoreValue) +"*"+getClassResult.items[i].k1+ "*" +"("+ peoNum + "*" + "1"+")"+"*"+"0.5" + "=" + x3;
                    createFormula(text);
                    formulaOut.style.display="block";
                    y3=Number(y3)+Number(x3);
                }
                else if (peoNum<=40.0) {
                    x3 = parseFloat(GuidePeopleScoreValue)*getClassResult.items[i].k1* (20 * 1 * (peoNum - 20.0) * 0.6 )* 0.5;
                    x3=x3.toFixed(2);
                    text = "y3"+"="+parseFloat(GuidePeopleScoreValue) +"*"+getClassResult.items[i].k1+ "*" +"("+"20"+"*"+"1"+"+"+ (peoNum - 20.0) + "*" +"0.6"+")"+"*"+ "0.5" + "=" + x3;
                    createFormula(text);
                    formulaOut.style.display="block";
                    y3=Number(y3)+Number(x3);
                }
                else if (peoNum<=100) {
                    x3 = parseFloat(GuidePeopleScoreValue) *getClassResult.items[i].k1*(20 * 1 + 20 * 0.6 + (peoNum - 40) * 0.3) * 0.5;
                    x3=x3.toFixed(2);
                    text = "y3"+"="+parseFloat(GuidePeopleScoreValue)+"*"+getClassResult.items[i].k1+ "*"+"("+"20"+"*"+ "1"+"+"+"20"+"*"+"0.6"+"+"+ (peoNum - 40) + "*" +"0.3"+")"+"*"+ "0.5" + "=" + x3;
                    createFormula(text);
                    formulaOut.style.display="block";
                    y3=Number(y3)+Number(x3);
                }
                else if (peoNum>=101) {
                    x3 = parseFloat(GuidePeopleScoreValue) *getClassResult.items[i].k1*(20 * 1+ 20 * 0.6 + 60 * 0.3 + (peoNum - 100) * 0.15 )* 0.5;
                    x3=x3.toFixed(2);
                    text = "y3"+"="+parseFloat(GuidePeopleScoreValue) +"*"+getClassResult.items[i].k1+ "*"+"("+"20"+"*"+ "1"+"+"+"20"+"*"+"0.6"+"+"+"60"+"*"+"0.3"+"+"+ (peoNum - 100) + "*" +"0.15"+")"+"*"+ "0.5" + "=" + x3;
                    createFormula(text);
                    formulaOut.style.display="block";
                    y3=Number(y3)+Number(x3);
                }
                else
                    alert("请先输入指导课程设计的人数！");
            }
        }
    }
    //计算出结果
    var SumSubmit=document.getElementById("SumSubmit");
    SumSubmit.onclick=function() {
        var sumValue;
        var Sum=document.getElementById("Sum");
        sumValue=parseFloat(y1)+parseFloat(y3)+parseFloat(y6);
        // alert(y1);
        // alert(y3);
        // alert(y6);
        //sumValue=parseFloat(sumValue);
        sumValue=sumValue.toFixed(2);
        Sum.innerHTML=sumValue;
        alert(sumValue);
    }
    getClassName();
    function  getClassName(){
        $.ajax({
            url:'/api/Data',   //路径
            type:'POST',               //方法
            cache:false,               //是否缓存
            dataType:'json',           //返回值类型
            data:{                     //传给后端的数据
               'TeacherNum':2017012
              // 'term':"2016-2017-2"
            },
            success:function(getClassResult){
                //成功时
                alert(getClassResult.code)
                if(getClassResult.code=="ok"){
                    alert("接口调用成功");
                    createClass(getClassResult);
                    courseClose(getClassResult);
                }
            },
            error:function(){                //失败
                // alert(message);
                if(getClassResult.code=="ok"){
                    //alert("afa");
                    createClass(getClassResult);
                    courseClose(getClassResult);
                    //buttonClick(getClassResult)
                }
            }
        })
    }


   /* var getClassResult=
    {
        "code":"ok",
        "item":[
            {
                "g":0.0,
                "e":0.3,
                "d1":0.3,
                "subjectname":"Java EE框架应用开发",
                "c":1.6,
                "k1":1.24,
                "k0":1.1,
                "f":0.0,
                "d2":0.0,
                "d3":0.0,
                "annualSchoolingHours":64.0,
                "annualProgramCredit":4.0,
                "classattendance":98.0,
                "kind":0
            },
            {
                "g":0.0,
                "e":0.3,
                "d1":0.3,
                "subjectname":"Python语言",
                "c":0,
                "k1":1.208,
                "k0":1.1,
                "f":0.0,
                "d2":0.0,
                "d3":0.0,
                "annualSchoolingHours":32.0,
                "annualProgramCredit":6.0,
                "classattendance":98.0,
                "kind":0
            },
            {
                "g":0.0,
                "e":0.3,
                "d1":0.3,
                "subjectname":"C语言设计大作业",
                "c":0.8,
                "k1":1.0,
                "k0":1.1,
                "f":0.0,
                "d2":0.0,
                "d3":0.0,
                "annualSchoolingHours":10.0,
                "annualProgramCredit":1.0,
                "classattendance":98.0,
                "kind":1
            }
        ]
    }*/

}