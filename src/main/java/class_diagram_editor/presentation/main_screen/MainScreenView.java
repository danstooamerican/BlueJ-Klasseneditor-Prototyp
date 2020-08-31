package class_diagram_editor.presentation.main_screen;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenView implements FxmlView<MainScreenViewModel>, Initializable {

    @InjectViewModel
    private MainScreenViewModel viewModel;

    @FXML
    private Button btnGenerateCode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGenerateCode.setOnAction((e) -> {
            viewModel.generateCode();
        });
    }
}
