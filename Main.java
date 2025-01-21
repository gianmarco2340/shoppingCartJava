package app;

import sales.SalesRegister;
import shop.ClothingItem;
import shop.Inventory;


import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SalesRegister sale = new SalesRegister();
        int n = 0;

        System.out.println(Inventory.ANSI_YELLOW+"\n*** Bienvenido a Strafalarius ***"+Inventory.ANSI_RESET);

        System.out.print("Indica el tamaño del inventario: ");
        int tamanio = sc.nextInt();
        Inventory inv = new Inventory(tamanio);

        double price;
        char size;
        String name;

        do{
            System.out.println(menuIteractivo());
            System.out.print("\nSelecciona una opción: ");

            //En caso de que inserte algo distinto a un número
            try {
                n = sc.nextInt();
                if(!(n == 1 || n == 2 || n == 3 || n== 4 || n == 5)){
                    System.out.println(Inventory.ANSI_RED+"\nOpcion invalida, intentalo de nuevo."+Inventory.ANSI_RESET);
                }
            }catch (Exception e){
                System.out.println(Inventory.ANSI_RED+"\nDebe insertar un número."+Inventory.ANSI_RESET);
                //Vaciamos el salto de linea para poder leer de nuevo los valores tipo String
                sc.nextLine();
            }

            switch(n){
                case 1:
                    agregarItem(sc, inv);
                    break;
                case 2:
                    System.out.print("\n"+inv);
                    inv.mostrarTodo();
                    System.out.println();
                    break;

                case 3:
                    venderItem(sc, sale, inv);
                    break;

                case 4:
                    System.out.println("\nNumero de ventas procesadas: " +
                            Inventory.ANSI_RED + sale.getNumVeces() + Inventory.ANSI_RESET);
                    break;
            }

        }while(n != 5);


    }

    public static void venderItem(Scanner sc, SalesRegister sale, Inventory inv){
        char size;
        String name;

        System.out.print("Ingrese el nombre de la prenda que desean comprar: ");
        name = sc.next();

        System.out.print("Ingrese la talla de la prenda " + name + ": ");
        size = sc.next().toUpperCase().charAt(0);

        sale.busqueda(inv, name, size);
        sale.ventasProcess(inv, name, size);
    }
    public static void agregarItem(Scanner sc, Inventory inv){
        double price;
        char size;
        String name;

        boolean aniadidoCorrectamente = false;
        while(!aniadidoCorrectamente) {
            try {
                System.out.print("Inserta el nombre de la prenda que desea añadir: ");
                name = sc.next();
                System.out.print("Inserta la talla de la prenda que desea añadir: ");
                size = sc.next().toUpperCase().charAt(0);

                System.out.print("Inserta el precio de la prenda que desea añadir: ");
                price = sc.nextDouble();

                System.out.print("");

                ClothingItem item1 = new ClothingItem(name, price, size);
                inv.addItems(item1);

                aniadidoCorrectamente = true;

            } catch (Exception e) {
                System.out.println(Inventory.ANSI_RED+"\nLos valores introducidos son incorrectos.\n" +
                        "Porfavor, introdúcelos de nuevo:\n"+Inventory.ANSI_RESET);

                //Vaciamos el salto de linea para poder leer de nuevo los valores tipo String
                sc.nextLine();
            }
        }
    }

    public static String menuIteractivo(){
        String mensaje =
                "\nMenú de opciones: " + "\n" +
                "-------------------------------\n"+
                Inventory.ANSI_BLUE+
                "1. Añadir prenda al inventario" + "\n" +
                "2. Mostar inventario" + "\n" +
                "3. Vender prenda" + "\n" +
                "4. Ventas procesadas" + "\n" +
                "5. Salir\n" +
                Inventory.ANSI_RESET+
                "-------------------------------";
        return mensaje;
    }
}