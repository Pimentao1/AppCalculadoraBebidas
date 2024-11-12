package br.ulbra.appcalculadorabebidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtV1, edtV2;
    Button btnCalcular, btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtV1 = findViewById(R.id.edtV1);
        edtV2 = findViewById(R.id.edtV2);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double convidadosStr = Double.parseDouble(edtV1.getText().toString());
                double duracaoStr = Double.parseDouble(edtV2.getText().toString());
                double totalAgua = (convidadosStr * duracaoStr * 500);
                double totalrefri = (convidadosStr * duracaoStr * 300);
                double totalsuco = (convidadosStr * duracaoStr * 200);
                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("agua", totalAgua);
                intent.putExtra("refri", totalrefri);
                intent.putExtra("suco", totalsuco);
                startActivity(intent);

            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtV1.setText("");
                edtV2.setText("");

            }
        });

    }

}