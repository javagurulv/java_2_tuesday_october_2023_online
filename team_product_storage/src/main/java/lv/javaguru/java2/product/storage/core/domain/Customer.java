package lv.javaguru.java2.product.storage.core.domain;

import java.util.Objects;

public class Customer {

    private Long id;
    private String customerName;
    private String registrationCode;

    public Customer() {
    }

    public Customer(String customerName, String registrationCode) {
        this.customerName = customerName;
        this.registrationCode = registrationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getRegistrationCode(), customer.getRegistrationCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerName(), getRegistrationCode());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + customerName + '\'' +
                ", registrationCode='" + registrationCode + '\'' +
                '}';
    }
}
