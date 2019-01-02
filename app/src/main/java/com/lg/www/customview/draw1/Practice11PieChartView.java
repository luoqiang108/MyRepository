package com.lg.www.customview.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lg.www.customview.PxDpUtil;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

    private List<Data> datas;
    private Paint paint;
    private RectF rectF;
    private float total;
    private float max; //占比最大的比例
    private boolean isMove = false; //当是占比最大的区域时，扇形需要往外移动

    float startAngle = 0f; // 开始的角度
    float sweepAngle;      // 扫过的角度
    float lineAngle;       // 当前扇形一半的角度

    float lineStartX = 0f; // 直线开始的X坐标
    float lineStartY = 0f; // 直线开始的Y坐标
    float lineEndX;        // 直线结束的X坐标
    float lineEndY;        // 直线结束的Y坐标

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        datas = new ArrayList<>();
        Data data = new Data("Gingerbread", 10.0f, Color.WHITE);
        datas.add(data);
        data = new Data("Ice Cream Sandwich", 18.0f, Color.MAGENTA);
        datas.add(data);
        data = new Data("Jelly Bean", 22.0f, Color.GRAY);
        datas.add(data);
        data = new Data("KitKat", 27.0f, Color.GREEN);
        datas.add(data);
        data = new Data("Lollipop", 40.0f, Color.BLUE);
        datas.add(data);
        data = new Data("Marshmallow", 60.0f, Color.RED);
        datas.add(data);
        data = new Data("Nougat", 33.5f, Color.YELLOW);
        datas.add(data);
        total = 0.0f;
        max = Float.MIN_VALUE;
        for (Data d : datas) {
            total += d.getNumber();
            max = Math.max(max, d.getNumber());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(20);
        rectF = new RectF(-200, -200, 200, 200);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);  // 将画布(0，0)坐标点移到画布的中心
        for (Data data : datas) {
            if (isMove) {
                canvas.translate(-lineStartX * 0.1f, -lineStartY * 0.1f);
                isMove = false;
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(data.getColor());
            sweepAngle = data.getNumber() / total * 360f;
            lineAngle = startAngle + sweepAngle / 2;
            lineStartX = 200 * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineStartY = 200 * (float) Math.sin(lineAngle / 180 * Math.PI);
            lineEndX = 220 * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineEndY = 220 * (float) Math.sin(lineAngle / 180 * Math.PI);
            if (data.getNumber() == max) {
                //这里对画布的translate操作还不是很理解？？？
                canvas.translate(lineStartX * 0.1f, lineStartY * 0.1f);
                canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
                isMove = true;
            } else {
                canvas.drawArc(rectF, startAngle, sweepAngle - 1.0f, true, paint);
            }
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            if (lineAngle > 90 && lineAngle <= 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint);
                canvas.drawText(data.getName(), lineEndX - 50 - 10 - paint.measureText(data.getName()), lineEndY, paint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint);
                canvas.drawText(data.getName(), lineEndX + 50 + 10, lineEndY, paint);
            }
            startAngle += sweepAngle;
        }
    }

    class Data {
        private String name;
        private float number;
        private int color;

        public Data(String name, float number, int color) {
            this.name = name;
            this.number = number;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public float getNumber() {
            return number;
        }

        public int getColor() {
            return color;
        }
    }

}
