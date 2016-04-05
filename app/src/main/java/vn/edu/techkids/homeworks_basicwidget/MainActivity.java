package vn.edu.techkids.homeworks_basicwidget;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String arr[] = {"Ha noi", "Thai Nguyen", "Nam Dinh", "Thai Binh", "Lang Son"};
    TextView address;
    Spinner spinner;
    TextView txtBirthday;
    Button btnBirthday;
    Calendar calendar;
    Date dateFinish;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        address = (TextView)findViewById(R.id.txtAddress);
        spinner = (Spinner)findViewById(R.id.spinnerAddress);
        //gan data source arr vao adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,arr);
        //hien thi danh sach cho spinner
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        //thiet lap adapter cho spinner
        spinner.setAdapter(adapter);
        //thiet lap su kien chon phan tu cho Spinner
        txtBirthday = (TextView)findViewById(R.id.txtBirthday);
        btnBirthday = (Button)findViewById(R.id.btnBirthday);
        btnBirthday.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showDatePickerDialog();
                getDateFormat();
            }
        });

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SaveActivity.class);
                startActivity(myIntent);
            }
        });



    }
    //khi co lua chon thi vao ham nay
    private void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3){
        //arg2 la phan tu duoc chon trong data source
        address.setText(arr[arg2]);
    }
    //neu khong chon gi ca
    public void onNothingSelected(AdapterView<?> arg0){
        address.setText(" ");
    }
    public void showDatePickerDialog(){
        final DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //mooi lan thay doi ngay thang nam thi cap nhat lai ngay
                btnBirthday.setText((dayOfMonth) + "/" + (monthOfYear) + "/" + (year));
                //luu vet lai bien ngay hoan thanh
                calendar.set(year, monthOfYear, dayOfMonth);
                dateFinish = calendar.getTime();
            }
        };

        //Cac lenh duoi nay xu ly ngay gio trong DatepicketDialog
        String s = btnBirthday.getText()+"";
        String strArrtmp[] = s.split("/");
        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]);
        int nam = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, callback, nam, thang, ngay);
        datePickerDialog.setTitle("Chon ngay sinh cua ban");
        datePickerDialog.show();

    }
    //ham dinh dang ngay/thang/namm
    public void getDateFormat(){
        calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = simpleDateFormat.format(calendar.getTime());
        //hien thi len giao dien
        btnBirthday.setText(strDate);

    }

}
