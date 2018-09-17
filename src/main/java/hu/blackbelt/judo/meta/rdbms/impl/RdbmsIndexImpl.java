/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsIndex;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl#isUnique <em>Unique</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsIndexImpl extends RdbmsElementImpl implements RdbmsIndex {
    /**
     * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUnique()
     * @generated
     * @ordered
     */
    protected static final boolean UNIQUE_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsIndexImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_INDEX;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable getTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_INDEX__TABLE, RdbmsPackage.Literals.RDBMS_INDEX__TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTable(RdbmsTable newTable, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTable, RdbmsPackage.RDBMS_INDEX__TABLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTable(RdbmsTable newTable) {
        eDynamicSet(RdbmsPackage.RDBMS_INDEX__TABLE, RdbmsPackage.Literals.RDBMS_INDEX__TABLE, newTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsField> getFields() {
        return (EList<RdbmsField>)eDynamicGet(RdbmsPackage.RDBMS_INDEX__FIELDS, RdbmsPackage.Literals.RDBMS_INDEX__FIELDS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUnique() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_INDEX__UNIQUE, RdbmsPackage.Literals.RDBMS_INDEX__UNIQUE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUnique(boolean newUnique) {
        eDynamicSet(RdbmsPackage.RDBMS_INDEX__UNIQUE, RdbmsPackage.Literals.RDBMS_INDEX__UNIQUE, newUnique);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_INDEX__TABLE:
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
            case RdbmsPackage.RDBMS_INDEX__TABLE:
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
            case RdbmsPackage.RDBMS_INDEX__TABLE:
                return eInternalContainer().eInverseRemove(this, RdbmsPackage.RDBMS_TABLE__INDEXES, RdbmsTable.class, msgs);
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
            case RdbmsPackage.RDBMS_INDEX__TABLE:
                return getTable();
            case RdbmsPackage.RDBMS_INDEX__FIELDS:
                return getFields();
            case RdbmsPackage.RDBMS_INDEX__UNIQUE:
                return isUnique();
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
            case RdbmsPackage.RDBMS_INDEX__TABLE:
                setTable((RdbmsTable)newValue);
                return;
            case RdbmsPackage.RDBMS_INDEX__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends RdbmsField>)newValue);
                return;
            case RdbmsPackage.RDBMS_INDEX__UNIQUE:
                setUnique((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_INDEX__TABLE:
                setTable((RdbmsTable)null);
                return;
            case RdbmsPackage.RDBMS_INDEX__FIELDS:
                getFields().clear();
                return;
            case RdbmsPackage.RDBMS_INDEX__UNIQUE:
                setUnique(UNIQUE_EDEFAULT);
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
            case RdbmsPackage.RDBMS_INDEX__TABLE:
                return getTable() != null;
            case RdbmsPackage.RDBMS_INDEX__FIELDS:
                return !getFields().isEmpty();
            case RdbmsPackage.RDBMS_INDEX__UNIQUE:
                return isUnique() != UNIQUE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsIndexImpl
