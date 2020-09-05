package class_diagram_editor.presentation.nodes;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class ExtendsArrowNode extends Line {

    private final DiagramNode start;
    private final DiagramNode end;

    public ExtendsArrowNode(DiagramNode start, DiagramNode end) {
        this.start = start;
        this.end = end;

        init();
    }

    private void init() {
        setStartX(start.getCenterX());
        setStartY(start.getCenterY());

        setEndX(end.getCenterX());
        setEndY(end.getCenterY());

        start.getNode().addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            setStartX(start.getCenterX());
            setStartY(start.getCenterY());
        });

        end.getNode().addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            setEndX(end.getCenterX());
            setEndY(end.getCenterY());
        });
    }
}
