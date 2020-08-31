package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.code_generation.CodeElementType;
import class_diagram_editor.code_generation.CodeGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Class implements CodeElement {

    private String name;

    @Override
    public CodeElementType getType() {
        return CodeElementType.CLASS;
    }

    @Override
    public void accept(CodeGenerator codeGenerator) {
        codeGenerator.visitClass(this);
    }
}
