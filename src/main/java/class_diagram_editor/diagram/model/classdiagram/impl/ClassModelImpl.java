/**
 */
package class_diagram_editor.diagram.model.classdiagram.impl;

import class_diagram_editor.code_generation.CodeGenerator;
import class_diagram_editor.diagram.model.classdiagram.ClassModel;
import class_diagram_editor.diagram.model.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.ClassModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link classdiagram.impl.ClassModelImpl#isAbstractClass <em>Abstract Class</em>}</li>
 *   <li>{@link classdiagram.impl.ClassModelImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassModelImpl extends MinimalEObjectImpl.Container implements ClassModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstractClass() <em>Abstract Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstractClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstractClass() <em>Abstract Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstractClass()
	 * @generated
	 * @ordered
	 */
	protected boolean abstractClass = ABSTRACT_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected ClassModel extends_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramPackage.Literals.CLASS_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	@Override
	public void accept(CodeGenerator codeGenerator) {
		codeGenerator.visitClass(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstractClass() {
		return abstractClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractClass(boolean newAbstractClass) {
		boolean oldAbstractClass = abstractClass;
		abstractClass = newAbstractClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS_MODEL__ABSTRACT_CLASS, oldAbstractClass, abstractClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassModel getExtends() {
		if (extends_ != null && extends_.eIsProxy()) {
			InternalEObject oldExtends = (InternalEObject)extends_;
			extends_ = (ClassModel)eResolveProxy(oldExtends);
			if (extends_ != oldExtends) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.CLASS_MODEL__EXTENDS, oldExtends, extends_));
			}
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassModel basicGetExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(ClassModel newExtends) {
		ClassModel oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS_MODEL__EXTENDS, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramPackage.CLASS_MODEL__NAME:
				return getName();
			case ClassdiagramPackage.CLASS_MODEL__ABSTRACT_CLASS:
				return isAbstractClass();
			case ClassdiagramPackage.CLASS_MODEL__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassdiagramPackage.CLASS_MODEL__NAME:
				setName((String)newValue);
				return;
			case ClassdiagramPackage.CLASS_MODEL__ABSTRACT_CLASS:
				setAbstractClass((Boolean)newValue);
				return;
			case ClassdiagramPackage.CLASS_MODEL__EXTENDS:
				setExtends((ClassModel)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ClassdiagramPackage.CLASS_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ClassdiagramPackage.CLASS_MODEL__ABSTRACT_CLASS:
				setAbstractClass(ABSTRACT_CLASS_EDEFAULT);
				return;
			case ClassdiagramPackage.CLASS_MODEL__EXTENDS:
				setExtends((ClassModel)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ClassdiagramPackage.CLASS_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ClassdiagramPackage.CLASS_MODEL__ABSTRACT_CLASS:
				return abstractClass != ABSTRACT_CLASS_EDEFAULT;
			case ClassdiagramPackage.CLASS_MODEL__EXTENDS:
				return extends_ != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", abstractClass: ");
		result.append(abstractClass);
		result.append(')');
		return result.toString();
	}

} //ClassModelImpl
