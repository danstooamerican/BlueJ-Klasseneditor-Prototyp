package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.SourceCodeControl;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainScreenViewModel implements ViewModel {
    private final StringProperty classes = new SimpleStringProperty();

    private final SourceCodeControl sourceCodeControl;

    public MainScreenViewModel(SourceCodeControl sourceCodeControl) {
        this.sourceCodeControl = sourceCodeControl;

        classes.setValue(sourceCodeControl.getAvailableClasses().stream().map(Class::getName).reduce((aClass, aClass2) -> aClass + ", " + aClass2).orElse(""));
    }

    public StringProperty classesProperty() {
        return classes;
    }

    public void generateCode() {
        sourceCodeControl.generateClass(new Class("TestClass123"));
    }
}
