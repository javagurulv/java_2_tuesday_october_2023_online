package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import org.hibernate.query.Query;

import java.util.List;

public interface UserSizeDb {

    List<UserSizes> getUserSizesOrders();
    void addUserSize(UserSizes userSizes);
    void updateUserSize(Long id, UserSizes userSizes);
    UserSizes getUserSizeByOrderId(Long id);
    void setOrderId(Long orderId);
   /* void setClientId(Query query);*/
}
