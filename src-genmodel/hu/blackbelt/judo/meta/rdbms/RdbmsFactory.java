/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage
 * @generated
 */
public interface RdbmsFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RdbmsFactory eINSTANCE = hu.blackbelt.judo.meta.rdbms.impl.RdbmsFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Table</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Table</em>'.
     * @generated
     */
    RdbmsTable createRdbmsTable();

    /**
     * Returns a new object of class '<em>Foreign Key</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Foreign Key</em>'.
     * @generated
     */
    RdbmsForeignKey createRdbmsForeignKey();

    /**
     * Returns a new object of class '<em>Unique Constraint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Unique Constraint</em>'.
     * @generated
     */
    RdbmsUniqueConstraint createRdbmsUniqueConstraint();

    /**
     * Returns a new object of class '<em>Junction Table</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Junction Table</em>'.
     * @generated
     */
    RdbmsJunctionTable createRdbmsJunctionTable();

    /**
     * Returns a new object of class '<em>Identifier Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Identifier Field</em>'.
     * @generated
     */
    RdbmsIdentifierField createRdbmsIdentifierField();

    /**
     * Returns a new object of class '<em>View</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View</em>'.
     * @generated
     */
    RdbmsView createRdbmsView();

    /**
     * Returns a new object of class '<em>View Value Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Value Field</em>'.
     * @generated
     */
    RdbmsViewValueField createRdbmsViewValueField();

    /**
     * Returns a new object of class '<em>View Expression Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Expression Field</em>'.
     * @generated
     */
    RdbmsViewExpressionField createRdbmsViewExpressionField();

    /**
     * Returns a new object of class '<em>Field Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Field Type</em>'.
     * @generated
     */
    RdbmsFieldType createRdbmsFieldType();

    /**
     * Returns a new object of class '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
    RdbmsModel createRdbmsModel();

    /**
     * Returns a new object of class '<em>Value Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Field</em>'.
     * @generated
     */
    RdbmsValueField createRdbmsValueField();

    /**
     * Returns a new object of class '<em>View Identifier Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Identifier Field</em>'.
     * @generated
     */
    RdbmsViewIdentifierField createRdbmsViewIdentifierField();

    /**
     * Returns a new object of class '<em>Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration</em>'.
     * @generated
     */
    RdbmsConfiguration createRdbmsConfiguration();

    /**
     * Returns a new object of class '<em>Feature</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature</em>'.
     * @generated
     */
    RdbmsFeature createRdbmsFeature();

    /**
     * Returns a new object of class '<em>Table Alias</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Table Alias</em>'.
     * @generated
     */
    RdbmsTableAlias createRdbmsTableAlias();

    /**
     * Returns a new object of class '<em>Label Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Label Expression</em>'.
     * @generated
     */
    RdbmsLabelExpression createRdbmsLabelExpression();

    /**
     * Returns a new object of class '<em>Relation Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Relation Expression</em>'.
     * @generated
     */
    RdbmsRelationExpression createRdbmsRelationExpression();

    /**
     * Returns a new object of class '<em>Modify Table Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Modify Table Operation</em>'.
     * @generated
     */
    RdbmsModifyTableOperation createRdbmsModifyTableOperation();

    /**
     * Returns a new object of class '<em>Create Field Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Create Field Operation</em>'.
     * @generated
     */
    RdbmsCreateFieldOperation createRdbmsCreateFieldOperation();

    /**
     * Returns a new object of class '<em>Modify Field Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Modify Field Operation</em>'.
     * @generated
     */
    RdbmsModifyFieldOperation createRdbmsModifyFieldOperation();

    /**
     * Returns a new object of class '<em>Delete Field Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Delete Field Operation</em>'.
     * @generated
     */
    RdbmsDeleteFieldOperation createRdbmsDeleteFieldOperation();

    /**
     * Returns a new object of class '<em>View Relation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Relation</em>'.
     * @generated
     */
    RdbmsViewRelation createRdbmsViewRelation();

    /**
     * Returns a new object of class '<em>View Foreign Identifier Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Foreign Identifier Field</em>'.
     * @generated
     */
    RdbmsViewForeignIdentifierField createRdbmsViewForeignIdentifierField();

    /**
     * Returns a new object of class '<em>Index</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Index</em>'.
     * @generated
     */
    RdbmsIndex createRdbmsIndex();

    /**
     * Returns a new object of class '<em>View Record</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Record</em>'.
     * @generated
     */
    RdbmsViewRecord createRdbmsViewRecord();

    /**
     * Returns a new object of class '<em>View Record Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Record Value</em>'.
     * @generated
     */
    RdbmsViewRecordValue createRdbmsViewRecordValue();

    /**
     * Returns a new object of class '<em>Create Table Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Create Table Operation</em>'.
     * @generated
     */
    RdbmsCreateTableOperation createRdbmsCreateTableOperation();

    /**
     * Returns a new object of class '<em>Delete Table Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Delete Table Operation</em>'.
     * @generated
     */
    RdbmsDeleteTableOperation createRdbmsDeleteTableOperation();

    /**
     * Returns a new object of class '<em>Operation Meta</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Meta</em>'.
     * @generated
     */
    RdbmsOperationMeta createRdbmsOperationMeta();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    RdbmsPackage getRdbmsPackage();

} //RdbmsFactory
