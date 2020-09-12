package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.presentation.main_screen.skins.ExtendsConnectionSkin;
import class_diagram_editor.presentation.main_screen.skins.ImplementsConnectionSkin;
import class_diagram_editor.presentation.main_screen.validator.UMLConnectorValidator;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.tesis.dynaware.grapheditor.GraphEditor;
import de.tesis.dynaware.grapheditor.core.DefaultGraphEditor;
import de.tesis.dynaware.grapheditor.core.view.GraphEditorContainer;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.model.GraphFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

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
    private Button btnAddRandomInterface;

    @FXML
    private BorderPane bdpRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addControlHandlers();
        initializeGraph();
    }

    private void addControlHandlers() {
        btnGenerateCode.setOnAction((e) -> {
            viewModel.generateCode();
        });

        btnAddRandomClass.setOnAction((e) -> {
            viewModel.addRandomClass();
        });

        btnAddRandomInterface.setOnAction((e) -> {
            viewModel.addRandomInterface();
        });
    }

    private void initializeGraph() {
        GraphEditor graphEditor = new DefaultGraphEditor();

        GraphEditorContainer graphEditorContainer = new GraphEditorContainer();
        graphEditorContainer.setGraphEditor(graphEditor);

        addSkins(graphEditor);
        addGraphControls(graphEditor);
        addGraphModel(graphEditor);

        bdpRoot.centerProperty().setValue(graphEditorContainer);
    }

    private void addSkins(GraphEditor graphEditor) {
        graphEditor.setNodeSkinFactory(viewModel::createNodeSkin);
        graphEditor.setConnectorSkinFactory(viewModel::createConnectorSkin);
        graphEditor.setConnectorValidator(new UMLConnectorValidator());
        graphEditor.setConnectionSkinFactory(viewModel::createConnectionSkin);
    }

    private void addGraphControls(GraphEditor graphEditor) {
        graphEditor.setOnConnectionCreated(connection -> {
            GConnector connectorInput = connection.getSource();
            GConnector connectorOutput = connection.getTarget();

            String inputId = connectorInput.getParent().getId();
            String outputId = connectorOutput.getParent().getId();

            switch (connection.getType()) {
                case ExtendsConnectionSkin.TYPE:
                    viewModel.addExtendsRelation(inputId, outputId);
                    break;
                case ImplementsConnectionSkin.TYPE:
                    viewModel.addImplementsRelation(inputId, outputId);
                    break;
            }

            return null;
        });
    }

    private void addGraphModel(GraphEditor graphEditor) {
        GModel graphModel = GraphFactory.eINSTANCE.createGModel();

        graphModel.setContentWidth(10000);
        graphModel.setContentHeight(10000);

        graphEditor.setModel(graphModel);

        EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(graphModel);
        viewModel.init(domain, graphModel);
    }
}
