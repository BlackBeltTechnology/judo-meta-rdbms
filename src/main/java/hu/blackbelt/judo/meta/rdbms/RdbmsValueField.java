/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsValueField#isTechnical <em>Technical</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsValueField()
 * @model annotation="http://www.obeo.fr/dsl/dnc/archetype archetype='MomentInterval'"
 * @generated
 */
public interface RdbmsValueField extends RdbmsField {
    /**
     * Returns the value of the '<em><b>Technical</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technical</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technical</em>' attribute.
     * @see #setTechnical(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsValueField_Technical()
     * @model default="false"
     * @generated
     */
    boolean isTechnical();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsValueField#isTechnical <em>Technical</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technical</em>' attribute.
     * @see #isTechnical()
     * @generated
     */
    void setTechnical(boolean value);

} // RdbmsValueField
