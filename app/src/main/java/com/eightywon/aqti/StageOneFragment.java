package com.eightywon.aqti;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class StageOneFragment extends Fragment {
    int[] ofTen=new int[5];

    int stage1Score;
    TextView txtStage1Score;
    TextView txtStage1of10;
    NumberPicker s1np5s;
    NumberPicker s1np4s;
    NumberPicker s1np3s;
    NumberPicker s1np0s;

    int stage2Score;
    TextView txtStage2Score;
    TextView txtStage2of10;
    NumberPicker s2np5s;
    NumberPicker s2np4s;
    NumberPicker s2np3s;
    NumberPicker s2np0s;

    int stage3Score;
    TextView txtStage3Score;
    TextView txtStage3of10;
    NumberPicker s3np5s;
    NumberPicker s3np4s;
    NumberPicker s3np3s;
    NumberPicker s3np0s;

    int stage4Score;
    TextView txtStage4Score;
    TextView txtStage4of10;
    NumberPicker s4np5s;
    NumberPicker s4np4s;
    NumberPicker s4np3s;
    NumberPicker s4np0s;

    TextView txtTotalScore;
    TextView txtQualification;
    Button btnReset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.frag_stage_1, container,
                false);

        initStage1(rootView);
        initStage2(rootView);
        initStage3(rootView);
        initStage4(rootView);
        txtQualification=(TextView) rootView.findViewById(R.id.txtQualification);
        txtTotalScore=(TextView) rootView.findViewById(R.id.txtTotalScore);
        txtTotalScore.setText("0/250");
        txtTotalScore.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        btnReset=(Button) rootView.findViewById(R.id.btnReset);

        txtStage1Score.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearStage(1);
                return false;
            }
        });

        txtStage2Score.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearStage(2);
                return false;
            }
        });

        txtStage3Score.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearStage(3);
                return false;
            }
        });

        txtStage4Score.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearStage(4);
                return false;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int i;
                for (i=1;i<=4;i++) {
                    clearStage(i);
                }
            }
        });

        return rootView;
    }

    public void clearStage(int stage) {
        switch (stage) {
            case 1:
                s1np5s.setValue(0);
                s1np4s.setValue(0);
                s1np3s.setValue(0);
                s1np0s.setValue(0);
                stage1Score=getStage1Score(s1np5s.getValue(), s1np4s.getValue(), s1np3s.getValue(), s1np0s.getValue());
                txtStage1Score.setText(String.valueOf(stage1Score)+"/50");
                toggleLock(setOfTen(1),1);
                break;
            case 2:
                s2np5s.setValue(0);
                s2np4s.setValue(0);
                s2np3s.setValue(0);
                s2np0s.setValue(0);
                stage2Score=getStage2Score(s2np5s.getValue(), s2np4s.getValue(), s2np3s.getValue(), s2np0s.getValue());
                txtStage2Score.setText(String.valueOf(stage2Score)+"/50");
                toggleLock(setOfTen(2),2);
                break;
            case 3:
                s3np5s.setValue(0);
                s3np4s.setValue(0);
                s3np3s.setValue(0);
                s3np0s.setValue(0);
                stage3Score=getStage3Score(s3np5s.getValue(), s3np4s.getValue(), s3np3s.getValue(), s3np0s.getValue());
                txtStage3Score.setText(String.valueOf(stage3Score)+"/50");
                toggleLock(setOfTen(3),3);
                break;
            case 4:
                s4np5s.setValue(0);
                s4np4s.setValue(0);
                s4np3s.setValue(0);
                s4np0s.setValue(0);
                stage4Score=getStage4Score(s4np5s.getValue(), s4np4s.getValue(), s4np3s.getValue(), s4np0s.getValue());
                txtStage4Score.setText(String.valueOf(stage4Score)+"/100");
                toggleLock(setOfTen(4),4);
                break;
        }
    }

    public boolean setOfTen(int stage) {
        int fives;
        int fours;
        int threes;
        int zeros;
        boolean lock=false;

        switch (stage) {
            case 1:
                fives=s1np5s.getValue();
                fours=s1np4s.getValue();
                threes=s1np3s.getValue();
                zeros=s1np0s.getValue();
                ofTen[stage]=fives+fours+threes+zeros;
                txtStage1of10.setText(ofTen[stage]+"/10");
                if (ofTen[stage]==10) {
                    txtStage1of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                    lock=true;
                } else {
                    txtStage1of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                    lock=false;
                }
                break;
            case 2:
                fives=s2np5s.getValue();
                fours=s2np4s.getValue();
                threes=s2np3s.getValue();
                zeros=s2np0s.getValue();
                ofTen[stage]=fives+fours+threes+zeros;
                txtStage2of10.setText(ofTen[stage]+"/10");
                if (ofTen[stage]==10) {
                    txtStage2of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                    lock=true;
                } else {
                    txtStage2of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                    lock=false;
                }
                break;
            case 3:
                fives=s3np5s.getValue();
                fours=s3np4s.getValue();
                threes=s3np3s.getValue();
                zeros=s3np0s.getValue();
                ofTen[stage]=fives+fours+threes+zeros;
                txtStage3of10.setText(ofTen[stage]+"/10");
                if (ofTen[stage]==10) {
                    txtStage3of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                    lock=true;
                } else {
                    txtStage3of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                    lock=false;
                }
                break;
            case 4:
                fives=s4np5s.getValue();
                fours=s4np4s.getValue();
                threes=s4np3s.getValue();
                zeros=s4np0s.getValue();
                ofTen[stage]=fives+fours+threes+zeros;
                txtStage4of10.setText(ofTen[stage]+"/10");
                if (ofTen[stage]==10) {
                    txtStage4of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                    lock=true;
                } else {
                    txtStage4of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                    lock=false;
                }
                break;
        }
        return lock;
    }

    public void toggleLock (boolean lock, int stage) {

        switch (stage){
            case 1:
                if (lock) {
                    s1np5s.setMaxValue(s1np5s.getValue());
                    s1np4s.setMaxValue(s1np4s.getValue());
                    s1np3s.setMaxValue(s1np3s.getValue());
                    s1np0s.setMaxValue(s1np0s.getValue());
                    txtStage1Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                } else {
                    s1np5s.setMaxValue(10);
                    s1np4s.setMaxValue(10);
                    s1np3s.setMaxValue(10);
                    s1np0s.setMaxValue(10);
                    txtStage1Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                }
                break;
            case 2:
                if (lock) {
                    s2np5s.setMaxValue(s2np5s.getValue());
                    s2np4s.setMaxValue(s2np4s.getValue());
                    s2np3s.setMaxValue(s2np3s.getValue());
                    s2np0s.setMaxValue(s2np0s.getValue());
                    txtStage2Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                } else {
                    s2np5s.setMaxValue(10);
                    s2np4s.setMaxValue(10);
                    s2np3s.setMaxValue(10);
                    s2np0s.setMaxValue(10);
                    txtStage2Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                }
                break;
            case 3:
                if (lock) {
                    s3np5s.setMaxValue(s3np5s.getValue());
                    s3np4s.setMaxValue(s3np4s.getValue());
                    s3np3s.setMaxValue(s3np3s.getValue());
                    s3np0s.setMaxValue(s3np0s.getValue());
                    txtStage3Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                } else {
                    s3np5s.setMaxValue(10);
                    s3np4s.setMaxValue(10);
                    s3np3s.setMaxValue(10);
                    s3np0s.setMaxValue(10);
                    txtStage3Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                }
                break;
            case 4:
                if (lock) {
                    s4np5s.setMaxValue(s4np5s.getValue());
                    s4np4s.setMaxValue(s4np4s.getValue());
                    s4np3s.setMaxValue(s4np3s.getValue());
                    s4np0s.setMaxValue(s4np0s.getValue());
                    txtStage4Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
                } else {
                    s4np5s.setMaxValue(10);
                    s4np4s.setMaxValue(10);
                    s4np3s.setMaxValue(10);
                    s4np0s.setMaxValue(10);
                    txtStage4Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
                }
                break;
        }

        if (ofTen[1]==10 && ofTen[2]==10 && ofTen[3]==10 && ofTen[4]==10) {
            txtTotalScore.setTextColor(ContextCompat.getColor(getContext(),R.color.colorGreen));
            int totalScore=stage1Score+stage2Score+stage3Score+stage4Score;
            if (totalScore<125) {
                txtQualification.setText("Unqualified");
            } else if (totalScore<=169) {
                txtQualification.setText("Marksman");
            } else if (totalScore<=209) {
                txtQualification.setText("Sharpshooter");
            } else {
                txtQualification.setText("Expert (Rifleman)");
            }
        } else {
            txtTotalScore.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
            txtQualification.setText("");
        }
    }

    public int getStage1Score(int fives, int fours, int threes, int zeros) {
        stage1Score=0;
        stage1Score+=fives*5;
        stage1Score+=fours*4;
        stage1Score+=threes*3;
        stage1Score+=zeros*0;
        updateTotalScore();
        return stage1Score;
    }

    public int getStage2Score(int fives, int fours, int threes, int zeros) {
        stage2Score=0;
        stage2Score+=fives*5;
        stage2Score+=fours*4;
        stage2Score+=threes*3;
        stage2Score+=zeros*0;
        updateTotalScore();
        return stage2Score;
    }

    public int getStage3Score(int fives, int fours, int threes, int zeros) {
        stage3Score=0;
        stage3Score+=fives*5;
        stage3Score+=fours*4;
        stage3Score+=threes*3;
        stage3Score+=zeros*0;
        updateTotalScore();
        return stage3Score;
    }

    public int getStage4Score(int fives, int fours, int threes, int zeros) {
        stage4Score=0;
        stage4Score+=fives*5;
        stage4Score+=fours*4;
        stage4Score+=threes*3;
        stage4Score+=zeros*0;
        stage4Score*=2;
        updateTotalScore();
        return (stage4Score);
    }

    public void updateTotalScore() {
        txtTotalScore.setText(String.valueOf(stage1Score+stage2Score+stage3Score+stage4Score)+"/250");
    }

    public void initStage1(View rootView) {
        txtStage1Score = (TextView) rootView.findViewById(R.id.txtStage1Score);
        txtStage1Score.setText("0/50");
        txtStage1Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        txtStage1of10 = (TextView) rootView.findViewById(R.id.txtStage1of10);
        txtStage1of10.setText("0/10");
        txtStage1of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        s1np5s = (NumberPicker) rootView.findViewById(R.id.s1np5s);
        s1np4s = (NumberPicker) rootView.findViewById(R.id.s1np4s);
        s1np3s = (NumberPicker) rootView.findViewById(R.id.s1np3s);
        s1np0s  = (NumberPicker) rootView.findViewById(R.id.s1np0s);

        s1np5s.setMinValue(0);
        s1np5s.setMaxValue(10);
        s1np5s.setWrapSelectorWheel(false);
        s1np5s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                stage1Score=getStage1Score(s1np5s.getValue(), s1np4s.getValue(), s1np3s.getValue(), s1np0s.getValue());
                txtStage1Score.setText(String.valueOf(stage1Score+"/50"));
                toggleLock(setOfTen(1),1);
            }
        });

        s1np4s.setMinValue(0);
        s1np4s.setMaxValue(10);
        s1np4s.setWrapSelectorWheel(false);
        s1np4s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage1Score(s1np5s.getValue(), s1np4s.getValue(), s1np3s.getValue(), s1np0s.getValue());
                txtStage1Score.setText(String.valueOf(stage1Score+"/50"));
                toggleLock(setOfTen(1),1);
            }
        });

        s1np3s.setMinValue(0);
        s1np3s.setMaxValue(10);
        s1np3s.setWrapSelectorWheel(false);
        s1np3s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage1Score(s1np5s.getValue(), s1np4s.getValue(), s1np3s.getValue(), s1np0s.getValue());
                txtStage1Score.setText(String.valueOf(stage1Score+"/50"));
                toggleLock(setOfTen(1),1);
            }
        });

        s1np0s.setMinValue(0);
        s1np0s.setMaxValue(10);
        s1np0s.setWrapSelectorWheel(false);
        s1np0s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage1Score(s1np5s.getValue(), s1np4s.getValue(), s1np3s.getValue(), s1np0s.getValue());
                txtStage1Score.setText(String.valueOf(stage1Score+"/50"));
                toggleLock(setOfTen(1),1);
            }
        });
    }

    public void initStage2(View rootView) {
        txtStage2Score = (TextView) rootView.findViewById(R.id.txtStage2Score);
        txtStage2Score.setText("0/50");
        txtStage2Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        txtStage2of10 = (TextView) rootView.findViewById(R.id.txtStage2of10);
        txtStage2of10.setText("0/10");
        txtStage2of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        s2np5s = (NumberPicker) rootView.findViewById(R.id.s2np5s);
        s2np4s = (NumberPicker) rootView.findViewById(R.id.s2np4s);
        s2np3s = (NumberPicker) rootView.findViewById(R.id.s2np3s);
        s2np0s  = (NumberPicker) rootView.findViewById(R.id.s2np0s);

        s2np5s.setMinValue(0);
        s2np5s.setMaxValue(10);
        s2np5s.setWrapSelectorWheel(false);
        s2np5s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                stage2Score=getStage2Score(s2np5s.getValue(), s2np4s.getValue(), s2np3s.getValue(), s2np0s.getValue());
                txtStage2Score.setText(String.valueOf(stage2Score+"/50"));
                toggleLock(setOfTen(2),2);
            }
        });

        s2np4s.setMinValue(0);
        s2np4s.setMaxValue(10);
        s2np4s.setWrapSelectorWheel(false);
        s2np4s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage2Score(s2np5s.getValue(), s2np4s.getValue(), s2np3s.getValue(), s2np0s.getValue());
                txtStage2Score.setText(String.valueOf(stage2Score+"/50"));
                toggleLock(setOfTen(2),2);
            }
        });

        s2np3s.setMinValue(0);
        s2np3s.setMaxValue(10);
        s2np3s.setWrapSelectorWheel(false);
        s2np3s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage2Score(s2np5s.getValue(), s2np4s.getValue(), s2np3s.getValue(), s2np0s.getValue());
                txtStage2Score.setText(String.valueOf(stage2Score+"/50"));
                toggleLock(setOfTen(2),2);
            }
        });

        s2np0s.setMinValue(0);
        s2np0s.setMaxValue(10);
        s2np0s.setWrapSelectorWheel(false);
        s2np0s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage2Score(s2np5s.getValue(), s2np4s.getValue(), s2np3s.getValue(), s2np0s.getValue());
                txtStage2Score.setText(String.valueOf(stage2Score+"/50"));
                toggleLock(setOfTen(2),2);
            }
        });
    }

    public void initStage3(View rootView) {
        txtStage3Score = (TextView) rootView.findViewById(R.id.txtStage3Score);
        txtStage3Score.setText("0/50");
        txtStage3Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        txtStage3of10 = (TextView) rootView.findViewById(R.id.txtStage3of10);
        txtStage3of10.setText("0/10");
        txtStage3of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        s3np5s = (NumberPicker) rootView.findViewById(R.id.s3np5s);
        s3np4s = (NumberPicker) rootView.findViewById(R.id.s3np4s);
        s3np3s = (NumberPicker) rootView.findViewById(R.id.s3np3s);
        s3np0s  = (NumberPicker) rootView.findViewById(R.id.s3np0s);

        s3np5s.setMinValue(0);
        s3np5s.setMaxValue(10);
        s3np5s.setWrapSelectorWheel(false);
        s3np5s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                stage3Score=getStage3Score(s3np5s.getValue(), s3np4s.getValue(), s3np3s.getValue(), s3np0s.getValue());
                txtStage3Score.setText(String.valueOf(stage3Score+"/50"));
                toggleLock(setOfTen(3),3);
            }
        });

        s3np4s.setMinValue(0);
        s3np4s.setMaxValue(10);
        s3np4s.setWrapSelectorWheel(false);
        s3np4s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage3Score(s3np5s.getValue(), s3np4s.getValue(), s3np3s.getValue(), s3np0s.getValue());
                txtStage3Score.setText(String.valueOf(stage3Score+"/50"));
                toggleLock(setOfTen(3),3);
            }
        });

        s3np3s.setMinValue(0);
        s3np3s.setMaxValue(10);
        s3np3s.setWrapSelectorWheel(false);
        s3np3s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage3Score(s3np5s.getValue(), s3np4s.getValue(), s3np3s.getValue(), s3np0s.getValue());
                txtStage3Score.setText(String.valueOf(stage3Score+"/50"));
                toggleLock(setOfTen(3),3);
            }
        });

        s3np0s.setMinValue(0);
        s3np0s.setMaxValue(10);
        s3np0s.setWrapSelectorWheel(false);
        s3np0s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage3Score(s3np5s.getValue(), s3np4s.getValue(), s3np3s.getValue(), s3np0s.getValue());
                txtStage3Score.setText(String.valueOf(stage3Score+"/50"));
                toggleLock(setOfTen(3),3);
            }
        });
    }

    public void initStage4(View rootView) {
        txtStage4Score = (TextView) rootView.findViewById(R.id.txtStage4Score);
        txtStage4Score.setText("0/100");
        txtStage4Score.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        txtStage4of10 = (TextView) rootView.findViewById(R.id.txtStage4of10);
        txtStage4of10.setText("0/10");
        txtStage4of10.setTextColor(ContextCompat.getColor(getContext(),R.color.colorRed));
        s4np5s = (NumberPicker) rootView.findViewById(R.id.s4np5s);
        s4np4s = (NumberPicker) rootView.findViewById(R.id.s4np4s);
        s4np3s = (NumberPicker) rootView.findViewById(R.id.s4np3s);
        s4np0s  = (NumberPicker) rootView.findViewById(R.id.s4np0s);

        s4np5s.setMinValue(0);
        s4np5s.setMaxValue(10);
        s4np5s.setWrapSelectorWheel(false);
        s4np5s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                stage4Score=getStage4Score(s4np5s.getValue(), s4np4s.getValue(), s4np3s.getValue(), s4np0s.getValue());
                txtStage4Score.setText(String.valueOf(stage4Score+"/100"));
                toggleLock(setOfTen(4),4);
            }
        });

        s4np4s.setMinValue(0);
        s4np4s.setMaxValue(10);
        s4np4s.setWrapSelectorWheel(false);
        s4np4s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage4Score(s4np5s.getValue(), s4np4s.getValue(), s4np3s.getValue(), s4np0s.getValue());
                txtStage4Score.setText(String.valueOf(stage4Score+"/100"));
                toggleLock(setOfTen(4),4);
            }
        });

        s4np3s.setMinValue(0);
        s4np3s.setMaxValue(10);
        s4np3s.setWrapSelectorWheel(false);
        s4np3s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage4Score(s4np5s.getValue(), s4np4s.getValue(), s4np3s.getValue(), s4np0s.getValue());
                txtStage4Score.setText(String.valueOf(stage4Score+"/100"));
                toggleLock(setOfTen(4),4);
            }
        });

        s4np0s.setMinValue(0);
        s4np0s.setMaxValue(10);
        s4np0s.setWrapSelectorWheel(false);
        s4np0s.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                getStage4Score(s4np5s.getValue(), s4np4s.getValue(), s4np3s.getValue(), s4np0s.getValue());
                txtStage4Score.setText(String.valueOf(stage4Score+"/100"));
                toggleLock(setOfTen(4),4);
            }
        });
    }
}