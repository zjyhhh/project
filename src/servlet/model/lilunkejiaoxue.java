package servlet.model;

public class lilunkejiaoxue {
    private  double AnnualSchoolingHours;//学时
    private  double K0;
    private  double K1;
    private  double C;
    private  double E;
    private  double F;
    //private  double G;
    private  String Subjectname;//课程名称
    private  double AnnualProgramCredit;//学分
    private  double AnnualProgramCredit2;
    private  double Classattendance;//人数（大作业）
    private  double panduan;
    private  double people;//人数
    //private  double D1;
    //private  double D2;
    //private  double D3;
    private String term2;//年份
    private String classname;//班级名称
    private String classnumber;//班级代号

    public String getclassnumber() { return classnumber; }
    public void setclassnumber(String classnumber) { this.classnumber = classnumber; }
    public String getTerm2() { return term2; }
    public void setTerm2(String term2) { this.term2 = term2; }
    public String getclassname() { return classname; }
    public void setclassname(String classname) { this.classname = classname; }
    public double getAnnualSchoolingHours() { return AnnualSchoolingHours; }
    public void setAnnualSchoolingHours(double AnnualSchoolingHours) {
        this.AnnualSchoolingHours =AnnualSchoolingHours;
    }
    public double getK0() { return K0; }
    public void setK0(double K0) { this.K0 = K0; }
    public double getK1() { return K1; }
    public void setK1(double K1) { this.K1 = K1; }
    public double getC() { return C; }
    public void setC(double C) {
        this.C = C;
    }
    public double getE() { return E; }
    public void setE(double E) {
        this.E = E;
    }
    public double getF() { return F; }
    public void setF(double F) {
        this.F = F;
    }
    //public double getG() { return G; }
    //public void setG(double G) {this.G = G;}
    public String getSubjectname() { return Subjectname; }
    public void setSubjectname(String Subjectname) {
        this.Subjectname =Subjectname;
    }
    public double getAnnualProgramCredit() { return AnnualProgramCredit; }
    public void setAnnualProgramCredit(double AnnualProgramCredit) {
        this.AnnualProgramCredit =AnnualProgramCredit;
    }
    public double getAnnualProgramCredit2() { return AnnualProgramCredit2; }
    public void setAnnualProgramCredit2(double AnnualProgramCredit2) { this.AnnualProgramCredit2 =AnnualProgramCredit2; }
    public double getClassattendance() { return Classattendance; }
    public void setClassattendance(double Classattendance) {
        this.Classattendance =Classattendance;
    }
    public double getpanduan() { return panduan; }
    public void setpanduan(double panduan) {
        this.panduan =panduan;
    }
    //public double getD1() { return D1; }
    //public void setD1(double D1) { this.D1 = D1; }
    //public double getD2() { return D2; }
    //public void setD2(double D2) { this.D2 = D2; }
    //public double getD3() { return D3; }
    //public void setD3(double D3) { this.D3 = D3; }
    public double getPeople() { return people; }
    public void setPeople(double people) { this.people = people; }
}
