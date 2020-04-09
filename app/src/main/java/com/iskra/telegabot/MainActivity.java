package com.iskra.telegabot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ToneGenerator toneG;

    enum Notes {
        DO,
        RE,
        MI,
        FA,
        SOL,
        LA,
        SI
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        toneG = new ToneGenerator(AudioManager.STREAM_MUSIC, 80);
    }

    public void buttonClick(View view)
    {
        Notes note = Notes.DO;

        switch (view.getId()) {
            case (R.id.button1):
                note = Notes.DO;
                toneG.startTone(ToneGenerator.TONE_PROP_BEEP, 700);
                break;
            case (R.id.button2):
                note = Notes.RE;
                toneG.startTone(ToneGenerator.TONE_DTMF_1, 200);
                break;
            case (R.id.button3):
                note = Notes.MI;
                toneG.startTone(ToneGenerator.TONE_DTMF_2, 200);
                break;
            case (R.id.button4):
                note = Notes.FA;
                toneG.startTone(ToneGenerator.TONE_DTMF_3, 200);
                break;
            case (R.id.button5):
                note = Notes.SOL;
                toneG.startTone(ToneGenerator.TONE_DTMF_4, 200);
                break;
            case (R.id.button6):
                note = Notes.LA;
                toneG.startTone(ToneGenerator.TONE_DTMF_5, 200);
                break;
            case (R.id.button7):
                note = Notes.SI;
                toneG.startTone(ToneGenerator.TONE_DTMF_6, 200);
                break;
        }
    }
}
