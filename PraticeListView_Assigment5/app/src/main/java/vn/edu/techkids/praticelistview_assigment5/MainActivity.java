package vn.edu.techkids.praticelistview_assigment5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listEmployee;
    Button add;
    ImageButton close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListEmployee();


    }
    private void initListEmployee(){
        add = (Button)this.findViewById(R.id.btnAdd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddEmployeeActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });

        ArrayList<Employee> arrayListEmployee = EmployeeManager.getInstance().getEmployeeArrayList();
//        arrayEmployee = new ArrayList<>();
//        for (Employee employee : arrayListEmployee){
//            arrayEmployee.add(new Employee(employee.getName(), employee.getAge(), employee.getJob()));
//        }
        listEmployee = (ListView)this.findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.list_employee, arrayListEmployee);

        listEmployee.setAdapter(adapter);


    }

}
