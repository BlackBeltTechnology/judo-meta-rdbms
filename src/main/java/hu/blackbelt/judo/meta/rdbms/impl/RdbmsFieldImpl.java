/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsFieldType;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getRdbmsTypeName <em>Rdbms Type Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getSize <em>Size</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl#getStorageByte <em>Storage Byte</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsFieldImpl extends RdbmsElementImpl implements RdbmsField {
    /**
     * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMandatory()
     * @generated
     * @ordered
     */
    protected static final boolean MANDATORY_EDEFAULT = false;

    /**
     * The default value of the '{@link #getRdbmsTypeName() <em>Rdbms Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRdbmsTypeName()
     * @generated
     * @ordered
     */
    protected static final String RDBMS_TYPE_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSize()
     * @generated
     * @ordered
     */
    protected static final int SIZE_EDEFAULT = 0;

    /**
     * The default value of the '{@link #getPrecision() <em>Precision</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrecision()
     * @generated
     * @ordered
     */
    protected static final int PRECISION_EDEFAULT = 0;

    /**
     * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScale()
     * @generated
     * @ordered
     */
    protected static final int SCALE_EDEFAULT = 0;

    /**
     * The default value of the '{@link #getStorageByte() <em>Storage Byte</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStorageByte()
     * @generated
     * @ordered
     */
    protected static final int STORAGE_BYTE_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable getTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_FIELD__TABLE, RdbmsPackage.Literals.RDBMS_FIELD__TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTable(RdbmsTable newTable, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTable, RdbmsPackage.RDBMS_FIELD__TABLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTable(RdbmsTable newTable) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__TABLE, RdbmsPackage.Literals.RDBMS_FIELD__TABLE, newTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsFieldType getType() {
        return (RdbmsFieldType)eDynamicGet(RdbmsPackage.RDBMS_FIELD__TYPE, RdbmsPackage.Literals.RDBMS_FIELD__TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsFieldType basicGetType() {
        return (RdbmsFieldType)eDynamicGet(RdbmsPackage.RDBMS_FIELD__TYPE, RdbmsPackage.Literals.RDBMS_FIELD__TYPE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(RdbmsFieldType newType) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__TYPE, RdbmsPackage.Literals.RDBMS_FIELD__TYPE, newType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isMandatory() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_FIELD__MANDATORY, RdbmsPackage.Literals.RDBMS_FIELD__MANDATORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMandatory(boolean newMandatory) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__MANDATORY, RdbmsPackage.Literals.RDBMS_FIELD__MANDATORY, newMandatory);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRdbmsTypeName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_FIELD__RDBMS_TYPE_NAME, RdbmsPackage.Literals.RDBMS_FIELD__RDBMS_TYPE_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRdbmsTypeName(String newRdbmsTypeName) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__RDBMS_TYPE_NAME, RdbmsPackage.Literals.RDBMS_FIELD__RDBMS_TYPE_NAME, newRdbmsTypeName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSize() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD__SIZE, RdbmsPackage.Literals.RDBMS_FIELD__SIZE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSize(int newSize) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__SIZE, RdbmsPackage.Literals.RDBMS_FIELD__SIZE, newSize);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPrecision() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD__PRECISION, RdbmsPackage.Literals.RDBMS_FIELD__PRECISION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrecision(int newPrecision) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__PRECISION, RdbmsPackage.Literals.RDBMS_FIELD__PRECISION, newPrecision);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getScale() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD__SCALE, RdbmsPackage.Literals.RDBMS_FIELD__SCALE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScale(int newScale) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__SCALE, RdbmsPackage.Literals.RDBMS_FIELD__SCALE, newScale);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getStorageByte() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD__STORAGE_BYTE, RdbmsPackage.Literals.RDBMS_FIELD__STORAGE_BYTE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStorageByte(int newStorageByte) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD__STORAGE_BYTE, RdbmsPackage.Literals.RDBMS_FIELD__STORAGE_BYTE, newStorageByte);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTable((RdbmsTable)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                return basicSetTable(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                return eInternalContainer().eInverseRemove(this, RdbmsPackage.RDBMS_TABLE__FIELDS, RdbmsTable.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                return getTable();
            case RdbmsPackage.RDBMS_FIELD__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case RdbmsPackage.RDBMS_FIELD__MANDATORY:
                return isMandatory();
            case RdbmsPackage.RDBMS_FIELD__RDBMS_TYPE_NAME:
                return getRdbmsTypeName();
            case RdbmsPackage.RDBMS_FIELD__SIZE:
                return getSize();
            case RdbmsPackage.RDBMS_FIELD__PRECISION:
                return getPrecision();
            case RdbmsPackage.RDBMS_FIELD__SCALE:
                return getScale();
            case RdbmsPackage.RDBMS_FIELD__STORAGE_BYTE:
                return getStorageByte();
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
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                setTable((RdbmsTable)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__TYPE:
                setType((RdbmsFieldType)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__MANDATORY:
                setMandatory((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__RDBMS_TYPE_NAME:
                setRdbmsTypeName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__SIZE:
                setSize((Integer)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__PRECISION:
                setPrecision((Integer)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__SCALE:
                setScale((Integer)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD__STORAGE_BYTE:
                setStorageByte((Integer)newValue);
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
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                setTable((RdbmsTable)null);
                return;
            case RdbmsPackage.RDBMS_FIELD__TYPE:
                setType((RdbmsFieldType)null);
                return;
            case RdbmsPackage.RDBMS_FIELD__MANDATORY:
                setMandatory(MANDATORY_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD__RDBMS_TYPE_NAME:
                setRdbmsTypeName(RDBMS_TYPE_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD__SIZE:
                setSize(SIZE_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD__PRECISION:
                setPrecision(PRECISION_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD__SCALE:
                setScale(SCALE_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD__STORAGE_BYTE:
                setStorageByte(STORAGE_BYTE_EDEFAULT);
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
            case RdbmsPackage.RDBMS_FIELD__TABLE:
                return getTable() != null;
            case RdbmsPackage.RDBMS_FIELD__TYPE:
                return basicGetType() != null;
            case RdbmsPackage.RDBMS_FIELD__MANDATORY:
                return isMandatory() != MANDATORY_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD__RDBMS_TYPE_NAME:
                return RDBMS_TYPE_NAME_EDEFAULT == null ? getRdbmsTypeName() != null : !RDBMS_TYPE_NAME_EDEFAULT.equals(getRdbmsTypeName());
            case RdbmsPackage.RDBMS_FIELD__SIZE:
                return getSize() != SIZE_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD__PRECISION:
                return getPrecision() != PRECISION_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD__SCALE:
                return getScale() != SCALE_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD__STORAGE_BYTE:
                return getStorageByte() != STORAGE_BYTE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsFieldImpl
