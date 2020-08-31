package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.ClassDiagram;
import class_diagram_editor.diagram.SourceCodeControl;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class MainScreenViewModel implements ViewModel {
    private final SourceCodeControl sourceCodeControl;

    private final ClassDiagram classDiagram;

    public MainScreenViewModel(SourceCodeControl sourceCodeControl) {
        this.sourceCodeControl = sourceCodeControl;
        this.classDiagram = new ClassDiagram();
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
}
