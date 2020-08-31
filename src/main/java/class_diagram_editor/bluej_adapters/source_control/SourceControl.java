package class_diagram_editor.bluej_adapters.source_control;

import bluej.extensions.*;
import bluej.extensions.editor.Editor;
import bluej.extensions.editor.TextLocation;
import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.code_generation.CodeGenerator;
import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.ClassDiagram;
import class_diagram_editor.diagram.SourceCodeControl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SourceControl implements SourceCodeControl {

    private static final TextLocation START_LOCATION = new TextLocation(0, 0);

    private final BProject project;
    private final CodeGenerator codeGenerator;

    public SourceControl(BProject project) {
        this.project = project;
        this.codeGenerator = new CodeGenerator();
    }

    @Override
    public void generate(ClassDiagram classDiagram) {
        Iterator<CodeElement> iterator = classDiagram.iterator();

        try {
            BPackage bpackage = project.getPackages()[0];

            while (iterator.hasNext()) {
                CodeElement codeElement = iterator.next();

                Editor editor = createFile(bpackage, codeElement);

                if (editor != null) {
                    generateElement(editor, codeElement);
                } else {
                    System.err.println("Error generating code for " + codeElement.getName() + ".java");
                }
            }
        } catch (ProjectNotOpenException e) {
            e.printStackTrace();
        }
    }

    private Editor createFile(BPackage bPackage, CodeElement codeElement) {
        Editor editor = null;

        try {
            File javaFile = new File(bPackage.getDir(), codeElement.getName() + ".java");

            if (javaFile.exists()) {
                editor = getBlueJEditor(bPackage, codeElement);
            } else {
                if (javaFile.createNewFile()) {
                    editor = createBlueJEditor(bPackage, codeElement);
                }
            }
        } catch (ProjectNotOpenException | PackageNotFoundException | MissingJavaFileException | IOException e) {
            e.printStackTrace();
        }

        return editor;
    }

    private Editor createBlueJEditor(BPackage bpackage, CodeElement codeElement)
            throws ProjectNotOpenException, MissingJavaFileException, PackageNotFoundException {
        switch (codeElement.getType()) {
            case CLASS:
                return bpackage.newClass(codeElement.getName()).getEditor();
            default:
                throw new NotImplementedException();
        }
    }

    private Editor getBlueJEditor(BPackage bpackage, CodeElement codeElement)
            throws ProjectNotOpenException, PackageNotFoundException {
        switch (codeElement.getType()) {
            case CLASS:
                return bpackage.getBClass(codeElement.getName()).getEditor();
            default:
                throw new NotImplementedException();
        }
    }

    private void generateElement(Editor editor, CodeElement codeElement) {
        editor.setReadOnly(true);

        // line index is zero indexed
        int lastLine = editor.getLineCount() - 1;
        int lastColumn = editor.getLineLength(lastLine);

        codeElement.accept(codeGenerator);

        editor.setText(START_LOCATION, new TextLocation(lastLine, lastColumn), codeGenerator.getLastGeneratedCode());

        editor.saveFile();

        editor.setReadOnly(false);
    }
}
