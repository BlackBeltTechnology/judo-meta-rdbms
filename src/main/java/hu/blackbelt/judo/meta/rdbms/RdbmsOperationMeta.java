/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Meta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getPreviousModel <em>Previous Model</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getCurrentModel <em>Current Model</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsOperationMeta()
 * @model
 * @generated
 */
public interface RdbmsOperationMeta extends EObject {
    /**
     * Returns the value of the '<em><b>Previous Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Previous Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Previous Model</em>' reference.
     * @see #setPreviousModel(RdbmsModel)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsOperationMeta_PreviousModel()
     * @model required="true"
     * @generated
     */
    RdbmsModel getPreviousModel();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getPreviousModel <em>Previous Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Previous Model</em>' reference.
     * @see #getPreviousModel()
     * @generated
     */
    void setPreviousModel(RdbmsModel value);

    /**
     * Returns the value of the '<em><b>Current Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Current Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Current Model</em>' reference.
     * @see #setCurrentModel(RdbmsModel)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsOperationMeta_CurrentModel()
     * @model required="true"
     * @generated
     */
    RdbmsModel getCurrentModel();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getCurrentModel <em>Current Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Current Model</em>' reference.
     * @see #getCurrentModel()
     * @generated
     */
    void setCurrentModel(RdbmsModel value);

} // RdbmsOperationMeta
