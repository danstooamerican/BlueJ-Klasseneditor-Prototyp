package class_diagram_editor.presentation.nodes;

import class_diagram_editor.diagram.Class;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasClassDiagramNode extends Canvas implements DiagramNode {

    private static final double WIDTH = 300;
    private static final double HEIGHT = 200;

    private final Class c;

    public CanvasClassDiagramNode(Class c) {
        this.c = c;

        setWidth(WIDTH);
        setHeight(HEIGHT);

        draw();
    }

    public boolean isExtending() {
        return c.isExtending();
    }

    public String getExtendsName() {
        return c.getExtends();
    }

    private void draw() {
        GraphicsContext gc = getGraphicsContext2D();

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.setLineWidth(3);
        gc.fillRect(0, 0, WIDTH - 5, HEIGHT - 5);

        gc.setFill(Color.BLACK);
        gc.fillText(c.getName(), WIDTH / 2, 10);
    }

    @Override
    public double getCenterX() {
        return getTranslateX() + WIDTH / 2;
    }

    @Override
    public double getCenterY() {
        return getTranslateY() + HEIGHT / 2;
    }

    @Override
    public Node getNode() {
        return this;
    }
}
