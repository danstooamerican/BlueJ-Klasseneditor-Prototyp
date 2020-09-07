/**
 */
package class_diagram_editor.diagram.model.classdiagram;

import class_diagram_editor.code_generation.CodeElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.ClassModel#getName <em>Name</em>}</li>
 *   <li>{@link classdiagram.ClassModel#isAbstractClass <em>Abstract Class</em>}</li>
 *   <li>{@link classdiagram.ClassModel#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getClassModel()
 * @model
 * @generated
 */
public interface ClassModel extends EObject, CodeElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see classdiagram.ClassdiagramPackage#getClassModel_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link classdiagram.ClassModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Abstract Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Class</em>' attribute.
	 * @see #setAbstractClass(boolean)
	 * @see classdiagram.ClassdiagramPackage#getClassModel_AbstractClass()
	 * @model
	 * @generated
	 */
	boolean isAbstractClass();

	/**
	 * Sets the value of the '{@link classdiagram.ClassModel#isAbstractClass <em>Abstract Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Class</em>' attribute.
	 * @see #isAbstractClass()
	 * @generated
	 */
	void setAbstractClass(boolean value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(ClassModel)
	 * @see classdiagram.ClassdiagramPackage#getClassModel_Extends()
	 * @model
	 * @generated
	 */
	ClassModel getExtends();

	/**
	 * Sets the value of the '{@link classdiagram.ClassModel#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(ClassModel value);

} // ClassModel
