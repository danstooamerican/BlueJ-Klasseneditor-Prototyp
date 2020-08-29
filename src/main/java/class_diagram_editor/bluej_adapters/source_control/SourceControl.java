package class_diagram_editor.bluej_adapters.source_control;

import bluej.extensions.*;
import bluej.extensions.editor.Editor;
import bluej.extensions.editor.TextLocation;
import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.SourceCodeControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SourceControl implements SourceCodeControl {

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

    @Override
    public void generateClass(Class c) {
        Editor editor = null;

        try {
            BPackage bpackage = project.getPackages()[0];
            BClass bclass;

            File javaFile = new File(bpackage.getDir(), c.getName() + ".java");

            if (!javaFile.exists()) {
                javaFile.createNewFile();

                bclass = bpackage.newClass(c.getName(), SourceType.Java);
            } else {
                bclass = bpackage.getBClass(c.getName());
            }

            editor = bclass.getEditor();
            editor.setReadOnly(true);

            // line index is zero indexed
            int lastLine = editor.getLineCount() - 1;
            int lastColumn = editor.getLineLength(lastLine);

            editor.setText(new TextLocation(0, 0), new TextLocation(lastLine, lastColumn), "Hello World");

            editor.saveFile();
        } catch (ProjectNotOpenException | PackageNotFoundException | MissingJavaFileException | IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (editor != null) {
                editor.setReadOnly(false);
            }
        }
    }
}
