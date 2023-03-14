import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


class Toy {

    public String name;
    public int id;
    public int weight;
    public int count; 

    public Toy(String name, int id, int weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.count = 0;
    }   
}

public class Toys {
    static ArrayList<Toy> toys = new ArrayList<Toy>(); 

    static void addToy(int id, String name, int weight) {

        for(int i = 0; i < toys.size();i++) {
            Toy toy = toys.get(i);
            if (toy.id == id) {                
                toy.name = name;
                toy.weight = weight;
                return;
            }
        }

        toys.add(new Toy(name, id, weight));
    }
    
    public static void main(String[] args) {


}
}