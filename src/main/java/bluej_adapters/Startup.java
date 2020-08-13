package bluej_adapters;

import bluej.extensions.BlueJ;
import bluej.extensions.Extension;

public class Startup extends Extension {
    public boolean isCompatible() {
        return true;
    }

    public void startup(BlueJ blueJ) {
        blueJ.addPackageListener(new BlueJPackeListener());
    }

    public String getName() {
        return "Klasseneditor";
    }

    public String getVersion() {
        return "0.0.1";
    }
}
