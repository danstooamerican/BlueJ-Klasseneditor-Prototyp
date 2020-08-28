package class_diagram_editor;

import class_diagram_editor.diagram.DiagramSource;
import class_diagram_editor.presentation.main_screen.MainScreenView;
import class_diagram_editor.presentation.main_screen.MainScreenViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClassEditorApplication extends Application implements Runnable {

    private final String title;
    private final DiagramSource diagramSource;

    public ClassEditorApplication(String projectTitle, DiagramSource diagramSource) {
        this.title = "Klasseneditor: " + projectTitle;
        this.diagramSource = diagramSource;
    }

    public ClassEditorApplication() {
        this.title = "Klasseneditor";
        this.diagramSource = null;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        stage.setTitle(title);

        ViewTuple<MainScreenView, MainScreenViewModel> viewTuple = FluentViewLoader.fxmlView(MainScreenView.class)
                .codeBehind(new MainScreenView())
                .load();

        Parent root = viewTuple.getView();

        viewTuple.getViewModel().setDiagramSource(diagramSource);

        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void run() {
        start(new Stage());
    }
}
