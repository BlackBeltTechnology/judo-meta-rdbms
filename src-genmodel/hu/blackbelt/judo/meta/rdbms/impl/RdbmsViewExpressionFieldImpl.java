/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsExpression;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Expression Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewExpressionFieldImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewExpressionFieldImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RdbmsViewExpressionFieldImpl extends RdbmsViewFieldImpl implements RdbmsViewExpressionField {
    /**
     * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected static final String EXPRESSION_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsViewExpressionFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_VIEW_EXPRESSION_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<RdbmsExpression> getExpressions() {
        return (EList<RdbmsExpression>)eDynamicGet(RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS, RdbmsPackage.Literals.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExpression() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION, RdbmsPackage.Literals.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(String newExpression) {
        eDynamicSet(RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION, RdbmsPackage.Literals.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION, newExpression);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS:
                return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
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
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS:
                return getExpressions();
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION:
                return getExpression();
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
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS:
                getExpressions().clear();
                getExpressions().addAll((Collection<? extends RdbmsExpression>)newValue);
                return;
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION:
                setExpression((String)newValue);
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
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS:
                getExpressions().clear();
                return;
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION:
                setExpression(EXPRESSION_EDEFAULT);
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
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS:
                return !getExpressions().isEmpty();
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION:
                return EXPRESSION_EDEFAULT == null ? getExpression() != null : !EXPRESSION_EDEFAULT.equals(getExpression());
        }
        return super.eIsSet(featureID);
    }

} //RdbmsViewExpressionFieldImpl
