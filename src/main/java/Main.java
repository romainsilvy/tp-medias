import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Scanner scanner2 = new Scanner(System.in);

    public static void main(String[] args) {
        Arguments.ManageArgs(args);
        boolean menu = true;

        while (menu) {
            Menu.displayMenu();
            int choix = Main.scanner.nextInt();
            switch (choix) {
                case 1 -> Menu.case1();
                case 2 -> Menu.case2();
                case 3 -> menu = false;
                default -> System.out.println("merci de choisir un nombre entre 1 et 3");
            }
        }
    }
}