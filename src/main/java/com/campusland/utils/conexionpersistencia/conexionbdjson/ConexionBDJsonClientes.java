package com.campusland.utils.conexionpersistencia.conexionbdjson;

import com.campusland.respository.models.Cliente;

public class ConexionBDJsonClientes extends ConexionBDJsonBase<Cliente> {

    private static ConexionBDJsonClientes conexionClientes;

    private ConexionBDJsonClientes() {
        super("clientes.json");
    }

    public static ConexionBDJsonClientes getConexion() {
        if (conexionClientes != null) {
            return conexionClientes;
        } else {
            conexionClientes = new ConexionBDJsonClientes();
            return conexionClientes;
        }
    }
    
}
