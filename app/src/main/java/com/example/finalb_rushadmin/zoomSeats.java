package com.example.finalb_rushadmin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class zoomSeats extends View {
    private Drawable image;
    ImageButton img,img1;
    private int zoomController=20;

    public zoomSeats(Context context){
        super(context);

        image=context.getResources().getDrawable(R.drawable.topviewseats);
        //image=context.getResources().getDrawable(R.drawable.icon);

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //To control height and width
        image.setBounds((getWidth()/2)-zoomController, (getHeight()/2)-zoomController, (getWidth()/2)+zoomController, (getHeight()/2)+zoomController);
        image.draw(canvas);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_DPAD_UP){
            // zoom in
            zoomController+=10;
        }
        if(keyCode==KeyEvent.KEYCODE_DPAD_DOWN){
            // zoom out
            zoomController-=10;
        }
        if(zoomController<10){
            zoomController=10;
        }

        invalidate();
        return true;
    }
}
