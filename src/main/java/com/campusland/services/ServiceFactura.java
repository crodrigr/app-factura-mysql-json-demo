package com.campusland.services;

import java.util.List;

import com.campusland.respository.models.Factura;

public interface ServiceFactura {

    List<Factura> listar();

    void crear(Factura factura);

    
}
