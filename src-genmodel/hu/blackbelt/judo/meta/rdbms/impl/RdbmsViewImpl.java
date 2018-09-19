/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias;
import hu.blackbelt.judo.meta.rdbms.RdbmsView;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl#getPrimaryTable <em>Primary Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl#getOriginUuid <em>Origin Uuid</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl#getPrimaryIdentifierField <em>Primary Identifier Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl#getTables <em>Tables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsViewImpl extends RdbmsElementImpl implements RdbmsView {
    /**
     * The default value of the '{@link #getOriginUuid() <em>Origin Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginUuid()
     * @generated
     * @ordered
     */
    protected static final String ORIGIN_UUID_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsViewField> getFields() {
        return (EList<RdbmsViewField>)eDynamicGet(RdbmsPackage.RDBMS_VIEW__FIELDS, RdbmsPackage.Literals.RDBMS_VIEW__FIELDS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias getPrimaryTable() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE, RdbmsPackage.Literals.RDBMS_VIEW__PRIMARY_TABLE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias basicGetPrimaryTable() {
        return (RdbmsTableAlias)eDynamicGet(RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE, RdbmsPackage.Literals.RDBMS_VIEW__PRIMARY_TABLE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimaryTable(RdbmsTableAlias newPrimaryTable) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE, RdbmsPackage.Literals.RDBMS_VIEW__PRIMARY_TABLE, newPrimaryTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOriginUuid() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_VIEW__ORIGIN_UUID, RdbmsPackage.Literals.RDBMS_VIEW__ORIGIN_UUID, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginUuid(String newOriginUuid) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW__ORIGIN_UUID, RdbmsPackage.Literals.RDBMS_VIEW__ORIGIN_UUID, newOriginUuid);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsViewRelation> getRelations() {
        return (EList<RdbmsViewRelation>)eDynamicGet(RdbmsPackage.RDBMS_VIEW__RELATIONS, RdbmsPackage.Literals.RDBMS_VIEW__RELATIONS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField getPrimaryIdentifierField() {
        return (RdbmsViewIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD, RdbmsPackage.Literals.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField basicGetPrimaryIdentifierField() {
        return (RdbmsViewIdentifierField)eDynamicGet(RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD, RdbmsPackage.Literals.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimaryIdentifierField(RdbmsViewIdentifierField newPrimaryIdentifierField) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD, RdbmsPackage.Literals.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD, newPrimaryIdentifierField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsTableAlias> getTables() {
        return (EList<RdbmsTableAlias>)eDynamicGet(RdbmsPackage.RDBMS_VIEW__TABLES, RdbmsPackage.Literals.RDBMS_VIEW__TABLES, true, true);
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
            case RdbmsPackage.RDBMS_VIEW__FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFields()).basicAdd(otherEnd, msgs);
            case RdbmsPackage.RDBMS_VIEW__TABLES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTables()).basicAdd(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_VIEW__FIELDS:
                return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_VIEW__RELATIONS:
                return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
            case RdbmsPackage.RDBMS_VIEW__TABLES:
                return ((InternalEList<?>)getTables()).basicRemove(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_VIEW__FIELDS:
                return getFields();
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE:
                if (resolve) return getPrimaryTable();
                return basicGetPrimaryTable();
            case RdbmsPackage.RDBMS_VIEW__ORIGIN_UUID:
                return getOriginUuid();
            case RdbmsPackage.RDBMS_VIEW__RELATIONS:
                return getRelations();
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD:
                if (resolve) return getPrimaryIdentifierField();
                return basicGetPrimaryIdentifierField();
            case RdbmsPackage.RDBMS_VIEW__TABLES:
                return getTables();
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
            case RdbmsPackage.RDBMS_VIEW__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends RdbmsViewField>)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE:
                setPrimaryTable((RdbmsTableAlias)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW__ORIGIN_UUID:
                setOriginUuid((String)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW__RELATIONS:
                getRelations().clear();
                getRelations().addAll((Collection<? extends RdbmsViewRelation>)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD:
                setPrimaryIdentifierField((RdbmsViewIdentifierField)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW__TABLES:
                getTables().clear();
                getTables().addAll((Collection<? extends RdbmsTableAlias>)newValue);
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
            case RdbmsPackage.RDBMS_VIEW__FIELDS:
                getFields().clear();
                return;
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE:
                setPrimaryTable((RdbmsTableAlias)null);
                return;
            case RdbmsPackage.RDBMS_VIEW__ORIGIN_UUID:
                setOriginUuid(ORIGIN_UUID_EDEFAULT);
                return;
            case RdbmsPackage.RDBMS_VIEW__RELATIONS:
                getRelations().clear();
                return;
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD:
                setPrimaryIdentifierField((RdbmsViewIdentifierField)null);
                return;
            case RdbmsPackage.RDBMS_VIEW__TABLES:
                getTables().clear();
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
            case RdbmsPackage.RDBMS_VIEW__FIELDS:
                return !getFields().isEmpty();
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_TABLE:
                return basicGetPrimaryTable() != null;
            case RdbmsPackage.RDBMS_VIEW__ORIGIN_UUID:
                return ORIGIN_UUID_EDEFAULT == null ? getOriginUuid() != null : !ORIGIN_UUID_EDEFAULT.equals(getOriginUuid());
            case RdbmsPackage.RDBMS_VIEW__RELATIONS:
                return !getRelations().isEmpty();
            case RdbmsPackage.RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD:
                return basicGetPrimaryIdentifierField() != null;
            case RdbmsPackage.RDBMS_VIEW__TABLES:
                return !getTables().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewImpl
