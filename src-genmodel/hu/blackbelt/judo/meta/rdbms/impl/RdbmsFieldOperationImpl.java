/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldOperationImpl#getField <em>Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldOperationImpl#isReviewRequired <em>Review Required</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsFieldOperationImpl extends RdbmsElementImpl implements RdbmsFieldOperation {
    /**
     * The default value of the '{@link #isReviewRequired() <em>Review Required</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReviewRequired()
     * @generated
     * @ordered
     */
    protected static final boolean REVIEW_REQUIRED_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsFieldOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_FIELD_OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsField getField() {
        return (RdbmsField)eDynamicGet(RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD, RdbmsPackage.Literals.RDBMS_FIELD_OPERATION__FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsField basicGetField() {
        return (RdbmsField)eDynamicGet(RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD, RdbmsPackage.Literals.RDBMS_FIELD_OPERATION__FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setField(RdbmsField newField) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD, RdbmsPackage.Literals.RDBMS_FIELD_OPERATION__FIELD, newField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReviewRequired() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED, RdbmsPackage.Literals.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReviewRequired(boolean newReviewRequired) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED, RdbmsPackage.Literals.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED, newReviewRequired);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD:
                if (resolve) return getField();
                return basicGetField();
            case RdbmsPackage.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED:
                return isReviewRequired();
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
            case RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD:
                setField((RdbmsField)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED:
                setReviewRequired((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD:
                setField((RdbmsField)null);
                return;
            case RdbmsPackage.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED:
                setReviewRequired(REVIEW_REQUIRED_EDEFAULT);
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
            case RdbmsPackage.RDBMS_FIELD_OPERATION__FIELD:
                return basicGetField() != null;
            case RdbmsPackage.RDBMS_FIELD_OPERATION__REVIEW_REQUIRED:
                return isReviewRequired() != REVIEW_REQUIRED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsFieldOperationImpl
