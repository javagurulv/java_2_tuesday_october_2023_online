package lv.javaguru.java2.cakeConstructor.newApp.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="type", nullable = false)
    private String type;
    @Column(name="taste", nullable = false)
    private String taste;

    public Ingredient() { }

    public Ingredient(String type, String taste) {
        this.type = type;
        this.taste = taste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }


    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(taste, that.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, taste);
    }



}

