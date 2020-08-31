package class_diagram_editor.diagram.code_generation

import class_diagram_editor.diagram.Class;

class ClassModel {

    def String generate(Class c) '''
        public «IF c.isAbstract()»abstract«ENDIF»class «c.getName()» «IF c.isExtending()»extends «c.getExtends()»«ENDIF» {

        }
    '''

}