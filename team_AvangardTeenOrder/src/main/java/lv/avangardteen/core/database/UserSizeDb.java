package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.UserSizes;

import java.util.List;

public interface UserSizeDb {

    List<UserSizes> getUserSizesOrders();
    void addUserSize(UserSizes userSizes);

    UserSizes getUserSizeByClientId(Long id);


}
