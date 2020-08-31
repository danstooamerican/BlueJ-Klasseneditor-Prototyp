package class_diagram_editor.code_generation;

import class_diagram_editor.diagram.Class;
import class_diagram_editor.diagram.code_generation.ClassModel;
import lombok.Getter;

@Getter
public class CodeGenerator {

    private String lastGeneratedCode;

    private void generate(String code) {
        lastGeneratedCode = code;
    }

    public void visitClass(Class c) {
        ClassModel classModel = new ClassModel();

        generate(classModel.generate(c));
    }

}
