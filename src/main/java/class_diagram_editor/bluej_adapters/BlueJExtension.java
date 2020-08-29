package class_diagram_editor.bluej_adapters;

import bluej.extensions.BlueJ;
import bluej.extensions.Extension;
import class_diagram_editor.bluej_adapters.menu.BlueJMenuGenerator;

public class BlueJExtension extends Extension {
    public boolean isCompatible() {
        return true;
    }

    public void startup(BlueJ blueJ) {
        blueJ.setMenuGenerator(new BlueJMenuGenerator());
    }

    public String getName() {
        return "Klasseneditor";
    }

    public String getVersion() {
        return "0.0.1";
    }
}
