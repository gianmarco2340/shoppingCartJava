package shop;

public class Inventory {

    private ClothingItem[] items;
    private int numItems = 0;

    //MAX_SIZE controla la cantidad maxima de prendas que podemos tener dentro del array.
    private final int MAX_SIXE;

    //Constructor
    public Inventory(int MAX_SIXE){
        this.MAX_SIXE = MAX_SIXE;
        this.items = new ClothingItem[MAX_SIXE];
    }
    //Colores
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_MAGENTA ="\u001b[35m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_RESET = "\u001b[0m";




    //Metodo que devuelve cuantos items hay en el inventario
    public int returnItems(int itemLength){
        return itemLength;
    }

    //Metodo que añade prendas en el inventario
    public void addItems(String nombre, char tamanio){
        //Si no hay más sitio
        if(numItems != MAX_SIXE){
            items[numItems] = new ClothingItem(nombre,tamanio);
            numItems++;
        }else{
            System.out.println(ANSI_RED+"Inventario lleno, no podemos adicionar mas prendas."+ANSI_RESET);
        }
    }
    //Sobrecarga
    public void addItems(ClothingItem item){
        //Si no hay más sitio
        if(numItems != MAX_SIXE){
            int position = busqueda(item.getName(), item.getSize());
            //Si la prenda ya está en el inventario
            if(position == -1){
                items[numItems] = item;
                numItems++;
                System.out.println("\n"+ANSI_GREEN+ item + " --> añadido al inventario!."+ANSI_RESET);
            }else{
                System.out.println("\n"+ANSI_RED+"El inventario ya cuenta con esa prenda."+ANSI_RESET);
            }
        }else{
            System.out.println("\n"+ANSI_RED+"Inventario lleno, no podemos adicionar mas prendas."+ANSI_RESET);
        }
    }

    //Metodo de busqueda
    public int busqueda(String nombre, char tamaño){
        for(int i = 0; i < numItems; i++){
            if(items[i].getName().equals(nombre) && items[i].getSize() == tamaño){
                return i;
            }
        }
        return -1;
    }

    //Metodo que permite saber si hay stock de una prenda dado el nombre y el tamaño
    public void stock(String nombre, char tamaño){
        int numPrendas = 0;
        for(int i = 0; i < numItems; i++){
            if(items[i].getName().equals(nombre) && items[i].getSize() == tamaño){
                numPrendas++;
            }
        }
        System.out.println("Stock de prenda " + nombre + " con tamaño " + tamaño + ": " + numPrendas);

    }

    //Metodo que elimine prenda
    public void eliminePrenda(String name, char size){
        //Comprobamos que haya prendas en el inventario
        if(numItems != 0) {
            int position = busqueda(name, size);
            //Comprobamos que exista la prenda
            if (position != -1) {
                for (int i = position; i < numItems-1; i++) {
                    items[i] = items[i+1];
                }
                numItems--;
            } else {
                System.out.println(ANSI_RED+"Elemento no encontrado en stock."+ANSI_RESET);
            }
        }else{
            System.out.println(ANSI_RED+"Todavía no hay prendas en el inventario."+ANSI_RESET);
        }
    }

    public void mostrarTodo(){
        System.out.println("\n---------------------------------------------");
        System.out.print(ANSI_MAGENTA);
        for(int i = 0; i<numItems; i++){
            System.out.println(items[i]);
        }
        System.out.print(ANSI_RESET);
        System.out.print("---------------------------------------------");

    }

    //Metodo que busque y devuelva la prenda
    public void buscar(String nombre, char tamaño){
        for(int i = 0; i < numItems; i++){
            if(items[i].getName().equals(nombre) && items[i].getSize() == tamaño){
                System.out.println("Item encontrado: " + items[i]);
            }
        }

    }

    //Sobrecarga toString();
    @Override
    public String toString(){
        return "Inventory => Item Length: " + ANSI_MAGENTA + numItems + ANSI_RESET +", " +
                "Max Size = " + ANSI_MAGENTA + MAX_SIXE + ANSI_RESET;
    }

}
