/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration;
import hu.blackbelt.judo.meta.rdbms.RdbmsFeature;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsConfigurationImpl#getDialect <em>Dialect</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsConfigurationImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsConfigurationImpl extends MinimalEObjectImpl.Container implements RdbmsConfiguration {
    /**
     * The default value of the '{@link #getDialect() <em>Dialect</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDialect()
     * @generated
     * @ordered
     */
    protected static final String DIALECT_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsConfigurationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_CONFIGURATION;
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
    public String getDialect() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_CONFIGURATION__DIALECT, RdbmsPackage.Literals.RDBMS_CONFIGURATION__DIALECT, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDialect(String newDialect) {
        eDynamicSet(RdbmsPackage.RDBMS_CONFIGURATION__DIALECT, RdbmsPackage.Literals.RDBMS_CONFIGURATION__DIALECT, newDialect);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsFeature> getFeatures() {
        return (EList<RdbmsFeature>)eDynamicGet(RdbmsPackage.RDBMS_CONFIGURATION__FEATURES, RdbmsPackage.Literals.RDBMS_CONFIGURATION__FEATURES, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_CONFIGURATION__FEATURES:
                return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_CONFIGURATION__DIALECT:
                return getDialect();
            case RdbmsPackage.RDBMS_CONFIGURATION__FEATURES:
                return getFeatures();
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
            case RdbmsPackage.RDBMS_CONFIGURATION__DIALECT:
                setDialect((String)newValue);
                return;
            case RdbmsPackage.RDBMS_CONFIGURATION__FEATURES:
                getFeatures().clear();
                getFeatures().addAll((Collection<? extends RdbmsFeature>)newValue);
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
            case RdbmsPackage.RDBMS_CONFIGURATION__DIALECT:
                setDialect(DIALECT_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_CONFIGURATION__FEATURES:
                getFeatures().clear();
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
            case RdbmsPackage.RDBMS_CONFIGURATION__DIALECT:
                return DIALECT_EDEFAULT == null ? getDialect() != null : !DIALECT_EDEFAULT.equals(getDialect());
            case RdbmsPackage.RDBMS_CONFIGURATION__FEATURES:
                return !getFeatures().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RdbmsConfigurationImpl
