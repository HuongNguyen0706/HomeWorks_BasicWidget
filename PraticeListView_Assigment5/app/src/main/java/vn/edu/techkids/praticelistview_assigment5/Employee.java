package vn.edu.techkids.praticelistview_assigment5;

/**
 * Created by Admin on 4/14/2016.
 */
public class Employee {
    private String name;
    private String age;
    private String birthDay;
    private String address;
    private String job;
    private int avatar;


    public Employee(String name, String age, String birthDay, String address, String job, int avatar){
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.address = address;
        this.job = job;
        this.avatar = avatar;

    }

    public Employee(String name,
                    String age,
                    String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Employee() {
        this.name = "";
        this.age = "";
        this.job = "";
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
