package class_diagram_editor.diagram;

import class_diagram_editor.code_generation.CodeElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ClassDiagram {

    private final Map<String, ClassModel> classes;

    public ClassDiagram() {
        this.classes = new HashMap<>();
    }

    public String addCodeElement(ClassModel codeElement) {
        String uuid = UUID.randomUUID().toString();

        classes.put(uuid, codeElement);

        return uuid;
    }

    public void addExtendsRelation(String superClass, String extendingClass) {
        if (classes.containsKey(superClass) && classes.containsKey(extendingClass)) {
            ClassModel superClassModel = classes.get(superClass);
            ClassModel extendingClassModel = classes.get(extendingClass);

            extendingClassModel.setExtendsClass(superClassModel);
        }
    }

    public Iterator<CodeElement> iterator() {
        Collection<CodeElement> codeElements = new ArrayList<>(classes.values());

        return new ClassModelIterator(codeElements);
    }

    private static class ClassModelIterator implements Iterator<CodeElement> {

        private final List<CodeElement> codeElements;
        private int currentElement;

        public ClassModelIterator(Collection<CodeElement> codeElements) {
            this.codeElements = new ArrayList<>(codeElements);
            this.currentElement = 0;
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
