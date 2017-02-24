package com.lalitsonawane.lalit.solitaire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final String LOGCAT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.textView1).setOnTouchListener((View.OnTouchListener) this);
        findViewById(R.id.pinkLayout).setOnDragListener((View.OnDragListener) this);
        findViewById(R.id.yellowLayout).setOnDragListener((View.OnDragListener) this);

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {

        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {

            return false;
        }

    }


    public boolean onDrag(View layoutview, DragEvent dragEvent) {
        int action = dragEvent.getAction();

        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(LOGCAT, "Drag event started");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(LOGCAT, "Drag event entered in to " + layoutview.toString());

            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(LOGCAT, "Drag event exited from " + layoutview.toString());

            case DragEvent.ACTION_DROP:
                Log.d(LOGCAT, "Dropped");

                View view = (View) dragEvent.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) layoutview;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(LOGCAT, "Drag event");
                break;
            default:
                break;
        }
        return true;

    }


}





