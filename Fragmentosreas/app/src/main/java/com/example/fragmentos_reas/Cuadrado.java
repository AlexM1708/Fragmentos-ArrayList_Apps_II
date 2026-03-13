package com.example.fragmentos_reas;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cuadrado extends Fragment implements View.OnClickListener {

    TextView vista;
    EditText num1;
    Button botons, botonr, botonm, botonc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cuadrado, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vista = view.findViewById(R.id.vista);
        num1 = view.findViewById(R.id.num1);
        botonc = view.findViewById(R.id.botonc);

        botons = view.findViewById(R.id.botons); // Botón Cuadrado
        botonr = view.findViewById(R.id.botonr); // Botón Rectángulo
        botonm = view.findViewById(R.id.botonm); // Botón Círculo

        botons.setOnClickListener(this);
        botonr.setOnClickListener(this);
        botonm.setOnClickListener(this);
        botonc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String cadenitas = ((Button)view).getText().toString();

        if (cadenitas.equals("Cuadrado")) {
            Navigation.findNavController(view).navigate(R.id.cuadrado);
        }
        else
            if (cadenitas.equals("Rectángulo")) {
                Navigation.findNavController(view).navigate(R.id.rectangulo);
            }
            else
                if (cadenitas.equals("Circulo")) {
                    Navigation.findNavController(view).navigate(R.id.circulo);
                }
                else {
                    if (!num1.getText().toString().isEmpty()) {
                        double lado = Double.parseDouble(num1.getText().toString());
                        double area = lado * lado;
                        vista.setText("Área: " + area);
                    }
                    else {
                        vista.setText("Introduce el lado");
                    }
        }
    }
}