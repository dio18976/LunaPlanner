package com.example.lunaplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.os.Handler;

public class MenuPrincipal extends AppCompatActivity {

    Button CerrarSesion;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        CerrarSesion = findViewById(R.id.CerrarSesion);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SalirAplicacion(v);
            }
        });
    }

    private void SalirAplicacion(View view) {
        firebaseAuth.signOut();
        Snackbar.make(view, "Cerraste Sesion Correctamente", Snackbar.LENGTH_LONG).show();

        // Retrasar el inicio de la nueva actividad por 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MenuPrincipal.this, MainActivity.class));
                finish(); // Termina la actividad actual
            }
        }, 2000); // 3000 milisegundos = 3 segundos
    }
}
