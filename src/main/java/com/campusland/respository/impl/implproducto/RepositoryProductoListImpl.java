package com.campusland.respository.impl.implproducto;

import java.util.List;

import com.campusland.respository.RepositoryProducto;
import com.campusland.respository.models.Producto;
import com.campusland.utils.conexionpersistencia.conexiondblist.ConexionBDList;

public class RepositoryProductoListImpl implements RepositoryProducto{

    ConexionBDList conexion = ConexionBDList.getConexion();

    @Override
    public List<Producto> listar() {
        return conexion.getListaProductos();        
    }

    @Override
    public Producto porCodigo(int codigo) {
        Producto resultado = null;
        for (Producto producto : conexion.getListaProductos()) {
            if (producto.getCodigo() == codigo) {
                resultado = producto;
                break;
            }
        }
        return resultado;
        
    }

    @Override
    public void crear(Producto producto) {
        conexion.getListaProductos().add(producto);
        
    }

    @Override
    public void editar(Producto producto) {   
        for(Producto prod: conexion.getListaProductos()){
            if (prod.getCodigo()==producto.getCodigo()) {
               prod.setNombre(producto.getNombre());
               prod.setPrecioVenta(producto.getPrecioVenta());
               prod.setPrecioCompra(producto.getPrecioCompra());
               prod.setDescripcion(prod.getDescripcion());                
               break;
           }
       }     
        
    }

    @Override
    public void eliminar(Producto prod) {
        for (Producto producto : conexion.getListaProductos()) {
            if (producto.getCodigo() == prod.getCodigo()) {
                conexion.getListaProductos().remove(producto);
                break;
            }
        }
    }
    
}
