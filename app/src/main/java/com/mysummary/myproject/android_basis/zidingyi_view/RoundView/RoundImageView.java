package com.mysummary.myproject.android_basis.zidingyi_view.RoundView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by xingzhi on 2018/6/25.
 */

public class RoundImageView extends AppCompatImageView{


    private Paint paint ;

    public RoundImageView(Context context) {
        super(context);
        init();
    }



    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setColor(Color.RED);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();
        if (drawable!=null){
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
//            Bitmap b = getRoundBitmap(bitmap, 50);

//            final Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());
//            final Rect rectDest = new Rect(0,0,getWidth(),getHeight());
//            paint.reset();
//            canvas.drawBitmap(b, rectSrc, rectDest, paint);
//            canvas.drawBitmap(b,0,0,paint);

//
//            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
//                    bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas canvas1 = new Canvas(output);

//        final int color = 0xff424242;

            int layerID = canvas.saveLayer(0,0,bitmap.getWidth(),bitmap.getWidth(),paint,Canvas.ALL_SAVE_FLAG);

            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            final Rect dst = new Rect(0, 0, getWidth(), getHeight());



            final RectF rectF = new RectF(dst);
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
//        canvas.drawARGB(0, 0, 0, 0);
//        paint.setColor(color);
//        paint.setColor(Color.RED);
//        int x = bitmap.getWidth();

//            canvas.drawRoundRect(rectF, 50, 50, paint);
//



            canvas.drawRoundRect(rectF, 50, 50, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, dst, paint);

            paint.setXfermode(null);
            canvas.restoreToCount(layerID);

        }else {

            super.onDraw(canvas);
        }


    }

    private Bitmap getRoundBitmap(Bitmap bitmap, int roundPx) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

//        final int color = 0xff424242;

        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final Rect dst = new Rect(0, 0, getWidth(), getHeight());


        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
//        canvas.drawARGB(0, 0, 0, 0);
//        paint.setColor(color);
//        paint.setColor(Color.RED);
//        int x = bitmap.getWidth();

        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, dst, paint);
        return output;


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println(event);
        System.out.println(event.getX());
        System.out.println(event.getRawX());

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }
}
