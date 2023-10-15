import java.util.ArrayList;
import java.util.List;

public class DataBase implements DateBaseIf {
    private List<Cake> cakes = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public void add(Cake cake) {
        cake.setClientId(cake.getClientId());
        cakes.add(cake);
    }

    @Override
    public List<Cake> getCakesForClient(int clientId) {
        List<Cake> cakeForClientId = new ArrayList<>();
        for (Cake cake : cakes) {
            if (clientId == cake.getClientId()) {
                cakeForClientId.add(cake);
            }
        }
        return cakeForClientId;
    }


    @Override
    public List<Cake> getAllCake() {
        return cakes;
    }

    @Override
    public void saveCake(List<Cake> cakes) {
    }
}
