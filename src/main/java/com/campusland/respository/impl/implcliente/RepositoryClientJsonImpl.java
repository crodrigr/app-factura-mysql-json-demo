package com.campusland.respository.impl.implcliente;

import java.util.List;

import com.campusland.respository.RepositoryCliente;
import com.campusland.respository.models.Cliente;
import com.campusland.utils.conexionpersistencia.conexionbdjson.ConexionBDJsonClientes;

public class RepositoryClientJsonImpl implements RepositoryCliente {

    ConexionBDJsonClientes conexion = ConexionBDJsonClientes.getConexion();

    @Override
    public List<Cliente> listar() {
        return conexion.getData(Cliente.class);
    }

    @Override
    public Cliente porDocumento(String documento) {
        Cliente resultado = null;
        for (Cliente cliente : conexion.getData(Cliente.class)) {
            if (cliente.getDocumento().equals(documento)) {
                resultado = cliente;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        List<Cliente> listClientes = conexion.getData(Cliente.class);
        listClientes.add(cliente);
        conexion.saveData(listClientes);
        

    }

    @Override
    public void editar(Cliente cliente) {
        List<Cliente> listClientes = conexion.getData(Cliente.class);
        boolean change = false;
        for (Cliente clienteCurrent : listClientes) {
            if (clienteCurrent.getDocumento().equals(cliente.getDocumento())) {
                clienteCurrent.setNombre(cliente.getNombre());
                clienteCurrent.setApellido(cliente.getApellido());
                clienteCurrent.setDireccion(cliente.getDireccion());
                clienteCurrent.setEmail(cliente.getEmail());
                clienteCurrent.setCelular(cliente.getCelular());
                change = true;
                break;
            }
        }
        if (change)
            conexion.saveData(listClientes);
    }

    @Override
    public void eliminar(Cliente cli) {
        List<Cliente> listClientes = conexion.getData(Cliente.class);
        boolean change = false;
        for (Cliente cliente : listClientes) {
            if (cliente.getDocumento().equals(cli.getDocumento())) {
                listClientes.remove(cliente);
                change = true;
                break;
            }

        }
        if (change)
            conexion.saveData(listClientes);
    }
}
