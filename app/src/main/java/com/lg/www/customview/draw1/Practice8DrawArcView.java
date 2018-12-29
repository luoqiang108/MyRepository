package com.lg.www.customview.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        RectF mRectF = new RectF(200, 200, 450, 350);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(mRectF, -130, 110, true, mPaint);// 从-130开始，跨度110

        canvas.drawArc(mRectF, 20, 120, false, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mRectF, 180, 40, false, mPaint);
    }
}
