package br.ulbra.appcalculadorabebidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    Button btVoltar;
    private TextView txResultadoAgua;
    private TextView txResultadoRefri;
    private TextView txResultadoSuco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.resultado);

        txResultadoAgua = findViewById(R.id.txtResultadoAgua);
        txResultadoRefri = findViewById(R.id.txtResultadoRefri);
        txResultadoSuco = findViewById(R.id.txtResultadoSuco);
        btVoltar = findViewById(R.id.btnVoltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultado.this, MainActivity.class);
                startActivity(intent);
            }
        });

        double totalAgua = getIntent().getDoubleExtra("agua", 0);
        double totalrefri = getIntent().getDoubleExtra("refri", 0);
        double totalsuco = getIntent().getDoubleExtra("suco", 0);




        txResultadoAgua.setText("Água: " +totalAgua +" L");
        txResultadoRefri.setText("refrigerante: " + totalrefri + "L");
        txResultadoSuco.setText("suco: " + totalsuco + "L");


    }
}