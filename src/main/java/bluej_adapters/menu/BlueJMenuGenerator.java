package bluej_adapters.menu;

import bluej.extensions.BPackage;
import bluej.extensions.MenuGenerator;
import presentation.ClassEditorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BlueJMenuGenerator extends MenuGenerator {

    @Override
    public JMenuItem getToolsMenuItem(BPackage bp) {
        return new JMenuItem(new OpenClassEditorAction());
    }

    private static class OpenClassEditorAction extends AbstractAction {
        public OpenClassEditorAction() {
            putValue(AbstractAction.NAME, "Klasseneditor öffnen");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new ClassEditorApplication().run();
        }
    }
}
