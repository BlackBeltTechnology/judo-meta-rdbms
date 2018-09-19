/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsFieldType;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getRdbmsTypeName <em>Rdbms Type Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl#getStorageByte <em>Storage Byte</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsFieldTypeImpl extends MinimalEObjectImpl.Container implements RdbmsFieldType {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

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
     * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUuid()
     * @generated
     * @ordered
     */
    protected static final String UUID_EDEFAULT = null;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

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
    protected RdbmsFieldTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_FIELD_TYPE;
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
    public String getName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__NAME, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__NAME, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__NAME, newName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRdbmsTypeName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRdbmsTypeName(String newRdbmsTypeName) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME, newRdbmsTypeName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUuid() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__UUID, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__UUID, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUuid(String newUuid) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__UUID, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__UUID, newUuid);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__DESCRIPTION, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__DESCRIPTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__DESCRIPTION, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__DESCRIPTION, newDescription);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSize() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__SIZE, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__SIZE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSize(int newSize) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__SIZE, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__SIZE, newSize);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPrecision() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__PRECISION, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__PRECISION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrecision(int newPrecision) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__PRECISION, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__PRECISION, newPrecision);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getScale() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__SCALE, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__SCALE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScale(int newScale) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__SCALE, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__SCALE, newScale);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getStorageByte() {
        return (Integer)eDynamicGet(RdbmsPackage.RDBMS_FIELD_TYPE__STORAGE_BYTE, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__STORAGE_BYTE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStorageByte(int newStorageByte) {
        eDynamicSet(RdbmsPackage.RDBMS_FIELD_TYPE__STORAGE_BYTE, RdbmsPackage.Literals.RDBMS_FIELD_TYPE__STORAGE_BYTE, newStorageByte);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_FIELD_TYPE__NAME:
                return getName();
            case RdbmsPackage.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME:
                return getRdbmsTypeName();
            case RdbmsPackage.RDBMS_FIELD_TYPE__UUID:
                return getUuid();
            case RdbmsPackage.RDBMS_FIELD_TYPE__DESCRIPTION:
                return getDescription();
            case RdbmsPackage.RDBMS_FIELD_TYPE__SIZE:
                return getSize();
            case RdbmsPackage.RDBMS_FIELD_TYPE__PRECISION:
                return getPrecision();
            case RdbmsPackage.RDBMS_FIELD_TYPE__SCALE:
                return getScale();
            case RdbmsPackage.RDBMS_FIELD_TYPE__STORAGE_BYTE:
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
            case RdbmsPackage.RDBMS_FIELD_TYPE__NAME:
                setName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME:
                setRdbmsTypeName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__UUID:
                setUuid((String)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__SIZE:
                setSize((Integer)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__PRECISION:
                setPrecision((Integer)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__SCALE:
                setScale((Integer)newValue);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__STORAGE_BYTE:
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
            case RdbmsPackage.RDBMS_FIELD_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME:
                setRdbmsTypeName(RDBMS_TYPE_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__UUID:
                setUuid(UUID_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__SIZE:
                setSize(SIZE_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__PRECISION:
                setPrecision(PRECISION_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__SCALE:
                setScale(SCALE_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FIELD_TYPE__STORAGE_BYTE:
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
            case RdbmsPackage.RDBMS_FIELD_TYPE__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
            case RdbmsPackage.RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME:
                return RDBMS_TYPE_NAME_EDEFAULT == null ? getRdbmsTypeName() != null : !RDBMS_TYPE_NAME_EDEFAULT.equals(getRdbmsTypeName());
            case RdbmsPackage.RDBMS_FIELD_TYPE__UUID:
                return UUID_EDEFAULT == null ? getUuid() != null : !UUID_EDEFAULT.equals(getUuid());
            case RdbmsPackage.RDBMS_FIELD_TYPE__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
            case RdbmsPackage.RDBMS_FIELD_TYPE__SIZE:
                return getSize() != SIZE_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD_TYPE__PRECISION:
                return getPrecision() != PRECISION_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD_TYPE__SCALE:
                return getScale() != SCALE_EDEFAULT;
            case RdbmsPackage.RDBMS_FIELD_TYPE__STORAGE_BYTE:
                return getStorageByte() != STORAGE_BYTE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsFieldTypeImpl
