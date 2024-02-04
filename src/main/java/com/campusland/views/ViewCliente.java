package com.campusland.views;

import com.campusland.exceptiones.clienteexceptions.ClienteNullException;
import com.campusland.respository.models.Cliente;

public class ViewCliente extends ViewMain {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    modificarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarCliente() {
        System.out.println("Busqueda de cliente ");
        leer.nextLine();
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            Cliente cliente = serviceCliente.porDocumento(documento);
            System.out.println();
            cliente.imprimir();
        } catch (ClienteNullException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente buscarGetCliente() {
        System.out.println("Busqueda de cliente "); 
        leer.nextLine();       
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            return serviceCliente.porDocumento(documento);

        } catch (ClienteNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearCliente() {
        leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Email: ");
        String email = leer.nextLine();
        System.out.print("Celular: ");
        String celular = leer.nextLine();
        System.out.print("Dirección: ");
        String direccion = leer.nextLine();
        System.out.print("Documentos: ");
        String documento = leer.nextLine();
        Cliente cliente = new Cliente(nombre, apellido, email, celular, direccion, documento);
        serviceCliente.crear(cliente);

    }

    public static void listarClientes() {
        System.out.println("Lista de Clientes");
        for (Cliente cliente : serviceCliente.listar()) {
            cliente.imprimir();
            System.out.println();
        }
    }

    public static void modificarCliente() {

        Cliente clienteActual = buscarGetCliente();

        if (clienteActual != null) {
            System.out.println();
            clienteActual.imprimir();

            System.out.println("Modificar nombre: si o no? ");
            String opcion = leer.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre: ");
                String nuevoNombre = leer.nextLine();
                clienteActual.setNombre(nuevoNombre);
            }
            System.out.println("Modificar apellido: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Apellido: ");
                String nuevoApellido = leer.nextLine();
                clienteActual.setApellido(nuevoApellido);
            }
            System.out.println("Modificar email: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Email: ");
                String nuevoEmail = leer.nextLine();
                clienteActual.setEmail(nuevoEmail);
            }
            System.out.println("Modificar celular: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Celular: ");
                String nuevoCelular = leer.nextLine();
                clienteActual.setCelular(nuevoCelular);
            }
            System.out.println("Modificar direccion: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Direccion: ");
                String nuevoDireccion = leer.nextLine();
                clienteActual.setDireccion(nuevoDireccion);
            }
            serviceCliente.editar(clienteActual);

        }

    }

    public static void eliminarCliente() {
        Cliente cliente = buscarGetCliente();
        if (cliente != null) {
            serviceCliente.eliminar(cliente);
            System.out.println("Elmininado el cliente con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el cliente");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear cliente.");
        System.out.println("2. Listar cliente.");
        System.out.println("3. Buscar cliente.");
        System.out.println("4. Modificar cliente.");
        System.out.println("5. Eliminar cliente.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

}
