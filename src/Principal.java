import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMonedas consulta = new ConsultarMonedas();
        System.out.println("******************************");
        System.out.println("Escriba la moneda base");
        System.out.println("USD(Estado Unidos), ARS(Peso Argentino), BOB(Boliviano), GTQ(Guatemala Quetzal), JPY(Yen Japones) ");
        try {
            var monedas1 = String.valueOf(lectura.nextLine());

            System.out.println("Escriba la monde que deseea convertir");
            System.out.println("USD(Estado Unidos), ARS(Peso Argentino), BOB(Boliviano), GTQ(Guatemala Quetzal), JPY(Yen Japones) ");
            var monedas2 = String.valueOf(lectura.nextLine());

            System.out.println("escriba la cantidad");
            var cantidad = Integer.valueOf(lectura.nextLine());
            MonedasApi moneda = consulta.convertir(monedas1,monedas2,cantidad);
            System.out.println("La cantida de "+ cantidad +"-" + moneda.base_code()+ " a la moneda de " + moneda.target_code() + " es de Resultado: "+moneda.conversion_result() + " Tasa de conversion: " + moneda.conversion_rate());


        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
