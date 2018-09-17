/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modify Field Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#isTypeChanged <em>Type Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#isMandatoryChanged <em>Mandatory Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#getPreviousField <em>Previous Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#isSizeChanged <em>Size Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#isNameChanged <em>Name Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#isChangedValueFieldToForeignKey <em>Changed Value Field To Foreign Key</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl#isChangedForeignKeyToValueField <em>Changed Foreign Key To Value Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsModifyFieldOperationImpl extends RdbmsFieldOperationImpl implements RdbmsModifyFieldOperation {
    /**
     * The default value of the '{@link #isTypeChanged() <em>Type Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTypeChanged()
     * @generated
     * @ordered
     */
    protected static final boolean TYPE_CHANGED_EDEFAULT = false;

    /**
     * The default value of the '{@link #isMandatoryChanged() <em>Mandatory Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMandatoryChanged()
     * @generated
     * @ordered
     */
    protected static final boolean MANDATORY_CHANGED_EDEFAULT = false;

    /**
     * The default value of the '{@link #isSizeChanged() <em>Size Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSizeChanged()
     * @generated
     * @ordered
     */
    protected static final boolean SIZE_CHANGED_EDEFAULT = false;

    /**
     * The default value of the '{@link #isNameChanged() <em>Name Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNameChanged()
     * @generated
     * @ordered
     */
    protected static final boolean NAME_CHANGED_EDEFAULT = false;

    /**
     * The default value of the '{@link #isChangedValueFieldToForeignKey() <em>Changed Value Field To Foreign Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isChangedValueFieldToForeignKey()
     * @generated
     * @ordered
     */
    protected static final boolean CHANGED_VALUE_FIELD_TO_FOREIGN_KEY_EDEFAULT = false;

    /**
     * The default value of the '{@link #isChangedForeignKeyToValueField() <em>Changed Foreign Key To Value Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isChangedForeignKeyToValueField()
     * @generated
     * @ordered
     */
    protected static final boolean CHANGED_FOREIGN_KEY_TO_VALUE_FIELD_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsModifyFieldOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTypeChanged() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTypeChanged(boolean newTypeChanged) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED, newTypeChanged);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isMandatoryChanged() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMandatoryChanged(boolean newMandatoryChanged) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED, newMandatoryChanged);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsField getPreviousField() {
        return (RdbmsField)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsField basicGetPreviousField() {
        return (RdbmsField)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPreviousField(RdbmsField newPreviousField) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD, newPreviousField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSizeChanged() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSizeChanged(boolean newSizeChanged) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED, newSizeChanged);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNameChanged() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNameChanged(boolean newNameChanged) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED, newNameChanged);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isChangedValueFieldToForeignKey() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setChangedValueFieldToForeignKey(boolean newChangedValueFieldToForeignKey) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY, newChangedValueFieldToForeignKey);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isChangedForeignKeyToValueField() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setChangedForeignKeyToValueField(boolean newChangedForeignKeyToValueField) {
        eDynamicSet(RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD, RdbmsPackage.Literals.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD, newChangedForeignKeyToValueField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED:
                return isTypeChanged();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED:
                return isMandatoryChanged();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD:
                if (resolve) return getPreviousField();
                return basicGetPreviousField();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED:
                return isSizeChanged();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED:
                return isNameChanged();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY:
                return isChangedValueFieldToForeignKey();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD:
                return isChangedForeignKeyToValueField();
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
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED:
                setTypeChanged((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED:
                setMandatoryChanged((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD:
                setPreviousField((RdbmsField)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED:
                setSizeChanged((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED:
                setNameChanged((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY:
                setChangedValueFieldToForeignKey((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD:
                setChangedForeignKeyToValueField((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED:
                setTypeChanged(TYPE_CHANGED_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED:
                setMandatoryChanged(MANDATORY_CHANGED_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD:
                setPreviousField((RdbmsField)null);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED:
                setSizeChanged(SIZE_CHANGED_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED:
                setNameChanged(NAME_CHANGED_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY:
                setChangedValueFieldToForeignKey(CHANGED_VALUE_FIELD_TO_FOREIGN_KEY_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD:
                setChangedForeignKeyToValueField(CHANGED_FOREIGN_KEY_TO_VALUE_FIELD_EDEFAULT);
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
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED:
                return isTypeChanged() != TYPE_CHANGED_EDEFAULT;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED:
                return isMandatoryChanged() != MANDATORY_CHANGED_EDEFAULT;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD:
                return basicGetPreviousField() != null;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED:
                return isSizeChanged() != SIZE_CHANGED_EDEFAULT;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED:
                return isNameChanged() != NAME_CHANGED_EDEFAULT;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY:
                return isChangedValueFieldToForeignKey() != CHANGED_VALUE_FIELD_TO_FOREIGN_KEY_EDEFAULT;
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD:
                return isChangedForeignKeyToValueField() != CHANGED_FOREIGN_KEY_TO_VALUE_FIELD_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsModifyFieldOperationImpl
