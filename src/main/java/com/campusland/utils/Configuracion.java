package com.campusland.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {

    private static Properties propiedades;

    static {
        propiedades = new Properties();
        cargarPropiedades();
    }

    private static void cargarPropiedades() {
        try (FileInputStream entrada = new FileInputStream("configuracion.properties")) {
            propiedades.load(entrada);
        } catch (IOException e) {
            e.printStackTrace();
            // Puedes manejar la excepción según tus necesidades
        }
    }

    public static String obtenerValor(String clave) {
        return propiedades.getProperty(clave);
    }
    
}