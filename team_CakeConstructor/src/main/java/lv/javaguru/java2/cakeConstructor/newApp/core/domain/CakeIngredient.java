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
    private Double quantity;

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CakeIngredient that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCake(), that.getCake()) && Objects.equals(getIngredient(), that.getIngredient()) && Objects.equals(getQuantity(), that.getQuantity());
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