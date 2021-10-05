public class Movie {
    Boolean adult;
    String backdrop_path;
    int budget;
    Genres[] genres;
    String homepage;
    int id;
    String imdb_id;
    String original_language;
    String original_title;
    String overview;
    Double popularity;
    String poster_path;
    Production_companies[] production_companies;
    Production_countries[] production_countries;
    String release_date;
    int revenue;
    int runtime;
    Spoken_languages[] spoken_languages;
    String status;
    String tagline;
    String title;
    Boolean video;
    Float vote_average;
    int vote_count;

    public Movie (Boolean adult, String backdrop_path, int budget, Genres[] genres, String homepage, int id, String imdb_id, String original_language, String original_title, String overview, Double popularity, String poster_path, Production_companies[] production_companies, Production_countries[] production_countries, String release_date, int revenue, int runtime, Spoken_languages[] spoken_languages, String status, String tagline, String title, Boolean video, Float vote_average, int vote_count) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }
}
