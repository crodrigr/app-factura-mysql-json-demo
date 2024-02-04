package com.campusland.services;

import java.util.List;

import com.campusland.exceptiones.productoexceptions.ProductoNullException;
import com.campusland.respository.models.Producto;

public interface ServiceProducto {

    List<Producto> listar();

    Producto porCodigo(int codigo) throws ProductoNullException;

    void crear(Producto cliente);

    void editar(Producto cliente);

    void eliminar(Producto codigo);

}
