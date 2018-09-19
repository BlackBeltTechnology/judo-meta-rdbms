/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration;
import hu.blackbelt.judo.meta.rdbms.RdbmsFieldType;
import hu.blackbelt.judo.meta.rdbms.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsView;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getRdbmsFieldTypes <em>Rdbms Field Types</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getRdbmsTables <em>Rdbms Tables</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getRdbmsViews <em>Rdbms Views</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getTableOperations <em>Table Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl#getViewRecords <em>View Records</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsModelImpl extends MinimalEObjectImpl.Container implements RdbmsModel {
    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_MODEL;
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
    public EList<RdbmsFieldType> getRdbmsFieldTypes() {
        return (EList<RdbmsFieldType>)eDynamicGet(RdbmsPackage.RDBMS_MODEL__RDBMS_FIELD_TYPES, RdbmsPackage.Literals.RDBMS_MODEL__RDBMS_FIELD_TYPES, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsTable> getRdbmsTables() {
        return (EList<RdbmsTable>)eDynamicGet(RdbmsPackage.RDBMS_MODEL__RDBMS_TABLES, RdbmsPackage.Literals.RDBMS_MODEL__RDBMS_TABLES, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsView> getRdbmsViews() {
        return (EList<RdbmsView>)eDynamicGet(RdbmsPackage.RDBMS_MODEL__RDBMS_VIEWS, RdbmsPackage.Literals.RDBMS_MODEL__RDBMS_VIEWS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsConfiguration getConfiguration() {
        return (RdbmsConfiguration)eDynamicGet(RdbmsPackage.RDBMS_MODEL__CONFIGURATION, RdbmsPackage.Literals.RDBMS_MODEL__CONFIGURATION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetConfiguration(RdbmsConfiguration newConfiguration, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject)newConfiguration, RdbmsPackage.RDBMS_MODEL__CONFIGURATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfiguration(RdbmsConfiguration newConfiguration) {
        eDynamicSet(RdbmsPackage.RDBMS_MODEL__CONFIGURATION, RdbmsPackage.Literals.RDBMS_MODEL__CONFIGURATION, newConfiguration);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_MODEL__VERSION, RdbmsPackage.Literals.RDBMS_MODEL__VERSION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(String newVersion) {
        eDynamicSet(RdbmsPackage.RDBMS_MODEL__VERSION, RdbmsPackage.Literals.RDBMS_MODEL__VERSION, newVersion);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsTableOperation> getTableOperations() {
        return (EList<RdbmsTableOperation>)eDynamicGet(RdbmsPackage.RDBMS_MODEL__TABLE_OPERATIONS, RdbmsPackage.Literals.RDBMS_MODEL__TABLE_OPERATIONS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsViewRecord> getViewRecords() {
        return (EList<RdbmsViewRecord>)eDynamicGet(RdbmsPackage.RDBMS_MODEL__VIEW_RECORDS, RdbmsPackage.Literals.RDBMS_MODEL__VIEW_RECORDS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_MODEL__RDBMS_FIELD_TYPES:
                return ((InternalEList<?>)getRdbmsFieldTypes()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_MODEL__RDBMS_TABLES:
                return ((InternalEList<?>)getRdbmsTables()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_MODEL__RDBMS_VIEWS:
                return ((InternalEList<?>)getRdbmsViews()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_MODEL__CONFIGURATION:
                return basicSetConfiguration(null, msgs);
            case RdbmsPackage.RDBMS_MODEL__TABLE_OPERATIONS:
                return ((InternalEList<?>)getTableOperations()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_MODEL__VIEW_RECORDS:
                return ((InternalEList<?>)getViewRecords()).basicRemove(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_MODEL__RDBMS_FIELD_TYPES:
                return getRdbmsFieldTypes();
            case RdbmsPackage.RDBMS_MODEL__RDBMS_TABLES:
                return getRdbmsTables();
            case RdbmsPackage.RDBMS_MODEL__RDBMS_VIEWS:
                return getRdbmsViews();
            case RdbmsPackage.RDBMS_MODEL__CONFIGURATION:
                return getConfiguration();
            case RdbmsPackage.RDBMS_MODEL__VERSION:
                return getVersion();
            case RdbmsPackage.RDBMS_MODEL__TABLE_OPERATIONS:
                return getTableOperations();
            case RdbmsPackage.RDBMS_MODEL__VIEW_RECORDS:
                return getViewRecords();
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
            case RdbmsPackage.RDBMS_MODEL__RDBMS_FIELD_TYPES:
                getRdbmsFieldTypes().clear();
                getRdbmsFieldTypes().addAll((Collection<? extends RdbmsFieldType>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODEL__RDBMS_TABLES:
                getRdbmsTables().clear();
                getRdbmsTables().addAll((Collection<? extends RdbmsTable>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODEL__RDBMS_VIEWS:
                getRdbmsViews().clear();
                getRdbmsViews().addAll((Collection<? extends RdbmsView>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODEL__CONFIGURATION:
                setConfiguration((RdbmsConfiguration)newValue);
                return;
            case RdbmsPackage.RDBMS_MODEL__VERSION:
                setVersion((String)newValue);
                return;
            case RdbmsPackage.RDBMS_MODEL__TABLE_OPERATIONS:
                getTableOperations().clear();
                getTableOperations().addAll((Collection<? extends RdbmsTableOperation>)newValue);
                return;
            case RdbmsPackage.RDBMS_MODEL__VIEW_RECORDS:
                getViewRecords().clear();
                getViewRecords().addAll((Collection<? extends RdbmsViewRecord>)newValue);
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
            case RdbmsPackage.RDBMS_MODEL__RDBMS_FIELD_TYPES:
                getRdbmsFieldTypes().clear();
                return;
            case RdbmsPackage.RDBMS_MODEL__RDBMS_TABLES:
                getRdbmsTables().clear();
                return;
            case RdbmsPackage.RDBMS_MODEL__RDBMS_VIEWS:
                getRdbmsViews().clear();
                return;
            case RdbmsPackage.RDBMS_MODEL__CONFIGURATION:
                setConfiguration((RdbmsConfiguration)null);
                return;
            case RdbmsPackage.RDBMS_MODEL__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_MODEL__TABLE_OPERATIONS:
                getTableOperations().clear();
                return;
            case RdbmsPackage.RDBMS_MODEL__VIEW_RECORDS:
                getViewRecords().clear();
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
            case RdbmsPackage.RDBMS_MODEL__RDBMS_FIELD_TYPES:
                return !getRdbmsFieldTypes().isEmpty();
            case RdbmsPackage.RDBMS_MODEL__RDBMS_TABLES:
                return !getRdbmsTables().isEmpty();
            case RdbmsPackage.RDBMS_MODEL__RDBMS_VIEWS:
                return !getRdbmsViews().isEmpty();
            case RdbmsPackage.RDBMS_MODEL__CONFIGURATION:
                return getConfiguration() != null;
            case RdbmsPackage.RDBMS_MODEL__VERSION:
                return VERSION_EDEFAULT == null ? getVersion() != null : !VERSION_EDEFAULT.equals(getVersion());
            case RdbmsPackage.RDBMS_MODEL__TABLE_OPERATIONS:
                return !getTableOperations().isEmpty();
            case RdbmsPackage.RDBMS_MODEL__VIEW_RECORDS:
                return !getViewRecords().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RdbmsModelImpl
