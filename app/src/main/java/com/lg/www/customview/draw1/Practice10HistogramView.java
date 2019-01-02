package com.lg.www.customview.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lg.www.customview.PxDpUtil;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        float width = 70;
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(PxDpUtil.dip2px(getContext(), 1));
        canvas.drawLine(50, 50, 50, 400, mPaint);//纵坐标
        canvas.drawLine(50, 400, 600, 400, mPaint);//横坐标

        mPaint.setTextSize(18);
        canvas.drawText("Froyo", 85, 450, mPaint);
        canvas.drawText("GB", 85 + width * 1, 450, mPaint);
        canvas.drawText("ICS", 85 + width * 2, 450, mPaint);
        canvas.drawText("JB", 85 + width * 3, 450, mPaint);
        canvas.drawText("KitKat", 85 + width * 4, 450, mPaint);
        canvas.drawText("L", 85 + width * 5, 450, mPaint);
        canvas.drawText("M", 85 + width * 6, 450, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(PxDpUtil.dip2px(getContext(), 20));
        canvas.drawLine(110, 400, 110, 380, mPaint);
        canvas.drawLine(110 + width, 400, 110 + width, 350, mPaint);
        canvas.drawLine(110 + width * 2, 400, 110 + width * 2, 350, mPaint);
        canvas.drawLine(110 + width * 3, 400, 110 + width * 3, 250, mPaint);
        canvas.drawLine(110 + width * 4, 400, 110 + width * 4, 100, mPaint);
        canvas.drawLine(110 + width * 5, 400, 110 + width * 5, 150, mPaint);
        canvas.drawLine(110 + width * 6, 400, 110 + width * 6, 280, mPaint);

        mPaint.setTextSize(25);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("直方图", 85 + width * 2.5f, 500, mPaint);
    }
}
