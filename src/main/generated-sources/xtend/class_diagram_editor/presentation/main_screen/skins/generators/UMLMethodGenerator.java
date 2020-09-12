package class_diagram_editor.presentation.main_screen.skins.generators;

import class_diagram_editor.diagram.AttributeModel;
import class_diagram_editor.diagram.MethodModel;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class UMLMethodGenerator {
  public String generate(final MethodModel methodModel) {
    StringConcatenation _builder = new StringConcatenation();
    String _symbol = methodModel.getVisibility().getSymbol();
    _builder.append(_symbol);
    _builder.append(" ");
    String _name = methodModel.getName();
    _builder.append(_name);
    {
      List<AttributeModel> _attributes = methodModel.getAttributes();
      boolean _hasElements = false;
      for(final AttributeModel attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("(");
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.newLineIfNotEmpty();
        String _name_1 = attribute.getName();
        _builder.append(_name_1);
        _builder.append(" : ");
        String _type = attribute.getType();
        _builder.append(_type);
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
      }
      if (_hasElements) {
        _builder.append(")");
      }
    }
    _builder.append(" ");
    {
      String _returnType = methodModel.getReturnType();
      boolean _tripleNotEquals = (_returnType != null);
      if (_tripleNotEquals) {
        _builder.append(": ");
        String _returnType_1 = methodModel.getReturnType();
        _builder.append(_returnType_1);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
