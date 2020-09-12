package class_diagram_editor.presentation.main_screen.skins.generators;

import class_diagram_editor.diagram.AttributeModel;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class UMLAttributeGenerator {
  public String generate(final AttributeModel attributeModel) {
    StringConcatenation _builder = new StringConcatenation();
    String _symbol = attributeModel.getVisibility().getSymbol();
    _builder.append(_symbol);
    _builder.append(" ");
    String _name = attributeModel.getName();
    _builder.append(_name);
    _builder.append(" : ");
    String _type = attributeModel.getType();
    _builder.append(_type);
    {
      boolean _isFinal = attributeModel.isFinal();
      if (_isFinal) {
        _builder.append(" {readOnly}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
