package com.example.samsung.techinnova;

/**
 * Created by samsung on 27-Jul-16.
 */
public class Student {



    private String Name;
    private String Branch;
    private String Year;
    private String Section;
    private String Email_id;
    private String Contact;

    private String password;

    public Student() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getName() {return Name;}
    public String getBranch() {return Branch;}
    public String getYear() {return Year;}
    public String getSection() {return Section;}
    public String getEmail() {return Email_id;}
    public String getContact() {return Contact;}

    public void setName(String Name) {this.Name=Name;}
    public void setBranch(String Branch) {this.Branch=Branch;}
    public void setYear(String Year) {this.Year=Year;}
    public void setSection(String Section) {this.Section=Section;}
    public void setEmail(String Email_id) {this.Email_id=Email_id;}
    public void setContact(String Contact) {this.Contact=Contact;}


}
