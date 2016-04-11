package vn.edu.techkids.homeworks_basicwidget;

import java.util.ArrayList;

/**
 * Created by Admin on 4/9/2016.
 */
public class EmployeeManager {
    private ArrayList<Employee> arrEmployee;
    private static EmployeeManager ourInstace = new EmployeeManager();

    private EmployeeManager(){
        arrEmployee = new ArrayList<>();
    }

    public ArrayList<Employee> getArrEmployee() {
        return arrEmployee;
    }

    public static EmployeeManager getOurInstace() {
        return ourInstace;
    }
}
