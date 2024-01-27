package com.campusland.utils.conexionpersistencia.conexionbdjson;

import com.campusland.respository.models.Factura;

public class ConexionBDJsonFacturas extends ConexionBDJsonBase<Factura>  {

    private static ConexionBDJsonFacturas conexionProductos;

    private ConexionBDJsonFacturas() {
        super("facturas.json");
    }

    public static ConexionBDJsonFacturas getConexion() {
        if (conexionProductos != null) {
            return conexionProductos;
        } else {
            conexionProductos = new ConexionBDJsonFacturas();
            return conexionProductos;
        }
    }
    
}
