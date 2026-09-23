public class Producto {
    int codigo;
    String nombre;
    double precio;
    int stock;

    //Atributo global de clase
    static int totalProductosRegistrados=0;

    //Constructor sin argumentos

    public Producto(){
        this.codigo=0;
        this.nombre="Sin registrar";
        this.precio=0.0;
        this.stock=0;
        totalProductosRegistrados++;    //Incrementa el contador de clase
    }


    //Constructor parametrizado

    public Producto(int codigo, String nombre, double precio, int stock){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
        totalProductosRegistrados++; //Incrementa el contador de clase
    }

    //Metodo void de instancia para mostrar ficha del producto

    public void mostrarInformacion(){
        System.out.println("----------------");
        System.out.println(" Codigo :" + this.codigo);
        System.out.println(" Nombre :" + this.nombre);
        System.out.println(" Precio :S/" + this.precio);
        System.out.println("Stock   :" + this.stock + "unidades");
        System.out.println("Status  :" + (this.stock >0 ?"Disponible":"Agotado"));
        System.out.println("---------------------");
    }

    //Metodo con retorno boolean para validar disponibilidad de stock

    public boolean validarStock(int cantidadRequerida){
        if(cantidadRequerida<=0){
            return false;
        }
        return this.stock>=cantidadRequerida;
    }

    //Metodo void de instancia para actualizar el stock(despacho o reabastecimiento)

    public void actualizarStock(int cantidad){
        this.stock+=cantidad; // Operador de asignacion compuesta
        if(this.stock<0){
            this.stock=0;
        }
    }

    //Metodo con retorno double para calcular el valor monetario del inventario

    public double calcularValorTotalInventario(){
        return this.precio * this.stock;
    }

    //Metodo estatico para consultar el total de productos instanciados

    public static void mostrarTotalRegistrados(){
        System.out.println("\n[SISTEMA] Total de productos registrados hasta el momento: " + totalProductosRegistrados);
    }

}