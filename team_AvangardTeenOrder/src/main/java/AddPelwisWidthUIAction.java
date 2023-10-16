import java.util.Scanner;

public class AddPelwisWidthUIAction {

    private AddPelwisWidthService serviceAddPelvisWidth;

    public AddPelwisWidthUIAction(AddPelwisWidthService serviceAddPelvisWidth) {
        this.serviceAddPelvisWidth = serviceAddPelvisWidth;
    }

    public void execute(AddPelwisWidthService serviceAddPelvisWidth) {
        System.out.println("введите ширину таза пользователя");
        Scanner scan = new Scanner(System.in);
        int pelvisWidth = scan.nextInt();
        serviceAddPelvisWidth.addUserPelwis(pelvisWidth);
    }

}
