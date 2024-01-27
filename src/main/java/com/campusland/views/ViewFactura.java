package com.campusland.views;

import com.campusland.respository.models.Factura;
import com.campusland.respository.models.Producto;

public class ViewFactura extends ViewMain{


    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    //crearProducto();
                    break;
                case 2:
                    listarFactura();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }


    public static int mostrarMenu() {
        System.out.println("----Menu--Factura----");
        System.out.println("1. Crear factura.");
        System.out.println("2. Listar factura.");      
        System.out.println("3. Salir ");
        return leer.nextInt();
    }

    public static void listarFactura() {
        System.out.println("Lista de Facturas");
        for (Factura factura : serviceFactura.listar()) {
            factura.display();
            System.out.println();
        }
    }
    
}
