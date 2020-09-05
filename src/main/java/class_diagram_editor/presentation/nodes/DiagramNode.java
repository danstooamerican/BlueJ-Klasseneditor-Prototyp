package class_diagram_editor.presentation.nodes;

import javafx.scene.Node;

public interface DiagramNode {

    double getCenterX();

    double getCenterY();

    double getWidth();

    double getHeight();

    Node getNode();

}
