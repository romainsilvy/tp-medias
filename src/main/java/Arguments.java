public class Arguments {

    public static void ManageArgs(String[] args) {
        try {
            if (args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("--search")) {
                        Actions.search("https://api.themoviedb.org/3/search/multi?api_key=8ac8920a6691cfb0e988250f77cb8e67&query=", args[i+1], "");
                    } else if (args[i].equals("--detail")) {
                        Actions.detail("https://api.themoviedb.org/3/movie/", args[i+1], "?api_key=061128256033c2efcf30e88914540437");
                        Actions.detail("https://api.themoviedb.org/3/tv/", args[i+1], "?api_key=061128256033c2efcf30e88914540437");
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
