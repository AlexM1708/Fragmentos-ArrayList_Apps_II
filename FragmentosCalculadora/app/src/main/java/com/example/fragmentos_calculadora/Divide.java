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
import android.widget.EditText;
import android.widget.TextView;

public class Divide extends Fragment implements View.OnClickListener{

    TextView vista;
    EditText num1,num2;
    Button botonr,botonc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_divide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vista = view.findViewById(R.id.vista);
        num1 = view.findViewById(R.id.num1);
        num2 = view.findViewById(R.id.num2);
        botonc = view.findViewById(R.id.botonc);
        botonr = view.findViewById(R.id.botonr);

        botonc.setOnClickListener(this);
        botonr.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.botonr) {
            Navigation.findNavController(view).navigate(R.id.inicio);
        } else
        if (id == R.id.botonc) {
            int numero1 = Integer.parseInt(num1.getText().toString());
            int numero2 = Integer.parseInt(num2.getText().toString());
            int res = numero1 / numero2;
            vista.setText("Resultado = " + res);
        }
    }

}