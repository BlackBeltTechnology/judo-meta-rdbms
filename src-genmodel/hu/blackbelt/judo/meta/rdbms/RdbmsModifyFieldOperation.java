/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modify Field Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isTypeChanged <em>Type Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isMandatoryChanged <em>Mandatory Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#getPreviousField <em>Previous Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isSizeChanged <em>Size Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isNameChanged <em>Name Changed</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedValueFieldToForeignKey <em>Changed Value Field To Foreign Key</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedForeignKeyToValueField <em>Changed Foreign Key To Value Field</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation()
 * @model
 * @generated
 */
public interface RdbmsModifyFieldOperation extends RdbmsFieldOperation {
    /**
     * Returns the value of the '<em><b>Type Changed</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Changed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type Changed</em>' attribute.
     * @see #setTypeChanged(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_TypeChanged()
     * @model default="false"
     * @generated
     */
    boolean isTypeChanged();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isTypeChanged <em>Type Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Changed</em>' attribute.
     * @see #isTypeChanged()
     * @generated
     */
    void setTypeChanged(boolean value);

    /**
     * Returns the value of the '<em><b>Mandatory Changed</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory Changed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory Changed</em>' attribute.
     * @see #setMandatoryChanged(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_MandatoryChanged()
     * @model default="false"
     * @generated
     */
    boolean isMandatoryChanged();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isMandatoryChanged <em>Mandatory Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory Changed</em>' attribute.
     * @see #isMandatoryChanged()
     * @generated
     */
    void setMandatoryChanged(boolean value);

    /**
     * Returns the value of the '<em><b>Previous Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Previous Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Previous Field</em>' reference.
     * @see #setPreviousField(RdbmsField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_PreviousField()
     * @model required="true"
     * @generated
     */
    RdbmsField getPreviousField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#getPreviousField <em>Previous Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Previous Field</em>' reference.
     * @see #getPreviousField()
     * @generated
     */
    void setPreviousField(RdbmsField value);

    /**
     * Returns the value of the '<em><b>Size Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size Changed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Size Changed</em>' attribute.
     * @see #setSizeChanged(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_SizeChanged()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isSizeChanged();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isSizeChanged <em>Size Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Size Changed</em>' attribute.
     * @see #isSizeChanged()
     * @generated
     */
    void setSizeChanged(boolean value);

    /**
     * Returns the value of the '<em><b>Name Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name Changed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name Changed</em>' attribute.
     * @see #setNameChanged(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_NameChanged()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isNameChanged();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isNameChanged <em>Name Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name Changed</em>' attribute.
     * @see #isNameChanged()
     * @generated
     */
    void setNameChanged(boolean value);

    /**
     * Returns the value of the '<em><b>Changed Value Field To Foreign Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Changed Value Field To Foreign Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Changed Value Field To Foreign Key</em>' attribute.
     * @see #setChangedValueFieldToForeignKey(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_ChangedValueFieldToForeignKey()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isChangedValueFieldToForeignKey();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedValueFieldToForeignKey <em>Changed Value Field To Foreign Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Changed Value Field To Foreign Key</em>' attribute.
     * @see #isChangedValueFieldToForeignKey()
     * @generated
     */
    void setChangedValueFieldToForeignKey(boolean value);

    /**
     * Returns the value of the '<em><b>Changed Foreign Key To Value Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Changed Foreign Key To Value Field</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Changed Foreign Key To Value Field</em>' attribute.
     * @see #setChangedForeignKeyToValueField(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyFieldOperation_ChangedForeignKeyToValueField()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isChangedForeignKeyToValueField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedForeignKeyToValueField <em>Changed Foreign Key To Value Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Changed Foreign Key To Value Field</em>' attribute.
     * @see #isChangedForeignKeyToValueField()
     * @generated
     */
    void setChangedForeignKeyToValueField(boolean value);

} // RdbmsModifyFieldOperation
