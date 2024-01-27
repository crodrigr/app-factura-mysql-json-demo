package com.campusland.respository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemFactura {

    private int cantidad;
    private Producto producto;

    public double getImporte(){
        return this.cantidad*this.producto.getPrecioVenta();
    }


    @Override
    public String toString() {
        return "ItemFactura [cantidad=" + cantidad + ", producto=" + producto.toString() + "]";
    }
    
}
