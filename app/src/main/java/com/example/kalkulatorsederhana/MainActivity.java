package com.example.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    Button btnTambah, btnKurang, btnKali, btnBagi;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulator_layout);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        txtHasil = findViewById(R.id.txtHasil);


        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionHitung("+");
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionHitung("-");
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionHitung("X");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionHitung(":");
            }
        });

    }

    private void actionHitung(String operator){
        String input1 = txt1.getText().toString();
        String input2 = txt2.getText().toString();

        if (TextUtils.isEmpty(input1)){
            txt1.setError("tidak boleh kosong");
        }else if(TextUtils.isEmpty(input2)){
            txt2.setError("tidak boleh kosong");
        }else{
            double hasil = 0;
            switch (operator){
                case "+":
                    hasil = Double.parseDouble(input1)+Double.parseDouble(input2);
                    break;
                case "-":
                    hasil = Double.parseDouble(input1)-Double.parseDouble(input2);
                    break;
                case "X":
                    hasil = Double.parseDouble(input1)*Double.parseDouble(input2);
                    break;
                case ":":
                    hasil = Double.parseDouble(input1)/Double.parseDouble(input2);
                    break;

            }

            DecimalFormat df = new DecimalFormat("0.###");

            txtHasil.setText(String.valueOf(hasil));
        }
    }

}
