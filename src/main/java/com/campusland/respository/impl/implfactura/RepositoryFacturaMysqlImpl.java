package com.campusland.respository.impl.implfactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.campusland.respository.RepositoryFactura;
import com.campusland.respository.models.Cliente;
import com.campusland.respository.models.Factura;
import com.campusland.respository.models.ItemFactura;
import com.campusland.respository.models.Producto;
import com.campusland.utils.Formato;
import com.campusland.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryFacturaMysqlImpl implements RepositoryFactura {

    private static final String SQL_GET_LIST_FACTURAS = "SELECT f.numeroFactura, f.fecha, c.id, c.nombre, c.apellido, c.email, c.direccion, c.celular, c.documento FROM factura f JOIN cliente c ON c.id=f.cliente_id";
    private static final String SQL_GET_LIST_ITEMS_FACTURAS = "SELECT i.id,i.cantidad,i.importe,p.codigo,p.nombre,p.descripcion,p.precioVenta,p.precioCompra  FROM item_factura i join producto p on i.producto_codigo=p.codigo WHERE i.factura_numeroFactura =?";

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Factura> listar() {
        List<Factura> listFacturas = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_LIST_FACTURAS);
                ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Factura factura = creaFactura(rs);
                obtenerItemsFactura(connection, factura);
                listFacturas.add(factura);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listFacturas;
    }

    private void obtenerItemsFactura(Connection connection, Factura factura) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_LIST_ITEMS_FACTURAS)) {
            preparedStatement.setInt(1, factura.getNumeroFactura());
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    factura.agregarItem(crearItems(rs));
                }
            }
        }
    }

    @Override
    public void crear(Factura factura) {
        // conexion.getListFacturas().add(factura);

    }

    private Factura creaFactura(ResultSet rs) throws SQLException {
        final int clienteId = rs.getInt("id");
        final String documento = rs.getString("documento");
        final String nombre = rs.getString("nombre");
        final String apellido = rs.getString("apellido");
        final String email = rs.getString("email");
        final String direccion = rs.getString("direccion");
        final String celular = rs.getString("celular");
        final Cliente cliente = new Cliente(clienteId, documento, nombre, apellido, email, direccion, celular);
        final int numeroFactura = rs.getInt("numeroFactura");
        final LocalDateTime fecha = Formato.convertirTimestampFecha(rs.getTimestamp("fecha"));
        return new Factura(numeroFactura, fecha, cliente);

    }

    private ItemFactura crearItems(ResultSet rs) throws SQLException {
        final int codigo = rs.getInt("codigo");
        final String nombre = rs.getString("nombre");
        final String descripcion = rs.getString("descripcion");
        final double precioVenta = rs.getDouble("precioVenta");
        final double precioCompra = rs.getDouble("precioCompra");
        final Producto producto = new Producto(codigo, nombre, descripcion, precioVenta, precioCompra);
        return new ItemFactura(rs.getInt("cantidad"), producto);
        
    }

}
