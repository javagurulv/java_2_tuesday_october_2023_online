package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.*;
import lv.avangardteen.core.service.WheelchairComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
public class DataOrders implements Database {
    private Long nextId = 1L;
    List<Client> clients = new ArrayList<>();
    List<UserSizes> userSizesOrders = new ArrayList<>();
    List<Wheelchair> usersWheelchairs = new ArrayList<>();
    List<WheelchairComponent> userChooseComponents = new ArrayList<>();


    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public List<UserSizes> getUserSizesOrders() {
        return userSizesOrders;
    }

    @Override
    public List<Wheelchair> getUserWheelchair() {
        return usersWheelchairs;
    }

    @Override
    public List<WheelchairComponent> getUserChooseComponents() {
        return userChooseComponents;
    }

    @Override
    public void addUser(Client client) {
        client.setId(nextId);
        nextId++;
        clients.add(client);
    }


    @Override
    public void addUserSize(UserSizes userSizes) {
        userSizes.setId(nextId - 1);

        userSizesOrders.add(userSizes);
    }

    @Override
    public void addWheelchair(Wheelchair wheelchair) {
        wheelchair.setId(nextId - 1);

        usersWheelchairs.add(wheelchair);
    }

    @Override
    public void addWheelchairComponents(WheelchairComponent wheelchairComponent) {
        wheelchairComponent.setId(nextId - 1);
        userChooseComponents.add(wheelchairComponent);

    }

    @Override
    public void updateUser(Long id, Client updateClient) {
        List<Client> clientList = getClients();
        for (int i = 0; i < clientList.size(); i++) {
            if (clients.get(i).getId() == id) {
                updateClient.setId(clientList.get(i).getId());
                clients.set(i, updateClient);
            }
        }
    }

    @Override
    public void updateUserSize(Long id, UserSizes updateUserSizes) {
        List<UserSizes> userSizesList = getUserSizesOrders();
        for (int i = 0; i < userSizesList.size(); i++) {
            if (userSizesList.get(i).getId() == id) {
                updateUserSizes.setId(userSizesList.get(i).getId());
                userSizesList.set(i, updateUserSizes);
            }
        }

    }

    @Override
    public void updateWheelchair(Long id, Wheelchair updateWheelchair) {
        List<Wheelchair> wheelchairList = getUserWheelchair();
        for (int i = 0; i < wheelchairList.size(); i++) {
            if (wheelchairList.get(i).getId() == id) {
                updateWheelchair.setId(wheelchairList.get(i).getId());
                wheelchairList.set(i, updateWheelchair);
            }
        }
    }

    @Override
    public void updateWheelchairComponents(Long id, WheelchairComponent updateWheelchairComponent) {
        List<WheelchairComponent> wheelchairComponentList = getUserChooseComponents();
        for (int i = 0; i < wheelchairComponentList.size(); i++) {
            if (wheelchairComponentList.get(i).getId() == id) {
                updateWheelchairComponent.setId(wheelchairComponentList.get(i).getId());
                wheelchairComponentList.set(i, updateWheelchairComponent);
            }
        }
    }

    @Override
    public boolean deleteClientById(Long id) {

        return (deleteUserSize(id)
                && deleteWheelchair(id)
                && deleteWheelchairComponents(id));
    }

    private boolean deleteClient(Long id) {
        boolean isClientDelete = false;
        Optional<Client> clientToDelete = clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst();
        if (clientToDelete.isPresent()) {
            Client clientToRemove = clientToDelete.get();
            isClientDelete = clients.remove(clientToRemove);
        }
        return isClientDelete;
    }

    private boolean deleteUserSize(Long id) {
        boolean isUserSizeDelete = false;
        Optional<UserSizes> userSizesToDelete = userSizesOrders.stream()
                .filter(userSizes -> userSizes.getId() == id)
                .findFirst();
        if (userSizesToDelete.isPresent()) {
            UserSizes userSizeToRemove = userSizesToDelete.get();
            isUserSizeDelete = userSizesOrders.remove(userSizeToRemove);
        }
        return isUserSizeDelete;
    }

    private boolean deleteWheelchair(Long id) {
        boolean isWheelchairDelete = false;
        Optional<Wheelchair> wheelchairToDelete = usersWheelchairs.stream()
                .filter(wheelchair -> wheelchair.getId() == id)
                .findFirst();
        if (wheelchairToDelete.isPresent()) {
            Wheelchair wheelchairToRemove = wheelchairToDelete.get();
            isWheelchairDelete = usersWheelchairs.remove(wheelchairToRemove);
        }
        return isWheelchairDelete;
    }

    private boolean deleteWheelchairComponents(Long id) {
        boolean isWheelchairComponentsDelete = false;
        Optional<WheelchairComponent> wheelchairComponentsToDelete = userChooseComponents.stream()
                .filter(wheelchairComponent -> wheelchairComponent.getId() == id)
                .findFirst();
        if (wheelchairComponentsToDelete.isPresent()) {
            WheelchairComponent wheelchairComponentsToRemove = wheelchairComponentsToDelete.get();
            isWheelchairComponentsDelete = userChooseComponents.remove(wheelchairComponentsToRemove);
        }
        return isWheelchairComponentsDelete;
    }

    @Override
    public Client getClient(Long id) {
        List<Client> clientList = getClients();
        Client clientSearch = null;
        for (Client client : clientList) {
            if (client.getId() == id) {
                clientSearch = client;
            }
        }
        return clientSearch;

    }

    @Override
    public UserSizes getUserSize(Long id) {
        List<UserSizes> userSizesList = getUserSizesOrders();
        UserSizes userSizesSearch = null;
        for (UserSizes userSizes : userSizesList) {
            if (userSizes.getId() == id) {
                userSizesSearch = userSizes;
            }
        }
        return userSizesSearch;
    }

    @Override
    public Wheelchair getWheelchair(Long id) {
        List<Wheelchair> wheelchairList = getUserWheelchair();
        Wheelchair wheelchairSearch = null;
        for (Wheelchair wheelchair : wheelchairList) {
            if (wheelchair.getId() == id) {
                wheelchairSearch = wheelchair;
            }
        }
        return wheelchairSearch;
    }

    @Override
    public WheelchairComponent getWheelchairComponents(Long id) {
        List<WheelchairComponent> wheelchairComponentList = getUserChooseComponents();
        WheelchairComponent wheelchairComponentSearch = null;
        for (WheelchairComponent wheelchairComponent : wheelchairComponentList) {
            if (wheelchairComponent.getId() == id) {
                wheelchairComponentSearch = wheelchairComponent;
            }
        }
        return wheelchairComponentSearch;
    }


    @Override
    public Client findBySurnameAndPersonalCode(String surname, Long personalCode) {
        return getClients().stream()
                .filter(client -> client.getNameSurname().equals(surname))
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst().get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataOrders that = (DataOrders) o;
        return Objects.equals(nextId, that.nextId) && Objects.equals(clients, that.clients) && Objects.equals(userSizesOrders, that.userSizesOrders) && Objects.equals(usersWheelchairs, that.usersWheelchairs) && Objects.equals(userChooseComponents, that.userChooseComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextId, clients, userSizesOrders, usersWheelchairs, userChooseComponents);
    }

    @Override
    public String toString() {
        return "DataOrders{" +
                "nextId=" + nextId +
                ", clients=" + clients +
                ", userSizesOrders=" + userSizesOrders +
                ", usersWheelchairs=" + usersWheelchairs +
                ", userChooseComponents=" + userChooseComponents +
                '}';
    }
}
