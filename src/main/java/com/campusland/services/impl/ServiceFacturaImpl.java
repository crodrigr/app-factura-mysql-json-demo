package com.campusland.services.impl;

import java.util.List;

import com.campusland.respository.RepositoryFactura;
import com.campusland.respository.models.Factura;
import com.campusland.services.ServiceFactura;

public class ServiceFacturaImpl implements ServiceFactura{

    private final RepositoryFactura crudRepositoryFactura;

    public ServiceFacturaImpl(RepositoryFactura crudRepositoryFactura){
        this.crudRepositoryFactura=crudRepositoryFactura;
    }

    @Override
    public List<Factura> listar() {
      return  this.crudRepositoryFactura.listar();
        
    }

    @Override
    public void crear(Factura factura) {
       this.crudRepositoryFactura.crear(factura);  
    }    
    
}
