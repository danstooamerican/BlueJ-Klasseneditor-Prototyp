package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.code_generation.CodeElementType;
import class_diagram_editor.code_generation.CodeGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Class implements CodeElement {

    private boolean isAbstract;

    @Getter
    private String name;

    private Class extendsClass;

    @Override
    public CodeElementType getType() {
        return CodeElementType.CLASS;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public boolean isExtending() {
        return extendsClass != null;
    }

    public String getExtends() {
        if (isExtending()) {
            return extendsClass.getName();
        }

        return "";
    }

    @Override
    public void accept(CodeGenerator codeGenerator) {
        codeGenerator.visitClass(this);
    }
}
