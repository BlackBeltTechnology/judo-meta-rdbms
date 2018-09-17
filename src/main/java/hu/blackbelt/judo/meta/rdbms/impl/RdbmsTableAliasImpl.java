/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias;
import hu.blackbelt.judo.meta.rdbms.RdbmsView;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Alias</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableAliasImpl#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableAliasImpl#getView <em>View</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsTableAliasImpl extends RdbmsElementImpl implements RdbmsTableAlias {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsTableAliasImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_TABLE_ALIAS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable getTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE, RdbmsPackage.Literals.RDBMS_TABLE_ALIAS__TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable basicGetTable() {
        return (RdbmsTable)eDynamicGet(RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE, RdbmsPackage.Literals.RDBMS_TABLE_ALIAS__TABLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTable(RdbmsTable newTable) {
        eDynamicSet(RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE, RdbmsPackage.Literals.RDBMS_TABLE_ALIAS__TABLE, newTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsView getView() {
        return (RdbmsView)eDynamicGet(RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW, RdbmsPackage.Literals.RDBMS_TABLE_ALIAS__VIEW, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetView(RdbmsView newView, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newView, RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setView(RdbmsView newView) {
        eDynamicSet(RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW, RdbmsPackage.Literals.RDBMS_TABLE_ALIAS__VIEW, newView);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetView((RdbmsView)otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                return basicSetView(null, msgs);
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
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                return eInternalContainer().eInverseRemove(this, RdbmsPackage.RDBMS_VIEW__TABLES, RdbmsView.class, msgs);
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
            case RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE:
                if (resolve) return getTable();
                return basicGetTable();
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                return getView();
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
            case RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE:
                setTable((RdbmsTable)newValue);
                return;
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                setView((RdbmsView)newValue);
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
            case RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE:
                setTable((RdbmsTable)null);
                return;
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                setView((RdbmsView)null);
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
            case RdbmsPackage.RDBMS_TABLE_ALIAS__TABLE:
                return basicGetTable() != null;
            case RdbmsPackage.RDBMS_TABLE_ALIAS__VIEW:
                return getView() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsTableAliasImpl
