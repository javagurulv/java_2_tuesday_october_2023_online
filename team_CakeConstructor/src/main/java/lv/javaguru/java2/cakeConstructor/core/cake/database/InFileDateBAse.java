package lv.javaguru.java2.cakeConstructor.core.cake.database;

import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileDateBAse implements DateBaseIf {
    private List<Cake> cakes = new ArrayList<>();

    private String file;

    public InFileDateBAse () {
        this.file = "C:\\Users\\ArchAtalar\\javaLab\\java_2_tuesday_october_2023_online\\team_CakeConstructor\\src\\main\\java\\lv\\javaguru\\java2\\cakeConstructor\\core\\cake\\database\\cake";
    }

    @Override
    public void add(Cake cake1) {
        List<Cake> cakes = getAllCake();
        cakes.add(cake1);
        saveCake(cakes);

    }

    @Override
    public List<Cake> getCakesForClient(String clientLogin) {
        return getCakesForClient(clientLogin);
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
