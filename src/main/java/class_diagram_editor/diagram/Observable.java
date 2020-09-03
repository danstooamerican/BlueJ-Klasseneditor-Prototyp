package class_diagram_editor.diagram;

public interface Observable<T extends Observable> {

    void subscribe(Subject<T> subject);

    void unsubscribe(Subject<T> subject);

    void updateAll();

}
