//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.music_viktorina;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnLoadCompleteListener {
    ImageButton forsa;
    ImageButton termi;
    ImageButton rocky_b;
    int flag_cinema = 0;
    final String LOG_TAG = "myLogs";
    final int MAX_STREAMS = 1;
    final Random random = new Random();
    Button start;
    TextView show_result;
    TextView number;
    SoundPool sp;
    int soundIdFors;
    int soundIdTerm;
    int soundIdRocky;
    Toast Toast_message;
    MediaPlayer mediaPlayer;
    AudioManager am;

    public MainActivity() {
    }
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        start = findViewById(R.id.play);
        show_result = findViewById(R.id.show_result);
        forsa = findViewById(R.id.fors_button);
        termi = findViewById(R.id.term_button);
        rocky_b = findViewById(R.id.rocky_button);
        start.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                flag_cinema = random.nextInt(3);

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }

                switch(flag_cinema) {
                    case 0:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.forsag);
                        mediaPlayer.start();
                        break;
                    case 1:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.rocky);
                        mediaPlayer.start();
                        break;
                    case 2:
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.term);
                       mediaPlayer.start();
                }

            }
        });
        forsa.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    if (flag_cinema == 0) {
                        Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Угадал, это и правда фильм - Форсаж", 1);
                        Toast_message.show();
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }

                        mediaPlayer = null;
                    } else {
                       Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Увы", 1);
                       Toast_message.show();
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }

                       mediaPlayer = null;
                    }
                } else {
                    Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Включи музыку! Нажми кнопку старт!", 1);
                    Toast_message.show();
                }

            }
        });
        rocky_b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    if (flag_cinema == 1) {
                       Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Угадал, это и правда фильм - Рокки", 1);
                       Toast_message.show();
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }
                        mediaPlayer = null;
                    } else {
                        Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Увы", 1);
                        Toast_message.show();
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }
                        mediaPlayer = null;
                    }
                } else {
                    Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Включи музыку! Нажми кнопку старт!", 1);
                    Toast_message.show();
                }

            }
        });
        termi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    if (flag_cinema == 2) {
                        Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Угадал, это и правда фильм - Терминатор", 1);
                        Toast_message.show();
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }
                       mediaPlayer = null;
                    } else {
                       Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Увы", 1);
                       Toast_message.show();
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }
                       mediaPlayer = null;
                    }
                } else {
                    Toast_message = Toast.makeText(MainActivity.this.getApplicationContext(), "Включи музыку! Нажми кнопку старт!", 1);
                    Toast_message.show();
                }

            }
        });
    }

    public void onLoadComplete(SoundPool soundPool, int i, int i1) {
    }
}
