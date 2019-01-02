package com.lg.www.customview.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Path mPath = new Path();
        mPath.addArc(new RectF(200, 200, 400, 400), -225, 225); // 半径 100 的扇形 225度，从-225开始
        mPath.arcTo(new RectF(400, 200, 600, 400), -180, 225, false); // false 不留下移笔痕迹
        mPath.lineTo(400, 542); // 从原点画直线到坐标400,542
        //这里有个问题没想明白，留着以后理解：这段代码在我的理解里绘制出来的心形应该是少了左下直线部分的，但是为什么实际是一个完整的心形呢？
        canvas.drawPath(mPath, mPaint);
    }
}
