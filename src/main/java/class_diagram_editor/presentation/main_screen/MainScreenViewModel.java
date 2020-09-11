package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.diagram.ClassDiagram;
import class_diagram_editor.diagram.ClassModel;
import class_diagram_editor.diagram.InterfaceModel;
import class_diagram_editor.diagram.SourceCodeControl;
import class_diagram_editor.presentation.main_screen.skins.ClassSkin;
import class_diagram_editor.presentation.main_screen.skins.ConnectorSkin;
import class_diagram_editor.presentation.main_screen.skins.ExtendsConnectionSkin;
import class_diagram_editor.presentation.main_screen.skins.ImplementsConnectionSkin;
import class_diagram_editor.presentation.main_screen.skins.InterfaceSkin;
import de.saxsys.mvvmfx.ViewModel;
import de.tesis.dynaware.grapheditor.GConnectionSkin;
import de.tesis.dynaware.grapheditor.GConnectorSkin;
import de.tesis.dynaware.grapheditor.GNodeSkin;
import de.tesis.dynaware.grapheditor.core.skins.defaults.DefaultNodeSkin;
import de.tesis.dynaware.grapheditor.model.GConnection;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.model.GNode;
import de.tesis.dynaware.grapheditor.model.GraphFactory;
import de.tesis.dynaware.grapheditor.model.GraphPackage;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class MainScreenViewModel implements ViewModel {
    private final SourceCodeControl sourceCodeControl;

    private EditingDomain domain;
    private GModel graphModel;
    private ClassDiagram classDiagram;

    public MainScreenViewModel(SourceCodeControl sourceCodeControl) {
        this.sourceCodeControl = sourceCodeControl;
    }

    public void init(EditingDomain domain, GModel graphModel) {
        this.domain = domain;
        this.graphModel = graphModel;
        this.classDiagram = new ClassDiagram();
    }

    public void generateCode() {
        sourceCodeControl.generate(classDiagram);
    }

    public void addRandomClass() {
        ClassModel classModel = new ClassModel();
        classModel.setName("TestKlasse" + (int) (Math.random() * 100));
        classModel.setAbstract(Math.random() < 0.5);

        String id = classDiagram.addClass(classModel);

        addNode("class", id);
    }

    public void addRandomInterface() {
        InterfaceModel interfaceModel = new InterfaceModel();
        interfaceModel.setName("TestInterface" + (int) (Math.random() * 100));

        String id = classDiagram.addInterface(interfaceModel);

        addNode("interface", id);
    }

    private void addNode(String type, String id) {
        GNode node = GraphFactory.eINSTANCE.createGNode();

        node.setType(type);
        node.setId(id);

        node.setX(100);
        node.setY(100);
        node.setWidth(200);
        node.setHeight(150);

        node.getConnectors().add(createConnector("top"));
        node.getConnectors().add(createConnector("top"));

        node.getConnectors().add(createConnector("right"));
        node.getConnectors().add(createConnector("right"));

        node.getConnectors().add(createConnector("left"));
        node.getConnectors().add(createConnector("left"));

        node.getConnectors().add(createConnector("bottom"));
        node.getConnectors().add(createConnector("bottom"));

        EReference nodes = GraphPackage.Literals.GMODEL__NODES;

        CompoundCommand command= new CompoundCommand();
        command.append(AddCommand.create(domain, graphModel, nodes, node));

        if (command.canExecute()) {
            domain.getCommandStack().execute(command);
        }
    }

    private GConnector createConnector(String type) {
        final String connectorType = type + "-input";

        GConnector connector = GraphFactory.eINSTANCE.createGConnector();

        connector.setConnectionDetachedOnDrag(false);
        connector.setType(connectorType);

        return connector;
    }

    public void addExtendsRelation(String superClass, String extendsClass) {
        classDiagram.addExtendsRelation(superClass, extendsClass);
    }

    public GNodeSkin createNodeSkin(final GNode node)
    {
        switch (node.getType()) {
            case "class":
                return new ClassSkin(node, classDiagram.getClassModel(node.getId()));
            case "interface":
                return new InterfaceSkin(node, classDiagram.getInterfaceModel(node.getId()));
            default:
                return new DefaultNodeSkin(node);
        }
    }

    public GConnectorSkin createConnectorSkin(final GConnector connector)
    {
        return new ConnectorSkin(connector);
    }

    public GConnectionSkin createConnectionSkin(final GConnection connection) {
        final String connectionType = connection.getType();

        if (connectionType.equals(ExtendsConnectionSkin.TYPE)) {
            return new ExtendsConnectionSkin(connection);
        } else if (connectionType.equals(ImplementsConnectionSkin.TYPE)) {
            return new ImplementsConnectionSkin(connection);
        }

        return null;
    }
}
