package com.eightywon.aqti;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.y;

public class StageTwoFragment extends Fragment {
    ImageView theTarget;
    ImageView theTargetHighlight;
    ImageView[] shots=new ImageView[11];
    public int shotCount;
    ConstraintLayout l;
    ConstraintSet set;
    float lastX, lastY;
    long tapStart=0;
    boolean lock;
    final static int THREE=-23296;
    final static int FOUR=-256;
    final static int FIVE=-16744448;
    final static int SHOT_SIZE=50;
    final static int X_ADJUSTMENT=18;
    final static int Y_ADJUSTMENT=-5;

    TextView status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.frag_stage_2, container,
                false);

        theTarget=(ImageView) rootView.findViewById(R.id.imageView);
        theTargetHighlight=(ImageView) rootView.findViewById(R.id.stage1highlight);

        status=(TextView) rootView.findViewById(R.id.textView);

        shotCount=0;
        l=(ConstraintLayout) rootView.findViewById(R.id.stage2);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked()==MotionEvent.ACTION_UP && !lock) {
                    shotCount++;

                    if (shotCount<=10) {
                        shots[shotCount] = new ImageView(getContext());
                        /*
                        if (shotCount<10){
                            shots[shotCount].setImageResource(R.drawable.c_shot);
                        } else {
                        */
                            shots[shotCount].setImageResource(R.drawable.shot);
                        /*
                        }

                        if (shotCount>1) {
                            shots[shotCount-1].setImageResource(R.drawable.shot);
                        }
                        */
                        l.addView(shots[shotCount],SHOT_SIZE,SHOT_SIZE);
                        shots[shotCount].setX(event.getX()-((SHOT_SIZE/2)));
                        shots[shotCount].setY(event.getY()-((SHOT_SIZE/2)));
                        rootView.playSoundEffect(android.view.SoundEffectConstants.CLICK);


                        /*
                        Log.d("AQT","base: "+event.getX()+", "+event.getY());
                        Log.d("AQT","tL: "+(event.getX()-SHOT_SIZE/2)+","+(event.getY()+SHOT_SIZE/2));
                        Log.d("AQT","tR: "+(event.getX()+SHOT_SIZE/2)+","+(event.getY()+SHOT_SIZE/2));
                        Log.d("AQT","bR: "+(event.getX()+SHOT_SIZE/2)+","+(event.getY()-SHOT_SIZE/2));
                        Log.d("AQT","bL: "+(event.getX()-SHOT_SIZE/2)+","+(event.getY()-SHOT_SIZE/2));
                        */

                        /*
                        int top=getColor(event.getX(),event.getY()-(SHOT_SIZE/2)+17,v);
                        int bottom=getColor(event.getX(),event.getY()+(SHOT_SIZE/2)+13,v);
                        int left=getColor(event.getX()-(SHOT_SIZE/2)+16,event.getY(),v);
                        int right=getColor(event.getX()+(SHOT_SIZE/2)+12,event.getY(),v);
                        */

                        int i;
                        int zoneHit=0;
                        float eventX=event.getX();
                        float eventY=event.getY();
                        int r=SHOT_SIZE/2;

                        theTargetHighlight.setDrawingCacheEnabled(true);
                        Bitmap hotspots=Bitmap.createBitmap(theTargetHighlight.getDrawingCache());
                        theTargetHighlight.setDrawingCacheEnabled(false);

                        for (i=1; i<=12; i++) {

                            double x = ((eventX + r * Math.cos(2 * Math.PI * i / 12)));
                            double y = ((eventY + r * Math.sin(2 * Math.PI * i / 12)));
                            int spot=getColor(x,y,v,hotspots);

                            if (spot==FIVE) {
                                zoneHit=5;
                                i=13;
                            } else if (spot==FOUR) {
                                zoneHit=4;
                            } else if (spot==THREE && zoneHit!=4) {
                                zoneHit=3;
                            }
                        }

                        switch (zoneHit) {
                            case 5:
                                status.setText("HIT - 5");
                                break;
                            case 4:
                                status.setText("HIT - 4");
                                break;
                            case 3:
                                status.setText("HIT - 3");
                                break;
                            case 0:
                                status.setText("MISS");
                                break;
                        }


                        int bottomRight=0; //=getColor(event.getX()+(SHOT_SIZE/2)+13,event.getY()+(SHOT_SIZE/2)+15,v);

                        /*
                        int tL=getColor((event.getX()-(SHOT_SIZE/2)+X_ADJUSTMENT),(event.getY()+((SHOT_SIZE/2)-Y_ADJUSTMENT)),v);
                        int tR=getColor(event.getX()+((SHOT_SIZE/2)+X_ADJUSTMENT),event.getY()+((SHOT_SIZE/2)-Y_ADJUSTMENT),v);
                        int bR=getColor(event.getX()+((SHOT_SIZE/2)+X_ADJUSTMENT),event.getY()-((SHOT_SIZE/2)-Y_ADJUSTMENT),v);
                        int bL=getColor(event.getX()-((SHOT_SIZE/2)),event.getY()-((SHOT_SIZE/2)),v);
                        */

                        /*
                        if (top==FIVE || bottom==FIVE || left==FIVE || right==FIVE || bottomRight==FIVE) {
                            status.setText("HIT - 5");
                        } else if (top==FOUR || bottom==FOUR|| left==FOUR|| right==FOUR || bottomRight==FIVE) {
                            status.setText("HIT - 4");
                        } else if (top==THREE || bottom==THREE|| left==THREE|| right==THREE || bottomRight==FIVE) {
                            status.setText("HIT - 3");
                        } else {
                            status.setText("MISS");
                        }
                        */
                    }
                }

                if (event.getActionMasked()==MotionEvent.ACTION_DOWN) {
                    lock=false;
                    tapStart=System.currentTimeMillis();
                    return true;
                }

                if (tapStart>0 && (System.currentTimeMillis()-tapStart>=750)) {
                    int i;
                    for (i=1;i<=10;i++) {
                        if (shots[i]!=null) {
                            l.removeView(shots[i]);
                            shots[i]=null;
                            status.setText("");
                        }
                    }
                    shotCount=0;
                    lock=true;
                    tapStart=0;
                    //rootView.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                    v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                }
                return false;
            }
        });
        return rootView;
    }

    private int getColor(double x, double y, View v, Bitmap h)
    {
        return h.getPixel((int) x, (int) y);
    }
}