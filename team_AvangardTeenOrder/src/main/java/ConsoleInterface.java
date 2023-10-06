import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleInterface {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int choose = 0;
        while (choose != 7) {
/*
            System.out.println("������ ������� Avangard Teen");
            System.out.println("�������� ����� �� ����");
            System.out.println("1. ������ ������������������ ������ ������ (������ �����, ������ ����, ������ ������, ������ ����� �� ������� ���� �������)");
            System.out.println("2. �������� ������������������ ������ �������");
            System.out.println("3. �������� ��������� ������������������ ������");
            System.out.println("4. �������� ����������� �������");
            System.out.println("5. ������ ��������� � ����������� �������");
            System.out.println("6. �������� ����������� � ������� ��������� �������");
            System.out.println("7. ��������� ������ ������ ��� ����� � �����");
*/
            choose = scan.nextInt();

            switch (choose) {
                case (1):
                    System.out.println("������� ������ ���� ������������");
                    int pelwicWidth = scan.nextInt();
                    System.out.println("������� ������ ����� ������������");
                    int hipLength = scan.nextInt();
                    System.out.println("������� ������ ����� ������������ �� ������� ���� �������");
                    int backLength = scan.nextInt();
                    System.out.println("������� ������ ������ ������������");
                    int shinLength = scan.nextInt();
                    System.out.println("�������� ��������� ������: ");
                    System.out.println("������ ����:  " + pelwicWidth);
                    System.out.println("������ �����: " + hipLength);
                    System.out.println("������ ����� �� ������� ���� �������: " + backLength);
                    System.out.println("������ ������: " + shinLength);
                    // ������� ����� ������������������ ������ � ��������� ���� �����������
                    System.out.println("������� \"��\", ����� ��������� ������");
                    String ok = scan.next();
                    if (ok.equals("ok")) System.out.println("������ ���������");
                    Thread.sleep(2000);
                    break;
                case (2):
                    System.out.println("����� �� ���������� ������ ��������?");
                    System.out.println("1. ������ ����:  "); // + ������ �� ������ ������������������ ������);
                    System.out.println("2. ������ �����: "); // + ������ �� ������ ������������������ ������);
                    System.out.println("3. ������ ����� �� ������� ���� �������: ");// + ������ �� ������ ������������������ ������);
                    System.out.println("4. ������ ������: "); // + ������ �� ������ ������������������ ������);
                    int chanch = scan.nextInt();
                    switch (chanch) {
                        case (1):
                            System.out.println("������� ����� �������� ������ ����");
                            int newPelwicWidth = scan.nextInt();
                            System.out.println("����� �������� ���������");
                            Thread.sleep(2000);
                            //��� � ������������
                            break;
                        case (2):
                            System.out.println("������� ����� �������� ������ �����");
                            int newHipLength = scan.nextInt();
                            System.out.println("����� �������� ���������");
                            Thread.sleep(2000);
                            //��� � ������������
                            break;
                        case (3):
                            System.out.println("������� ����� �������� ������ ����� �� ������� ���� �������");
                            int newBackLength = scan.nextInt();
                            System.out.println("����� �������� ���������");
                            Thread.sleep(2000);
                            //��� � ������������
                            break;
                        case (4):
                            System.out.println("������� ����� �������� ������ ������");
                            int newShinLength = scan.nextInt();
                            System.out.println("����� �������� ���������");
                            Thread.sleep(2000);
                            //��� � ������������
                            break;
                    }
                case (3):
                    System.out.println("���� ���������: "); // + ������ �� ������ ������������������ ������);
                    System.out.println("������ ����:  "); // + ������ �� ������ ������������������ ������);
                    System.out.println("������ �����: "); // + ������ �� ������ ������������������ ������);
                    System.out.println("������ ����� �� ������� ���� �������: ");// + ������ �� ������ ������������������ ������);
                    System.out.println("������ ������: "); // + ������ �� ������ ����������������
                    System.out.println("������� \"��\", ����� ����������");
                    String okey = scan.next();

                case (4):
                    System.out.println("� ������ ������� ��������� � ����� �������. " +
                            "\n � ���� �� ����� ������ ��� ��������� ��������� �������� ���������, �� ������� ��� ���� ����� ������� ���� �������. \n " +
                            "� ����� ������ ����� ������� ����, ������� ����� ������������ � ��������� �������. \n " +
                            "���� ������ ���� ����� �������, ������ ���� ������� ������ � ������� ��������� � �� ����������� ����� ��������� �������.");
                            System.out.println("1) ������ 3 �����");
                            System.out.println("2) ������ 4 �����");
                            System.out.println("3) ������ 5 �����");
                            System.out.println("4) ������ 6 �����");
                            int frontWheel = scan.nextInt();


            }
        }


    }
}



