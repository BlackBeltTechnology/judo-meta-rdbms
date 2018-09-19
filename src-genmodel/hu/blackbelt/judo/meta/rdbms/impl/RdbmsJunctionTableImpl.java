/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Junction Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsJunctionTableImpl#getField1 <em>Field1</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsJunctionTableImpl#getField2 <em>Field2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsJunctionTableImpl extends RdbmsTableImpl implements RdbmsJunctionTable {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsJunctionTableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsForeignKey getField1() {
        return (RdbmsForeignKey)eDynamicGet(RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE__FIELD1, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsForeignKey basicGetField1() {
        return (RdbmsForeignKey)eDynamicGet(RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE__FIELD1, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setField1(RdbmsForeignKey newField1) {
        eDynamicSet(RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE__FIELD1, newField1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsForeignKey getField2() {
        return (RdbmsForeignKey)eDynamicGet(RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE__FIELD2, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsForeignKey basicGetField2() {
        return (RdbmsForeignKey)eDynamicGet(RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE__FIELD2, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setField2(RdbmsForeignKey newField2) {
        eDynamicSet(RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE__FIELD2, newField2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1:
                if (resolve) return getField1();
                return basicGetField1();
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2:
                if (resolve) return getField2();
                return basicGetField2();
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
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1:
                setField1((RdbmsForeignKey)newValue);
                return;
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2:
                setField2((RdbmsForeignKey)newValue);
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
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1:
                setField1((RdbmsForeignKey)null);
                return;
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2:
                setField2((RdbmsForeignKey)null);
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
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD1:
                return basicGetField1() != null;
            case RdbmsPackage.RDBMS_JUNCTION_TABLE__FIELD2:
                return basicGetField2() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsJunctionTableImpl
