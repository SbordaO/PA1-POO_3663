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
3. Asegurarse de compilar los archivos `Producto.java` y `GestionProductos.java`.
4. Ejecutar el archivo `GestionProductos.java` (contiene el método `main`).
5. Interactuar con el menú numérico ingresando las opciones del 1 al 7 a través de la consola.

## Enlace del Video de Exposición
* 

## Decisiones de Diseño y Modelado de la Solución
Para resolver el caso funcional de forma clara y ordenada, el equipo tomó las siguientes decisiones técnicas:

* **Separación de Lógica (Clases):** Se dividió la solución en una clase de dominio (`Producto`) que encapsula la lógica de negocio y estado, y una clase ejecutora (`GestionProductos`) encargada del flujo y la interfaz de consola.
* **Atributos Globales y Locales:** Se aislaron las propiedades únicas de cada artículo en atributos de instancia (código, nombre, precio, stock), mientras que se utilizó un atributo de clase (`static int totalProductosRegistrados`) para unificar el conteo global de instancias creadas.
* **Constructores y Métodos:** Se diseñaron constructores parametrizados para la creación íntegra de objetos. Se aplicaron métodos `void` para acciones directas (como actualizar stock) y métodos con retorno (`boolean` y `double`) para validaciones y cálculos matemáticos (como validar disponibilidad o valor de inventario).
* **Estructuras de Control:** La iteración principal se controló mediante un `do-while` para asegurar la carga inicial del menú. La selección de operaciones se estructuró con un `switch-case`, protegido internamente por condicionales `if-else` para evitar excepciones por objetos nulos o stock insuficiente. Para las métricas del negocio se implementaron operadores de incremento en variables contadoras y acumuladoras.