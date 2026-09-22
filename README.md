# PA1 - Sistema de Registro y Control de Productos

## Descripción del Trabajo
Este proyecto consiste en un sistema de consola desarrollado en Java para la gestión de inventario de una microempresa. El programa permite el registro de un producto, la consulta de su información técnica, la validación de stock disponible, el registro de ventas (salidas) y el reabastecimiento. La solución aplica estrictamente los fundamentos de Programación Orientada a Objetos correspondientes a las primeras cuatro semanas del curso.

## Integrantes
1. Sebastian Borda Ojeda
2. Adrian Moises Basurco Castro
3. Ammy Angela Gabriela Illescas Carbajal
4. Rodrigo David Sifuentes Alza
5. Jorge Adrian Ismael Illescas Carbajal

## Instrucciones Mínimas de Ejecución
1. Clonar el repositorio en el entorno de desarrollo local.
2. Abrir el proyecto en un IDE (Apache NetBeans, VS Code, IntelliJ, Eclipse, etc.).
3. Asegurarse de tener instalado el JDK (Java Development Kit) versión 8 o superior.
4. Asegurarse de compilar los archivos `Producto.java` y `GestionProductos.java`.
5. Ejecutar el archivo `GestionProductos.java` (contiene el método `main`).
6. Interactuar con el menú numérico ingresando las opciones del 1 al 7 a través de la consola.

## Enlace del Video de Exposición
* 

## Decisiones de Diseño y Modelado de la Solución
Para resolver el caso funcional de forma clara y ordenada, el equipo tomó las siguientes decisiones técnicas:

1. Abstracción del Dominio (Producto.java):
- Se representaron las características principales (`codigo`, `nombre`, `precio`, `stock`) mediante atributos globales de instancia.
- Se aplicó un atributo de clase (`static int totalProductosRegistrados`) para llevar el conteo global de instancias creadas, demostrando el uso de elementos compartidos a nivel de clase.

2. Constructores:
- Se implementaron constructores sin parámetros y parametrizados para brindar flexibilidad en el momento de instanciar los objetos.

3. Métodos:
- Métodos void (`mostrarInformacion`, `actualizarStock`): Utilizados para realizar acciones sin retorno de valor.
- Métodos no void (`validarStock`, `calcularValorTotalInventario`): Utilizados para devolver resultados lógicos (`boolean`) y financieros (`double`).
- Método estático (`mostrarTotalRegistrados`): Permite acceder al atributo de clase sin depender de la lógica particular de una instancia.

4. Estructuras de Control (`GestionProductos.java`):
- Se empleó una estructura `do-while` para mantener activo el menú interactivo.
- Se usó `switch-case` para la selección ordenada de las opciones.
- Se aplicaron variables contador (`contadorVentas++`) y acumulador (`acumuladorVentasTotales += ...`) para registrar el historial de la sesión.
