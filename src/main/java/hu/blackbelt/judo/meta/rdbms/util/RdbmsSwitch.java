/**
 */
package hu.blackbelt.judo.meta.rdbms.util;

import hu.blackbelt.judo.meta.rdbms.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage
 * @generated
 */
public class RdbmsSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static RdbmsPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsSwitch() {
        if (modelPackage == null) {
            modelPackage = RdbmsPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case RdbmsPackage.RDBMS_ELEMENT: {
                RdbmsElement rdbmsElement = (RdbmsElement)theEObject;
                T result = caseRdbmsElement(rdbmsElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_TABLE: {
                RdbmsTable rdbmsTable = (RdbmsTable)theEObject;
                T result = caseRdbmsTable(rdbmsTable);
                if (result == null) result = caseRdbmsElement(rdbmsTable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_FIELD: {
                RdbmsField rdbmsField = (RdbmsField)theEObject;
                T result = caseRdbmsField(rdbmsField);
                if (result == null) result = caseRdbmsElement(rdbmsField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_FOREIGN_KEY: {
                RdbmsForeignKey rdbmsForeignKey = (RdbmsForeignKey)theEObject;
                T result = caseRdbmsForeignKey(rdbmsForeignKey);
                if (result == null) result = caseRdbmsIdentifierField(rdbmsForeignKey);
                if (result == null) result = caseRdbmsField(rdbmsForeignKey);
                if (result == null) result = caseRdbmsElement(rdbmsForeignKey);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT: {
                RdbmsUniqueConstraint rdbmsUniqueConstraint = (RdbmsUniqueConstraint)theEObject;
                T result = caseRdbmsUniqueConstraint(rdbmsUniqueConstraint);
                if (result == null) result = caseRdbmsElement(rdbmsUniqueConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_JUNCTION_TABLE: {
                RdbmsJunctionTable rdbmsJunctionTable = (RdbmsJunctionTable)theEObject;
                T result = caseRdbmsJunctionTable(rdbmsJunctionTable);
                if (result == null) result = caseRdbmsTable(rdbmsJunctionTable);
                if (result == null) result = caseRdbmsElement(rdbmsJunctionTable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_IDENTIFIER_FIELD: {
                RdbmsIdentifierField rdbmsIdentifierField = (RdbmsIdentifierField)theEObject;
                T result = caseRdbmsIdentifierField(rdbmsIdentifierField);
                if (result == null) result = caseRdbmsField(rdbmsIdentifierField);
                if (result == null) result = caseRdbmsElement(rdbmsIdentifierField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW: {
                RdbmsView rdbmsView = (RdbmsView)theEObject;
                T result = caseRdbmsView(rdbmsView);
                if (result == null) result = caseRdbmsElement(rdbmsView);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_FIELD: {
                RdbmsViewField rdbmsViewField = (RdbmsViewField)theEObject;
                T result = caseRdbmsViewField(rdbmsViewField);
                if (result == null) result = caseRdbmsElement(rdbmsViewField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_VALUE_FIELD: {
                RdbmsViewValueField rdbmsViewValueField = (RdbmsViewValueField)theEObject;
                T result = caseRdbmsViewValueField(rdbmsViewValueField);
                if (result == null) result = caseRdbmsViewAliasField(rdbmsViewValueField);
                if (result == null) result = caseRdbmsViewTableField(rdbmsViewValueField);
                if (result == null) result = caseRdbmsViewField(rdbmsViewValueField);
                if (result == null) result = caseRdbmsElement(rdbmsViewValueField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD: {
                RdbmsViewExpressionField rdbmsViewExpressionField = (RdbmsViewExpressionField)theEObject;
                T result = caseRdbmsViewExpressionField(rdbmsViewExpressionField);
                if (result == null) result = caseRdbmsViewField(rdbmsViewExpressionField);
                if (result == null) result = caseRdbmsElement(rdbmsViewExpressionField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_EXPRESSION: {
                RdbmsExpression rdbmsExpression = (RdbmsExpression)theEObject;
                T result = caseRdbmsExpression(rdbmsExpression);
                if (result == null) result = caseRdbmsElement(rdbmsExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_FIELD_TYPE: {
                RdbmsFieldType rdbmsFieldType = (RdbmsFieldType)theEObject;
                T result = caseRdbmsFieldType(rdbmsFieldType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_MODEL: {
                RdbmsModel rdbmsModel = (RdbmsModel)theEObject;
                T result = caseRdbmsModel(rdbmsModel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VALUE_FIELD: {
                RdbmsValueField rdbmsValueField = (RdbmsValueField)theEObject;
                T result = caseRdbmsValueField(rdbmsValueField);
                if (result == null) result = caseRdbmsField(rdbmsValueField);
                if (result == null) result = caseRdbmsElement(rdbmsValueField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_IDENTIFIER_FIELD: {
                RdbmsViewIdentifierField rdbmsViewIdentifierField = (RdbmsViewIdentifierField)theEObject;
                T result = caseRdbmsViewIdentifierField(rdbmsViewIdentifierField);
                if (result == null) result = caseRdbmsViewAliasField(rdbmsViewIdentifierField);
                if (result == null) result = caseRdbmsViewTableField(rdbmsViewIdentifierField);
                if (result == null) result = caseRdbmsViewField(rdbmsViewIdentifierField);
                if (result == null) result = caseRdbmsElement(rdbmsViewIdentifierField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_CONFIGURATION: {
                RdbmsConfiguration rdbmsConfiguration = (RdbmsConfiguration)theEObject;
                T result = caseRdbmsConfiguration(rdbmsConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_FEATURE: {
                RdbmsFeature rdbmsFeature = (RdbmsFeature)theEObject;
                T result = caseRdbmsFeature(rdbmsFeature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_TABLE_ALIAS: {
                RdbmsTableAlias rdbmsTableAlias = (RdbmsTableAlias)theEObject;
                T result = caseRdbmsTableAlias(rdbmsTableAlias);
                if (result == null) result = caseRdbmsElement(rdbmsTableAlias);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_LABEL_EXPRESSION: {
                RdbmsLabelExpression rdbmsLabelExpression = (RdbmsLabelExpression)theEObject;
                T result = caseRdbmsLabelExpression(rdbmsLabelExpression);
                if (result == null) result = caseRdbmsExpression(rdbmsLabelExpression);
                if (result == null) result = caseRdbmsElement(rdbmsLabelExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_RELATION_EXPRESSION: {
                RdbmsRelationExpression rdbmsRelationExpression = (RdbmsRelationExpression)theEObject;
                T result = caseRdbmsRelationExpression(rdbmsRelationExpression);
                if (result == null) result = caseRdbmsExpression(rdbmsRelationExpression);
                if (result == null) result = caseRdbmsElement(rdbmsRelationExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_ALIAS_FIELD: {
                RdbmsViewAliasField rdbmsViewAliasField = (RdbmsViewAliasField)theEObject;
                T result = caseRdbmsViewAliasField(rdbmsViewAliasField);
                if (result == null) result = caseRdbmsViewTableField(rdbmsViewAliasField);
                if (result == null) result = caseRdbmsViewField(rdbmsViewAliasField);
                if (result == null) result = caseRdbmsElement(rdbmsViewAliasField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION: {
                RdbmsModifyTableOperation rdbmsModifyTableOperation = (RdbmsModifyTableOperation)theEObject;
                T result = caseRdbmsModifyTableOperation(rdbmsModifyTableOperation);
                if (result == null) result = caseRdbmsTableOperation(rdbmsModifyTableOperation);
                if (result == null) result = caseRdbmsElement(rdbmsModifyTableOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_FIELD_OPERATION: {
                RdbmsFieldOperation rdbmsFieldOperation = (RdbmsFieldOperation)theEObject;
                T result = caseRdbmsFieldOperation(rdbmsFieldOperation);
                if (result == null) result = caseRdbmsElement(rdbmsFieldOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_CREATE_FIELD_OPERATION: {
                RdbmsCreateFieldOperation rdbmsCreateFieldOperation = (RdbmsCreateFieldOperation)theEObject;
                T result = caseRdbmsCreateFieldOperation(rdbmsCreateFieldOperation);
                if (result == null) result = caseRdbmsFieldOperation(rdbmsCreateFieldOperation);
                if (result == null) result = caseRdbmsElement(rdbmsCreateFieldOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION: {
                RdbmsModifyFieldOperation rdbmsModifyFieldOperation = (RdbmsModifyFieldOperation)theEObject;
                T result = caseRdbmsModifyFieldOperation(rdbmsModifyFieldOperation);
                if (result == null) result = caseRdbmsFieldOperation(rdbmsModifyFieldOperation);
                if (result == null) result = caseRdbmsElement(rdbmsModifyFieldOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_DELETE_FIELD_OPERATION: {
                RdbmsDeleteFieldOperation rdbmsDeleteFieldOperation = (RdbmsDeleteFieldOperation)theEObject;
                T result = caseRdbmsDeleteFieldOperation(rdbmsDeleteFieldOperation);
                if (result == null) result = caseRdbmsFieldOperation(rdbmsDeleteFieldOperation);
                if (result == null) result = caseRdbmsElement(rdbmsDeleteFieldOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_RELATION: {
                RdbmsViewRelation rdbmsViewRelation = (RdbmsViewRelation)theEObject;
                T result = caseRdbmsViewRelation(rdbmsViewRelation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_TABLE_FIELD: {
                RdbmsViewTableField rdbmsViewTableField = (RdbmsViewTableField)theEObject;
                T result = caseRdbmsViewTableField(rdbmsViewTableField);
                if (result == null) result = caseRdbmsViewField(rdbmsViewTableField);
                if (result == null) result = caseRdbmsElement(rdbmsViewTableField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD: {
                RdbmsViewForeignIdentifierField rdbmsViewForeignIdentifierField = (RdbmsViewForeignIdentifierField)theEObject;
                T result = caseRdbmsViewForeignIdentifierField(rdbmsViewForeignIdentifierField);
                if (result == null) result = caseRdbmsViewTableField(rdbmsViewForeignIdentifierField);
                if (result == null) result = caseRdbmsViewField(rdbmsViewForeignIdentifierField);
                if (result == null) result = caseRdbmsElement(rdbmsViewForeignIdentifierField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_INDEX: {
                RdbmsIndex rdbmsIndex = (RdbmsIndex)theEObject;
                T result = caseRdbmsIndex(rdbmsIndex);
                if (result == null) result = caseRdbmsElement(rdbmsIndex);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_RECORD: {
                RdbmsViewRecord rdbmsViewRecord = (RdbmsViewRecord)theEObject;
                T result = caseRdbmsViewRecord(rdbmsViewRecord);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE: {
                RdbmsViewRecordValue rdbmsViewRecordValue = (RdbmsViewRecordValue)theEObject;
                T result = caseRdbmsViewRecordValue(rdbmsViewRecordValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_TABLE_OPERATION: {
                RdbmsTableOperation rdbmsTableOperation = (RdbmsTableOperation)theEObject;
                T result = caseRdbmsTableOperation(rdbmsTableOperation);
                if (result == null) result = caseRdbmsElement(rdbmsTableOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_CREATE_TABLE_OPERATION: {
                RdbmsCreateTableOperation rdbmsCreateTableOperation = (RdbmsCreateTableOperation)theEObject;
                T result = caseRdbmsCreateTableOperation(rdbmsCreateTableOperation);
                if (result == null) result = caseRdbmsTableOperation(rdbmsCreateTableOperation);
                if (result == null) result = caseRdbmsElement(rdbmsCreateTableOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_DELETE_TABLE_OPERATION: {
                RdbmsDeleteTableOperation rdbmsDeleteTableOperation = (RdbmsDeleteTableOperation)theEObject;
                T result = caseRdbmsDeleteTableOperation(rdbmsDeleteTableOperation);
                if (result == null) result = caseRdbmsTableOperation(rdbmsDeleteTableOperation);
                if (result == null) result = caseRdbmsElement(rdbmsDeleteTableOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RdbmsPackage.RDBMS_OPERATION_META: {
                RdbmsOperationMeta rdbmsOperationMeta = (RdbmsOperationMeta)theEObject;
                T result = caseRdbmsOperationMeta(rdbmsOperationMeta);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsElement(RdbmsElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Table</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Table</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsTable(RdbmsTable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsField(RdbmsField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Foreign Key</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Foreign Key</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsForeignKey(RdbmsForeignKey object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unique Constraint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unique Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsUniqueConstraint(RdbmsUniqueConstraint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Junction Table</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Junction Table</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsJunctionTable(RdbmsJunctionTable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsIdentifierField(RdbmsIdentifierField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsView(RdbmsView object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewField(RdbmsViewField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Value Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Value Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewValueField(RdbmsViewValueField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Expression Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Expression Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewExpressionField(RdbmsViewExpressionField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsExpression(RdbmsExpression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsFieldType(RdbmsFieldType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsModel(RdbmsModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsValueField(RdbmsValueField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Identifier Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Identifier Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewIdentifierField(RdbmsViewIdentifierField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsConfiguration(RdbmsConfiguration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsFeature(RdbmsFeature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Table Alias</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Table Alias</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsTableAlias(RdbmsTableAlias object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Label Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Label Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsLabelExpression(RdbmsLabelExpression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Relation Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Relation Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsRelationExpression(RdbmsRelationExpression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Alias Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Alias Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewAliasField(RdbmsViewAliasField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Modify Table Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Modify Table Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsModifyTableOperation(RdbmsModifyTableOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsFieldOperation(RdbmsFieldOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Create Field Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Create Field Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsCreateFieldOperation(RdbmsCreateFieldOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Modify Field Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Modify Field Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsModifyFieldOperation(RdbmsModifyFieldOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Delete Field Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delete Field Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsDeleteFieldOperation(RdbmsDeleteFieldOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Relation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Relation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewRelation(RdbmsViewRelation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Table Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Table Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewTableField(RdbmsViewTableField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Foreign Identifier Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Foreign Identifier Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewForeignIdentifierField(RdbmsViewForeignIdentifierField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Index</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Index</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsIndex(RdbmsIndex object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Record</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewRecord(RdbmsViewRecord object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Record Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Record Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsViewRecordValue(RdbmsViewRecordValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Table Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Table Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsTableOperation(RdbmsTableOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Create Table Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Create Table Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsCreateTableOperation(RdbmsCreateTableOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Delete Table Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delete Table Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsDeleteTableOperation(RdbmsDeleteTableOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Meta</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Meta</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRdbmsOperationMeta(RdbmsOperationMeta object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //RdbmsSwitch
