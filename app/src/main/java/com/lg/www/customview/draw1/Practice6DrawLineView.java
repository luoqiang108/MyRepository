package com.lg.www.customview.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lg.www.customview.PxDpUtil;

public class Practice6DrawLineView extends View {

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        //mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(PxDpUtil.dip2px(getContext(), 5));
        canvas.drawLine(200, 200, 400, 400, mPaint);
    }
}
