package bluej_adapters;

import bluej.extensions.event.PackageEvent;
import bluej.extensions.event.PackageListener;

public class BlueJPackeListener implements PackageListener {
    @Override
    public void packageOpened(PackageEvent packageEvent) {
        System.out.println("package opened");
    }

    @Override
    public void packageClosing(PackageEvent packageEvent) {
        System.out.println("package closed");
    }
}
