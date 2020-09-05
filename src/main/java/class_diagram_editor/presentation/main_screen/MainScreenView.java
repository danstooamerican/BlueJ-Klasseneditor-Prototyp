package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.diagram.Class;
import class_diagram_editor.presentation.nodes.CanvasClassDiagramNode;
import class_diagram_editor.presentation.nodes.DiagramNode;
import class_diagram_editor.presentation.nodes.ExtendsArrowNode;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainScreenView implements FxmlView<MainScreenViewModel>, Initializable {

    @InjectViewModel
    private MainScreenViewModel viewModel;

    @FXML
    private Button btnGenerateCode;

    @FXML
    private Button btnAddRandomClass;

    @FXML
    private SubScene sbsDiagram;

    @FXML
    private Pane pnlDiagram;

    private double startDragX;
    private double startDragY;

    private double targetNodeDragStartX;
    private double targetNodeDragStartY;

    private Node targetNode;

    private Map<String, DiagramNode> hookableNodes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hookableNodes = new HashMap<>();

        btnGenerateCode.setOnAction((e) -> {
            viewModel.generateCode();
        });

        btnAddRandomClass.setOnAction((e) -> {
            viewModel.addRandomClass();
        });

        sbsDiagram.setWidth(pnlDiagram.getWidth());
        sbsDiagram.setHeight(pnlDiagram.getHeight());
        sbsDiagram.heightProperty().bind(pnlDiagram.heightProperty());
        sbsDiagram.widthProperty().bind(pnlDiagram.widthProperty());

        sbsDiagram.setFill(Color.GRAY);

        Group group = new Group();

        sbsDiagram.setRoot(group);

        Camera camera = new ParallelCamera();
        sbsDiagram.setCamera(camera);

        sbsDiagram.setOnMousePressed(event -> {
            startDragX = event.getX();
            startDragY = event.getY();

            Node pickedNode = event.getPickResult().getIntersectedNode();

            if (pickedNode instanceof DiagramNode) {
                targetNode = pickedNode;
            } else {
                targetNode = camera;
            }

            targetNodeDragStartX = targetNode.translateXProperty().get();
            targetNodeDragStartY = targetNode.translateYProperty().get();
        });

        sbsDiagram.setOnScroll(event -> {
            final double zoomSpeed = 0.05;
            double direction = event.getDeltaY() > 0 ? -1 : 1;

            camera.setScaleX(camera.getScaleX() + direction * zoomSpeed);
            camera.setScaleY(camera.getScaleY() + direction * zoomSpeed);
        });

        sbsDiagram.setOnMouseDragged(event -> {
            targetNode.translateXProperty().setValue(targetNodeDragStartX - camera.getScaleX() * (startDragX - event.getX()));
            targetNode.translateYProperty().setValue(targetNodeDragStartY - camera.getScaleY() * (startDragY - event.getY()));
        });

        viewModel.getCodeElements().addListener((ListChangeListener<CodeElement>) c -> {
            c.next();
            c.getAddedSubList().forEach(codeElement -> {
                Collection<Node> diagramNodesToAdd = new ArrayList<>();

                if (codeElement instanceof Class) {
                    CanvasClassDiagramNode classDiagramNode = new CanvasClassDiagramNode((Class) codeElement);

                    if (classDiagramNode.isExtending()) {
                        Node hookNode = new ExtendsArrowNode(classDiagramNode, hookableNodes.get(classDiagramNode.getExtendsName()));

                        diagramNodesToAdd.add(hookNode);
                    }

                    diagramNodesToAdd.add(classDiagramNode);
                    hookableNodes.put(codeElement.getName(), classDiagramNode);
                }

                group.getChildren().addAll(diagramNodesToAdd);
            });
        });
    }
}
