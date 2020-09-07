/**
 */
package class_diagram_editor.diagram.model.classdiagram;

import class_diagram_editor.diagram.model.classdiagram.impl.ClassdiagramFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage
 * @generated
 */
public interface ClassdiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdiagramFactory eINSTANCE = ClassdiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Model</em>'.
	 * @generated
	 */
	ClassModel createClassModel();

	/**
	 * Returns a new object of class '<em>Class Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Diagram</em>'.
	 * @generated
	 */
	ClassDiagram createClassDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassdiagramPackage getClassdiagramPackage();

} //ClassdiagramFactory
