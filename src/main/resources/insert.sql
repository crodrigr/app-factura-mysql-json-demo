-- Insertar clientes
INSERT INTO cliente (nombre, apellido, email, direccion, celular, documento) 
VALUES
('Juan', 'Perez', 'jperez@gmail.com', 'Calle 123', '31448975', '1001'),
('Maria', 'Lopez', 'mlopez@gmail.com', 'Avenida 456', '31567890', '1002'),
('Carlos', 'Gomez', 'cgomez@gmail.com', 'Carrera 789', '31789012', '1003'),
('Laura', 'Martinez', 'lmartinez@gmail.com', 'Calle 567', '31890123', '1004'),
('Pedro', 'Rodriguez', 'prodriguez@gmail.com', 'Calle 890', '31901234', '1005');

-- Insertar productos
INSERT INTO producto (nombre, descripcion, precioVenta, precioCompra) 
VALUES
('Producto1', 'Descripción del Producto 1', 50.00, 30.00),
('Producto2', 'Descripción del Producto 2', 40.00, 25.00),
('Producto3', 'Descripción del Producto 3', 60.00, 35.00),
('Producto4', 'Descripción del Producto 4', 70.00, 45.00),
('Producto5', 'Descripción del Producto 5', 55.00, 30.00),
-- ... Agrega más productos según sea necesario
('Producto18', 'Descripción del Producto 18', 65.00, 40.00),
('Producto19', 'Descripción del Producto 19', 80.00, 50.00),
('Producto20', 'Descripción del Producto 20', 75.00, 48.00);

-- Insertar facturas
INSERT INTO factura (fecha, cliente_id) 
VALUES
('2024-01-15 10:00:00', 1),
('2024-01-16 11:30:00', 2),
('2024-01-17 14:45:00', 3),
('2024-01-18 09:15:00', 4),
('2024-01-19 16:20:00', 5),
('2024-01-23 13:10:00', 1),
('2024-01-25 15:30:00', 2),
('2024-01-27 18:00:00', 3),
('2024-01-29 10:45:00', 4),
('2024-01-31 12:25:00', 5);

-- Insertar items de factura
INSERT INTO item_factura (factura_numeroFactura, producto_codigo, cantidad, importe) 
VALUES
(1, 1, 2, 100.00),
(1, 2, 3, 120.00),
(2, 3, 1, 60.00),
(2, 4, 2, 130.00),
(3, 5, 1, 55.00),
(8, 6, 2, 120.00),
(9, 7, 3, 195.00),
(10, 8, 1, 75.00);


