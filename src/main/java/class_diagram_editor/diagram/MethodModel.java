package class_diagram_editor.diagram;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MethodModel {

    private String name;
    private String returnType;

    private List<AttributeModel> attributes;

    public MethodModel() {
        this.attributes = new ArrayList<>();
    }

    public boolean hasAttributes() {
        return !attributes.isEmpty();
    }
}
