public class Detail {
    int id;
    String overview;
    String title;
    Float vote_average;
    int vote_count;
    String name;


    public void printAll() {
        try {
            System.out.println("L'ID du media est " + this.id);
            if (this.title == null) {
                System.out.println("Le nom du media est " + this.name);
            } else {
                System.out.println("Le nom du media est " + this.title);
            }
            System.out.println("La description du media est " + this.overview);
            System.out.println("La moyenne des votes du media est " + this.vote_average);
            System.out.println("Le nombre de votes du media est " + this.vote_count + "\n\n");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
