package class_diagram_editor.code_generation.generators;

@SuppressWarnings("all")
public abstract class Generator<T extends Object> {
  public abstract String generate(final T type);
}
