/**
 */
package class_diagram_editor.diagram.model.classdiagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.ClassDiagram#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getClassDiagram()
 * @model
 * @generated
 */
public interface ClassDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link classdiagram.ClassModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see classdiagram.ClassdiagramPackage#getClassDiagram_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassModel> getClasses();

} // ClassDiagram
