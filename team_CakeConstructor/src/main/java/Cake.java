import java.util.Objects;

public class Cake {

    private int clientId;
    private int typeOfCake;
    private String biscuit;
    private String cakeFilling;

    private String cakeShell;
    private String  cakeDecor;

    public Cake(int clientId, int  typeOfCake, String biscuit, String cakeFilling, String cakeShell, String cakeDecor) {
        this.clientId = clientId;
        this.typeOfCake = typeOfCake;
        this.biscuit = biscuit;
        this.cakeFilling = cakeFilling;
        this.cakeShell = cakeShell;
        this.cakeDecor = cakeDecor;

    }
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTypeOfCake() {
        return typeOfCake;
    }

    public void setTypeOfCake(int typeOfCake) {
        this.typeOfCake = typeOfCake;
    }

    public String getBiscuit() {
        return biscuit;
    }

    public void setBiscuit(String biscuit) {
        this.biscuit = biscuit;
    }

    public String getCakeFilling() {
        return cakeFilling;
    }

    public void setCakeFilling(String cakeFilling) {
        this.cakeFilling = cakeFilling;
    }

    public String getCakeShell() {
        return cakeShell;
    }

    public void setCakeShell(String cakeShell) {
        this.cakeShell = cakeShell;
    }

    public String getCakeDecor() {
        return cakeDecor;
    }

    public void setCakeDecor(String cakeDecor) {
        this.cakeDecor = cakeDecor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return clientId == cake.clientId && typeOfCake == cake.typeOfCake && Objects.equals(biscuit, cake.biscuit) && Objects.equals(cakeFilling, cake.cakeFilling) && Objects.equals(cakeShell, cake.cakeShell) && Objects.equals(cakeDecor, cake.cakeDecor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, typeOfCake, biscuit, cakeFilling, cakeShell, cakeDecor);
    }


    @Override
    public String toString() {
        return "Cake{" +
                "clientId=" + clientId +
                ", typeOfCake=" + typeOfCake +
                ", biscuit='" + biscuit + '\'' +
                ", cakeFilling='" + cakeFilling + '\'' +
                ", cakeShell='" + cakeShell + '\'' +
                ", cakeDecor='" + cakeDecor + '\'' +
                '}';
    }




}
