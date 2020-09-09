package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.code_generation.CodeGenerator;
import lombok.Setter;

@Setter
public class ClassModel implements CodeElement {

    private String name;
    private ClassModel extendsClass;
    private boolean isAbstract;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(CodeGenerator codeGenerator) {
        codeGenerator.visitClass(this);
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public boolean isExtending() {
        return extendsClass != null;
    }

    public ClassModel getExtendsClass() {
        return extendsClass;
    }

}
