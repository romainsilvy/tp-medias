import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tools myTools = new Tools();
        myTools.ManageArgs(args);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            myTools.displayMenu();
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("entrez le nom du film que vous voulez rechercher");
                    String strToFind = scanner2.nextLine();
                    myTools.search("https://api.themoviedb.org/3/search/multi?api_key=8ac8920a6691cfb0e988250f77cb8e67&query=", strToFind, "");
                    break;
                case 2:
                    System.out.println("entrez l'id du film sur lequel vous voulez des informations");
                    String strToFind2 = scanner2.nextLine();
                    myTools.detail("https://api.themoviedb.org/3/movie/", strToFind2, "?api_key=061128256033c2efcf30e88914540437");
                    break;
                case 3:
                    menu = false;
                    break;
                default:
                    System.out.println("merci de choisir un nombre entre 1 et 3");
                    break;
            }
        }
    }
}