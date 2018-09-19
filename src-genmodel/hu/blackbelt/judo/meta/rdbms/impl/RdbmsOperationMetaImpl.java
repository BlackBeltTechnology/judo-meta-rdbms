/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsOperationMetaImpl#getPreviousModel <em>Previous Model</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsOperationMetaImpl#getCurrentModel <em>Current Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsOperationMetaImpl extends MinimalEObjectImpl.Container implements RdbmsOperationMeta {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsOperationMetaImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_OPERATION_META;
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
    public RdbmsModel getPreviousModel() {
        return (RdbmsModel)eDynamicGet(RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL, RdbmsPackage.Literals.RDBMS_OPERATION_META__PREVIOUS_MODEL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsModel basicGetPreviousModel() {
        return (RdbmsModel)eDynamicGet(RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL, RdbmsPackage.Literals.RDBMS_OPERATION_META__PREVIOUS_MODEL, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPreviousModel(RdbmsModel newPreviousModel) {
        eDynamicSet(RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL, RdbmsPackage.Literals.RDBMS_OPERATION_META__PREVIOUS_MODEL, newPreviousModel);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsModel getCurrentModel() {
        return (RdbmsModel)eDynamicGet(RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL, RdbmsPackage.Literals.RDBMS_OPERATION_META__CURRENT_MODEL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsModel basicGetCurrentModel() {
        return (RdbmsModel)eDynamicGet(RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL, RdbmsPackage.Literals.RDBMS_OPERATION_META__CURRENT_MODEL, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCurrentModel(RdbmsModel newCurrentModel) {
        eDynamicSet(RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL, RdbmsPackage.Literals.RDBMS_OPERATION_META__CURRENT_MODEL, newCurrentModel);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL:
                if (resolve) return getPreviousModel();
                return basicGetPreviousModel();
            case RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL:
                if (resolve) return getCurrentModel();
                return basicGetCurrentModel();
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
            case RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL:
                setPreviousModel((RdbmsModel)newValue);
                return;
            case RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL:
                setCurrentModel((RdbmsModel)newValue);
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
            case RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL:
                setPreviousModel((RdbmsModel)null);
                return;
            case RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL:
                setCurrentModel((RdbmsModel)null);
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
            case RdbmsPackage.RDBMS_OPERATION_META__PREVIOUS_MODEL:
                return basicGetPreviousModel() != null;
            case RdbmsPackage.RDBMS_OPERATION_META__CURRENT_MODEL:
                return basicGetCurrentModel() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsOperationMetaImpl
