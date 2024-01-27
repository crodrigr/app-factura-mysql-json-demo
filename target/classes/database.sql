CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    direccion VARCHAR(255),
    celular VARCHAR(20),
    documento VARCHAR(20) NOT NULL,
    INDEX idx_cliente_documento (documento)
);

CREATE TABLE producto (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precioVenta DECIMAL(10, 2) NOT NULL,
    precioCompra DECIMAL(10, 2) NOT NULL,
    INDEX idx_producto_nombre (nombre)
);

CREATE TABLE factura (
    numeroFactura INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    INDEX idx_factura_cliente (cliente_id)
);

CREATE TABLE item_factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    factura_numeroFactura INT,
    producto_codigo INT,
    cantidad INT NOT NULL,
    importe DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (factura_numeroFactura) REFERENCES factura(numeroFactura),
    FOREIGN KEY (producto_codigo) REFERENCES producto(codigo),
    INDEX idx_item_factura_factura (factura_numeroFactura),
    INDEX idx_item_factura_producto (producto_codigo)
);
