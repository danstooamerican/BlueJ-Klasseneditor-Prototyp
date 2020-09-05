package class_diagram_editor.presentation.nodes;


import class_diagram_editor.diagram.Class;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ClassNode extends Rectangle {

    public ClassNode(Class c) {
        super(150, 100);

        setFill(Color.TRANSPARENT);
        setStroke(Color.BLACK);
        setStrokeType(StrokeType.INSIDE);
    }
}
