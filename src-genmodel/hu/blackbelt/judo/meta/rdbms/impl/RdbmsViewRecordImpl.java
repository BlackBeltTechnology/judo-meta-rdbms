/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsView;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordImpl#getValues <em>Values</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordImpl#getView <em>View</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsViewRecordImpl extends MinimalEObjectImpl.Container implements RdbmsViewRecord {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewRecordImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_RECORD;
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
    @SuppressWarnings("unchecked")
    public EList<RdbmsViewRecordValue> getValues() {
        return (EList<RdbmsViewRecordValue>)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD__VALUES, RdbmsPackage.Literals.RDBMS_VIEW_RECORD__VALUES, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsView getView() {
        return (RdbmsView)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD__VIEW, RdbmsPackage.Literals.RDBMS_VIEW_RECORD__VIEW, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsView basicGetView() {
        return (RdbmsView)eDynamicGet(RdbmsPackage.RDBMS_VIEW_RECORD__VIEW, RdbmsPackage.Literals.RDBMS_VIEW_RECORD__VIEW, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setView(RdbmsView newView) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_RECORD__VIEW, RdbmsPackage.Literals.RDBMS_VIEW_RECORD__VIEW, newView);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_RECORD__VALUES:
                return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_VIEW_RECORD__VALUES:
                return getValues();
            case RdbmsPackage.RDBMS_VIEW_RECORD__VIEW:
                if (resolve) return getView();
                return basicGetView();
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
            case RdbmsPackage.RDBMS_VIEW_RECORD__VALUES:
                getValues().clear();
                getValues().addAll((Collection<? extends RdbmsViewRecordValue>)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_RECORD__VIEW:
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
            case RdbmsPackage.RDBMS_VIEW_RECORD__VALUES:
                getValues().clear();
                return;
            case RdbmsPackage.RDBMS_VIEW_RECORD__VIEW:
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
            case RdbmsPackage.RDBMS_VIEW_RECORD__VALUES:
                return !getValues().isEmpty();
            case RdbmsPackage.RDBMS_VIEW_RECORD__VIEW:
                return basicGetView() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewRecordImpl
