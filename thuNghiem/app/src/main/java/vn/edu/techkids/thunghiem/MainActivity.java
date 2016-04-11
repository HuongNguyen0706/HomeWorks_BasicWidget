package vn.edu.techkids.thunghiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton close1;
    ImageButton close2;
    ImageButton close3;
    FrameLayout FrameLayout1;
    FrameLayout FrameLayout2;
    FrameLayout FrameLayout3;
    Button show;
    Button hide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout1 = (FrameLayout) findViewById(R.id.fl1);
        FrameLayout2 = (FrameLayout) findViewById(R.id.fl2);
        FrameLayout3 = (FrameLayout) findViewById(R.id.fl3);

        close1 = (ImageButton) findViewById(R.id.iBtnClose1);
        close2 = (ImageButton) findViewById(R.id.iBtnClose2);
        close3 = (ImageButton) findViewById(R.id.iBtnClose3);

        close1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout1.setVisibility(View.INVISIBLE);
            }
        });
        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout2.setVisibility(View.INVISIBLE);
            }
        });
        close3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout3.setVisibility(View.INVISIBLE);
            }
        });

        show = (Button)findViewById(R.id.btnShow);
        hide = (Button)findViewById(R.id.btnHide);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout1.setVisibility(View.VISIBLE);
                FrameLayout2.setVisibility(View.VISIBLE);
                FrameLayout3.setVisibility(View.VISIBLE);

            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout1.setVisibility(View.INVISIBLE);
                FrameLayout2.setVisibility(View.INVISIBLE);
                FrameLayout3.setVisibility(View.INVISIBLE);

            }
        });



    }


}
