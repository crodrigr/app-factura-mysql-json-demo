package com.campusland.utils.conexionpersistencia.conexionbdjson;

import com.campusland.respository.models.Producto;

public class ConexionBDJsonProductos extends ConexionBDJsonBase<Producto>{

    private static ConexionBDJsonProductos conexionProductos;

    private ConexionBDJsonProductos() {
        super("productos.json");
    }

    public static ConexionBDJsonProductos getConexion() {
        if (conexionProductos != null) {
            return conexionProductos;
        } else {
            conexionProductos = new ConexionBDJsonProductos();
            return conexionProductos;
        }
    }
    
}
