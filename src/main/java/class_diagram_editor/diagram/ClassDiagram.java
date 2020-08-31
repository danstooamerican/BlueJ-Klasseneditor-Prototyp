package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;

import java.util.Iterator;

public class ClassDiagram {

    public Iterator<CodeElement> iterator() {
        return new ClassDiagramIterator(this);
    }

    private static class ClassDiagramIterator implements Iterator<CodeElement> {

        private final ClassDiagram classDiagram;

        public ClassDiagramIterator(ClassDiagram classDiagram) {
            this.classDiagram = classDiagram;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public CodeElement next() {
            return null;
        }
    }

}
