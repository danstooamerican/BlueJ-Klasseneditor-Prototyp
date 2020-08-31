package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.ClassDiagram;
import class_diagram_editor.diagram.SourceCodeControl;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
        classDiagram.addClass(new Class("Class" + (int) (Math.random() * 100)));
    }
}
