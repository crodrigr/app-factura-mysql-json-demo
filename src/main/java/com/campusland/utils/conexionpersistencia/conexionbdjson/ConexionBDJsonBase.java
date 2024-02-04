package com.campusland.utils.conexionpersistencia.conexionbdjson;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class ConexionBDJsonBase<T> {

    private final String NOMBRE_FILE;

    protected List<T> listaElementos;

    protected ConexionBDJsonBase(String nombreFile) {
        NOMBRE_FILE = nombreFile;
        listaElementos = new ArrayList<>();
    }

    public List<T> getData(Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (!objectMapper.getRegisteredModuleIds().contains(JavaTimeModule.class.getName())) {
            objectMapper.registerModule(new JavaTimeModule());
        }
    
        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            listaElementos = objectMapper.readValue(new File(NOMBRE_FILE), type);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaElementos;
    }

    public void saveData(List<T> listUpdate) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            objectMapper.writeValue(new File(NOMBRE_FILE), listUpdate);
            System.out.println("Se guardaron los elementos en " + NOMBRE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
