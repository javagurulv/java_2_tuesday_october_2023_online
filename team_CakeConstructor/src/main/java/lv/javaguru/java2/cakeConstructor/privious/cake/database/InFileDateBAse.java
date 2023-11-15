package lv.javaguru.java2.cakeConstructor.privious.cake.database;

import lv.javaguru.java2.cakeConstructor.privious.cake.domain.Cake;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileDateBAse implements DateBaseIf {
    private List<Cake> cakes = new ArrayList<>();

    private String file;

    public InFileDateBAse () {
        this.file = "databases/cake";
    }

    @Override
    public void add(Cake cake1) {
        cakes.add(cake1);
        saveCake();

    }

    @Override
    public List<Cake> getCakesForClient(String clientLogin) {
        return getCakesForClient(clientLogin);
    }

    public List<Cake> getAllCake() {
        // каждый должен забить свой путь к файлу
        String absolutePath = "C:\\Users\\ArchAtalar\\javaLab\\java_2_tuesday_october_2023_online\\team_CakeConstructor\\src\\main\\resources\\databases\\cake";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(absolutePath))) {
            cakes = (List<Cake>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cakes;
    }

    public void saveCake() {
        // каждый должен забить свой путь к файлу
        String absolutePath = "C:\\Users\\ArchAtalar\\javaLab\\java_2_tuesday_october_2023_online\\team_CakeConstructor\\src\\main\\resources\\databases\\cake";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(absolutePath))){
            oos.writeObject(cakes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

