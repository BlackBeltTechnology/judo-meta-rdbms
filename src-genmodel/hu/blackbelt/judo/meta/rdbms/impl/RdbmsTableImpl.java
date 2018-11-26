/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsIndex;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl#getUniqueConstraints <em>Unique Constraints</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl#getParents <em>Parents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsTableImpl extends RdbmsElementImpl implements RdbmsTable {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsTableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_TABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsField> getFields() {
        return (EList<RdbmsField>)eDynamicGet(RdbmsPackage.RDBMS_TABLE__FIELDS, RdbmsPackage.Literals.RDBMS_TABLE__FIELDS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsUniqueConstraint> getUniqueConstraints() {
        return (EList<RdbmsUniqueConstraint>)eDynamicGet(RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS, RdbmsPackage.Literals.RDBMS_TABLE__UNIQUE_CONSTRAINTS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField getPrimaryKey() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY, RdbmsPackage.Literals.RDBMS_TABLE__PRIMARY_KEY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField basicGetPrimaryKey() {
        return (RdbmsIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY, RdbmsPackage.Literals.RDBMS_TABLE__PRIMARY_KEY, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimaryKey(RdbmsIdentifierField newPrimaryKey) {
        eDynamicSet(RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY, RdbmsPackage.Literals.RDBMS_TABLE__PRIMARY_KEY, newPrimaryKey);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsIndex> getIndexes() {
        return (EList<RdbmsIndex>)eDynamicGet(RdbmsPackage.RDBMS_TABLE__INDEXES, RdbmsPackage.Literals.RDBMS_TABLE__INDEXES, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsTable> getParents() {
        return (EList<RdbmsTable>)eDynamicGet(RdbmsPackage.RDBMS_TABLE__PARENTS, RdbmsPackage.Literals.RDBMS_TABLE__PARENTS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_TABLE__FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFields()).basicAdd(otherEnd, msgs);
            case RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getUniqueConstraints()).basicAdd(otherEnd, msgs);
            case RdbmsPackage.RDBMS_TABLE__INDEXES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIndexes()).basicAdd(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_TABLE__FIELDS:
                return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS:
                return ((InternalEList<?>)getUniqueConstraints()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_TABLE__INDEXES:
                return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_TABLE__FIELDS:
                return getFields();
            case RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS:
                return getUniqueConstraints();
            case RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY:
                if (resolve) return getPrimaryKey();
                return basicGetPrimaryKey();
            case RdbmsPackage.RDBMS_TABLE__INDEXES:
                return getIndexes();
            case RdbmsPackage.RDBMS_TABLE__PARENTS:
                return getParents();
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
            case RdbmsPackage.RDBMS_TABLE__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends RdbmsField>)newValue);
                return;
            case RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS:
                getUniqueConstraints().clear();
                getUniqueConstraints().addAll((Collection<? extends RdbmsUniqueConstraint>)newValue);
                return;
            case RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY:
                setPrimaryKey((RdbmsIdentifierField)newValue);
                return;
            case RdbmsPackage.RDBMS_TABLE__INDEXES:
                getIndexes().clear();
                getIndexes().addAll((Collection<? extends RdbmsIndex>)newValue);
                return;
            case RdbmsPackage.RDBMS_TABLE__PARENTS:
                getParents().clear();
                getParents().addAll((Collection<? extends RdbmsTable>)newValue);
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
            case RdbmsPackage.RDBMS_TABLE__FIELDS:
                getFields().clear();
                return;
            case RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS:
                getUniqueConstraints().clear();
                return;
            case RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY:
                setPrimaryKey((RdbmsIdentifierField)null);
                return;
            case RdbmsPackage.RDBMS_TABLE__INDEXES:
                getIndexes().clear();
                return;
            case RdbmsPackage.RDBMS_TABLE__PARENTS:
                getParents().clear();
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
            case RdbmsPackage.RDBMS_TABLE__FIELDS:
                return !getFields().isEmpty();
            case RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS:
                return !getUniqueConstraints().isEmpty();
            case RdbmsPackage.RDBMS_TABLE__PRIMARY_KEY:
                return basicGetPrimaryKey() != null;
            case RdbmsPackage.RDBMS_TABLE__INDEXES:
                return !getIndexes().isEmpty();
            case RdbmsPackage.RDBMS_TABLE__PARENTS:
                return !getParents().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RdbmsTableImpl
