package class_diagram_editor.presentation.main_screen;

import class_diagram_editor.diagram.DiagramSource;
import de.saxsys.mvvmfx.ViewModel;
import lombok.Setter;

@Setter
public class MainScreenViewModel implements ViewModel {

    private DiagramSource diagramSource;

}
