package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ClassDiagram implements Observable<ClassDiagram> {

    private final Map<String, CodeElement> codeElements;

    private final Collection<Subject<ClassDiagram>> subjects;

    public ClassDiagram() {
        this.codeElements = new HashMap<>();
        this.subjects = new ArrayList<>();
    }

    public void addClass(Class c) {
        codeElements.put(c.getName(), c);

        updateAll();
    }

    public Collection<CodeElement> getCodeElements() {
        return new ArrayList<>(codeElements.values());
    }

    public Iterator<CodeElement> iterator() {
        return new ClassDiagramIterator(this);
    }

    @Override
    public void subscribe(Subject<ClassDiagram> subject) {
        subjects.add(subject);
    }

    @Override
    public void unsubscribe(Subject<ClassDiagram> subject) {
        subjects.remove(subject);
    }

    @Override
    public void updateAll() {
        subjects.forEach(s -> s.update(this));
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
