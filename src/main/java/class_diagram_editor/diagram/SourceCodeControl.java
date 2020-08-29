package class_diagram_editor.diagram;

import java.util.Collection;

public interface SourceCodeControl {

    Collection<Class> getAvailableClasses();

    void generateClass(Class c);

}
