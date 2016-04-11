package vn.edu.techkids.homeworks_basicwidget;

/**
 * Created by Admin on 4/9/2016.
 */
public class Employee {
    private String name;
    private String age;
    private String birthYear;

    public Employee(String age, String birthYear, String name) {
        this.age = age;
        this.birthYear = birthYear;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
