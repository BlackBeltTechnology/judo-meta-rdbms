/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl#getReferenceKey <em>Reference Key</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl#isInheritenceBased <em>Inheritence Based</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl#getForeignKeySqlName <em>Foreign Key Sql Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl#isDeleteOnCascade <em>Delete On Cascade</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl#isDeferred <em>Deferred</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsForeignKeyImpl extends RdbmsIdentifierFieldImpl implements RdbmsForeignKey {
    /**
     * The default value of the '{@link #isInheritenceBased() <em>Inheritence Based</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInheritenceBased()
     * @generated
     * @ordered
     */
    protected static final boolean INHERITENCE_BASED_EDEFAULT = false;

    /**
     * The default value of the '{@link #getForeignKeySqlName() <em>Foreign Key Sql Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getForeignKeySqlName()
     * @generated
     * @ordered
     */
    protected static final String FOREIGN_KEY_SQL_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #isDeleteOnCascade() <em>Delete On Cascade</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleteOnCascade()
     * @generated
     * @ordered
     */
    protected static final boolean DELETE_ON_CASCADE_EDEFAULT = false;

    /**
     * The default value of the '{@link #isDeferred() <em>Deferred</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeferred()
     * @generated
     * @ordered
     */
    protected static final boolean DEFERRED_EDEFAULT = false;

    /**
     * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
    protected static final boolean READ_ONLY_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsForeignKeyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_FOREIGN_KEY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField getReferenceKey() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__REFERENCE_KEY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField basicGetReferenceKey() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__REFERENCE_KEY, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReferenceKey(RdbmsIdentifierField newReferenceKey, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject)newReferenceKey, RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferenceKey(RdbmsIdentifierField newReferenceKey) {
        eDynamicSet(RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__REFERENCE_KEY, newReferenceKey);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInheritenceBased() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__INHERITENCE_BASED, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__INHERITENCE_BASED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInheritenceBased(boolean newInheritenceBased) {
        eDynamicSet(RdbmsPackage.RDBMS_FOREIGN_KEY__INHERITENCE_BASED, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__INHERITENCE_BASED, newInheritenceBased);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getForeignKeySqlName() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForeignKeySqlName(String newForeignKeySqlName) {
        eDynamicSet(RdbmsPackage.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME, newForeignKeySqlName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeleteOnCascade() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleteOnCascade(boolean newDeleteOnCascade) {
        eDynamicSet(RdbmsPackage.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE, newDeleteOnCascade);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeferred() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__DEFERRED, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__DEFERRED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeferred(boolean newDeferred) {
        eDynamicSet(RdbmsPackage.RDBMS_FOREIGN_KEY__DEFERRED, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__DEFERRED, newDeferred);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReadOnly() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_FOREIGN_KEY__READ_ONLY, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__READ_ONLY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadOnly(boolean newReadOnly) {
        eDynamicSet(RdbmsPackage.RDBMS_FOREIGN_KEY__READ_ONLY, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY__READ_ONLY, newReadOnly);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY:
                RdbmsIdentifierField referenceKey = basicGetReferenceKey();
                if (referenceKey != null)
                    msgs = ((InternalEObject)referenceKey).eInverseRemove(this, RdbmsPackage.RDBMS_IDENTIFIER_FIELD__FOREIGN_KEYS, RdbmsIdentifierField.class, msgs);
                return basicSetReferenceKey((RdbmsIdentifierField)otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY:
                return basicSetReferenceKey(null, msgs);
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
            case RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY:
                if (resolve) return getReferenceKey();
                return basicGetReferenceKey();
            case RdbmsPackage.RDBMS_FOREIGN_KEY__INHERITENCE_BASED:
                return isInheritenceBased();
            case RdbmsPackage.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME:
                return getForeignKeySqlName();
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE:
                return isDeleteOnCascade();
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DEFERRED:
                return isDeferred();
            case RdbmsPackage.RDBMS_FOREIGN_KEY__READ_ONLY:
                return isReadOnly();
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
            case RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY:
                setReferenceKey((RdbmsIdentifierField)newValue);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__INHERITENCE_BASED:
                setInheritenceBased((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME:
                setForeignKeySqlName((String)newValue);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE:
                setDeleteOnCascade((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DEFERRED:
                setDeferred((Boolean)newValue);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__READ_ONLY:
                setReadOnly((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY:
                setReferenceKey((RdbmsIdentifierField)null);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__INHERITENCE_BASED:
                setInheritenceBased(INHERITENCE_BASED_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME:
                setForeignKeySqlName(FOREIGN_KEY_SQL_NAME_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE:
                setDeleteOnCascade(DELETE_ON_CASCADE_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DEFERRED:
                setDeferred(DEFERRED_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
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
            case RdbmsPackage.RDBMS_FOREIGN_KEY__REFERENCE_KEY:
                return basicGetReferenceKey() != null;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__INHERITENCE_BASED:
                return isInheritenceBased() != INHERITENCE_BASED_EDEFAULT;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME:
                return FOREIGN_KEY_SQL_NAME_EDEFAULT == null ? getForeignKeySqlName() != null : !FOREIGN_KEY_SQL_NAME_EDEFAULT.equals(getForeignKeySqlName());
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE:
                return isDeleteOnCascade() != DELETE_ON_CASCADE_EDEFAULT;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__DEFERRED:
                return isDeferred() != DEFERRED_EDEFAULT;
            case RdbmsPackage.RDBMS_FOREIGN_KEY__READ_ONLY:
                return isReadOnly() != READ_ONLY_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsForeignKeyImpl
