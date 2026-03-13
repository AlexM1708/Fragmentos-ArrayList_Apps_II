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

public class Inicio extends Fragment implements View.OnClickListener {

    Button botons, botonr, botonm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        botons = view.findViewById(R.id.botons);
        botonr = view.findViewById(R.id.botonr);
        botonm = view.findViewById(R.id.botont);

        botons.setOnClickListener(this);
        botonr.setOnClickListener(this);
        botonm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String textoBoton = ((Button)view).getText().toString();

        if (textoBoton.equals("Cuadrado")) {
            Navigation.findNavController(view).navigate(R.id.cuadrado);
        } else if (textoBoton.equals("Rectángulo")) {
            Navigation.findNavController(view).navigate(R.id.rectangulo);
        } else if (textoBoton.equals("Triángulo")) {
            Navigation.findNavController(view).navigate(R.id.triangulo);
        }
    }
}