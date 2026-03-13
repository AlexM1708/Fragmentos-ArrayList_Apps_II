package com.example.kekas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText cantidadEdit;
    Spinner combo;
    Button agregarBtn, pagarBtn;
    TableLayout tabla;

    String productos[] = {"papa", "queso", "picadillo"};
    int precios[] = {20, 30, 25};

    Arreglito lista = new Arreglito();
    int seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidadEdit = findViewById(R.id.edit);
        combo = findViewById(R.id.combo);
        agregarBtn = findViewById(R.id.agregar);
        pagarBtn = findViewById(R.id.pagar);
        tabla = findViewById(R.id.tabla);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                productos
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        combo.setAdapter(adapter);
        combo.setOnItemSelectedListener(this);

        agregarBtn.setOnClickListener(this);
        pagarBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.agregar) {
            agregarProducto();

        } else
            if (v.getId() == R.id.pagar) {
                mostrarTotal();
            }
    }

    private void agregarProducto() {

        String texto = cantidadEdit.getText().toString();

        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingresa la cantidad", Toast.LENGTH_SHORT).show();
            return;
        }

        int cantidad = Integer.parseInt(texto);

        Clasesita item = new Clasesita();
        item.setTipo(seleccion);
        item.setCantidad(cantidad);
        item.setCosto(precios[seleccion]);

        lista.agregar(item);

        cantidadEdit.setText("");

        Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show();
    }

    private void mostrarTotal() {

        ArrayList<Clasesita> items = lista.regresar();

        tabla.removeAllViews();

        int totalGeneral = 0;

        for (int i = 0; i < items.size(); i++) {

            Clasesita it = items.get(i);

            TableRow fila = new TableRow(this);

            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            int subtotal = it.getCantidad() * it.getCosto();

            c1.setText(String.valueOf(it.getCantidad()));
            c2.setText(productos[it.getTipo()]);
            c3.setText("$" + it.getCosto());
            c4.setText("$" + subtotal);

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            tabla.addView(fila);

            totalGeneral += subtotal;
        }

        TableRow filaTotal = new TableRow(this);

        TextView t1 = new TextView(this);
        TextView t2 = new TextView(this);
        TextView t3 = new TextView(this);
        TextView t4 = new TextView(this);

        t1.setText("TOTAL");
        t4.setText("$" + totalGeneral);

        filaTotal.addView(t1);
        filaTotal.addView(t2);
        filaTotal.addView(t3);
        filaTotal.addView(t4);

        tabla.addView(filaTotal);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        seleccion = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}