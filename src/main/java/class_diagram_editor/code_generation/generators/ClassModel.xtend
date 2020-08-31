package class_diagram_editor.diagram.code_generation

import class_diagram_editor.diagram.Class;

class ClassModel {

    def String generate(Class c) '''
        public class «c.getName()» {

        }
    '''

}