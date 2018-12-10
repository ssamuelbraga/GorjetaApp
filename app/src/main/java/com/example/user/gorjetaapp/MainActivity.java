package com.example.user.gorjetaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView valorGorjeta;
    private TextView valorTotal;
    private SeekBar seekBarPorcent;

    private double porcentagem = 0; //porcentagem inicial da gorjeta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.porcentagem);
        valorGorjeta = findViewById(R.id.valorGorjeta);
        valorTotal = findViewById(R.id.valorTotal);
        seekBarPorcent = findViewById(R.id.seekBarPorcent);

        //controle seekbar
        seekBarPorcent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                textPorcentagem.setText(Math.round(porcentagem)+" %");
                Calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void Calcular()
    {
        //Recuperando valor digitado pelo user
        double valorDigitado = Double.parseDouble(editValor.getText().toString());  //convertendo o string para double

    //calculo da gorjeta
        double gorjeta = valorDigitado*(porcentagem/100);
        double total = gorjeta+valorDigitado;

        //exibindo gorjeta e total
        valorGorjeta.setText("R$ "+Math.round(gorjeta));
        valorTotal.setText("R$ "+Math.round(total));
    }
}
