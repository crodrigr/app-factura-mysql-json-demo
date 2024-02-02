package com.campusland.respository.models;

import com.campusland.utils.Formato;

import lombok.Data;

@Data
public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private double precioCompra;
    private static int nextCodigo;

    public Producto() {
        this.codigo = ++nextCodigo;
    }

    

    public Producto(int codigo, String nombre, String descripcion, double precioVenta, double precioCompra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }



    public Producto(String nombre, double precioVenta, double precioCompra, String descripcion) {
        this.codigo = ++nextCodigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.descripcion = descripcion;
    }

    public double getUtilidad() {
        return this.precioVenta - this.precioCompra;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precioVenta=" + Formato.formatoMonedaPesos(precioVenta) + ", precioCompra="
                + Formato.formatoMonedaPesos(precioCompra) + " descripcion=" + descripcion + "]";
    }

    public String getCodigoNombre() {
        return this.codigo + " " + this.nombre + " " + Formato.formatoMonedaPesos(this.precioVenta);
    }

}
