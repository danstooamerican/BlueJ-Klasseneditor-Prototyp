package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.diagram.SourceCodeControl;
import class_diagram_editor.diagram.model.classdiagram.ClassDiagram;
import class_diagram_editor.diagram.model.classdiagram.ClassModel;
import class_diagram_editor.diagram.model.classdiagram.ClassdiagramFactory;
import class_diagram_editor.diagram.model.classdiagram.ClassdiagramPackage;
import class_diagram_editor.diagram.model.classdiagram.util.ClassdiagramAdapterFactory;
import class_diagram_editor.diagram.model.classdiagram.util.ClassdiagramSwitch;
import de.saxsys.mvvmfx.ViewModel;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.model.GNode;
import de.tesis.dynaware.grapheditor.model.GraphFactory;
import de.tesis.dynaware.grapheditor.model.GraphPackage;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import java.util.UUID;

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

        classDiagram = ClassdiagramFactory.eINSTANCE.createClassDiagram();
    }

    public void generateCode() {
        // sourceCodeControl.generate(classDiagram);



        classDiagram.getClasses().forEach(c -> {
            System.out.println(c.getName());
            System.out.println(c.getExtends());
        });
    }

    public void addRandomClass() {
        GNode node = GraphFactory.eINSTANCE.createGNode();
        node.setId(UUID.randomUUID().toString());
        node.setX(100);
        node.setY(100);
        node.setWidth(100);
        node.setHeight(100);

        GConnector input = GraphFactory.eINSTANCE.createGConnector();
        GConnector output = GraphFactory.eINSTANCE.createGConnector();

        input.setType("left-input");
        output.setType("right-output");

        node.getConnectors().add(input);
        node.getConnectors().add(output);

        ClassModel classModel = ClassdiagramFactory.eINSTANCE.createClassModel();
        classModel.setName("TestKlasse" + (int) (Math.random() * 100));
        classModel.setAbstractClass(Math.random() < 0.5);

        EReference nodes = GraphPackage.Literals.GMODEL__NODES;
        EReference classes = ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES;

        CompoundCommand command= new CompoundCommand();
        command.append(AddCommand.create(domain, graphModel, nodes, node));
        command.append(AddCommand.create(domain, classDiagram, classes, classModel));

        if (command.canExecute()) {
            domain.getCommandStack().execute(command);
        }
    }
}
