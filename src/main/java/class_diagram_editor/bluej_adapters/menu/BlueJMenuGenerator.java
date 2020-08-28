package class_diagram_editor.bluej_adapters.menu;

import bluej.extensions.BPackage;
import bluej.extensions.BProject;
import bluej.extensions.MenuGenerator;
import bluej.extensions.ProjectNotOpenException;
import class_diagram_editor.ClassEditorApplication;
import class_diagram_editor.bluej_adapters.source_control.SourceControl;
import class_diagram_editor.diagram.DiagramSource;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BlueJMenuGenerator extends MenuGenerator {

    @Override
    public JMenuItem getToolsMenuItem(BPackage bp) {
        try {
            BProject project = bp.getProject();

            return new JMenuItem(new OpenClassEditorAction(project.getName(), new SourceControl(project)));
        } catch (ProjectNotOpenException e) {
            return null;
        }
    }

    private static class OpenClassEditorAction extends AbstractAction {
        private final DiagramSource diagramSource;
        private final String projectTitle;

        public OpenClassEditorAction(String projectTitle, DiagramSource diagramSource) {
            this.diagramSource = diagramSource;
            this.projectTitle = projectTitle;

            putValue(AbstractAction.NAME, "Klasseneditor öffnen");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ClassEditorApplication(projectTitle, diagramSource).run();
        }
    }
}
