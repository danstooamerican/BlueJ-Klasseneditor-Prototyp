package class_diagram_editor.diagram;

public interface Subject<T extends Observable> {

    void update(T observable);

}
