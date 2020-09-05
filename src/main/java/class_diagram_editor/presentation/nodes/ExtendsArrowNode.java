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
        setStart();
        setEnd();

        start.getNode().addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            setStart();
            setEnd();
        });

        end.getNode().addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            setStart();
            setEnd();
        });
    }

    private void setEnd() {
        double dx = -(end.getCenterX() - start.getCenterX());
        double dy = -(end.getCenterY() - start.getCenterY());

        setEndX(getIntersectionX(dx, dy, end));
        setEndY(getIntersectionY(dx, dy, end));
    }

    private void setStart() {
        double dx = end.getCenterX() - start.getCenterX();
        double dy = end.getCenterY() - start.getCenterY();

        setStartX(getIntersectionX(dx, dy, start));
        setStartY(getIntersectionY(dx, dy, start));
    }

    private double getIntersectionX(double dx, double dy, DiagramNode diagramNode) {
        if (Math.abs(dy / dx) < diagramNode.getHeight() / diagramNode.getWidth()) {
            // Hit vertical edge of box1
            return diagramNode.getCenterX() + (dx > 0 ? diagramNode.getWidth() : -diagramNode.getWidth()) / 2;
        } else {
            // Hit horizontal edge of box1
            return diagramNode.getCenterX() + dx * diagramNode.getHeight() / 2 / Math.abs(dy);
        }
    }

    private double getIntersectionY(double dx, double dy, DiagramNode diagramNode) {
        if (Math.abs(dy / dx) < diagramNode.getHeight() / diagramNode.getWidth()) {
            // Hit vertical edge of box1
            return diagramNode.getCenterY() + dy * diagramNode.getWidth() / 2 / Math.abs(dx);
        } else {
            // Hit horizontal edge of box1
            return diagramNode.getCenterY() + (dy > 0 ? diagramNode.getHeight() : -diagramNode.getHeight()) / 2;
        }
    }
}
