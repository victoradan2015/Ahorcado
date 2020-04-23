package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int letterindex;
    private TextView letter_1, letter_2, letter_3, letter_4, letter_5, letter_6, letter_7;
    private ArrayList<Character> wordCharacters;
    private ArrayList<TextView> letter_views;
    private String letter;
    private String currentword;
    private TextView letter_text;
    private ImageView hangmanpic;
    private Button a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, å, ä, ö;
    int errorscounter;
    private Button retry;
    private String test = "A";
    private int correctcounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letter_text = findViewById(R.id.number_of_letters);
        letter_text.setText("Una palabra con " + generadorPalabras().length() + " letras");
        hangmanpic = findViewById(R.id.hangman_pic);
        hangmanpic.setImageResource(R.drawable.mono0);
        retry = findViewById(R.id.retry_button);

        letter_1 = findViewById(R.id.letter1);
        letter_2 = findViewById(R.id.letter2);
        letter_3 = findViewById(R.id.letter3);
        letter_4 = findViewById(R.id.letter4);
        letter_5 = findViewById(R.id.letter5);
        letter_6 = findViewById(R.id.letter6);
        letter_7 = findViewById(R.id.letter7);

        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        c = findViewById(R.id.C);
        d = findViewById(R.id.D);
        e = findViewById(R.id.E);
        f = findViewById(R.id.F);
        g = findViewById(R.id.G);
        h = findViewById(R.id.H);
        i = findViewById(R.id.I);
        j = findViewById(R.id.J);
        k = findViewById(R.id.K);
        m = findViewById(R.id.M);
        n = findViewById(R.id.N);
        o = findViewById(R.id.O);
        p = findViewById(R.id.P);
        q = findViewById(R.id.Q);
        r = findViewById(R.id.R);
        s = findViewById(R.id.S);
        t = findViewById(R.id.T);
        u = findViewById(R.id.U);
        v = findViewById(R.id.V);
        x = findViewById(R.id.X);
        y = findViewById(R.id.Y);
        z = findViewById(R.id.Z);
        å = findViewById(R.id.Å);
        ä = findViewById(R.id.Ä);
        ö = findViewById(R.id.Ö);

        setTextViewVisibility();
    }

    public String generadorPalabras() {

        ArrayList<String> words_list = new ArrayList<>();
        words_list.add("TACO");
        words_list.add("SALSA");
        words_list.add("PROGRAMA");
        words_list.add("LENGUAJE");
        words_list.add("SERVIDOR");
        words_list.add("PAGINA");
        words_list.add("APP");
        words_list.add("LINK");
        words_list.add("INGENIERIA");
        words_list.add("PERRO");

        Random random = new Random();
        int randomnum = random.nextInt(words_list.size());
        currentword = words_list.get(randomnum);
        return currentword;
    }

    public void setTextViewVisibility() {
        switch (currentword.length()) {

            case 3:
                letter_1.setVisibility(View.VISIBLE);
                letter_2.setVisibility(View.VISIBLE);
                letter_3.setVisibility(View.VISIBLE);
                break;
            case 4:
                letter_1.setVisibility(View.VISIBLE);
                letter_2.setVisibility(View.VISIBLE);
                letter_3.setVisibility(View.VISIBLE);
                letter_4.setVisibility(View.VISIBLE);
                break;
            case 5:
                letter_1.setVisibility(View.VISIBLE);
                letter_2.setVisibility(View.VISIBLE);
                letter_3.setVisibility(View.VISIBLE);
                letter_4.setVisibility(View.VISIBLE);
                letter_5.setVisibility(View.VISIBLE);
                break;
            case 6:
                letter_1.setVisibility(View.VISIBLE);
                letter_2.setVisibility(View.VISIBLE);
                letter_3.setVisibility(View.VISIBLE);
                letter_4.setVisibility(View.VISIBLE);
                letter_5.setVisibility(View.VISIBLE);
                letter_6.setVisibility(View.VISIBLE);
                break;
            case 7:
                letter_1.setVisibility(View.VISIBLE);
                letter_2.setVisibility(View.VISIBLE);
                letter_3.setVisibility(View.VISIBLE);
                letter_4.setVisibility(View.VISIBLE);
                letter_5.setVisibility(View.VISIBLE);
                letter_6.setVisibility(View.VISIBLE);
                letter_7.setVisibility(View.VISIBLE);
                break;
        }
    }
    public void switchPictures() {

        errorscounter++;

        switch (errorscounter) {
            case 1:
                hangmanpic.setImageResource(R.drawable.mono1);
                break;
            case 2:
                hangmanpic.setImageResource(R.drawable.mono2);
                break;
            case 3:
                hangmanpic.setImageResource(R.drawable.mono3);
                break;
            case 4:
                hangmanpic.setImageResource(R.drawable.mono4);
                break;
            case 5:
                hangmanpic.setImageResource(R.drawable.mono5);
                break;
            case 6:
                hangmanpic.setImageResource(R.drawable.mono6);
                break;
            case 7:
                hangmanpic.setImageResource(R.drawable.mono7);
                break;
            case 8:
                hangmanpic.setImageResource(R.drawable.mono8);
                letter_text.setText("Perdiste, " + " la palabra correcta era " + currentword );
                break;

        }
    }

    public void retryGame(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        setTextViewVisibility();
    }

    public int checkIfLetterCorrect(char inputletter) {

        wordCharacters = new ArrayList<>();
        for (int i = 0; i < currentword.length(); i++) {
            wordCharacters.add(currentword.charAt(i));

            if (inputletter == wordCharacters.get(i)) {
                letterindex = i;
                correctcounter++;
                if (correctcounter==currentword.length()) {
                    letter_text.setText("¡Ganaste!");
                }
            }
        }
        return letterindex;
    }


    public void evaluateInputLetter(View view) {

        letter = ((TextView) view).getText().toString();
        letter_text.setText(letter);
        ((TextView) view).setTextColor(00000);
        char input = letter.charAt(0);

        if (!currentword.contains(letter)) {
            switchPictures();}

        if (currentword.contains(letter)) {

            checkIfLetterCorrect(input);

            switch (letterindex) {
                case 0:
                    letter_1.setText(letter);
                    break;
                case 1:
                    letter_2.setText(letter);
                    break;
                case 2:
                    letter_3.setText(letter);
                    break;
                case 3:
                    letter_4.setText(letter);
                    break;
                case 4:
                    letter_5.setText(letter);
                    break;
                case 5:
                    letter_6.setText(letter);
                    break;
                case 6:
                    letter_7.setText(letter);
            }
        }

    }
}
