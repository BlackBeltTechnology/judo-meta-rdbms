/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsView;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewField;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewFieldImpl#getView <em>View</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewFieldImpl#isInherited <em>Inherited</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsViewFieldImpl extends RdbmsElementImpl implements RdbmsViewField {
    /**
     * The default value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInherited()
     * @generated
     * @ordered
     */
    protected static final boolean INHERITED_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsView getView() {
        return (RdbmsView)eDynamicGet(RdbmsPackage.RDBMS_VIEW_FIELD__VIEW, RdbmsPackage.Literals.RDBMS_VIEW_FIELD__VIEW, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetView(RdbmsView newView, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newView, RdbmsPackage.RDBMS_VIEW_FIELD__VIEW, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setView(RdbmsView newView) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_FIELD__VIEW, RdbmsPackage.Literals.RDBMS_VIEW_FIELD__VIEW, newView);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInherited() {
        return (Boolean)eDynamicGet(RdbmsPackage.RDBMS_VIEW_FIELD__INHERITED, RdbmsPackage.Literals.RDBMS_VIEW_FIELD__INHERITED, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInherited(boolean newInherited) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_FIELD__INHERITED, RdbmsPackage.Literals.RDBMS_VIEW_FIELD__INHERITED, newInherited);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
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
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
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
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
                return eInternalContainer().eInverseRemove(this, RdbmsPackage.RDBMS_VIEW__FIELDS, RdbmsView.class, msgs);
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
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
                return getView();
            case RdbmsPackage.RDBMS_VIEW_FIELD__INHERITED:
                return isInherited();
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
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
                setView((RdbmsView)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_FIELD__INHERITED:
                setInherited((Boolean)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
                setView((RdbmsView)null);
                return;
            case RdbmsPackage.RDBMS_VIEW_FIELD__INHERITED:
                setInherited(INHERITED_EDEFAULT);
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
            case RdbmsPackage.RDBMS_VIEW_FIELD__VIEW:
                return getView() != null;
            case RdbmsPackage.RDBMS_VIEW_FIELD__INHERITED:
                return isInherited() != INHERITED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewFieldImpl
