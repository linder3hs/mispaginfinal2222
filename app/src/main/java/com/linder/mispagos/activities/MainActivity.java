package com.linder.mispagos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.linder.mispagos.repositories.GastoRepository;
import com.linder.mispagos.R;
import com.linder.mispagos.model.Gasto;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REGISTER_FORM_REQUEST = 100;
    private TextView total;

    //donde se guarda el gasto
    private double gastotal;

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = (TextView) findViewById(R.id.totalGasto);

        list = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        list.setAdapter(adapter);
    }

    public void addItem(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        ArrayAdapter<String> adapter = (ArrayAdapter<String>)list.getAdapter();

        adapter.clear();

        GastoRepository gastoRepository = GastoRepository.getInstance();

        List<Gasto> gastos = gastoRepository.getGastos();
        for (Gasto gasto : gastos) {
            adapter.add(gasto.getDetalle());
            adapter.add(gasto.getMonto().toString());

            double to = Double.parseDouble(total.getText().toString());
            to = to + gasto.getMonto();
            total.setText(total.getText());
        }
        adapter.notifyDataSetChanged();

    }
}
