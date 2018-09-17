/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getDialect <em>Dialect</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsConfiguration()
 * @model
 * @generated
 */
public interface RdbmsConfiguration extends EObject {
    /**
     * Returns the value of the '<em><b>Dialect</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dialect</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dialect</em>' attribute.
     * @see #setDialect(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsConfiguration_Dialect()
     * @model required="true"
     * @generated
     */
    String getDialect();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getDialect <em>Dialect</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dialect</em>' attribute.
     * @see #getDialect()
     * @generated
     */
    void setDialect(String value);

    /**
     * Returns the value of the '<em><b>Features</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsFeature}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Features</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsConfiguration_Features()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsFeature> getFeatures();

} // RdbmsConfiguration
