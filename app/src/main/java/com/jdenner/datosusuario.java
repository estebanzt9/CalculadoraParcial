package com.example.parcialprimercorte;

import static com.example.parcialprimercorte.loginprincipal.CIUDAD;
import static com.example.parcialprimercorte.loginprincipal.NOMBRE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class datosusuario extends AppCompatActivity {

    private TextView ne1;
    private TextView ne2;
    private TextView ae1;
    private Button   reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datosusuario);
        ne1=findViewById(R.id.usuest);
        ne2=findViewById(R.id.contres);
        ae1=findViewById(R.id.nota);
        reg=findViewById(R.id.registrodatos);
        EdadFactorial mt = new EdadFactorial();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bdcrud database = new Bdcrud(datosusuario.this);
                long  id = database.insertardato(ne1.getText().toString(),ne2.getText().toString(),ae1.getText().toString());

                if( id > 0 ){
                    Toast.makeText(datosusuario.this,"ESTUDIANTE REGISTRADO",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(datosusuario.this,"ERROR",Toast.LENGTH_LONG).show();
                }

            }
        });

        Bundle personaR=getIntent().getExtras();
        TextView nombre = (TextView) findViewById(R.id.usuest);
        nombre.setText(personaR.getString(NOMBRE));
        TextView ciudad = (TextView) findViewById(R.id.contres);
        ciudad.setText(personaR.getString(CIUDAD));

        Random random = new Random();
        int numeroal = random.nextInt(6);

        int resultado = Integer.parseInt(mt.factorial(numeroal,1));
        ae1.setText(Integer.toString(resultado));
    }

}