package sample;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Films {
    public ArrayList<Film> getFilms() {
        return films;
    }

    public Films(ArrayList<Film> films) {
        this.films = films;
    }

    public void setRates(ArrayList<Film> films) {
        this.films = films;
    }

    private ArrayList<Film> films;

    public Films() {
        films = new ArrayList<>();
    }

    public void add(Film film) {
        this.films.add(film);
    }

    @Override
    public String toString() {
        String result = "Films (" + (new Date()).toLocaleString() + ") " + System.lineSeparator();
        for (Film c : films) {
            result += c + System.lineSeparator();
        }
        return result;
    }
    public static Films fromJSONToObjects(String jsonData) throws IOException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.readValue(jsonData, Films.class);
    }

}