package com.example.sahilmtl;

public class dataex {
    String id,student, father, mother, aadhar, dob, mobile, address,rMale,rfmale,scaste, srel, smed, sdes, sreg;

    public dataex(String id,  String aadhar, String student, String father,String mother,String dob,String mobile,String address,String rMale,String rfmale,String scaste,String srel,String smed,String sdes,String sreg )
    {
        this.id=id;
        this.aadhar=aadhar;
        this.student=student;
        this.father=father;
        this.mother=mother;
        this.dob=dob;
        this.mobile=mobile;
        this.address=address;
        this.rMale=rMale;
        this.rfmale=rfmale;
        this.scaste=scaste;
        this.srel=srel;
        this.smed=smed;
        this.sdes=sdes;
        this.sreg=sreg;
    }




    public String getId()
    {
        return id;
    }
    public String getAadhar()

    {
        return aadhar;
    }
    public String getStudent()

    {
        return student;
    }
    public String getFather()

    {
        return father;
    }
    public String getMother()

    {
        return mother;
    }
    public String getDob(){return dob;}
    public String getMobile(){return mobile;}
    public String getAddress(){return address;}
    public String getRMale(){return rMale;}
    public String getRfmale(){return rfmale;}
    public String getScaste(){return scaste;}
    public String getSrel(){return srel;}
    public String getSmed() {return smed;}
    public String getSdes() {return sdes;}
    public String getSreg() {return sreg;}
}


