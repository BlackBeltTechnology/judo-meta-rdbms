/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableOperationImpl#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsTableOperationImpl extends RdbmsElementImpl implements RdbmsTableOperation {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsTableOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_TABLE_OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable getTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE, RdbmsPackage.Literals.RDBMS_TABLE_OPERATION__TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable basicGetTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE, RdbmsPackage.Literals.RDBMS_TABLE_OPERATION__TABLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTable(RdbmsTable newTable) {
        eDynamicSet(RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE, RdbmsPackage.Literals.RDBMS_TABLE_OPERATION__TABLE, newTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE:
                if (resolve) return getTable();
                return basicGetTable();
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
            case RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE:
                setTable((RdbmsTable)newValue);
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
            case RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE:
                setTable((RdbmsTable)null);
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
            case RdbmsPackage.RDBMS_TABLE_OPERATION__TABLE:
                return basicGetTable() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsTableOperationImpl
