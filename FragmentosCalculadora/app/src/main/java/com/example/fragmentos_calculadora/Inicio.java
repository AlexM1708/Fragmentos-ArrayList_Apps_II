package com.example.fragmentos_calculadora;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Inicio extends Fragment implements View.OnClickListener {

    Button botons,botonr,botonm,botond;

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
        botonm = view.findViewById(R.id.botonm);
        botond = view.findViewById(R.id.botond);

        botons.setOnClickListener(this);
        botonr.setOnClickListener(this);
        botonm.setOnClickListener(this);
        botond.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String cadenitas = ((Button)view).getText().toString();
        if (cadenitas.equals("Suma")){
            Navigation.findNavController(view).navigate(R.id.suma);
        } else
            if (cadenitas.equals("Resta")) {
                Navigation.findNavController(view).navigate(R.id.resta);
            } else
                if (cadenitas.equals("Multiplica")) {
                    Navigation.findNavController(view).navigate(R.id.multiplica);
                } else{
                    Navigation.findNavController(view).navigate(R.id.divide);
                    }
    }
}