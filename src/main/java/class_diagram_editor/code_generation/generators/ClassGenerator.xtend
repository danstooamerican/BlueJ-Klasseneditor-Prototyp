package class_diagram_editor.diagram.code_generation

import class_diagram_editor.diagram.Class;
import class_diagram_editor.code_generation.generators.Generator;

class ClassGenerator extends Generator<Class> {

    override String generate(Class c) '''
        public «IF c.isAbstract()»abstract «ENDIF»class «c.getName()» «IF c.isExtending()»extends «c.getExtends()» «ENDIF»{

        }
    '''

}