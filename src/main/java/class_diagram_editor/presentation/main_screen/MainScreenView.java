package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.diagram.model.classdiagram.ClassDiagram;
import class_diagram_editor.diagram.model.classdiagram.ClassdiagramPackage;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.tesis.dynaware.grapheditor.Commands;
import de.tesis.dynaware.grapheditor.GraphEditor;
import de.tesis.dynaware.grapheditor.core.DefaultGraphEditor;
import de.tesis.dynaware.grapheditor.core.view.GraphEditorContainer;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.model.GNode;
import de.tesis.dynaware.grapheditor.model.GraphFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
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
        GraphEditorContainer graphEditorContainer = new GraphEditorContainer();

        graphEditor.setOnConnectionCreated(connection -> {
            connection.getSource().getParent().getConnectors().add(GraphFactory.eINSTANCE.createGConnector());
            
            return null;
        });

        GModel graphModel = GraphFactory.eINSTANCE.createGModel();

        graphModel.setContentWidth(10000);
        graphModel.setContentHeight(10000);

        graphEditor.setModel(graphModel);

        EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(graphModel);
        viewModel.init(domain, graphModel);

        graphEditorContainer.setGraphEditor(graphEditor);

        graphEditorContainer.panTo(5000, 5000);

        sbsDiagram.setRoot(graphEditorContainer);
    }
}
