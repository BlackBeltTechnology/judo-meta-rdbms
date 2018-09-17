/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Alias Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewAliasFieldImpl#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsViewAliasFieldImpl extends RdbmsViewTableFieldImpl implements RdbmsViewAliasField {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewAliasFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_ALIAS_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias getAlias() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_ALIAS_FIELD__ALIAS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias basicGetAlias() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_ALIAS_FIELD__ALIAS, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlias(RdbmsTableAlias newAlias) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS, RdbmsPackage.Literals.RDBMS_VIEW_ALIAS_FIELD__ALIAS, newAlias);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS:
                if (resolve) return getAlias();
                return basicGetAlias();
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
            case RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS:
                setAlias((RdbmsTableAlias)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS:
                setAlias((RdbmsTableAlias)null);
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
            case RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD__ALIAS:
                return basicGetAlias() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewAliasFieldImpl
