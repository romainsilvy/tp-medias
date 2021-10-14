public class Movie {
    int id;
    String overview;
    String title;
    Float vote_average;
    int vote_count;


    public void printAll() {
        System.out.println("L'ID du media est " + this.id);
        System.out.println("Le nom du media est " + this.title);
        System.out.println("La description du media est " + this.overview);
        System.out.println("La moyenne des votes du media est " + this.vote_average);
        System.out.println("Le nombre de votes du media est " + this.vote_count);
    }
}
