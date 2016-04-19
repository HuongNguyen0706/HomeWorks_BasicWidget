package vn.edu.techkids.praticelistview_assigment5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatPopupWindow;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 4/15/2016.
 */
public class AddEmployeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener, View.OnClickListener {
    EditText editName;
    EditText editAge;
    EditText editJob;
    Button save, btnBirthDay;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("MM / dd / yyyy");
        finidView();
        setBirthplaceSpinner();
        Bundle bundle = new Bundle();

    }



    private void finidView() {
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        editName = (EditText) findViewById(R.id.editTextName);
        editAge = (EditText) findViewById(R.id.editAge);
        editJob = (EditText) findViewById(R.id.editJob);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        btnBirthDay = (Button) findViewById(R.id.btnBirthday);
        btnBirthDay.setText(simpleDateFormat.format(calendar.getTime()));
        btnBirthDay.setOnClickListener(this);

        save = (Button) findViewById(R.id.btnAdd);
        save.setOnClickListener(this);
    }
    private void setBirthplaceSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<>();
        categories.add("Ha Noi");
        categories.add("Thai Nguyen");
        categories.add("Nam Dinh");
        categories.add("Thai Binh");
        categories.add("Bac Ninh");
        categories.add("Ninh Thuan");
        categories.add("Ca Mau");
        categories.add("Quang Binh");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd: {
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String job = editJob.getText().toString();
                this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                Employee employee = new Employee(name, age, job);

                EmployeeManager.getInstance().getEmployeeArrayList().add(employee);
                Log.d("Size", String.valueOf(EmployeeManager.getInstance().getEmployeeArrayList().size()));

                Intent intent = new Intent(AddEmployeeActivity.this, MainActivity.class);

                startActivity(intent);
                finish();
                break;
            }
            case R.id.btnBirthday: {
                showDialog(1);
                break;
            }
            default:
                break;
        }

    }
    protected Dialog onCreateDialog(int id){
        return new DatePickerDialog(this, this, 1993, 01, 01);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        btnBirthDay.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
    }
}