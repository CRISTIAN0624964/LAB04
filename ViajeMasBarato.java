Proceso SistemaFacturacion
    Definir opcion Como Entero
    Definir sesionActiva Como Booleano
    sesionActiva <- FALSO

    Escribir "=== SISTEMA DE FACTURACIÓN ==="
    Escribir "Ingrese usuario:"
    Leer usuario
    Escribir "Ingrese contraseña:"
    Leer contrasena

    Si Login(usuario, contrasena) Entonces
        sesionActiva <- VERDADERO
    Sino
        Escribir "Credenciales incorrectas."
        FinProceso
    FinSi

    Mientras sesionActiva = VERDADERO
        Escribir "1. Registrar Cliente"
        Escribir "2. Registrar Producto"
        Escribir "3. Crear Factura"
        Escribir "4. Salir"
        Leer opcion

        Segun opcion Hacer
            1:
                Llamar RegistrarCliente
            2:
                Llamar RegistrarProducto
            3:
                Llamar CrearFactura
            4:
                sesionActiva <- FALSO
        FinSegun
    FinMientras

FinProceso

// Función Login
Funcion Login(usuario, contrasena) : Booleano
    // Aquí iría validación contra BD (simulada)
    Si usuario = "admin" Y contrasena = "1234" Entonces
        Login <- VERDADERO
    Sino
        Login <- FALSO
    FinSi
FinFuncion

// Registrar Cliente
SubProceso RegistrarCliente
    Definir nombre, documento, direccion Como Cadena
    Escribir "Ingrese nombre del cliente:"
    Leer nombre
    Escribir "Ingrese N° de documento:"
    Leer documento
    Escribir "Ingrese dirección:"
    Leer direccion

    // Simula guardar cliente
    Escribir "Cliente registrado correctamente."
FinSubProceso

// Registrar Producto
SubProceso RegistrarProducto
    Definir nombreProducto Como Cadena
    Definir precio, stock Como Real
    Escribir "Ingrese nombre del producto:"
    Leer nombreProducto
    Escribir "Ingrese precio:"
    Leer precio
    Escribir "Ingrese stock:"
    Leer stock

    // Simula guardar producto
    Escribir "Producto registrado correctamente."
FinSubProceso

// Crear Factura
SubProceso CrearFactura
    Definir subtotal, igv, total, precioUnitario Como Real
    Definir cantidad Como Entero
    Definir nombreCliente, producto Como Cadena

    Escribir "Ingrese nombre del cliente:"
    Leer nombreCliente
    Escribir "Ingrese nombre del producto:"
    Leer producto
    Escribir "Ingrese cantidad:"
    Leer cantidad
    Escribir "Ingrese precio unitario:"
    Leer precioUnitario

    subtotal <- precioUnitario * cantidad
    igv <- subtotal * 0.18
    total <- subtotal + igv

    Escribir "FACTURA:"
    Escribir "Cliente: ", nombreCliente
    Escribir "Producto: ", producto
    Escribir "Cantidad: ", cantidad
    Escribir "Subtotal: S/", subtotal
    Escribir "IGV (18%): S/", igv
    Escribir "Total a pagar: S/", total
FinSubProceso
