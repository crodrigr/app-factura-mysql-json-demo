package com.campusland.views;

import java.util.Scanner;

import com.campusland.respository.impl.implcliente.RepositoryClientMysqlImpl;
import com.campusland.respository.impl.implfactura.RepositoryFacturaJsonImpl;
import com.campusland.respository.impl.implfactura.RepositoryFacturaMysqlImpl;
import com.campusland.respository.impl.implproducto.RepositoryProductoMysqlImpl;
import com.campusland.services.ServiceCliente;
import com.campusland.services.ServiceFactura;
import com.campusland.services.ServiceProducto;
import com.campusland.services.impl.ServiceClienteImpl;
import com.campusland.services.impl.ServiceFacturaImpl;
import com.campusland.services.impl.ServiceProductoImpl;

public class ViewMain {

 
    public static final ServiceCliente serviceCliente = new ServiceClienteImpl(new RepositoryClientMysqlImpl());    
    public static final ServiceProducto serviceProducto = new ServiceProductoImpl(new RepositoryProductoMysqlImpl());
    public static final ServiceFactura serviceFactura = new ServiceFacturaImpl(new RepositoryFacturaMysqlImpl(),new RepositoryFacturaJsonImpl());
    public static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {      
        int op = 0;

        do {

            op = menuMain();
            switch (op) {
                case 1:
                    ViewCliente.startMenu();
                    break;
                case 2:
                    ViewProducto.startMenu();
                    break;
                case 3:
                    ViewFactura.startMenu();
                    break;
                default:
                    System.out.println("Fin");
                    break;
            }

        } while (op >= 1 && op < 4);

    }

    public static int menuMain() {
        System.out.println("---Aplicación de Facturación-----");
        System.out.println("1. Modulo de Cliente");
        System.out.println("2. Modulo de Producto");
        System.out.println("3. Modulo de Factura");
        System.out.println("4. Salir:");
        return leer.nextInt();
    }
}