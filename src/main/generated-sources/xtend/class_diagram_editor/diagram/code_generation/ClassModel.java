package class_diagram_editor.diagram.code_generation;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ClassModel {
  public String generate(final class_diagram_editor.diagram.Class c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _name = c.getName();
    _builder.append(_name);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
