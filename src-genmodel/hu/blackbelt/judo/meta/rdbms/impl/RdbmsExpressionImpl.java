/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsExpression;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsExpressionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RdbmsExpressionImpl extends RdbmsElementImpl implements RdbmsExpression {
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
    protected RdbmsExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RdbmsPackage.Literals.RDBMS_EXPRESSION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExpression() {
        return (String)eDynamicGet(RdbmsPackage.RDBMS_EXPRESSION__EXPRESSION, RdbmsPackage.Literals.RDBMS_EXPRESSION__EXPRESSION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(String newExpression) {
        eDynamicSet(RdbmsPackage.RDBMS_EXPRESSION__EXPRESSION, RdbmsPackage.Literals.RDBMS_EXPRESSION__EXPRESSION, newExpression);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RdbmsPackage.RDBMS_EXPRESSION__EXPRESSION:
                return getExpression();
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
            case RdbmsPackage.RDBMS_EXPRESSION__EXPRESSION:
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
            case RdbmsPackage.RDBMS_EXPRESSION__EXPRESSION:
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
            case RdbmsPackage.RDBMS_EXPRESSION__EXPRESSION:
                return EXPRESSION_EDEFAULT == null ? getExpression() != null : !EXPRESSION_EDEFAULT.equals(getExpression());
        }
        return super.eIsSet(featureID);
    }

} //RdbmsExpressionImpl
