/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsValueFieldImpl#isTechnical <em>Technical</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsValueFieldImpl extends RdbmsFieldImpl implements RdbmsValueField {
    /**
     * The default value of the '{@link #isTechnical() <em>Technical</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTechnical()
     * @generated
     * @ordered
     */
    protected static final boolean TECHNICAL_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsValueFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VALUE_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTechnical() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_VALUE_FIELD__TECHNICAL, RdbmsPackage.Literals.RDBMS_VALUE_FIELD__TECHNICAL, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnical(boolean newTechnical) {
        eDynamicSet(RdbmsPackage.RDBMS_VALUE_FIELD__TECHNICAL, RdbmsPackage.Literals.RDBMS_VALUE_FIELD__TECHNICAL, newTechnical);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VALUE_FIELD__TECHNICAL:
                return isTechnical();
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
            case RdbmsPackage.RDBMS_VALUE_FIELD__TECHNICAL:
                setTechnical((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_VALUE_FIELD__TECHNICAL:
                setTechnical(TECHNICAL_EDEFAULT);
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
            case RdbmsPackage.RDBMS_VALUE_FIELD__TECHNICAL:
                return isTechnical() != TECHNICAL_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsValueFieldImpl
