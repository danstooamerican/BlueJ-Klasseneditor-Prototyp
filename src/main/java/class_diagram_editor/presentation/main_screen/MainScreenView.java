package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.code_generation.CodeElement;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenView implements FxmlView<MainScreenViewModel>, Initializable {

    @InjectViewModel
    private MainScreenViewModel viewModel;

    @FXML
    private Button btnGenerateCode;

    @FXML
    private Button btnAddRandomClass;

    @FXML
    private SubScene sbsDiagram;

    private double startDragX;
    private double startDragY;

    private double targetNodeDragStartX;
    private double targetNodeDragStartY;

    private Node targetNode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGenerateCode.setOnAction((e) -> {
            viewModel.generateCode();
        });

        btnAddRandomClass.setOnAction((e) -> {
            viewModel.addRandomClass();
        });

        sbsDiagram.setFill(Color.GRAY);

        Group group = new Group();
        group.getChildren().add(new Rectangle(100, 100, Color.BLACK));
        group.getChildren().add(new Rectangle(100, 100, Color.BLUE));

        sbsDiagram.setRoot(group);

        Camera camera = new ParallelCamera();
        sbsDiagram.setCamera(camera);

        sbsDiagram.setOnMousePressed(event -> {
            startDragX = event.getX();
            startDragY = event.getY();

            Node pickedNode = event.getPickResult().getIntersectedNode();

            if (pickedNode instanceof Rectangle) {
                targetNode = pickedNode;
            } else {
                targetNode = camera;
            }

            targetNodeDragStartX = targetNode.translateXProperty().get();
            targetNodeDragStartY = targetNode.translateYProperty().get();
        });

        sbsDiagram.setOnMouseDragged(event -> {
            targetNode.translateXProperty().setValue(targetNodeDragStartX - (startDragX - event.getX()));
            targetNode.translateYProperty().setValue(targetNodeDragStartY - (startDragY - event.getY()));
        });

        viewModel.getCodeElements().addListener((ListChangeListener<CodeElement>) c -> {

        });
    }
}
