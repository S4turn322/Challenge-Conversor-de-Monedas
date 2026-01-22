import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        String monedaBase = "";
        String monedaDestino = "";
        int opcion = 0;
        ConversorApp conversorApp = new ConversorApp();
        Conversor conversor = new Conversor();

        System.out.println("*********************************\n"+
                            "Bienvenido al conversor de monedas\n");

        while (true) {

            System.out.println("Primero, ingrese la cantidad que quiere convertir: \n");
            var cantidadParaConvertir = Integer.valueOf(lectura.nextLine());

            String text = """
                    Ahora, deberá seleccionar la moneda base, las opciones son: 
                    1 - ARS 
                    2 - USD 
                    3 - BRL
                    4 - Salir
                    """;
            System.out.println(text);

            opcion = Integer.parseInt(lectura.nextLine());

            if (opcion == 4) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (opcion == 1) {
                monedaBase = "ARS";
            } else if (opcion == 2) {
                monedaBase = "USD";
            } else if (opcion == 3) {
                monedaBase = "BRL";
            }

            String text1 = """
                    Ahora deberá seleccionar la moneda a la cual quiere convertir su valor:
                    1 - ARS 
                    2 - USD 
                    3 - BRL
                    4 - Salir
                    """;

            System.out.println(text1);

            opcion = Integer.parseInt(lectura.nextLine());

            if (opcion == 4) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (opcion == 1) {
                monedaDestino = "ARS";
            } else if (opcion == 2) {
                monedaDestino = "USD";
            } else if (opcion == 3) {
                monedaDestino = "BRL";
            }

            System.out.println("Convertir " + cantidadParaConvertir + " " +
                    monedaBase + " a " + monedaDestino);

            try {
                Moneda moneda = conversorApp.conversorDeMoneda(cantidadParaConvertir, monedaBase, monedaDestino);
                System.out.println(moneda);
                double resultadoConversion = conversor.convertir(moneda);
                System.out.println("El resultado de la conversion es: " + resultadoConversion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
