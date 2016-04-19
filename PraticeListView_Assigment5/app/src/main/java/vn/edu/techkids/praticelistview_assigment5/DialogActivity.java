package vn.edu.techkids.praticelistview_assigment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {
    TextView name;
    TextView age;
    TextView address;
    TextView birth;
    TextView job;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        init();

    }
    public void init(){
        name = (TextView)findViewById(R.id.textViewName);
        age = (TextView)findViewById(R.id.textViewAge);
        address = (TextView)findViewById(R.id.textViewAdd);
        birth = (TextView)findViewById(R.id.textViewBirth);
        job = (TextView)findViewById(R.id.textViewJob);
        back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
