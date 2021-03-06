package com.ckuandroid.kolory;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView kolor;
    TextView wartoscCzerwona;
    TextView wartoscZielona;
    TextView wartoscNiebieska;
    SeekBar czerwony;
    SeekBar zielony;
    SeekBar niebieski;
    int skladowaCzerwona;
    int skladowaZielona;
    int skladowaNiebieska;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kolor = (TextView) findViewById(R.id.kolor);
        wartoscCzerwona = (TextView) findViewById(R.id.wartscCzerwona);
        wartoscZielona = (TextView) findViewById(R.id.wartscZielona);
        wartoscNiebieska = (TextView) findViewById(R.id.wartscNiebieska);
        czerwony = (SeekBar) findViewById(R.id.czerwony);
        zielony = (SeekBar) findViewById(R.id.zielony);
        niebieski = (SeekBar) findViewById(R.id.niebieski);

        czerwony.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                skladowaCzerwona = seekBar.getProgress();
                wartoscCzerwona.setText("Składowa czerwona: " + skladowaCzerwona);
                ustawKolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        zielony.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                skladowaZielona = seekBar.getProgress();
                wartoscZielona.setText("Składowa zielona: " + skladowaZielona);
                ustawKolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        niebieski.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                skladowaNiebieska = seekBar.getProgress();
                wartoscNiebieska.setText("Składowa niebieska: " + skladowaNiebieska);
                ustawKolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void ustawKolor() {
        int kolorTekstu = Color.rgb(255 - skladowaCzerwona,
                                   255 - skladowaZielona,
                                    255 - skladowaNiebieska);
        int kolorTla = Color.rgb(skladowaCzerwona, skladowaZielona, skladowaNiebieska);
        kolor.setBackgroundColor(kolorTla);
        kolor.setTextColor(kolorTekstu);
        kolor.setText("Tu pojawi się kolor: #" +
                       decToHex(skladowaCzerwona) +
                       decToHex(skladowaZielona) +
                       decToHex(skladowaNiebieska));
    }

    public String decToHex(int dziesietna) {
        String hexStr = "";
        String resztaStr = "";
        int wynik = dziesietna;
        while (wynik > 0) {
            int reszta = wynik % 16;
            if (reszta >= 0 && reszta <= 9) {
                resztaStr = "" + reszta;
            } else if (reszta == 10) {
                resztaStr = "A";
            } else if (reszta == 11) {
                resztaStr = "B";
            } else if (reszta == 12) {
                resztaStr = "C";
            } else if (reszta == 13) {
                resztaStr = "D";
            } else if (reszta == 14) {
                resztaStr = "E";
            } else if (reszta == 15) {
                resztaStr = "F";
            }
            wynik = wynik / 16;
            hexStr = resztaStr + hexStr;
        }
        if (hexStr.length() == 0) hexStr = "00";
        if (hexStr.length() == 1) hexStr = "0" + hexStr;
        return hexStr;
    }
}