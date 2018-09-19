/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unique Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsUniqueConstraintImpl#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsUniqueConstraintImpl#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsUniqueConstraintImpl extends RdbmsElementImpl implements RdbmsUniqueConstraint {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsUniqueConstraintImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_UNIQUE_CONSTRAINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable getTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE, RdbmsPackage.Literals.RDBMS_UNIQUE_CONSTRAINT__TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTable(RdbmsTable newTable, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTable, RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTable(RdbmsTable newTable) {
        eDynamicSet(RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE, RdbmsPackage.Literals.RDBMS_UNIQUE_CONSTRAINT__TABLE, newTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsField> getFields() {
        return (EList<RdbmsField>)eDynamicGet(RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__FIELDS, RdbmsPackage.Literals.RDBMS_UNIQUE_CONSTRAINT__FIELDS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
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
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
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
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
                return eInternalContainer().eInverseRemove(this, RdbmsPackage.RDBMS_TABLE__UNIQUE_CONSTRAINTS, RdbmsTable.class, msgs);
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
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
                return getTable();
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__FIELDS:
                return getFields();
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
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
                setTable((RdbmsTable)newValue);
                return;
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends RdbmsField>)newValue);
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
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
                setTable((RdbmsTable)null);
                return;
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__FIELDS:
                getFields().clear();
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
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__TABLE:
                return getTable() != null;
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT__FIELDS:
                return !getFields().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RdbmsUniqueConstraintImpl
