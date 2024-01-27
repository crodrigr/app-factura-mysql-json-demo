package com.campusland.respository;

import java.util.List;

import com.campusland.respository.models.Producto;

public interface RepositoryProducto {

     List<Producto> listar();

    Producto porCodigo(int codigo);

    void crear(Producto producto);

    void editar(Producto producto);

    void eliminar(Producto codigo);
    
    
}
