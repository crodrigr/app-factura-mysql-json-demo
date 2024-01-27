package com.campusland.utils.conexionpersistencia.conexiondblist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.campusland.respository.models.Cliente;
import com.campusland.respository.models.Factura;
import com.campusland.respository.models.ItemFactura;
import com.campusland.respository.models.Producto;

import lombok.Data;

@Data
public class ConexionBDList {

    private static ConexionBDList conexion;
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Factura> listFacturas;

    private ConexionBDList() {
        listaClientes = new ArrayList<>();
        listaProductos = new ArrayList<>();
        listFacturas = new ArrayList<>();
        this.loadData();
    }

    public static ConexionBDList getConexion() {
        if (conexion != null) {
            return conexion;
        } else {
            conexion = new ConexionBDList();
            return conexion;
        }
    }

    private void loadData() {
        getLoadDataClientes();
        getLoadDataFactura();
        getLoadDataProductos();
    }

    private void getLoadDataClientes() {
        listaClientes.add(new Cliente(1,"Juan", "Perez", "jperez@gmail.com", "dirección", "celular", "13822001"));
        listaClientes.add(new Cliente(2,"Maria", "Gomez", "mariag@gmail.com", "dirección", "celular", "13822002"));
        listaClientes.add(new Cliente(3,"Andres", "Sarmiento", "andress@gmail.com", "dirección", "celular", "13822003"));
        listaClientes.add(new Cliente(4,"Lizeth", "Villamizar", "lizethv@gmail.com", "dirección", "celular", "13822004"));
        listaClientes.add(new Cliente(5,"Gladys", "Moreno", "gladysm@gmail.com", "dirección", "celular", "13822005"));
        listaClientes.add(new Cliente(6,"Sebastian", "Dominguez", "sebastian@gmail.com", "dirección", "celular", "13822006"));
        listaClientes.add(new Cliente(7,"Maura", "Sabolla", "mauras@gmail.com", "dirección", "celular", "13822007"));
        listaClientes.add(new Cliente(8,"Catalina", "Moreno", "catalinam@gmail.com", "dirección", "celular", "13822008"));
        listaClientes.add(new Cliente(9,"Celina", "Torres", "celinat@gmail.com", "dirección", "celular", "13822009"));
        listaClientes.add(new Cliente(10,"Diego", "Rangel", "diegor@gmail.com", "dirección", "celular", "13822010"));
        listaClientes.add(new Cliente(11,"Camilo", "Rodriguez", "camilor@gmail.com", "dirección", "celular", "13822011"));
        listaClientes.add(new Cliente(12,"Diana", "Tarazona", "dianat@gmail.com", "dirección", "celular", "13822012"));

    }

    private void getLoadDataProductos() {
        listaProductos.add(new Producto("Tv 64 Samsung", 340000, 300000,""));
        listaProductos.add(new Producto("Tv 45 Lg", 240000, 200000,""));
        listaProductos.add(new Producto("Tv 32 Lg", 140000, 900000,""));
        listaProductos.add(new Producto("Tv 22 Lg", 80000, 50000,""));
        listaProductos.add(new Producto("Tv 80 Samsung", 940000, 500000,""));
        listaProductos.add(new Producto("Tv 45 Samsung", 240000, 120000,""));
        listaProductos.add(new Producto("Xiomi Note 15", 140000, 90000,""));
        listaProductos.add(new Producto("Xiomi Note 14", 900000, 50000,""));
        listaProductos.add(new Producto("Xiomi Note 13", 700000, 30000,""));
        listaProductos.add(new Producto("Xiomi Note 11", 600000, 20000,""));
    }

     private void getLoadDataFactura() {

        Producto tv = new Producto("Tv 64 Samsung", 3400000, 3000000,"");
        Producto phone = new Producto("Xiomi Note 15", 1400000, 900000,"");
        Cliente cliente = new Cliente("Juana", "Perez", "juanap@gmail.com", "dirección", "celular", "13822002");
        Factura factura = new Factura(LocalDateTime.now(), cliente);
        factura.agregarItem(new ItemFactura(1, phone));
        factura.agregarItem(new ItemFactura(2, tv));

        Factura factura1 = new Factura(LocalDateTime.now(),
                new Cliente("Maria", "Gomez", "mariag@gmail.com", "dirección", "celular", "13822002"));
                factura1.agregarItem(new ItemFactura(1, new Producto("Tv 22 Lg", 80000, 50000,"")));
                factura1.agregarItem(new ItemFactura(2, new Producto("Tv 45 Samsung", 240000, 120000,"")));

        Factura factura2 = new Factura(LocalDateTime.now(), new Cliente("Celina", "Torres", "celinat@gmail.com", "dirección", "celular", "13822009"));
        factura2.agregarItem(new ItemFactura(1, new Producto("Tv 22 Lg", 80000, 50000,"")));
        factura2.agregarItem(new ItemFactura(2, new Producto("Tv 45 Samsung", 240000, 120000,"")));

        Factura factura3 = new Factura(LocalDateTime.now(),
                new Cliente("Dora", "Paps", "dorap@gmail.com", "dirección", "celular", "13822009"));
                factura3.agregarItem(new ItemFactura(1, new Producto("Tv 22 Lg", 80000, 50000,"")));
                factura3.agregarItem(new ItemFactura(2, new Producto("Tv 45 Samsung", 240000, 120000,"")));

        listFacturas.add(factura);
        listFacturas.add(factura1);
        listFacturas.add(factura2);
        listFacturas.add(factura3);

    }

}
