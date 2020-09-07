package class_diagram_editor.presentation.main_screen;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.tesis.dynaware.grapheditor.Commands;
import de.tesis.dynaware.grapheditor.GraphEditor;
import de.tesis.dynaware.grapheditor.core.DefaultGraphEditor;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.model.GNode;
import de.tesis.dynaware.grapheditor.model.GraphFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

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
    private Pane pnlDiagram;

    @FXML
    private SubScene sbsDiagram;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGenerateCode.setOnAction((e) -> {
            viewModel.generateCode();
        });

        btnAddRandomClass.setOnAction((e) -> {
            viewModel.addRandomClass();
        });

        sbsDiagram.setWidth(pnlDiagram.getWidth());
        sbsDiagram.setHeight(pnlDiagram.getHeight());
        sbsDiagram.heightProperty().bind(pnlDiagram.heightProperty());
        sbsDiagram.widthProperty().bind(pnlDiagram.widthProperty());

        GraphEditor graphEditor = new DefaultGraphEditor();

        GModel model = GraphFactory.eINSTANCE.createGModel();
        graphEditor.setModel(model);

        addNodes(model);

        sbsDiagram.setRoot(graphEditor.getView());
    }

    private void addNodes(GModel model) {

        GNode firstNode = createNode();
        GNode secondNode = createNode();

        firstNode.setX(150);
        firstNode.setY(150);

        secondNode.setX(400);
        secondNode.setY(200);
        secondNode.setWidth(200);
        secondNode.setHeight(150);

        Commands.addNode(model, firstNode);
        Commands.addNode(model, secondNode);
    }

    private GNode createNode() {

        GNode node = GraphFactory.eINSTANCE.createGNode();

        GConnector input = GraphFactory.eINSTANCE.createGConnector();
        GConnector output = GraphFactory.eINSTANCE.createGConnector();

        input.setType("left-input");
        output.setType("right-output");

        node.getConnectors().add(input);
        node.getConnectors().add(output);

        return node;
    }
}
