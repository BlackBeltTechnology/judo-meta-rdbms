/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Junction Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField1 <em>Field1</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField2 <em>Field2</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsJunctionTable()
 * @model
 * @generated
 */
public interface RdbmsJunctionTable extends RdbmsTable {
    /**
     * Returns the value of the '<em><b>Field1</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field1</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field1</em>' reference.
     * @see #setField1(RdbmsForeignKey)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsJunctionTable_Field1()
     * @model required="true"
     * @generated
     */
    RdbmsForeignKey getField1();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField1 <em>Field1</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field1</em>' reference.
     * @see #getField1()
     * @generated
     */
    void setField1(RdbmsForeignKey value);

    /**
     * Returns the value of the '<em><b>Field2</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field2</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field2</em>' reference.
     * @see #setField2(RdbmsForeignKey)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsJunctionTable_Field2()
     * @model required="true"
     * @generated
     */
    RdbmsForeignKey getField2();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField2 <em>Field2</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field2</em>' reference.
     * @see #getField2()
     * @generated
     */
    void setField2(RdbmsForeignKey value);

} // RdbmsJunctionTable
