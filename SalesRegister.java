package sales;
import shop.Inventory;
public class SalesRegister {
    long numVeces;

    public String busqueda(Inventory n, String name, char size){
        //Buscar el producto
        int posicion = n.busqueda(name, size);
        if(posicion == -1){
            System.out.println(Inventory.ANSI_RED+"\nPrenda no encontrada."+Inventory.ANSI_RESET);
        }
        return n.toString();
    }
    public int ventasProcess(Inventory n, String name, char size) {
        int posicion = n.busqueda(name, size);
        if (posicion != -1) {
            n.eliminePrenda(name, size);
            System.out.println(Inventory.ANSI_GREEN+"\nVenta realizada!"+Inventory.ANSI_RESET);
            numVeces++;
        }
        return (int)numVeces;
    }
    public long getNumVeces(){
        return numVeces;
    }

}
