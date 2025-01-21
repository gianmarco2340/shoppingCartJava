package shop;

public class ClothingItem {

    //Declaracion de los atributos
    private String name;
    private double price;
    private char size;

    public static int clothingNum = 0;


    //Constructor de ClothingItem

    public ClothingItem(String name, double price, char size){
        this.name = name;
        if(price<0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.price = price;
        if(!(size == 'S' || size == 'M' || size == 'L')){
            this.size = 'M';
        }else{
            this.size = size;
        }
    }

    //Sobrecarga
    public ClothingItem(String name, char size){
        this.name = name;
        this.price = 0;
        if(!(size == 'S' || size == 'M' || size == 'L')){
            this.size = 'M';
        }else{
            this.size = size;
        }
    }


    //Funciones consultoras y modificadoras

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if(price < 0){
            System.out.println(Inventory.ANSI_RED+"El precio no puede ser negativo."+Inventory.ANSI_RESET);
        }else{
            this.price = price;
        }
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        if(!(size == 'S' || size == 'M' || size == 'L')){
            this.size = 'M';
        }else{
            this.size = size;
        }
    }

    //Sobrecarga toString()
    @Override
    public String toString(){
        return "Nombre: " + name  + " ~ Precio: " + price + " ~ Tamaño: " + size;
    }

}
