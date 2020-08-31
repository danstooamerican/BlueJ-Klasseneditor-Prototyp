package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;
import lombok.Getter;

import java.util.*;

public class ClassDiagram {

    private final Map<String, CodeElement> codeElements;

    public ClassDiagram() {
        this.codeElements = new HashMap<>();
    }

    public void addClass(Class c) {
        codeElements.put(c.getName(), c);
    }

    public Collection<CodeElement> getCodeElements() {
        return new ArrayList<>(codeElements.values());
    }

    public Iterator<CodeElement> iterator() {
        return new ClassDiagramIterator(this);
    }

    private static class ClassDiagramIterator implements Iterator<CodeElement> {

        private final List<CodeElement> codeElements;
        private int currentElement;

        public ClassDiagramIterator(ClassDiagram classDiagram) {
            this.currentElement = 0;
            this.codeElements = new ArrayList<>(classDiagram.getCodeElements());
        }

        @Override
        public boolean hasNext() {
            return currentElement < codeElements.size();
        }

        @Override
        public CodeElement next() {
            int temp = currentElement;

            currentElement++;

            return codeElements.get(temp);
        }
    }

}
