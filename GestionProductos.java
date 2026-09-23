import java.util.Scanner;
public class GestionProductos{

    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        //Instancia principal de producto para demostracion del sistema

        Producto productoActual=null;

        //Variables de control, contadores y acumuladores

        int opcion=0;
        int contadorVentas=0;
        double acumuladorVentasTotales=0.0;
        do{
            System.out.println("\n========================================");
                System.out.println(" Sistema de control de productos v1.0");

            System.out.println("\n========================================");
                System.out.println("1.Registrar o Reemplazar Producto");
                System.out.println("2. Ver informacion del Producto");
                System.out.println("3. Validar Stock Disponible");
                System.out.println("4. Vender/Salida de Producto");
                System.out.println("5. Reabastecer Stock de Producto");
                System.out.println("6. Ver Resumen General y Metricas");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion(1-7):");

                if(teclado.hasNextInt()){
                    opcion=teclado.nextInt();
                    teclado.nextLine(); //Limpiar el bufer
                } else {
                    System.out.println("\n[ERROR] Debe ingresar un número entero válido.");
                    teclado.nextLine(); //Limpiar entrada erronea
                    continue;
                }

                switch (opcion){
                    case 1:
                        System.out.println("\n--- REGISTRO DE PRODUCTO ---");
                        System.out.println("Ingrese el codigo del producto");
                        int cod=teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Ingrese el nombre del producto: ");
                        String nom = teclado.nextLine();

                        System.out.print("Ingrese el precio unitario (S/): ");
                        double prec = teclado.nextDouble();

                        System.out.print("Ingrese el stock inicial: ");
                        int st = teclado.nextInt();

                        //Creacion del objeto Producto mediante el constructor parametrizado

                        productoActual = new Producto(cod, nom, prec, st);
                        System.out.println("\n[ÉXITO] Producto registrado correctamente.");
                        break;

                    case 2:
                        System.out.println("\n--- INFORMACIÓN DEL PRODUCTO ---");
                        if (productoActual == null) {
                        System.out.println("[ALERTA] Aún no se ha registrado ningún producto.");
                        } else {
                        productoActual.mostrarInformacion();
                        }
                        break;

                    case 3:
                        System.out.println("\n--- VALIDACIÓN DE STOCK ---");
                        if (productoActual == null) {
                        System.out.println("[ALERTA] Aún no se ha registrado ningún producto.");
                        } else {
                        System.out.print("Ingrese la cantidad requerida para verificar: ");
                        int cantVerificar = teclado.nextInt();

                        if (productoActual.validarStock(cantVerificar)) {
                            System.out.println("[OK] ¡Hay suficiente stock! Se pueden atender " + cantVerificar + " unidades.");
                        } else  {
                            System.out.println("[RECHAZADO] Stock insuficiente. Disponible actual: " + productoActual.stock);
                                }
                        }
                        break;

                    case 4:
                        System.out.println("\n--- REGISTRAR VENTA ---");
                        if (productoActual == null) {
                            System.out.println("[ALERTA] Aún no se ha registrado ningún producto.");
                        } else {
                            System.out.print("Ingrese la cantidad a vender: ");
                            int cantVenta = teclado.nextInt();

                        if (productoActual.validarStock(cantVenta)) {
                            productoActual.actualizarStock(-cantVenta); // Disminuir stock
                            double subtotal = cantVenta * productoActual.precio;
                            
                            // Actualización de contador y acumulador
                            contadorVentas++; 
                            acumuladorVentasTotales += subtotal;

                            System.out.println("[VENTA EXITOSA]");
                            System.out.println("Monto de la transacción: S/ " + subtotal);
                            System.out.println("Nuevo stock disponible: " + productoActual.stock);
                        } else  {
                            System.out.println("[ERROR] No se pudo realizar la venta por falta de stock.");
                                }
                        }
                        break;

                    case 5:
                        System.out.println("\n--- REABASTECER STOCK ---");
                        if (productoActual == null) {
                            System.out.println("[ALERTA] Aún no se ha registrado ningún producto.");
                        } else {
                            System.out.print("Ingrese la cantidad de unidades que ingresan al inventario: ");
                            int cantIngreso = teclado.nextInt();

                        if (cantIngreso > 0) {
                            productoActual.actualizarStock(cantIngreso); // Aumentar stock
                            System.out.println("[ÉXITO] Stock actualizado. Nuevo stock: " + productoActual.stock);
                        } else  {
                            System.out.println("[ERROR] La cantidad ingresada debe ser mayor a 0.");
                                }
                        }
                        break;

                    case 6:
                        System.out.println("\n--- RESUMEN GENERAL Y MÉTRICAS ---");
                        Producto.mostrarTotalRegistrados();
                        System.out.println("Ventas realizadas en sesión : " + contadorVentas);
                        System.out.println("Monto total recaudado       : S/ " + acumuladorVentasTotales);
                        if (productoActual != null) {
                            System.out.println("Valor total del inventario  : S/ " + productoActual.calcularValorTotalInventario());
                        }
                        break;

                    case 7:
                    System.out.println("\nSaliendo del programa... ¡Gracias por utilizar el sistema!");
                    break;

                    default:
                        System.out.println("\n[ERROR] Opción inválida. Intente de nuevo.");
                }
            } while (opcion != 7);
            teclado.close();
                
        
    }
}