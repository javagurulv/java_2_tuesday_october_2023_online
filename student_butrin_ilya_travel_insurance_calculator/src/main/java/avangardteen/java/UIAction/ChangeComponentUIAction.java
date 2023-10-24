package avangardteen.java.UIAction;

import avangardteen.java.Category;
import avangardteen.java.Component;
import avangardteen.java.data.DataComponents;
import avangardteen.java.Wheelchair;
import avangardteen.java.service.ChangeComponentServise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChangeComponentUIAction implements UIAction {
ChangeComponentServise changeComponentServise;

    public ChangeComponentUIAction(ChangeComponentServise changeComponentServise) {
        this.changeComponentServise = changeComponentServise;
    }

    @Override
    public void execute() {
        System.out.println("какой из параметров вы хотите изменить?");
        changeComponentServise.showAllComponent();
        System.out.println("Выбор параметра:");
        changeComponentServise.chooseNewComponent();
    }
}
