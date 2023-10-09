import java.util.Date;
import java.util.Objects;

public class Appointment {
    private Mechanic mechanic;
    private Date date;
    private Boolean isTaken;

    public Appointment(Mechanic mechanic, Date date, Boolean isTaken) {
        this.mechanic = mechanic;
        this.date = date;
        this.isTaken = isTaken;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return isTaken;
    }

    public void setStatus(Boolean taken) {
        isTaken = taken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(mechanic, that.mechanic) && Objects.equals(date, that.date) && Objects.equals(isTaken, that.isTaken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mechanic, date, isTaken);
    }
}
