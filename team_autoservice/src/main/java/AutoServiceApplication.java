import java.util.*;

public class AutoServiceApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static int selectedOptionId;
    private static final HashMap<Integer, Mechanic> mechanics = new HashMap<>();
    private static final List<Appointment> appointments = new ArrayList<>();
    private static Mechanic selectedMechanic;

    public static void main(String[] args) {
        mechanics.put(1, new Mechanic("Mechanic", "One"));
        mechanics.put(2, new Mechanic("Mechanic", "Two"));
        mechanics.put(3, new Mechanic("Mechanic", "Three"));

        appointments.add(new Appointment(mechanics.get(1), new Date(), false));

        System.out.println("Welcome to the auto service application!");

        while(true) {
            System.out.println("Following options are available:");
            System.out.println("1. Mechanics list");
            System.out.println("2. Exit application");

            System.out.print("Select option: ");
            selectedOptionId = Integer.parseInt(scanner.nextLine());

            switch (selectedOptionId) {
                case 1:
                    printMechanicsList();
                    selectedMechanic = selectMechanic();

                    printMechanicAppointmentList(selectedMechanic);
                    bookAppointment();
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void printMechanicsList() {
        System.out.println("List of mechanics:");
        mechanics.forEach((id, mechanic) -> {
            System.out.println(id + ". " + mechanic.getName() + " " + mechanic.getSurname());
        });
    }

    private static Mechanic selectMechanic() {
        System.out.print("Select one of mechanics: ");
        selectedOptionId = Integer.parseInt(scanner.nextLine());

        if(!mechanics.containsKey(selectedOptionId)) {
            return selectMechanic();
        }

        return mechanics.get(selectedOptionId);
    }

    private static void printMechanicAppointmentList(Mechanic mechanic) {
        System.out.println("List of mechanic's available appointments:");

        for(Appointment appointment : appointments) {
            if(appointment.getMechanic().equals(selectedMechanic)) {
                System.out.println(appointments.indexOf(appointment) + ". " + appointment.getDate() + " (Is Taken: " + appointment.getStatus() + ")");
            }
        }
    }

    private static void bookAppointment() {
        System.out.print("Select one of available times: ");
        selectedOptionId = Integer.parseInt(scanner.nextLine());

        if(appointments.size() <= selectedOptionId) {
            bookAppointment();
            return;
        }

        Appointment appointment = appointments.get(selectedOptionId);
        if(appointment.getMechanic() != selectedMechanic || appointment.getStatus()) {
            bookAppointment();
            return;
        }

        appointment.setStatus(true);
        System.out.println("You have successfully reserved an appointment");
    }
}
