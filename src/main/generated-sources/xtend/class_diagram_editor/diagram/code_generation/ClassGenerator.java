package class_diagram_editor.diagram.code_generation;

import class_diagram_editor.code_generation.generators.Generator;
import class_diagram_editor.diagram.ClassModel;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ClassGenerator extends Generator<ClassModel> {
  @Override
  public String generate(final ClassModel c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    {
      boolean _isAbstract = c.isAbstract();
      if (_isAbstract) {
        _builder.append("abstract ");
      }
    }
    _builder.append("class ");
    String _name = c.getName();
    _builder.append(_name);
    _builder.append(" ");
    {
      boolean _isExtending = c.isExtending();
      if (_isExtending) {
        _builder.append("extends ");
        ClassModel _extendsClass = c.getExtendsClass();
        _builder.append(_extendsClass);
        _builder.append(" ");
      }
    }
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
