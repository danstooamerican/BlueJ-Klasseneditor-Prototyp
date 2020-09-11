package class_diagram_editor.presentation.main_screen.skins;

import class_diagram_editor.diagram.AttributeModel;
import class_diagram_editor.diagram.InterfaceModel;
import class_diagram_editor.diagram.MethodModel;
import de.tesis.dynaware.grapheditor.core.skins.defaults.DefaultNodeSkin;
import de.tesis.dynaware.grapheditor.model.GNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class InterfaceSkin extends DefaultNodeSkin {

    private final InterfaceModel interfaceModel;

    public InterfaceSkin(final GNode node, InterfaceModel interfaceModel) {
        super(node);

        this.interfaceModel = interfaceModel;

        VBox layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        Node header = getHeader();
        Node methods = getMethods();

        Separator methodsSeparator = new Separator();

        layout.getChildren().addAll(header, methodsSeparator, methods);

        getRoot().getChildren().add(layout);
    }

    private Node getHeader() {
        VBox layout = new VBox();
        layout.setPadding(new Insets(6, 8, 6, 8));
        layout.setAlignment(Pos.TOP_CENTER);

        layout.getChildren().add(new Label("<<interface>>"));

        layout.getChildren().add(new Label(interfaceModel.getName()));

        return layout;
    }

    private Node getMethods() {
        VBox layout = new VBox();

        if (interfaceModel.hasMethods()) {
            layout.setPadding(new Insets(6, 8, 6, 8));
            layout.setAlignment(Pos.TOP_LEFT);

            StringBuilder stringBuilder = new StringBuilder();
            for (MethodModel method : interfaceModel.getMethods()) {
                stringBuilder.append("+")
                        .append(method.getName())
                        .append("(");

                if (method.hasAttributes()) {
                    final String delimiter = ", ";

                    for (AttributeModel attribute : method.getAttributes()) {
                        stringBuilder.append(attribute.getName())
                                .append(" : ")
                                .append(attribute.getType())
                                .append(delimiter);
                    }

                    stringBuilder.setLength(stringBuilder.length() - delimiter.length());
                }

                stringBuilder.append(") : ")
                        .append(method.getReturnType());

                layout.getChildren().add(new Label(stringBuilder.toString()));

                stringBuilder.setLength(0);
            }
        }

        return layout;
    }

}
