package class_diagram_editor.presentation.main_screen;

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
    private BorderPane bdpRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGenerateCode.setOnAction((e) -> {
            viewModel.generateCode();
        });

        btnAddRandomClass.setOnAction((e) -> {
            viewModel.addRandomClass();
        });

        GraphEditor graphEditor = new DefaultGraphEditor();

        GraphEditorContainer graphEditorContainer = new GraphEditorContainer();
        graphEditorContainer.setGraphEditor(graphEditor);

        graphEditor.setOnConnectionCreated(connection -> {
            GConnector connectorInput;
            GConnector connectorOutput;

            // depends on where the connection originated from
            if (connection.getSource().getType().contains("input")) {
                connectorInput = connection.getSource();
                connectorOutput = connection.getTarget();
            } else {
                connectorInput = connection.getTarget();
                connectorOutput = connection.getSource();
            }

            String inputId = connectorInput.getParent().getId();
            String outputId = connectorOutput.getParent().getId();

            viewModel.addExtendsRelation(inputId, outputId);

            // create new connector for super class
            connectorInput.getParent().getConnectors().add(GraphFactory.eINSTANCE.createGConnector());
            
            return null;
        });

        GModel graphModel = GraphFactory.eINSTANCE.createGModel();

        graphModel.setContentWidth(10000);
        graphModel.setContentHeight(10000);

        graphEditor.setModel(graphModel);

        EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(graphModel);
        viewModel.init(domain, graphModel);

        // graphEditorContainer.panTo(5000, 5000);

        bdpRoot.centerProperty().setValue(graphEditorContainer);
    }
}
