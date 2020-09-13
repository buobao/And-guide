package com.turman.and_guide.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.turman.and_guide.R;

public class MyImageView extends View {
    private Bitmap mBitmap;
    private Paint mBitPaint;
    Drawable imgRes;

    public MyImageView(Context context) {
        super(context);
        init(null,0);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.MyImageView);
        imgRes = ta.getDrawable(R.styleable.MyImageView_img);
        ta.recycle();
        mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitPaint.setFilterBitmap(true);
        mBitPaint.setDither(true);

        imgRes.setBounds(new Rect(0,0,imgRes.getIntrinsicWidth(),imgRes.getIntrinsicHeight()));

        mBitmap = getmBitmap(imgRes);
//        mBitmap = Bitmap.createBitmap( imgRes.getIntrinsicWidth(), imgRes.getIntrinsicHeight(),
//                imgRes.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);

    }

    private Bitmap getmBitmap(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof AdaptiveIconDrawable) {
                Drawable[] drr = new Drawable[2];
                drr[0] = ((AdaptiveIconDrawable) drawable).getBackground();
                drr[1] = ((AdaptiveIconDrawable) drawable).getForeground();

                LayerDrawable layerDrawable = new LayerDrawable(drr);
                int width = layerDrawable.getIntrinsicWidth();
                int height = layerDrawable.getIntrinsicHeight();

                Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                layerDrawable.draw(canvas);
                return bitmap;
            }
        } else {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (imgRes!=null) {
//            imgRes.draw(canvas);
//        }

        canvas.drawBitmap(mBitmap, 0,0,null);
    }
}
