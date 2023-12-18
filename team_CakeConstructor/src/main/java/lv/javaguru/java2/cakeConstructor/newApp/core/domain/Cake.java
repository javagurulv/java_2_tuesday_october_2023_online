package lv.javaguru.java2.cakeConstructor.newApp.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cakes")
public class Cake {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cake_name", nullable = false)
    private String cakeName;

    @Column(name="weight", nullable = false)
    private double weight;

    public Cake() { }

    public Cake(Long id, String cakeName, double weight) {
        this.id = id;
        this.cakeName = cakeName;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cake cake)) return false;
        return Double.compare(getWeight(), cake.getWeight()) == 0 && Objects.equals(getId(), cake.getId()) && Objects.equals(getCakeName(), cake.getCakeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCakeName(), getWeight());
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", cakeName='" + cakeName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
