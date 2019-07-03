package com.exomatik.mpm.tes;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ImageButton ei,bi,si,di,i;
    private TextView waktu1, benar1;
    private  TimerClass timerClass;
    //   private Handler handler = new Handler();
    private int j = 0;
    final int[] imageArray =
            {R.drawable.a
                    , R.drawable.b
                    , R.drawable.c
                    , R.drawable.d
                    , R.drawable.e};

    final Random rand = new Random();
    private String jawaban , jawaban1;
    private ImageView gambar;
    private  int benarx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ei = (ImageButton) findViewById(R.id.alphabet_a);
        bi = (ImageButton) findViewById(R.id.alphabet_b);
        si = (ImageButton) findViewById(R.id.alphabet_c);
        di = (ImageButton) findViewById(R.id.alphabet_d);
        i = (ImageButton) findViewById(R.id.alphabet_e);
        waktu1 = (TextView) findViewById(R.id.waktu);
        gambar = (ImageView) findViewById(R.id.imageView);
        benar1 = (TextView) findViewById(R.id.benar);

        gambar();

        timerClass = new TimerClass(60000 * 1, 800);
        //Menjalankan Timer
        timerClass.start();
            }

    public void gambar() {
        if (j <=  4) {
            int a = imageArray[rand.nextInt(imageArray.length)];
            gambar.setImageResource(a);

            if (imageArray[0] == a) {
                jawaban = "ei";
            } else if (imageArray[1] == a) {
                jawaban = "bi";
            } else if (imageArray[2] == a) {
                jawaban = "si";
            } else if (imageArray[3] == a) {
                jawaban = "di";
            } else if (imageArray[4] == a) {
                jawaban = "i";
            }
            ei.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (jawaban.contains("ei")) {
                        Toast.makeText(MainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
                        benarx++;
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                    }
                    j++;
                    gambar();
                }
            });

            bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (jawaban.contains("bi")) {
                        Toast.makeText(MainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
                        benarx++;
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                    }
                    j++;
                    gambar();
                }
            });

            si.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (jawaban.contains("si")) {
                        Toast.makeText(MainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
                        benarx++;
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                    }
                    j++;
                    gambar();
                }
            });

            di.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (jawaban.contains("di")) {
                        Toast.makeText(MainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
                        benarx++;
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                    }
                    j++;
                    gambar();
                }
            });

            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (jawaban.contains("i")) {
                        Toast.makeText(MainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
                        benarx++;
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                    }
                    j++;
                    gambar();
                }
            });
        } else {
            Toast.makeText(MainActivity.this , "Selesai" , Toast.LENGTH_SHORT).show();
            benar1.setText(String.valueOf(benarx));
        }

    }

    public class TimerClass extends CountDownTimer {

        TimerClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //Method ini berjalan saat waktu/timer berubah
        @Override
        public void onTick(long millisUntilFinished) {
            //Kenfigurasi Format Waktu yang digunakan
            String waktu = String.format("%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

            //Menampilkannya pada TexView
            waktu1.setText(waktu);
        }

        @Override
        public void onFinish() {
            ///Berjalan saat waktu telah selesai atau berhenti
        /*
            Intent bg1 = new Intent(MainActivity.this, MainActivity1.class);

            startActivity(bg1);
            */
            Toast.makeText(MainActivity.this ,"Waktu Habis" , Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
