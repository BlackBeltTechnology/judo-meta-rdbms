/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modify Table Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl#getCreateFieldOperations <em>Create Field Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl#getModifyFieldOperations <em>Modify Field Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl#getDeleteFieldOperations <em>Delete Field Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl#getPreviousTable <em>Previous Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl#isNameChanged <em>Name Changed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsModifyTableOperationImpl extends RdbmsTableOperationImpl implements RdbmsModifyTableOperation {
    /**
     * The default value of the '{@link #isNameChanged() <em>Name Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNameChanged()
     * @generated
     * @ordered
     */
    protected static final boolean NAME_CHANGED_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsModifyTableOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsCreateFieldOperation> getCreateFieldOperations() {
        return (EList<RdbmsCreateFieldOperation>)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsModifyFieldOperation> getModifyFieldOperations() {
        return (EList<RdbmsModifyFieldOperation>)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsDeleteFieldOperation> getDeleteFieldOperations() {
        return (EList<RdbmsDeleteFieldOperation>)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable getPreviousTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable basicGetPreviousTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPreviousTable(RdbmsTable newPreviousTable) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE, newPreviousTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNameChanged() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNameChanged(boolean newNameChanged) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED, newNameChanged);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS:
                return ((InternalEList<?>)getCreateFieldOperations()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS:
                return ((InternalEList<?>)getModifyFieldOperations()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS:
                return ((InternalEList<?>)getDeleteFieldOperations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS:
                return getCreateFieldOperations();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS:
                return getModifyFieldOperations();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS:
                return getDeleteFieldOperations();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE:
                if (resolve) return getPreviousTable();
                return basicGetPreviousTable();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED:
                return isNameChanged();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS:
                getCreateFieldOperations().clear();
                getCreateFieldOperations().addAll((Collection<? extends RdbmsCreateFieldOperation>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS:
                getModifyFieldOperations().clear();
                getModifyFieldOperations().addAll((Collection<? extends RdbmsModifyFieldOperation>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS:
                getDeleteFieldOperations().clear();
                getDeleteFieldOperations().addAll((Collection<? extends RdbmsDeleteFieldOperation>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE:
                setPreviousTable((RdbmsTable)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED:
                setNameChanged((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS:
                getCreateFieldOperations().clear();
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS:
                getModifyFieldOperations().clear();
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS:
                getDeleteFieldOperations().clear();
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE:
                setPreviousTable((RdbmsTable)null);
                return;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED:
                setNameChanged(NAME_CHANGED_EDEFAULT);
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
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS:
                return !getCreateFieldOperations().isEmpty();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS:
                return !getModifyFieldOperations().isEmpty();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS:
                return !getDeleteFieldOperations().isEmpty();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE:
                return basicGetPreviousTable() != null;
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED:
                return isNameChanged() != NAME_CHANGED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsModifyTableOperationImpl
