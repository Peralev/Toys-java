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
    static ArrayList<Toy> prizeToys = new ArrayList<Toy>();
    static Random random = new Random(); 

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
    static void choiseToy() {
        int weight = 0;
        for(int i=0; i<toys.size(); i++) {
            weight += toys.get(i).weight;
        }
        
        int number = random.nextInt(weight);

        Toy choose = null;
        for(int i=0; i<toys.size(); i++) {
            number -= toys.get(i).weight;
            if (number >= 0)
                continue;
            choose = toys.get(i);
            break;  
        }
        choose.count += 1;

        prizeToys.add(choose);
    }

    static Toy getToy() {
        if (!prizeToys.isEmpty()) {
            Toy toy = prizeToys.remove(0);
            toy.count -= 1;
            return toy;
        }
        return null;
    }
    
    public static void main(String[] args) {

        addToy(1, "plane", 10);
        addToy(2, "plane2", 20);
        addToy(3, "Bear", 40);
        addToy(4, "Parot", 15);

        for (int i = 0; i < 10; i++) {
            choiseToy();
        }

        for (int i = 0; i < 10; i++) {
            choiseToy();
        }

        PrintWriter writer = null;       
        try {
            writer = new PrintWriter("Prize.txt");
                         
            for (Toy toy = getToy(); toy != null; toy = getToy()) {
                writer.format("name: %s, id: %d, weight: %d, count: %d\n",
                    toy.name, toy.id, toy.weight, toy.count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}