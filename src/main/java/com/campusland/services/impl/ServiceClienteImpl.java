package com.campusland.services.impl;

import java.util.List;

import com.campusland.exceptiones.clienteexceptions.ClienteNullException;
import com.campusland.respository.RepositoryCliente;
import com.campusland.respository.models.Cliente;
import com.campusland.services.ServiceCliente;

public class ServiceClienteImpl  implements ServiceCliente {

    private final RepositoryCliente crudRepositoryCliente;

    public ServiceClienteImpl(RepositoryCliente crudRepositoryCliente){
         this.crudRepositoryCliente=crudRepositoryCliente;
    }

    @Override
    public List<Cliente> listar() {
        return this.crudRepositoryCliente.listar();        
    }

    @Override
    public Cliente porDocumento(String documento) throws ClienteNullException {
        Cliente cliente=this.crudRepositoryCliente.porDocumento(documento);
        if(cliente!=null){
            return cliente;
        }else{
            throw new ClienteNullException("No se encontro cliente por id");
        }  
      
    }

    @Override
    public void crear(Cliente cliente) {
         this.crudRepositoryCliente.crear(cliente);
       
    }

    @Override
    public void editar(Cliente cliente) {
        this.crudRepositoryCliente.editar(cliente);
        
    }

    @Override
    public void eliminar(Cliente cliente) {
       this.crudRepositoryCliente.eliminar(cliente); 
        
    }
    
}
