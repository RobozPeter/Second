package com.example.second;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextView textViewColor;

    private Slider sliderRed;
    private Slider sliderGreen;
    private Slider sliderBlue;

    private   int dataRed;
    private   int dataGreen;
    private   int dataBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.relativeLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        sliderRed.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                dataRed = Math.round((value));
                if(dataRed+dataGreen<200){
                    textViewColor.setTextColor(Color.WHITE);
                }
                else{
                    textViewColor.setTextColor(Color.BLACK);
                }
                relativeLayout.setBackgroundColor(Color.rgb(dataRed,dataGreen,dataBlue));
                textViewColor.setText("("+dataRed+","+dataGreen+","+dataBlue+")");

            }
        });

        sliderGreen.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                dataGreen = Math.round((value));
                if(dataRed+dataGreen<200){
                    textViewColor.setTextColor(Color.WHITE);
                }
                else{
                    textViewColor.setTextColor(Color.BLACK);
                }
                relativeLayout.setBackgroundColor(Color.rgb(dataRed,dataGreen,dataBlue));
                textViewColor.setText("("+dataRed+","+dataGreen+","+dataBlue+")");

            }
        });

        sliderBlue.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                dataBlue = Math.round((value));
                if(dataRed+dataGreen<200){
                    textViewColor.setTextColor(Color.WHITE);
                }
                else{
                    textViewColor.setTextColor(Color.BLACK);
                }
                relativeLayout.setBackgroundColor(Color.rgb(dataRed,dataGreen,dataBlue));
                textViewColor.setText("("+dataRed+","+dataGreen+","+dataBlue+")");

            }
        });

    }
    public void init(){
        relativeLayout = findViewById(R.id.relativeLayout);
        textViewColor = findViewById(R.id.textViewColor);
        sliderRed = findViewById(R.id.redSlider);
        sliderGreen = findViewById(R.id.greenSlider);
        sliderBlue = findViewById(R.id.blueSlider);
    }
}