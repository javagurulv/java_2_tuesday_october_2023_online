import java.util.Objects;

public class Product {

    private String productName;
    private Long productID;

    public Product(String productName, Long productID) {
        this.productName = productName;
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProductID(), product.getProductID());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getProductID());
    }
}

