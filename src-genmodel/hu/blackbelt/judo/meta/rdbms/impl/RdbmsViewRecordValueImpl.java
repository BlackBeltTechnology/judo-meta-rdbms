/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewValueField;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Record Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl#getIdentifierField <em>Identifier Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl#getValueField <em>Value Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsViewRecordValueImpl extends MinimalEObjectImpl.Container implements RdbmsViewRecordValue {
    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewRecordValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE;
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
    public String getValue() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__VALUE, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField getIdentifierField() {
        return (RdbmsViewIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField basicGetIdentifierField() {
        return (RdbmsViewIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIdentifierField(RdbmsViewIdentifierField newIdentifierField) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD, newIdentifierField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewValueField getValueField() {
        return (RdbmsViewValueField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewValueField basicGetValueField() {
        return (RdbmsViewValueField)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueField(RdbmsViewValueField newValueField) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD, RdbmsPackage.Literals.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD, newValueField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE:
                return getValue();
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD:
                if (resolve) return getIdentifierField();
                return basicGetIdentifierField();
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD:
                if (resolve) return getValueField();
                return basicGetValueField();
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
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE:
                setValue((String)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD:
                setIdentifierField((RdbmsViewIdentifierField)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD:
                setValueField((RdbmsViewValueField)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD:
                setIdentifierField((RdbmsViewIdentifierField)null);
                return;
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD:
                setValueField((RdbmsViewValueField)null);
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
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE:
                return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD:
                return basicGetIdentifierField() != null;
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD:
                return basicGetValueField() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewRecordValueImpl
