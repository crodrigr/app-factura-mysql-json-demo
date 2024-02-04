package com.campusland.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formato {

    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final Locale COLOMBIA_LOCAL = new Locale("es", "CO");

    private Formato() {
    }

    public static String formatoFechaHora(LocalDateTime localDateTime) {
        return (localDateTime != null) ? localDateTime.format(FORMATO_FECHA_HORA) : "";
    }

    public static String formatoMonedaPesos(double monto) {
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(COLOMBIA_LOCAL);
        return formatoMoneda.format(monto);
    }

    public static LocalDateTime convertirTimestampFecha(Timestamp timestamp) {
        return (timestamp != null) ? timestamp.toLocalDateTime() : null;
    }

    public static Date convertirLocalDateTimeSqlDate(LocalDateTime fechaFactura) {
        return (fechaFactura != null) ? Date.valueOf(fechaFactura.toLocalDate()) : null;
    }
}
