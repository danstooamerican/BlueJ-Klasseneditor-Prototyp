/**
 */
package class_diagram_editor.diagram.model.classdiagram;

import class_diagram_editor.diagram.model.classdiagram.impl.ClassdiagramPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramFactory
 * @model kind="package"
 * @generated
 */
public interface ClassdiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdiagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org/eclipse/classdiagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.classdiagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdiagramPackage eINSTANCE = ClassdiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link classdiagram.impl.ClassModelImpl <em>Class Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classdiagram.impl.ClassModelImpl
	 * @see classdiagram.impl.ClassdiagramPackageImpl#getClassModel()
	 * @generated
	 */
	int CLASS_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Abstract Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODEL__ABSTRACT_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODEL__EXTENDS = 2;

	/**
	 * The number of structural features of the '<em>Class Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Class Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classdiagram.impl.ClassDiagramImpl
	 * @see classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
	 * @generated
	 */
	int CLASS_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__CLASSES = 0;

	/**
	 * The number of structural features of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link classdiagram.ClassModel <em>Class Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Model</em>'.
	 * @see classdiagram.ClassModel
	 * @generated
	 */
	EClass getClassModel();

	/**
	 * Returns the meta object for the attribute '{@link classdiagram.ClassModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see classdiagram.ClassModel#getName()
	 * @see #getClassModel()
	 * @generated
	 */
	EAttribute getClassModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link classdiagram.ClassModel#isAbstractClass <em>Abstract Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract Class</em>'.
	 * @see classdiagram.ClassModel#isAbstractClass()
	 * @see #getClassModel()
	 * @generated
	 */
	EAttribute getClassModel_AbstractClass();

	/**
	 * Returns the meta object for the reference '{@link classdiagram.ClassModel#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extends</em>'.
	 * @see classdiagram.ClassModel#getExtends()
	 * @see #getClassModel()
	 * @generated
	 */
	EReference getClassModel_Extends();

	/**
	 * Returns the meta object for class '{@link classdiagram.ClassDiagram <em>Class Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Diagram</em>'.
	 * @see classdiagram.ClassDiagram
	 * @generated
	 */
	EClass getClassDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link classdiagram.ClassDiagram#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see classdiagram.ClassDiagram#getClasses()
	 * @see #getClassDiagram()
	 * @generated
	 */
	EReference getClassDiagram_Classes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassdiagramFactory getClassdiagramFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link classdiagram.impl.ClassModelImpl <em>Class Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classdiagram.impl.ClassModelImpl
		 * @see classdiagram.impl.ClassdiagramPackageImpl#getClassModel()
		 * @generated
		 */
		EClass CLASS_MODEL = eINSTANCE.getClassModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MODEL__NAME = eINSTANCE.getClassModel_Name();

		/**
		 * The meta object literal for the '<em><b>Abstract Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MODEL__ABSTRACT_CLASS = eINSTANCE.getClassModel_AbstractClass();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MODEL__EXTENDS = eINSTANCE.getClassModel_Extends();

		/**
		 * The meta object literal for the '{@link classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classdiagram.impl.ClassDiagramImpl
		 * @see classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
		 * @generated
		 */
		EClass CLASS_DIAGRAM = eINSTANCE.getClassDiagram();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DIAGRAM__CLASSES = eINSTANCE.getClassDiagram_Classes();

	}

} //ClassdiagramPackage
