package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.ClassDiagram;
import class_diagram_editor.diagram.SourceCodeControl;
import class_diagram_editor.diagram.Subject;
import de.saxsys.mvvmfx.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainScreenViewModel implements ViewModel, Subject<ClassDiagram> {
    private final SourceCodeControl sourceCodeControl;

    private final ClassDiagram classDiagram;

    private final ObservableList<CodeElement> codeElements;
    private final Set<String> displayedCodeElements;

    public MainScreenViewModel(SourceCodeControl sourceCodeControl) {
        this.sourceCodeControl = sourceCodeControl;
        this.classDiagram = new ClassDiagram();
        this.codeElements = FXCollections.observableArrayList();
        this.displayedCodeElements = new HashSet<>();

        classDiagram.subscribe(this);
        update(classDiagram);
    }

    public void generateCode() {
        sourceCodeControl.generate(classDiagram);
    }

    public void addRandomClass() {
        CodeElement extendsClass = null;
        if (Math.random() < 0.5) {
            List<CodeElement> codeElementList = new ArrayList<>(classDiagram.getCodeElements());

            if (codeElementList.size() > 0) {
                extendsClass = codeElementList.get((int)(Math.random() * (codeElementList.size() - 1)));
            }
        }
        classDiagram.addClass(new Class(Math.random() < 0.5, "Class" + (int) (Math.random() * 100), (Class) extendsClass));
    }

    public ObservableList<CodeElement> getCodeElements() {
        return codeElements;
    }

    @Override
    public void update(ClassDiagram observable) {
        classDiagram.getCodeElements().forEach(codeElement -> {
            if (!displayedCodeElements.contains(codeElement.getName())) {
                codeElements.add(codeElement);
                displayedCodeElements.add(codeElement.getName());
            }
        });
    }
}
