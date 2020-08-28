package class_diagram_editor.bluej_adapters.source_control;

import bluej.extensions.BPackage;
import bluej.extensions.BProject;
import bluej.extensions.PackageNotFoundException;
import bluej.extensions.ProjectNotOpenException;
import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.DiagramSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SourceControl implements DiagramSource {

    private final BProject project;

    public SourceControl(BProject project) {
        this.project = project;
    }

    @Override
    public Collection<Class> getAvailableClasses() {
        Collection<Class> classes = new ArrayList<>();

        try {
            for (BPackage bPackage : project.getPackages()) {
                try {
                    classes.addAll(Stream.of(bPackage.getClasses())
                            .map(bClass -> new Class(bClass.getName()))
                            .collect(toList()));
                } catch (PackageNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (ProjectNotOpenException e) {
            System.err.println(e.getMessage());
            classes = Collections.emptyList();
        }

        return classes;
    }
}
