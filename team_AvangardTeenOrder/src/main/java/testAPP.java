public class testAPP {
    public static void main(String[] args) {
        UserSizes userSize1 = new UserSizes(31,31,40, 34);
        System.out.println("Ширина сиденья = " + userSize1.findSeatWidth() + " cm");
        System.out.println("Глубина сиденья = " + userSize1.findSeatDepth() + " cm");
        System.out.println("Высота спинки = " + userSize1.backHeight + " cm");
        System.out.println("Длина подножки = MB " + userSize1.findFootrestLength());

    }
}
