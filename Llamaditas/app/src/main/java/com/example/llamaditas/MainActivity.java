package com.example.llamaditas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editDuracion;
    Button bLocal, bNacional, bInternacional, bPagar;
    TableLayout tabla;

    Arreglito lista = new Arreglito();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDuracion = findViewById(R.id.edit1);
        bLocal = findViewById(R.id.blocal);
        bNacional = findViewById(R.id.bnacional);
        bInternacional = findViewById(R.id.binternacional);
        bPagar = findViewById(R.id.bpago);
        tabla = findViewById(R.id.tabla);

        bLocal.setOnClickListener(this);
        bNacional.setOnClickListener(this);
        bInternacional.setOnClickListener(this);
        bPagar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.blocal) {
            agregarLlamada(1);
        }
        else
            if (v.getId() == R.id.bnacional) {
                agregarLlamada(2);
            }
            else
                if (v.getId() == R.id.binternacional) {
                    agregarLlamada(3);
                }
                else
                    if (v.getId() == R.id.bpago) {
                        mostrarTabla();
                    }
    }

    private void agregarLlamada(int tipo) {

        String texto = editDuracion.getText().toString();

        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingresa la duración", Toast.LENGTH_SHORT).show();
            return;
        }

        int duracion = Integer.parseInt(texto);

        Clasesita llamada = new Clasesita();

        llamada.setTipo(tipo);
        llamada.setDuracion(duracion);
        llamada.setCosto(tipo * duracion);

        lista.agregar(llamada);

        editDuracion.setText("");

        Toast.makeText(this, "Llamada agregada", Toast.LENGTH_SHORT).show();
    }

    private void mostrarTabla() {

        ArrayList<Clasesita> datos = lista.regresar();

        tabla.removeViews(1, tabla.getChildCount() - 1);

        int total = 0;

        for (int i = 0; i < datos.size(); i++) {

            Clasesita llamada = datos.get(i);

            TableRow fila = new TableRow(this);

            TextView t1 = new TextView(this);
            TextView t2 = new TextView(this);
            TextView t3 = new TextView(this);

            t1.setText(String.valueOf(llamada.getTipo()));
            t2.setText(String.valueOf(llamada.getDuracion()));
            t3.setText("$" + llamada.getCosto());

            fila.addView(t1);
            fila.addView(t2);
            fila.addView(t3);

            tabla.addView(fila);

            total += llamada.getCosto();
        }

        TableRow filaTotal = new TableRow(this);

        TextView tt1 = new TextView(this);
        TextView tt2 = new TextView(this);
        TextView tt3 = new TextView(this);

        tt1.setText("TOTAL");
        tt2.setText("");
        tt3.setText("$" + total);

        filaTotal.addView(tt1);
        filaTotal.addView(tt2);
        filaTotal.addView(tt3);

        tabla.addView(filaTotal);
    }
}