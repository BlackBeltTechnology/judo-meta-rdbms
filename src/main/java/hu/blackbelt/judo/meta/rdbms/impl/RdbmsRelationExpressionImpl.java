/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsRelationExpressionImpl#getField <em>Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsRelationExpressionImpl extends RdbmsExpressionImpl implements RdbmsRelationExpression {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsRelationExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_RELATION_EXPRESSION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewAliasField getField() {
        return (RdbmsViewAliasField)eDynamicGet(RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD, RdbmsPackage.Literals.RDBMS_RELATION_EXPRESSION__FIELD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewAliasField basicGetField() {
        return (RdbmsViewAliasField)eDynamicGet(RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD, RdbmsPackage.Literals.RDBMS_RELATION_EXPRESSION__FIELD, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setField(RdbmsViewAliasField newField) {
        eDynamicSet(RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD, RdbmsPackage.Literals.RDBMS_RELATION_EXPRESSION__FIELD, newField);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD:
                if (resolve) return getField();
                return basicGetField();
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
            case RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD:
                setField((RdbmsViewAliasField)newValue);
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
            case RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD:
                setField((RdbmsViewAliasField)null);
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
            case RdbmsPackage.RDBMS_RELATION_EXPRESSION__FIELD:
                return basicGetField() != null;
        }
        return super.eIsSet(featureID);
    }

} //RdbmsRelationExpressionImpl
