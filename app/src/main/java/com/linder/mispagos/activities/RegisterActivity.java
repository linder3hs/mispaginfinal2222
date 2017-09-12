package com.linder.mispagos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.linder.mispagos.R;
import com.linder.mispagos.model.Gasto;
import com.linder.mispagos.repositories.GastoRepository;

public class RegisterActivity extends AppCompatActivity {
    private EditText detailInput;
    private EditText amountInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        detailInput = (EditText)findViewById(R.id.detail_input);
        amountInput = (EditText)findViewById(R.id.amount_input);
    }

    public void register(View view){
        String detalle = detailInput.getText().toString();
        String monto = amountInput.getText().toString();

        if(detalle.isEmpty() || monto.isEmpty()){
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Gasto gasto = new Gasto(detalle, Double.parseDouble(monto));

        GastoRepository gastoRepository = GastoRepository.getInstance();
        gastoRepository.agregarGasto(gasto);

        finish();

    }
}
