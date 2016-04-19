package vn.edu.techkids.praticelistview_assigment5;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Admin on 4/14/2016.
 */
public class EmployeeManager {
    private ArrayList<Employee> employeeArrayList;
    private static EmployeeManager ourInstance = new EmployeeManager();

    public static EmployeeManager getInstance() {
        return ourInstance;
    }
    public ArrayList<Employee> getEmployeeArrayList(){
        return employeeArrayList;
    }
    private EmployeeManager() {
        employeeArrayList=new ArrayList<>();
    }
}
