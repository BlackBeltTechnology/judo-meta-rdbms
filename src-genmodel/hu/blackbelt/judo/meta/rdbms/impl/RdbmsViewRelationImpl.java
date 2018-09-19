/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl#getFromAlias <em>From Alias</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl#getToAlias <em>To Alias</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl#getFromField <em>From Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl#getToField <em>To Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsViewRelationImpl extends MinimalEObjectImpl.Container implements RdbmsViewRelation {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewRelationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_RELATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias getFromAlias() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__FROM_ALIAS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias basicGetFromAlias() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__FROM_ALIAS, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFromAlias(RdbmsTableAlias newFromAlias) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__FROM_ALIAS, newFromAlias);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias getToAlias() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__TO_ALIAS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias basicGetToAlias() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__TO_ALIAS, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setToAlias(RdbmsTableAlias newToAlias) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__TO_ALIAS, newToAlias);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__NAME, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RELATION__NAME, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__NAME, newName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField getFromField() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__FROM_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField basicGetFromField() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__FROM_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFromField(RdbmsIdentifierField newFromField) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__FROM_FIELD, newFromField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField getToField() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__TO_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField basicGetToField() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__TO_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setToField(RdbmsIdentifierField newToField) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RELATION__TO_FIELD, newToField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS:
                if (resolve) return getFromAlias();
                return basicGetFromAlias();
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS:
                if (resolve) return getToAlias();
                return basicGetToAlias();
            case RdbmsPackage.RDBMS_VIEW_RELATION__NAME:
                return getName();
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD:
                if (resolve) return getFromField();
                return basicGetFromField();
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD:
                if (resolve) return getToField();
                return basicGetToField();
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
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS:
                setFromAlias((RdbmsTableAlias)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS:
                setToAlias((RdbmsTableAlias)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__NAME:
                setName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD:
                setFromField((RdbmsIdentifierField)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD:
                setToField((RdbmsIdentifierField)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS:
                setFromAlias((RdbmsTableAlias)null);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS:
                setToAlias((RdbmsTableAlias)null);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD:
                setFromField((RdbmsIdentifierField)null);
                return;
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD:
                setToField((RdbmsIdentifierField)null);
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
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_ALIAS:
                return basicGetFromAlias() != null;
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_ALIAS:
                return basicGetToAlias() != null;
            case RdbmsPackage.RDBMS_VIEW_RELATION__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
            case RdbmsPackage.RDBMS_VIEW_RELATION__FROM_FIELD:
                return basicGetFromField() != null;
            case RdbmsPackage.RDBMS_VIEW_RELATION__TO_FIELD:
                return basicGetToField() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewRelationImpl
