package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Controller {

    @FXML
    public TextArea textAreaJSON;

    @FXML
    public Button btnSortName;

    @FXML
    public Button btnSortRarity;

    @FXML
    public Button btn;

    JSONGetter gj = new JSONGetter();
    Films films = new Films();

    public void getJSON(ActionEvent actionEvent) throws InterruptedException, IOException {
        gj.start();
        String json = gj.getJson();

        do {
            Thread.sleep(100);
        } while ((json = gj.getJson()) == null);

        films = Films.fromJSONToObjects(json);
        textAreaJSON.setText(films.getFilms().toString());

        btnSortName.setDisable(false);
        btnSortRarity.setDisable(false);
        btn.setDisable(true);


    }

    public void btnSortYear(ActionEvent actionEvent) {
        films.getFilms().sort(Film.byYearAsc);
        textAreaJSON.setText(films.getFilms().toString());
    }

    public void btnSortRelease(ActionEvent actionEvent) {
        films.getFilms().sort(Film.byReleaseDesc);
        textAreaJSON.setText(films.getFilms().toString());
    }
}