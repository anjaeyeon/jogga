package com.example.jogga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = findViewById(R.id.surfaceView);

        // 캔버스 그리기
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                drawOnCanvas(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                // 캔버스 크기가 변경되었을 때 필요한 작업 수행
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // 액티비티가 종료될 때 필요한 작업 수행
            }
        });
    }

    private void drawOnCanvas(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        if (canvas != null) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);

            // 그림 그리기
            canvas.drawCircle(100, 100, 50, paint);

            holder.unlockCanvasAndPost(canvas);
        }
    }
}