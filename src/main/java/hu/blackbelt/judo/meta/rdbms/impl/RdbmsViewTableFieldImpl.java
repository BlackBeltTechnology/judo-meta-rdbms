/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Table Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewTableFieldImpl#getTableField <em>Table Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewTableFieldImpl#isForeign <em>Foreign</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsViewTableFieldImpl extends RdbmsViewFieldImpl implements RdbmsViewTableField {
    /**
     * The default value of the '{@link #isForeign() <em>Foreign</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForeign()
     * @generated
     * @ordered
     */
    protected static final boolean FOREIGN_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewTableFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_TABLE_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsField getTableField() {
        return (RdbmsField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsField basicGetTableField() {
        return (RdbmsField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTableField(RdbmsField newTableField) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD, newTableField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForeign() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__FOREIGN, RdbmsPackage.Literals.RDBMS_VIEW_TABLE_FIELD__FOREIGN, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForeign(boolean newForeign) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__FOREIGN, RdbmsPackage.Literals.RDBMS_VIEW_TABLE_FIELD__FOREIGN, newForeign);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD:
                if (resolve) return getTableField();
                return basicGetTableField();
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__FOREIGN:
                return isForeign();
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
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD:
                setTableField((RdbmsField)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__FOREIGN:
                setForeign((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD:
                setTableField((RdbmsField)null);
                return;
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__FOREIGN:
                setForeign(FOREIGN_EDEFAULT);
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
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD:
                return basicGetTableField() != null;
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD__FOREIGN:
                return isForeign() != FOREIGN_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewTableFieldImpl
