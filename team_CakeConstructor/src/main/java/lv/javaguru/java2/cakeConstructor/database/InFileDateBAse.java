package lv.javaguru.java2.cakeConstructor.database;

import lv.javaguru.java2.cakeConstructor.domain.Cake;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileDateBAse implements DateBaseIf {

    private String file;

    public InFileDateBAse () {
        this.file = "lv/javaguru/java2/cakeConstructor/database/cake";
    }

    @Override
    public void add(Cake cake1) {
        List<Cake> cakes = getAllCake();
        cakes.add(cake1);
        saveCake(cakes);

    }

    @Override
    public List<Cake> getCakesForClient(int clientId) {
        return getCakesForClient(clientId);
    }

    public List<Cake> getAllCake() {
        List<Cake> cake = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            cake = (List<Cake>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cake;
    }

    public void saveCake(List<Cake> cakes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(cakes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
