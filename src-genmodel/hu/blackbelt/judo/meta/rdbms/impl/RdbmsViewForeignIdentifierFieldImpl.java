/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Foreign Identifier Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewForeignIdentifierFieldImpl#getReferenceIdentifier <em>Reference Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsViewForeignIdentifierFieldImpl extends RdbmsViewTableFieldImpl implements RdbmsViewForeignIdentifierField {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewForeignIdentifierFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField getReferenceIdentifier() {
        return (RdbmsViewIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER, RdbmsPackage.Literals.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField basicGetReferenceIdentifier() {
        return (RdbmsViewIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER, RdbmsPackage.Literals.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferenceIdentifier(RdbmsViewIdentifierField newReferenceIdentifier) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER, RdbmsPackage.Literals.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER, newReferenceIdentifier);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER:
                if (resolve) return getReferenceIdentifier();
                return basicGetReferenceIdentifier();
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
            case RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER:
                setReferenceIdentifier((RdbmsViewIdentifierField)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER:
                setReferenceIdentifier((RdbmsViewIdentifierField)null);
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
            case RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER:
                return basicGetReferenceIdentifier() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewForeignIdentifierFieldImpl
