package vn.edu.techkids.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Admin on 4/21/2016.
 */
public class CircleProgressBar extends View {
    private int max;
    private int progress;

    private float delta;


    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
//        invalidate();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
        delta = 1.0f * 360 / max;
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        RectF rectF = new RectF(40, 200, 690,850);
        canvas.drawArc(rectF, 0, delta * progress, true, paint);

        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setStyle(Paint.Style.FILL);

        RectF rectF1 = new RectF(50, 210, 680, 840);
        canvas.drawArc(rectF1, 0, 360, true, paint1);

        Paint paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);

        RectF rectF2 = new RectF(350, 190, 380, 220);
        canvas.drawArc(rectF2, 0, 360, true, paint2);

    }
}
