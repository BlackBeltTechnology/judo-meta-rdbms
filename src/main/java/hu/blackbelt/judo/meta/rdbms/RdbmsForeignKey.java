/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getReferenceKey <em>Reference Key</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isInheritenceBased <em>Inheritence Based</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getForeignKeySqlName <em>Foreign Key Sql Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeleteOnCascade <em>Delete On Cascade</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeferred <em>Deferred</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey()
 * @model
 * @generated
 */
public interface RdbmsForeignKey extends RdbmsIdentifierField {
    /**
     * Returns the value of the '<em><b>Reference Key</b></em>' reference.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField#getForeignKeys <em>Foreign Keys</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference Key</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference Key</em>' reference.
     * @see #setReferenceKey(RdbmsIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey_ReferenceKey()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField#getForeignKeys
     * @model opposite="foreignKeys" required="true"
     * @generated
     */
    RdbmsIdentifierField getReferenceKey();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getReferenceKey <em>Reference Key</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference Key</em>' reference.
     * @see #getReferenceKey()
     * @generated
     */
    void setReferenceKey(RdbmsIdentifierField value);

    /**
     * Returns the value of the '<em><b>Inheritence Based</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inheritence Based</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inheritence Based</em>' attribute.
     * @see #setInheritenceBased(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey_InheritenceBased()
     * @model default="false"
     * @generated
     */
    boolean isInheritenceBased();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isInheritenceBased <em>Inheritence Based</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inheritence Based</em>' attribute.
     * @see #isInheritenceBased()
     * @generated
     */
    void setInheritenceBased(boolean value);

    /**
     * Returns the value of the '<em><b>Foreign Key Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign Key Sql Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreign Key Sql Name</em>' attribute.
     * @see #setForeignKeySqlName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey_ForeignKeySqlName()
     * @model required="true"
     * @generated
     */
    String getForeignKeySqlName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getForeignKeySqlName <em>Foreign Key Sql Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreign Key Sql Name</em>' attribute.
     * @see #getForeignKeySqlName()
     * @generated
     */
    void setForeignKeySqlName(String value);

    /**
     * Returns the value of the '<em><b>Delete On Cascade</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delete On Cascade</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delete On Cascade</em>' attribute.
     * @see #setDeleteOnCascade(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey_DeleteOnCascade()
     * @model default="false"
     * @generated
     */
    boolean isDeleteOnCascade();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeleteOnCascade <em>Delete On Cascade</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delete On Cascade</em>' attribute.
     * @see #isDeleteOnCascade()
     * @generated
     */
    void setDeleteOnCascade(boolean value);

    /**
     * Returns the value of the '<em><b>Deferred</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deferred</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deferred</em>' attribute.
     * @see #setDeferred(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey_Deferred()
     * @model default="false"
     * @generated
     */
    boolean isDeferred();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeferred <em>Deferred</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deferred</em>' attribute.
     * @see #isDeferred()
     * @generated
     */
    void setDeferred(boolean value);

    /**
     * Returns the value of the '<em><b>Read Only</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Read Only</em>' attribute.
     * @see #setReadOnly(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsForeignKey_ReadOnly()
     * @model default="false"
     * @generated
     */
    boolean isReadOnly();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isReadOnly <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Only</em>' attribute.
     * @see #isReadOnly()
     * @generated
     */
    void setReadOnly(boolean value);

} // RdbmsForeignKey
