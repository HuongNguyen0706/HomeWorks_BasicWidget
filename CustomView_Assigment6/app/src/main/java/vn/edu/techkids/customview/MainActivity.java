package vn.edu.techkids.customview;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int countTime;
    CircleProgressBar circleProgressBar;
    ImageButton start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgressBar = (CircleProgressBar) this.findViewById(R.id.circleProgressBar);
        circleProgressBar.setMax(20);
        circleProgressBar.setProgress(0);

        start = (ImageButton)findViewById(R.id.imageStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer T = new Timer();
                T.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        countTime++;
                        
                        if(countTime == 20){
                            NotificationCompat.Builder mBuilder =
                                    (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                                            .setSmallIcon(R.mipmap.ic_launcher)
                                            .setContentTitle("My notification")
                                            .setContentText("Hello World!");
                            Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);

                            TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
                            stackBuilder.addParentStack(ResultActivity.class);
                            stackBuilder.addNextIntent(resultIntent);
                            PendingIntent resultPendingIntent =
                                    stackBuilder.getPendingIntent(
                                            0,
                                            PendingIntent.FLAG_UPDATE_CURRENT
                                    );
                            mBuilder.setContentIntent(resultPendingIntent);
                            NotificationManager mNotificationManager =
                                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            mNotificationManager.notify(9999, mBuilder.build());
                        }
                        updateProgress(countTime);


                    }
                }, 1000, 1000);
            }
        });



    }

    private void updateProgress(int countTime) {
        this.circleProgressBar.setProgress(countTime);
        this.circleProgressBar.postInvalidate();
    }
}
