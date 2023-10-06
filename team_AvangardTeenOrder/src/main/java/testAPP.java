public class testAPP {
    public static void main(String[] args) {
        UserSizes userSize1 = new UserSizes(31,31,40, 34);
        System.out.println("Seat Septh = " + userSize1.findSeatWidth() + " cm");
        System.out.println("Seat Depth = " + userSize1.findSeatDepth() + " cm");
        System.out.println("Bach Height = " + userSize1.backHeight + " cm");
        System.out.println("Footrest Length = MB " + userSize1.findFootrestLength());

    }
}
