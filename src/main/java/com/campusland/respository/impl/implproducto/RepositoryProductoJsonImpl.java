package com.campusland.respository.impl.implproducto;

import java.util.List;

import com.campusland.respository.RepositoryProducto;
import com.campusland.respository.models.Producto;
import com.campusland.utils.conexionpersistencia.conexionbdjson.ConexionBDJsonProductos;

public class RepositoryProductoJsonImpl implements RepositoryProducto {

    ConexionBDJsonProductos conexion = ConexionBDJsonProductos.getConexion();

    @Override
    public List<Producto> listar() {
        return conexion.getData(Producto.class);
    }

    @Override
    public Producto porCodigo(int codigo) {
        Producto resultado = null;
        for (Producto producto : conexion.getData(Producto.class)) {
            if (producto.getCodigo() == codigo) {
                resultado = producto;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Producto producto) {
        List<Producto> listProductos = conexion.getData(Producto.class);
        listProductos.add(producto);
        conexion.saveData(listProductos);

    }

    @Override
    public void editar(Producto producto) {
        List<Producto> listProducto = conexion.getData(Producto.class);
        boolean change = false;
        for (Producto currenProducto : listProducto) {
            if (currenProducto.getCodigo() == producto.getCodigo()) {
                currenProducto.setNombre(producto.getNombre());
                currenProducto.setDescripcion(producto.getDescripcion());
                currenProducto.setPrecioVenta(producto.getPrecioVenta());
                currenProducto.setPrecioCompra(producto.getPrecioCompra());                
                change = true;
                break;
            }
        }
        if (change)
           conexion.saveData(listProducto);
    }

    @Override
    public void eliminar(Producto prod) {
        List<Producto> listProducto = conexion.getData(Producto.class);
        boolean change = false;
        for (Producto producto : listProducto) {
            if (producto.getCodigo()==prod.getCodigo()) {
                listProducto.remove(producto);
                change = true;
                break;
            }

        }
        if (change)
            conexion.saveData(listProducto);
    }


}
