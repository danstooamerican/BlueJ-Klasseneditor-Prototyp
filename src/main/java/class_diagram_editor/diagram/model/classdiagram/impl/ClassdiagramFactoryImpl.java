/**
 */
package class_diagram_editor.diagram.model.classdiagram.impl;

import class_diagram_editor.diagram.model.classdiagram.ClassDiagram;
import class_diagram_editor.diagram.model.classdiagram.ClassModel;
import class_diagram_editor.diagram.model.classdiagram.ClassdiagramFactory;
import class_diagram_editor.diagram.model.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramFactoryImpl extends EFactoryImpl implements ClassdiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassdiagramFactory init() {
		try {
			ClassdiagramFactory theClassdiagramFactory = (ClassdiagramFactory)EPackage.Registry.INSTANCE.getEFactory(ClassdiagramPackage.eNS_URI);
			if (theClassdiagramFactory != null) {
				return theClassdiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassdiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ClassdiagramPackage.CLASS_MODEL: return createClassModel();
			case ClassdiagramPackage.CLASS_DIAGRAM: return createClassDiagram();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassModel createClassModel() {
		ClassModelImpl classModel = new ClassModelImpl();
		return classModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDiagram createClassDiagram() {
		ClassDiagramImpl classDiagram = new ClassDiagramImpl();
		return classDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdiagramPackage getClassdiagramPackage() {
		return (ClassdiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassdiagramPackage getPackage() {
		return ClassdiagramPackage.eINSTANCE;
	}

} //ClassdiagramFactoryImpl
