package class_diagram_editor.presentation.main_screen.skins;

import class_diagram_editor.diagram.ClassModel;
import de.tesis.dynaware.grapheditor.core.skins.defaults.DefaultNodeSkin;
import de.tesis.dynaware.grapheditor.model.GNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 * Node skin for a 'tree-like' graph.
 */
public class ClassSkin extends DefaultNodeSkin {

    private static final String SEPARATOR_CLASS = "diagram-separator";

    private final ClassModel classModel;

    public ClassSkin(final GNode node, ClassModel classModel) {
        super(node);

        this.classModel = classModel;

        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        Node header = getHeader();
        Node attributes = getAttributes();
        Node methods = getMethods();

        Separator attributesSeparator = new Separator();
        attributesSeparator.getStyleClass().add(SEPARATOR_CLASS);

        Separator methodsSeparator = new Separator();
        methodsSeparator.getStyleClass().add(SEPARATOR_CLASS);

        layout.getChildren().addAll(header, attributesSeparator, attributes, methodsSeparator, methods);

        getRoot().getChildren().add(layout);
    }

    private Node getHeader() {
        VBox layout = new VBox();
        layout.setPadding(new Insets(6, 8, 6, 8));
        layout.setAlignment(Pos.TOP_CENTER);

        if (classModel.isAbstract()) {
            layout.getChildren().add(new Label("<<abstract>>"));
        }

        layout.getChildren().add(new Label(classModel.getName()));

        return layout;
    }

    private Node getAttributes() {
        VBox layout = new VBox();
        layout.setPadding(new Insets(6, 8, 6, 8));
        layout.setAlignment(Pos.TOP_LEFT);

        if (Math.random() < 0.5) {
            layout.getChildren().add(new Label("- name : String"));
        }

        if (layout.getChildren().isEmpty()) {
            return new VBox();
        }

        return layout;
    }

    private Node getMethods() {
        VBox layout = new VBox();
        layout.setPadding(new Insets(6, 8, 6, 8));
        layout.setAlignment(Pos.TOP_LEFT);

        if (Math.random() < 0.5) {
            layout.getChildren().add(new Label("+ getName : String"));
        }

        if (layout.getChildren().isEmpty()) {
            return new VBox();
        }

        return layout;
    }
}
