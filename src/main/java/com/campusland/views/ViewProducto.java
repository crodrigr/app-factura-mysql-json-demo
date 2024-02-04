package com.campusland.views;

import com.campusland.exceptiones.productoexceptions.ProductoNullException;
import com.campusland.respository.models.Producto;

public class ViewProducto extends ViewMain {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    listarProducto();
                    break;
                case 3:                   
                    buscarProducto();
                    break;
                case 4:
                    modificarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Producto----");
        System.out.println("1. Crear producto.");
        System.out.println("2. Listar producto.");
        System.out.println("3. Buscar producto.");
        System.out.println("4. Modificar producto.");
        System.out.println("5. Eliminar producto.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearProducto() {
        leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Precio venta:");
        double venta = leer.nextDouble();
        System.out.print("Precio compra: ");
        double compra = leer.nextDouble();
        System.out.print("Descripcion: ");
        String descripcion=leer.nextLine();
        serviceProducto.crear(new Producto(nombre, venta, compra,descripcion));

    }

    public static void listarProducto() {
        System.out.println("Lista de Productos");
        for (Producto producto : serviceProducto.listar()) {
            System.out.println(producto.toString());
            System.out.println();
        }
    }

    public static void buscarProducto() {  
        System.out.println("Busqueda de producto ");      
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        try {
            Producto producto = serviceProducto.porCodigo(codigo);
            System.out.println();
            System.out.println(producto.toString());
        } catch (ProductoNullException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Producto buscarGetProducto() {
        System.out.println("Busqueda de producto ");
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        try {
            return serviceProducto.porCodigo(codigo);

        } catch (ProductoNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    public static void modificarProducto() {
        Producto productoActual = buscarGetProducto();
        leer.nextLine();
        if (productoActual != null) {
            System.out.println();
            productoActual.toString();

            System.out.println("Modificar nombre: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre: ");
                String nuevoNombre = leer.nextLine();
                productoActual.setNombre(nuevoNombre);
            }
            System.out.println("Modificar precio venta: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Precio venta: ");
                double precioVenta = leer.nextDouble();
                productoActual.setPrecioVenta(precioVenta);
            }
            leer.nextLine();
            System.out.println("Modificar precio compra: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Precio compra: ");
                double precioCompra = leer.nextDouble();
                productoActual.setPrecioCompra(precioCompra);
            }
            leer.nextLine();
            System.out.println("Descripción: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Descripción: ");
                String descripcion = leer.nextLine();
                productoActual.setDescripcion(descripcion);
            }

            serviceProducto.editar(productoActual);
        }
    }

    public static void eliminarProducto() {       
        Producto producto = buscarGetProducto();
        if (producto != null) {
            serviceProducto.eliminar(producto);
            System.out.println("El producto se elmino correctamente ");
        } else {
            System.out.println("Se presento un proplema y no se puedo eliminar el producto ");
        }

    }





}
