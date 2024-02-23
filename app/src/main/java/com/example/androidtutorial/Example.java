package com.example.androidtutorial;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.xeoh.android.texthighlighter.TextHighlighter;

import java.util.Locale;

public class Example extends Activity {

EditText ed1;
Button b1;
    TextToSpeech t1;
    TextToSpeech t2;
    TextView text1,text2;
    Dialog dialog;
    ImageView image_readermode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);
        ed1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        text1=(TextView)findViewById(R.id.text1);
        text2=(TextView)findViewById(R.id.text2);
        image_readermode=(ImageView)findViewById(R.id.image_readermode);

        image_readermode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Createdialog();
            }
        });


       /* t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                     new TextHighlighter()
                            .setBackgroundColor(Color.parseColor("#FFF000"))
                            .setForegroundColor(Color.BLUE)
                            .addTarget(text1)
                            .highlight(text1.getText().toString(), TextHighlighter.BASE_MATCHER);
                    String toSpeak = text1.getText().toString();
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                }
            }
        });


        t2=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t2.setLanguage(Locale.UK);
                     new TextHighlighter()
                            .setBackgroundColor(Color.parseColor("#FFF000"))
                            .setForegroundColor(Color.BLUE)
                            .addTarget(text2)
                            .highlight(text2.getText().toString(), TextHighlighter.BASE_MATCHER);
                    String toSpeak1 = text2.getText().toString();
                    Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_SHORT).show();
                    t2.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });


*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TextHighlighter()
                        .setBackgroundColor(Color.parseColor("#FFF000"))
                        .setForegroundColor(Color.BLUE)
                        .addTarget(text1)
                        .highlight(text1.getText().toString(), TextHighlighter.BASE_MATCHER);

                new TextHighlighter()
                        .setBackgroundColor(Color.parseColor("#FFF000"))
                        .setForegroundColor(Color.BLUE)
                        .addTarget(text2)
                        .highlight(text2.getText().toString(), TextHighlighter.BASE_MATCHER);
                String toSpeak = text1.getText().toString();
                String toSpeak1 = text2.getText().toString();

                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    private void Createdialog() {

        dialog= new Dialog(this);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        dialog.setContentView(R.layout.dialog_reader);
        ImageView back,play,stop,next,close;

        back=(ImageView) dialog.findViewById(R.id.image_back);
        play=(ImageView) dialog.findViewById(R.id.image_play);
        stop=(ImageView) dialog.findViewById(R.id.image_stop);
        next=(ImageView) dialog.findViewById(R.id.image_next);
        close=(ImageView)dialog.findViewById(R.id.image_close);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);
                play.setVisibility(View.GONE);
                t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.UK);
                            new TextHighlighter()
                                    .setBackgroundColor(Color.parseColor("#FFF000"))
                                    .setForegroundColor(Color.BLUE)
                                    .addTarget(text1)
                                    .highlight(text1.getText().toString(), TextHighlighter.BASE_MATCHER);
                            String toSpeak = text1.getText().toString();
                            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                    }
                });

            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    stop.setVisibility(View.GONE);
                    play.setVisibility(View.VISIBLE);

                    t1.stop();
                }
            });

            }
        });


        dialog.show();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                t1.stop();
                t1.shutdown();
                new TextHighlighter()
                        .setBackgroundColor(Color.parseColor("#FFFFFF"))
                        .setForegroundColor(Color.BLACK)
                        .addTarget(text1)
                        .highlight(text1.getText().toString(), TextHighlighter.BASE_MATCHER);
            }
        });

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
