/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#getView <em>View</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#isInherited <em>Inherited</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewField()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsViewField extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>View</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View</em>' container reference.
     * @see #setView(RdbmsView)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewField_View()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getFields
     * @model opposite="fields" required="true" transient="false"
     * @generated
     */
    RdbmsView getView();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#getView <em>View</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>View</em>' container reference.
     * @see #getView()
     * @generated
     */
    void setView(RdbmsView value);

    /**
     * Returns the value of the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inherited</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inherited</em>' attribute.
     * @see #setInherited(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewField_Inherited()
     * @model required="true"
     * @generated
     */
    boolean isInherited();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#isInherited <em>Inherited</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inherited</em>' attribute.
     * @see #isInherited()
     * @generated
     */
    void setInherited(boolean value);

} // RdbmsViewField
