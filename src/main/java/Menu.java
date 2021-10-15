public class Menu {

    public static void displayMenu() {
        System.out.println("  __  __   ______   _   _   _    _ \n" +
                " |  \\/  | |  ____| | \\ | | | |  | |\n" +
                " | \\  / | | |__    |  \\| | | |  | |\n" +
                " | |\\/| | |  __|   | . ` | | |  | |\n" +
                " | |  | | | |____  | |\\  | | |__| |\n" +
                " |_|  |_| |______| |_| \\_|  \\____/\n");
        System.out.println("[1] Recherche ");
        System.out.println("[2] Detail");
        System.out.println("[3] Fermer l'application");
    }

    public static void case1() {
        try {
            System.out.println("entrez le nom du film que vous voulez rechercher");
            String strToFind = Main.scanner2.nextLine();
            Actions.search("https://api.themoviedb.org/3/search/multi?api_key=8ac8920a6691cfb0e988250f77cb8e67&query=", strToFind, "");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void case2() {
        try {
            System.out.println("entrez l'id du film sur lequel vous voulez des informations");
            String strToFind2 = Main.scanner2.nextLine();
            Actions.detail("https://api.themoviedb.org/3/movie/", strToFind2, "?api_key=061128256033c2efcf30e88914540437");
            Actions.detail("https://api.themoviedb.org/3/tv/", strToFind2, "?api_key=061128256033c2efcf30e88914540437");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
