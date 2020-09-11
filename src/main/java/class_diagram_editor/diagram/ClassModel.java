package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;
import class_diagram_editor.code_generation.CodeGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
public class ClassModel implements CodeElement {

    private String name;

    @Getter(AccessLevel.NONE)
    private boolean isAbstract;

    private ClassModel extendsClass;
    private Collection<InterfaceModel> implementsInterfaces;

    private List<AttributeModel> attributes;
    private List<MethodModel> methods;

    public ClassModel() {
        this.implementsInterfaces = new ArrayList<>();
        this.attributes = new ArrayList<>();
        this.methods = new ArrayList<>();
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

}
