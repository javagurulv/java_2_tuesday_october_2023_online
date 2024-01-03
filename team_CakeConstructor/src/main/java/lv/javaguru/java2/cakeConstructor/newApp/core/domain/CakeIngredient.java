package lv.javaguru.java2.cakeConstructor.newApp.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cake_ingredients")
public class CakeIngredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cake_id", nullable = false)
    private Cake cake;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    public CakeIngredient() {
    }

    public CakeIngredient(Cake cake, Ingredient ingredient, double quantity) {
        this.cake = cake;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CakeIngredient that)) return false;
        return Double.compare(getQuantity(), that.getQuantity()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getCake(), that.getCake()) && Objects.equals(getIngredient(), that.getIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCake(), getIngredient(), getQuantity());
    }

    @Override
    public String toString() {
        return "CakeIngredient{" +
                "id=" + id +
                ", cake=" + cake +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}