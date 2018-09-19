/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsElement;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getShortName <em>Short Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getFullName <em>Full Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getSqlName <em>Sql Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getOriginalName <em>Original Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl#getOriginalPackage <em>Original Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsElementImpl extends MinimalEObjectImpl.Container implements RdbmsElement {
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
     * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUuid()
     * @generated
     * @ordered
     */
    protected static final String UUID_EDEFAULT = null;

    /**
     * The default value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortName()
     * @generated
     * @ordered
     */
    protected static final String SHORT_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getFullName() <em>Full Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFullName()
     * @generated
     * @ordered
     */
    protected static final String FULL_NAME_EDEFAULT = null;

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
     * The default value of the '{@link #getSqlName() <em>Sql Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSqlName()
     * @generated
     * @ordered
     */
    protected static final String SQL_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getOriginalName() <em>Original Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalName()
     * @generated
     * @ordered
     */
    protected static final String ORIGINAL_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getOriginalPackage() <em>Original Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalPackage()
     * @generated
     * @ordered
     */
    protected static final String ORIGINAL_PACKAGE_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_ELEMENT;
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
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__NAME, newName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUuid() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__UUID, RdbmsPackage.Literals.RDBMS_ELEMENT__UUID, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUuid(String newUuid) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__UUID, RdbmsPackage.Literals.RDBMS_ELEMENT__UUID, newUuid);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getShortName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__SHORT_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__SHORT_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShortName(String newShortName) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__SHORT_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__SHORT_NAME, newShortName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFullName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__FULL_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__FULL_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFullName(String newFullName) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__FULL_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__FULL_NAME, newFullName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__DESCRIPTION, RdbmsPackage.Literals.RDBMS_ELEMENT__DESCRIPTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__DESCRIPTION, RdbmsPackage.Literals.RDBMS_ELEMENT__DESCRIPTION, newDescription);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSqlName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__SQL_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__SQL_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSqlName(String newSqlName) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__SQL_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__SQL_NAME, newSqlName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOriginalName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__ORIGINAL_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginalName(String newOriginalName) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_NAME, RdbmsPackage.Literals.RDBMS_ELEMENT__ORIGINAL_NAME, newOriginalName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOriginalPackage() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_PACKAGE, RdbmsPackage.Literals.RDBMS_ELEMENT__ORIGINAL_PACKAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginalPackage(String newOriginalPackage) {
        eDynamicSet(RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_PACKAGE, RdbmsPackage.Literals.RDBMS_ELEMENT__ORIGINAL_PACKAGE, newOriginalPackage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_ELEMENT__NAME:
                return getName();
            case RdbmsPackage.RDBMS_ELEMENT__UUID:
                return getUuid();
            case RdbmsPackage.RDBMS_ELEMENT__SHORT_NAME:
                return getShortName();
            case RdbmsPackage.RDBMS_ELEMENT__FULL_NAME:
                return getFullName();
            case RdbmsPackage.RDBMS_ELEMENT__DESCRIPTION:
                return getDescription();
            case RdbmsPackage.RDBMS_ELEMENT__SQL_NAME:
                return getSqlName();
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_NAME:
                return getOriginalName();
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_PACKAGE:
                return getOriginalPackage();
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
            case RdbmsPackage.RDBMS_ELEMENT__NAME:
                setName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__UUID:
                setUuid((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__SHORT_NAME:
                setShortName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__FULL_NAME:
                setFullName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__SQL_NAME:
                setSqlName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_NAME:
                setOriginalName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_PACKAGE:
                setOriginalPackage((String)newValue);
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
            case RdbmsPackage.RDBMS_ELEMENT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__UUID:
                setUuid(UUID_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__SHORT_NAME:
                setShortName(SHORT_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__FULL_NAME:
                setFullName(FULL_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__SQL_NAME:
                setSqlName(SQL_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_NAME:
                setOriginalName(ORIGINAL_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_PACKAGE:
                setOriginalPackage(ORIGINAL_PACKAGE_EDEFAULT);
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
            case RdbmsPackage.RDBMS_ELEMENT__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
            case RdbmsPackage.RDBMS_ELEMENT__UUID:
                return UUID_EDEFAULT == null ? getUuid() != null : !UUID_EDEFAULT.equals(getUuid());
            case RdbmsPackage.RDBMS_ELEMENT__SHORT_NAME:
                return SHORT_NAME_EDEFAULT == null ? getShortName() != null : !SHORT_NAME_EDEFAULT.equals(getShortName());
            case RdbmsPackage.RDBMS_ELEMENT__FULL_NAME:
                return FULL_NAME_EDEFAULT == null ? getFullName() != null : !FULL_NAME_EDEFAULT.equals(getFullName());
            case RdbmsPackage.RDBMS_ELEMENT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
            case RdbmsPackage.RDBMS_ELEMENT__SQL_NAME:
                return SQL_NAME_EDEFAULT == null ? getSqlName() != null : !SQL_NAME_EDEFAULT.equals(getSqlName());
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_NAME:
                return ORIGINAL_NAME_EDEFAULT == null ? getOriginalName() != null : !ORIGINAL_NAME_EDEFAULT.equals(getOriginalName());
            case RdbmsPackage.RDBMS_ELEMENT__ORIGINAL_PACKAGE:
                return ORIGINAL_PACKAGE_EDEFAULT == null ? getOriginalPackage() != null : !ORIGINAL_PACKAGE_EDEFAULT.equals(getOriginalPackage());
        }
        return super.eIsSet(featureID);
    }

} //RdbmsElementImpl
