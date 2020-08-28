package class_diagram_editor.presentation.main_screen;

import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenView implements FxmlView<MainScreenViewModel>, Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Hello World");
    }
}
