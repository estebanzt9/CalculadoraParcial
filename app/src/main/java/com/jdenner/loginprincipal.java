package com.example.parcialprimercorte;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginprincipal extends AppCompatActivity {

    public static final String NOMBRE ="nombre";
    public static final String CIUDAD = "ciudad";

    private Button consulta;
    private EditText usu;
    private EditText pass;
    private datos registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consulta=findViewById(R.id.consulta);
        usu=findViewById(R.id.usuario);
        pass=findViewById(R.id.contrasena);
        registro= new datos("ESTEBAN","MEDELLIN");
        consulta.setOnClickListener(view -> {
            String dato1 = registro.getNombre();
            String dato2 = registro.getCiudad();

            if(usu.getText().toString().equals("Esteban") && pass.getText().toString().equals("1234")) {

                Intent con = new Intent(loginprincipal.this, datosusuario.class);
                Bundle persona = new Bundle();
                persona.putString(NOMBRE,dato1);
                persona.putString(CIUDAD,dato2);
                con.putExtras(persona);
                startActivity(con);
                Toast.makeText(loginprincipal.this, "Hola!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(loginprincipal.this,"Usuario errado",Toast.LENGTH_SHORT).show();
            }

        });
    }

}