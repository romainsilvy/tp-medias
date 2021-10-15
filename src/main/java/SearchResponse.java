public class SearchResponse {
    int page;
    Media[] results;


    void printAll() {
        try {
            int rangeOnTab = 15;
            if (this.results.length < 15) {
                rangeOnTab = this.results.length;
            }

            for (int i = 0; i < rangeOnTab; i++) {
                switch (this.results[i].media_type) {
                    case "tv":
                        System.out.println("\u001B[32mL'ID du media est " + this.results[i].id);
                        System.out.println("Le nom du media est " + this.results[i].name);
                        System.out.println("le type est " + this.results[i].media_type + "\n");
                        break;
                    case "movie":
                        System.out.println("\u001B[34mL'ID du media est " + this.results[i].id);
                        System.out.println("Le nom du media est " + this.results[i].title);
                        System.out.println("le type est " + this.results[i].media_type + "\n");
                        break;
                    default:
                        break;
                }
                System.out.println("\u001B[0m");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
