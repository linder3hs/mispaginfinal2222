package com.linder.mispagos.repositories;

import com.linder.mispagos.model.Gasto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linderhassinger on 9/7/17.
 */

public class GastoRepository {

    private static GastoRepository _INSTANCE = null;

    private GastoRepository(){}

    public static GastoRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new GastoRepository();
        return _INSTANCE;
    }

    private List<Gasto> gastos = new ArrayList<>();

    public List<Gasto> getGastos() {
        return this.gastos;
    }

    public void agregarGasto(Gasto gasto){
        this.gastos.add(gasto);
    }
}
