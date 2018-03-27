package pl.motek.soa.Model;

import java.util.Arrays;
import java.util.List;

public class MoviesListBean {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        if(movies == null){
            movies = Arrays.asList(
                    new Movie("Ojciec chrzestny","dramat",1972,120000000),
                    new Movie("Pluton","wojenny",1985,50000000),
                    new Movie("Nagi instynkt", "thriller",1992,1000000000));
        }
        return movies;
    }
}
