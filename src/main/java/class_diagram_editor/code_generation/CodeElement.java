package class_diagram_editor.code_generation;

public interface CodeElement {

    String getName();

    CodeElementType getType();

    void accept(CodeGenerator codeGenerator);

}
