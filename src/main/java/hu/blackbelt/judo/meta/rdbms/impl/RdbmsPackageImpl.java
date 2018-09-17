/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration;
import hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsCreateTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsDeleteTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsElement;
import hu.blackbelt.judo.meta.rdbms.RdbmsExpression;
import hu.blackbelt.judo.meta.rdbms.RdbmsFactory;
import hu.blackbelt.judo.meta.rdbms.RdbmsFeature;
import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsFieldType;
import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsIndex;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression;
import hu.blackbelt.judo.meta.rdbms.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;
import hu.blackbelt.judo.meta.rdbms.RdbmsView;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField;
import hu.blackbelt.judo.meta.rdbms.RdbmsViewValueField;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RdbmsPackageImpl extends EPackageImpl implements RdbmsPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsTableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsForeignKeyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsUniqueConstraintEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsJunctionTableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsIdentifierFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewValueFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewExpressionFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsExpressionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsFieldTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsValueFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewIdentifierFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsFeatureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsTableAliasEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsLabelExpressionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsRelationExpressionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewAliasFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsModifyTableOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsFieldOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsCreateFieldOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsModifyFieldOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsDeleteFieldOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewRelationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewTableFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewForeignIdentifierFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsIndexEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewRecordEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsViewRecordValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsTableOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsCreateTableOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsDeleteTableOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rdbmsOperationMetaEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RdbmsPackageImpl() {
        super(eNS_URI, RdbmsFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link RdbmsPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RdbmsPackage init() {
        if (isInited) return (RdbmsPackage)EPackage.Registry.INSTANCE.getEPackage(RdbmsPackage.eNS_URI);

        // Obtain or create and register package
        RdbmsPackageImpl theRdbmsPackage = (RdbmsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RdbmsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RdbmsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theRdbmsPackage.createPackageContents();

        // Initialize created meta-data
        theRdbmsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRdbmsPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RdbmsPackage.eNS_URI, theRdbmsPackage);
        return theRdbmsPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsElement() {
        return rdbmsElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_Name() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_Uuid() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_ShortName() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_FullName() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_Description() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_SqlName() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_OriginalName() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsElement_OriginalPackage() {
        return (EAttribute)rdbmsElementEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsTable() {
        return rdbmsTableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTable_Fields() {
        return (EReference)rdbmsTableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTable_UniqueConstraints() {
        return (EReference)rdbmsTableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTable_PrimaryKey() {
        return (EReference)rdbmsTableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTable_Indexes() {
        return (EReference)rdbmsTableEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTable_Parent() {
        return (EReference)rdbmsTableEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsField() {
        return rdbmsFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsField_Table() {
        return (EReference)rdbmsFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsField_Type() {
        return (EReference)rdbmsFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsField_Mandatory() {
        return (EAttribute)rdbmsFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsField_RdbmsTypeName() {
        return (EAttribute)rdbmsFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsField_Size() {
        return (EAttribute)rdbmsFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsField_Precision() {
        return (EAttribute)rdbmsFieldEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsField_Scale() {
        return (EAttribute)rdbmsFieldEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsField_StorageByte() {
        return (EAttribute)rdbmsFieldEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsForeignKey() {
        return rdbmsForeignKeyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsForeignKey_ReferenceKey() {
        return (EReference)rdbmsForeignKeyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsForeignKey_InheritenceBased() {
        return (EAttribute)rdbmsForeignKeyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsForeignKey_ForeignKeySqlName() {
        return (EAttribute)rdbmsForeignKeyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsForeignKey_DeleteOnCascade() {
        return (EAttribute)rdbmsForeignKeyEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsForeignKey_Deferred() {
        return (EAttribute)rdbmsForeignKeyEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsForeignKey_ReadOnly() {
        return (EAttribute)rdbmsForeignKeyEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsUniqueConstraint() {
        return rdbmsUniqueConstraintEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsUniqueConstraint_Table() {
        return (EReference)rdbmsUniqueConstraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsUniqueConstraint_Fields() {
        return (EReference)rdbmsUniqueConstraintEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsJunctionTable() {
        return rdbmsJunctionTableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsJunctionTable_Field1() {
        return (EReference)rdbmsJunctionTableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsJunctionTable_Field2() {
        return (EReference)rdbmsJunctionTableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsIdentifierField() {
        return rdbmsIdentifierFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsIdentifierField_ForeignKeys() {
        return (EReference)rdbmsIdentifierFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsView() {
        return rdbmsViewEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsView_Fields() {
        return (EReference)rdbmsViewEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsView_PrimaryTable() {
        return (EReference)rdbmsViewEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsView_OriginUuid() {
        return (EAttribute)rdbmsViewEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsView_Relations() {
        return (EReference)rdbmsViewEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsView_PrimaryIdentifierField() {
        return (EReference)rdbmsViewEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsView_Tables() {
        return (EReference)rdbmsViewEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewField() {
        return rdbmsViewFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewField_View() {
        return (EReference)rdbmsViewFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsViewField_Inherited() {
        return (EAttribute)rdbmsViewFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewValueField() {
        return rdbmsViewValueFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewExpressionField() {
        return rdbmsViewExpressionFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewExpressionField_Expressions() {
        return (EReference)rdbmsViewExpressionFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsViewExpressionField_Expression() {
        return (EAttribute)rdbmsViewExpressionFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsExpression() {
        return rdbmsExpressionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsExpression_Expression() {
        return (EAttribute)rdbmsExpressionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsFieldType() {
        return rdbmsFieldTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_Name() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_RdbmsTypeName() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_Uuid() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_Description() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_Size() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_Precision() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_Scale() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldType_StorageByte() {
        return (EAttribute)rdbmsFieldTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsModel() {
        return rdbmsModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModel_RdbmsFieldTypes() {
        return (EReference)rdbmsModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModel_RdbmsTables() {
        return (EReference)rdbmsModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModel_RdbmsViews() {
        return (EReference)rdbmsModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModel_Configuration() {
        return (EReference)rdbmsModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModel_Version() {
        return (EAttribute)rdbmsModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModel_TableOperations() {
        return (EReference)rdbmsModelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModel_ViewRecords() {
        return (EReference)rdbmsModelEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsValueField() {
        return rdbmsValueFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsValueField_Technical() {
        return (EAttribute)rdbmsValueFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewIdentifierField() {
        return rdbmsViewIdentifierFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsConfiguration() {
        return rdbmsConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsConfiguration_Dialect() {
        return (EAttribute)rdbmsConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsConfiguration_Features() {
        return (EReference)rdbmsConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsFeature() {
        return rdbmsFeatureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFeature_Name() {
        return (EAttribute)rdbmsFeatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsTableAlias() {
        return rdbmsTableAliasEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTableAlias_Table() {
        return (EReference)rdbmsTableAliasEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTableAlias_View() {
        return (EReference)rdbmsTableAliasEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsLabelExpression() {
        return rdbmsLabelExpressionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsLabelExpression_Text() {
        return (EAttribute)rdbmsLabelExpressionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsRelationExpression() {
        return rdbmsRelationExpressionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsRelationExpression_Field() {
        return (EReference)rdbmsRelationExpressionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewAliasField() {
        return rdbmsViewAliasFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewAliasField_Alias() {
        return (EReference)rdbmsViewAliasFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsModifyTableOperation() {
        return rdbmsModifyTableOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModifyTableOperation_CreateFieldOperations() {
        return (EReference)rdbmsModifyTableOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModifyTableOperation_ModifyFieldOperations() {
        return (EReference)rdbmsModifyTableOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModifyTableOperation_DeleteFieldOperations() {
        return (EReference)rdbmsModifyTableOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModifyTableOperation_PreviousTable() {
        return (EReference)rdbmsModifyTableOperationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyTableOperation_NameChanged() {
        return (EAttribute)rdbmsModifyTableOperationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsFieldOperation() {
        return rdbmsFieldOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsFieldOperation_Field() {
        return (EReference)rdbmsFieldOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsFieldOperation_ReviewRequired() {
        return (EAttribute)rdbmsFieldOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsCreateFieldOperation() {
        return rdbmsCreateFieldOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsModifyFieldOperation() {
        return rdbmsModifyFieldOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyFieldOperation_TypeChanged() {
        return (EAttribute)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyFieldOperation_MandatoryChanged() {
        return (EAttribute)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsModifyFieldOperation_PreviousField() {
        return (EReference)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyFieldOperation_SizeChanged() {
        return (EAttribute)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyFieldOperation_NameChanged() {
        return (EAttribute)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyFieldOperation_ChangedValueFieldToForeignKey() {
        return (EAttribute)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsModifyFieldOperation_ChangedForeignKeyToValueField() {
        return (EAttribute)rdbmsModifyFieldOperationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsDeleteFieldOperation() {
        return rdbmsDeleteFieldOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewRelation() {
        return rdbmsViewRelationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRelation_FromAlias() {
        return (EReference)rdbmsViewRelationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRelation_ToAlias() {
        return (EReference)rdbmsViewRelationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsViewRelation_Name() {
        return (EAttribute)rdbmsViewRelationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRelation_FromField() {
        return (EReference)rdbmsViewRelationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRelation_ToField() {
        return (EReference)rdbmsViewRelationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewTableField() {
        return rdbmsViewTableFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewTableField_TableField() {
        return (EReference)rdbmsViewTableFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsViewTableField_Foreign() {
        return (EAttribute)rdbmsViewTableFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewForeignIdentifierField() {
        return rdbmsViewForeignIdentifierFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewForeignIdentifierField_ReferenceIdentifier() {
        return (EReference)rdbmsViewForeignIdentifierFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsIndex() {
        return rdbmsIndexEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsIndex_Table() {
        return (EReference)rdbmsIndexEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsIndex_Fields() {
        return (EReference)rdbmsIndexEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsIndex_Unique() {
        return (EAttribute)rdbmsIndexEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewRecord() {
        return rdbmsViewRecordEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRecord_Values() {
        return (EReference)rdbmsViewRecordEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRecord_View() {
        return (EReference)rdbmsViewRecordEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsViewRecordValue() {
        return rdbmsViewRecordValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRdbmsViewRecordValue_Value() {
        return (EAttribute)rdbmsViewRecordValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRecordValue_IdentifierField() {
        return (EReference)rdbmsViewRecordValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsViewRecordValue_ValueField() {
        return (EReference)rdbmsViewRecordValueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsTableOperation() {
        return rdbmsTableOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsTableOperation_Table() {
        return (EReference)rdbmsTableOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsCreateTableOperation() {
        return rdbmsCreateTableOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsDeleteTableOperation() {
        return rdbmsDeleteTableOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRdbmsOperationMeta() {
        return rdbmsOperationMetaEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsOperationMeta_PreviousModel() {
        return (EReference)rdbmsOperationMetaEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRdbmsOperationMeta_CurrentModel() {
        return (EReference)rdbmsOperationMetaEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsFactory getRdbmsFactory() {
        return (RdbmsFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        rdbmsElementEClass = createEClass(RDBMS_ELEMENT);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__NAME);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__UUID);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__SHORT_NAME);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__FULL_NAME);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__DESCRIPTION);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__SQL_NAME);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__ORIGINAL_NAME);
        createEAttribute(rdbmsElementEClass, RDBMS_ELEMENT__ORIGINAL_PACKAGE);

        rdbmsTableEClass = createEClass(RDBMS_TABLE);
        createEReference(rdbmsTableEClass, RDBMS_TABLE__FIELDS);
        createEReference(rdbmsTableEClass, RDBMS_TABLE__UNIQUE_CONSTRAINTS);
        createEReference(rdbmsTableEClass, RDBMS_TABLE__PRIMARY_KEY);
        createEReference(rdbmsTableEClass, RDBMS_TABLE__INDEXES);
        createEReference(rdbmsTableEClass, RDBMS_TABLE__PARENT);

        rdbmsFieldEClass = createEClass(RDBMS_FIELD);
        createEReference(rdbmsFieldEClass, RDBMS_FIELD__TABLE);
        createEReference(rdbmsFieldEClass, RDBMS_FIELD__TYPE);
        createEAttribute(rdbmsFieldEClass, RDBMS_FIELD__MANDATORY);
        createEAttribute(rdbmsFieldEClass, RDBMS_FIELD__RDBMS_TYPE_NAME);
        createEAttribute(rdbmsFieldEClass, RDBMS_FIELD__SIZE);
        createEAttribute(rdbmsFieldEClass, RDBMS_FIELD__PRECISION);
        createEAttribute(rdbmsFieldEClass, RDBMS_FIELD__SCALE);
        createEAttribute(rdbmsFieldEClass, RDBMS_FIELD__STORAGE_BYTE);

        rdbmsForeignKeyEClass = createEClass(RDBMS_FOREIGN_KEY);
        createEReference(rdbmsForeignKeyEClass, RDBMS_FOREIGN_KEY__REFERENCE_KEY);
        createEAttribute(rdbmsForeignKeyEClass, RDBMS_FOREIGN_KEY__INHERITENCE_BASED);
        createEAttribute(rdbmsForeignKeyEClass, RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME);
        createEAttribute(rdbmsForeignKeyEClass, RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE);
        createEAttribute(rdbmsForeignKeyEClass, RDBMS_FOREIGN_KEY__DEFERRED);
        createEAttribute(rdbmsForeignKeyEClass, RDBMS_FOREIGN_KEY__READ_ONLY);

        rdbmsUniqueConstraintEClass = createEClass(RDBMS_UNIQUE_CONSTRAINT);
        createEReference(rdbmsUniqueConstraintEClass, RDBMS_UNIQUE_CONSTRAINT__TABLE);
        createEReference(rdbmsUniqueConstraintEClass, RDBMS_UNIQUE_CONSTRAINT__FIELDS);

        rdbmsJunctionTableEClass = createEClass(RDBMS_JUNCTION_TABLE);
        createEReference(rdbmsJunctionTableEClass, RDBMS_JUNCTION_TABLE__FIELD1);
        createEReference(rdbmsJunctionTableEClass, RDBMS_JUNCTION_TABLE__FIELD2);

        rdbmsIdentifierFieldEClass = createEClass(RDBMS_IDENTIFIER_FIELD);
        createEReference(rdbmsIdentifierFieldEClass, RDBMS_IDENTIFIER_FIELD__FOREIGN_KEYS);

        rdbmsViewEClass = createEClass(RDBMS_VIEW);
        createEReference(rdbmsViewEClass, RDBMS_VIEW__FIELDS);
        createEReference(rdbmsViewEClass, RDBMS_VIEW__PRIMARY_TABLE);
        createEAttribute(rdbmsViewEClass, RDBMS_VIEW__ORIGIN_UUID);
        createEReference(rdbmsViewEClass, RDBMS_VIEW__RELATIONS);
        createEReference(rdbmsViewEClass, RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD);
        createEReference(rdbmsViewEClass, RDBMS_VIEW__TABLES);

        rdbmsViewFieldEClass = createEClass(RDBMS_VIEW_FIELD);
        createEReference(rdbmsViewFieldEClass, RDBMS_VIEW_FIELD__VIEW);
        createEAttribute(rdbmsViewFieldEClass, RDBMS_VIEW_FIELD__INHERITED);

        rdbmsViewValueFieldEClass = createEClass(RDBMS_VIEW_VALUE_FIELD);

        rdbmsViewExpressionFieldEClass = createEClass(RDBMS_VIEW_EXPRESSION_FIELD);
        createEReference(rdbmsViewExpressionFieldEClass, RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS);
        createEAttribute(rdbmsViewExpressionFieldEClass, RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION);

        rdbmsExpressionEClass = createEClass(RDBMS_EXPRESSION);
        createEAttribute(rdbmsExpressionEClass, RDBMS_EXPRESSION__EXPRESSION);

        rdbmsFieldTypeEClass = createEClass(RDBMS_FIELD_TYPE);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__NAME);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__UUID);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__DESCRIPTION);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__SIZE);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__PRECISION);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__SCALE);
        createEAttribute(rdbmsFieldTypeEClass, RDBMS_FIELD_TYPE__STORAGE_BYTE);

        rdbmsModelEClass = createEClass(RDBMS_MODEL);
        createEReference(rdbmsModelEClass, RDBMS_MODEL__RDBMS_FIELD_TYPES);
        createEReference(rdbmsModelEClass, RDBMS_MODEL__RDBMS_TABLES);
        createEReference(rdbmsModelEClass, RDBMS_MODEL__RDBMS_VIEWS);
        createEReference(rdbmsModelEClass, RDBMS_MODEL__CONFIGURATION);
        createEAttribute(rdbmsModelEClass, RDBMS_MODEL__VERSION);
        createEReference(rdbmsModelEClass, RDBMS_MODEL__TABLE_OPERATIONS);
        createEReference(rdbmsModelEClass, RDBMS_MODEL__VIEW_RECORDS);

        rdbmsValueFieldEClass = createEClass(RDBMS_VALUE_FIELD);
        createEAttribute(rdbmsValueFieldEClass, RDBMS_VALUE_FIELD__TECHNICAL);

        rdbmsViewIdentifierFieldEClass = createEClass(RDBMS_VIEW_IDENTIFIER_FIELD);

        rdbmsConfigurationEClass = createEClass(RDBMS_CONFIGURATION);
        createEAttribute(rdbmsConfigurationEClass, RDBMS_CONFIGURATION__DIALECT);
        createEReference(rdbmsConfigurationEClass, RDBMS_CONFIGURATION__FEATURES);

        rdbmsFeatureEClass = createEClass(RDBMS_FEATURE);
        createEAttribute(rdbmsFeatureEClass, RDBMS_FEATURE__NAME);

        rdbmsTableAliasEClass = createEClass(RDBMS_TABLE_ALIAS);
        createEReference(rdbmsTableAliasEClass, RDBMS_TABLE_ALIAS__TABLE);
        createEReference(rdbmsTableAliasEClass, RDBMS_TABLE_ALIAS__VIEW);

        rdbmsLabelExpressionEClass = createEClass(RDBMS_LABEL_EXPRESSION);
        createEAttribute(rdbmsLabelExpressionEClass, RDBMS_LABEL_EXPRESSION__TEXT);

        rdbmsRelationExpressionEClass = createEClass(RDBMS_RELATION_EXPRESSION);
        createEReference(rdbmsRelationExpressionEClass, RDBMS_RELATION_EXPRESSION__FIELD);

        rdbmsViewAliasFieldEClass = createEClass(RDBMS_VIEW_ALIAS_FIELD);
        createEReference(rdbmsViewAliasFieldEClass, RDBMS_VIEW_ALIAS_FIELD__ALIAS);

        rdbmsModifyTableOperationEClass = createEClass(RDBMS_MODIFY_TABLE_OPERATION);
        createEReference(rdbmsModifyTableOperationEClass, RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS);
        createEReference(rdbmsModifyTableOperationEClass, RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS);
        createEReference(rdbmsModifyTableOperationEClass, RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS);
        createEReference(rdbmsModifyTableOperationEClass, RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE);
        createEAttribute(rdbmsModifyTableOperationEClass, RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED);

        rdbmsFieldOperationEClass = createEClass(RDBMS_FIELD_OPERATION);
        createEReference(rdbmsFieldOperationEClass, RDBMS_FIELD_OPERATION__FIELD);
        createEAttribute(rdbmsFieldOperationEClass, RDBMS_FIELD_OPERATION__REVIEW_REQUIRED);

        rdbmsCreateFieldOperationEClass = createEClass(RDBMS_CREATE_FIELD_OPERATION);

        rdbmsModifyFieldOperationEClass = createEClass(RDBMS_MODIFY_FIELD_OPERATION);
        createEAttribute(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED);
        createEAttribute(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED);
        createEReference(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD);
        createEAttribute(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED);
        createEAttribute(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED);
        createEAttribute(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY);
        createEAttribute(rdbmsModifyFieldOperationEClass, RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD);

        rdbmsDeleteFieldOperationEClass = createEClass(RDBMS_DELETE_FIELD_OPERATION);

        rdbmsViewRelationEClass = createEClass(RDBMS_VIEW_RELATION);
        createEReference(rdbmsViewRelationEClass, RDBMS_VIEW_RELATION__FROM_ALIAS);
        createEReference(rdbmsViewRelationEClass, RDBMS_VIEW_RELATION__TO_ALIAS);
        createEAttribute(rdbmsViewRelationEClass, RDBMS_VIEW_RELATION__NAME);
        createEReference(rdbmsViewRelationEClass, RDBMS_VIEW_RELATION__FROM_FIELD);
        createEReference(rdbmsViewRelationEClass, RDBMS_VIEW_RELATION__TO_FIELD);

        rdbmsViewTableFieldEClass = createEClass(RDBMS_VIEW_TABLE_FIELD);
        createEReference(rdbmsViewTableFieldEClass, RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD);
        createEAttribute(rdbmsViewTableFieldEClass, RDBMS_VIEW_TABLE_FIELD__FOREIGN);

        rdbmsViewForeignIdentifierFieldEClass = createEClass(RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD);
        createEReference(rdbmsViewForeignIdentifierFieldEClass, RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER);

        rdbmsIndexEClass = createEClass(RDBMS_INDEX);
        createEReference(rdbmsIndexEClass, RDBMS_INDEX__TABLE);
        createEReference(rdbmsIndexEClass, RDBMS_INDEX__FIELDS);
        createEAttribute(rdbmsIndexEClass, RDBMS_INDEX__UNIQUE);

        rdbmsViewRecordEClass = createEClass(RDBMS_VIEW_RECORD);
        createEReference(rdbmsViewRecordEClass, RDBMS_VIEW_RECORD__VALUES);
        createEReference(rdbmsViewRecordEClass, RDBMS_VIEW_RECORD__VIEW);

        rdbmsViewRecordValueEClass = createEClass(RDBMS_VIEW_RECORD_VALUE);
        createEAttribute(rdbmsViewRecordValueEClass, RDBMS_VIEW_RECORD_VALUE__VALUE);
        createEReference(rdbmsViewRecordValueEClass, RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD);
        createEReference(rdbmsViewRecordValueEClass, RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD);

        rdbmsTableOperationEClass = createEClass(RDBMS_TABLE_OPERATION);
        createEReference(rdbmsTableOperationEClass, RDBMS_TABLE_OPERATION__TABLE);

        rdbmsCreateTableOperationEClass = createEClass(RDBMS_CREATE_TABLE_OPERATION);

        rdbmsDeleteTableOperationEClass = createEClass(RDBMS_DELETE_TABLE_OPERATION);

        rdbmsOperationMetaEClass = createEClass(RDBMS_OPERATION_META);
        createEReference(rdbmsOperationMetaEClass, RDBMS_OPERATION_META__PREVIOUS_MODEL);
        createEReference(rdbmsOperationMetaEClass, RDBMS_OPERATION_META__CURRENT_MODEL);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        rdbmsTableEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsFieldEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsForeignKeyEClass.getESuperTypes().add(this.getRdbmsIdentifierField());
        rdbmsUniqueConstraintEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsJunctionTableEClass.getESuperTypes().add(this.getRdbmsTable());
        rdbmsIdentifierFieldEClass.getESuperTypes().add(this.getRdbmsField());
        rdbmsViewEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsViewFieldEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsViewValueFieldEClass.getESuperTypes().add(this.getRdbmsViewAliasField());
        rdbmsViewExpressionFieldEClass.getESuperTypes().add(this.getRdbmsViewField());
        rdbmsExpressionEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsValueFieldEClass.getESuperTypes().add(this.getRdbmsField());
        rdbmsViewIdentifierFieldEClass.getESuperTypes().add(this.getRdbmsViewAliasField());
        rdbmsTableAliasEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsLabelExpressionEClass.getESuperTypes().add(this.getRdbmsExpression());
        rdbmsRelationExpressionEClass.getESuperTypes().add(this.getRdbmsExpression());
        rdbmsViewAliasFieldEClass.getESuperTypes().add(this.getRdbmsViewTableField());
        rdbmsModifyTableOperationEClass.getESuperTypes().add(this.getRdbmsTableOperation());
        rdbmsFieldOperationEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsCreateFieldOperationEClass.getESuperTypes().add(this.getRdbmsFieldOperation());
        rdbmsModifyFieldOperationEClass.getESuperTypes().add(this.getRdbmsFieldOperation());
        rdbmsDeleteFieldOperationEClass.getESuperTypes().add(this.getRdbmsFieldOperation());
        rdbmsViewTableFieldEClass.getESuperTypes().add(this.getRdbmsViewField());
        rdbmsViewForeignIdentifierFieldEClass.getESuperTypes().add(this.getRdbmsViewTableField());
        rdbmsIndexEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsTableOperationEClass.getESuperTypes().add(this.getRdbmsElement());
        rdbmsCreateTableOperationEClass.getESuperTypes().add(this.getRdbmsTableOperation());
        rdbmsDeleteTableOperationEClass.getESuperTypes().add(this.getRdbmsTableOperation());

        // Initialize classes, features, and operations; add parameters
        initEClass(rdbmsElementEClass, RdbmsElement.class, "RdbmsElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_ShortName(), ecorePackage.getEString(), "shortName", null, 0, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_FullName(), ecorePackage.getEString(), "fullName", null, 0, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_SqlName(), ecorePackage.getEString(), "sqlName", null, 0, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_OriginalName(), ecorePackage.getEString(), "originalName", null, 0, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsElement_OriginalPackage(), ecorePackage.getEString(), "originalPackage", null, 0, 1, RdbmsElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsTableEClass, RdbmsTable.class, "RdbmsTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsTable_Fields(), this.getRdbmsField(), this.getRdbmsField_Table(), "fields", null, 0, -1, RdbmsTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsTable_UniqueConstraints(), this.getRdbmsUniqueConstraint(), this.getRdbmsUniqueConstraint_Table(), "uniqueConstraints", null, 0, -1, RdbmsTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsTable_PrimaryKey(), this.getRdbmsIdentifierField(), null, "primaryKey", null, 1, 1, RdbmsTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsTable_Indexes(), this.getRdbmsIndex(), this.getRdbmsIndex_Table(), "indexes", null, 0, -1, RdbmsTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsTable_Parent(), this.getRdbmsTable(), null, "parent", null, 0, 1, RdbmsTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsFieldEClass, RdbmsField.class, "RdbmsField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsField_Table(), this.getRdbmsTable(), this.getRdbmsTable_Fields(), "table", null, 1, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsField_Type(), this.getRdbmsFieldType(), null, "type", null, 0, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsField_Mandatory(), ecorePackage.getEBoolean(), "mandatory", null, 1, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsField_RdbmsTypeName(), ecorePackage.getEString(), "rdbmsTypeName", null, 0, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsField_Size(), ecorePackage.getEInt(), "size", null, 0, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsField_Precision(), ecorePackage.getEInt(), "precision", null, 0, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsField_Scale(), ecorePackage.getEInt(), "scale", null, 0, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsField_StorageByte(), ecorePackage.getEInt(), "storageByte", null, 0, 1, RdbmsField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsForeignKeyEClass, RdbmsForeignKey.class, "RdbmsForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsForeignKey_ReferenceKey(), this.getRdbmsIdentifierField(), this.getRdbmsIdentifierField_ForeignKeys(), "referenceKey", null, 1, 1, RdbmsForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsForeignKey_InheritenceBased(), ecorePackage.getEBoolean(), "inheritenceBased", "false", 0, 1, RdbmsForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsForeignKey_ForeignKeySqlName(), ecorePackage.getEString(), "foreignKeySqlName", null, 1, 1, RdbmsForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsForeignKey_DeleteOnCascade(), ecorePackage.getEBoolean(), "deleteOnCascade", "false", 0, 1, RdbmsForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsForeignKey_Deferred(), ecorePackage.getEBoolean(), "deferred", "false", 0, 1, RdbmsForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsForeignKey_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "false", 0, 1, RdbmsForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsUniqueConstraintEClass, RdbmsUniqueConstraint.class, "RdbmsUniqueConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsUniqueConstraint_Table(), this.getRdbmsTable(), this.getRdbmsTable_UniqueConstraints(), "table", null, 1, 1, RdbmsUniqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsUniqueConstraint_Fields(), this.getRdbmsField(), null, "fields", null, 1, -1, RdbmsUniqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsJunctionTableEClass, RdbmsJunctionTable.class, "RdbmsJunctionTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsJunctionTable_Field1(), this.getRdbmsForeignKey(), null, "field1", null, 1, 1, RdbmsJunctionTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsJunctionTable_Field2(), this.getRdbmsForeignKey(), null, "field2", null, 1, 1, RdbmsJunctionTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsIdentifierFieldEClass, RdbmsIdentifierField.class, "RdbmsIdentifierField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsIdentifierField_ForeignKeys(), this.getRdbmsForeignKey(), this.getRdbmsForeignKey_ReferenceKey(), "foreignKeys", null, 0, -1, RdbmsIdentifierField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewEClass, RdbmsView.class, "RdbmsView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsView_Fields(), this.getRdbmsViewField(), this.getRdbmsViewField_View(), "fields", null, 0, -1, RdbmsView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsView_PrimaryTable(), this.getRdbmsTableAlias(), null, "primaryTable", null, 1, 1, RdbmsView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsView_OriginUuid(), ecorePackage.getEString(), "originUuid", null, 0, 1, RdbmsView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsView_Relations(), this.getRdbmsViewRelation(), null, "relations", null, 0, -1, RdbmsView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsView_PrimaryIdentifierField(), this.getRdbmsViewIdentifierField(), null, "primaryIdentifierField", null, 1, 1, RdbmsView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsView_Tables(), this.getRdbmsTableAlias(), this.getRdbmsTableAlias_View(), "tables", null, 1, -1, RdbmsView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewFieldEClass, RdbmsViewField.class, "RdbmsViewField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewField_View(), this.getRdbmsView(), this.getRdbmsView_Fields(), "view", null, 1, 1, RdbmsViewField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsViewField_Inherited(), ecorePackage.getEBoolean(), "inherited", null, 1, 1, RdbmsViewField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewValueFieldEClass, RdbmsViewValueField.class, "RdbmsViewValueField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rdbmsViewExpressionFieldEClass, RdbmsViewExpressionField.class, "RdbmsViewExpressionField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewExpressionField_Expressions(), this.getRdbmsExpression(), null, "expressions", null, 1, -1, RdbmsViewExpressionField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsViewExpressionField_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, RdbmsViewExpressionField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsExpressionEClass, RdbmsExpression.class, "RdbmsExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsExpression_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, RdbmsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsFieldTypeEClass, RdbmsFieldType.class, "RdbmsFieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsFieldType_Name(), ecorePackage.getEString(), "name", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_RdbmsTypeName(), ecorePackage.getEString(), "rdbmsTypeName", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_Uuid(), ecorePackage.getEString(), "uuid", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_Description(), ecorePackage.getEString(), "description", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_Size(), ecorePackage.getEInt(), "size", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_Precision(), ecorePackage.getEInt(), "precision", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_Scale(), ecorePackage.getEInt(), "scale", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldType_StorageByte(), ecorePackage.getEInt(), "storageByte", null, 0, 1, RdbmsFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsModelEClass, RdbmsModel.class, "RdbmsModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsModel_RdbmsFieldTypes(), this.getRdbmsFieldType(), null, "rdbmsFieldTypes", null, 0, -1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModel_RdbmsTables(), this.getRdbmsTable(), null, "rdbmsTables", null, 0, -1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModel_RdbmsViews(), this.getRdbmsView(), null, "rdbmsViews", null, 0, -1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModel_Configuration(), this.getRdbmsConfiguration(), null, "configuration", null, 1, 1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModel_Version(), ecorePackage.getEString(), "version", null, 0, 1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModel_TableOperations(), this.getRdbmsTableOperation(), null, "tableOperations", null, 0, -1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModel_ViewRecords(), this.getRdbmsViewRecord(), null, "viewRecords", null, 0, -1, RdbmsModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsValueFieldEClass, RdbmsValueField.class, "RdbmsValueField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsValueField_Technical(), ecorePackage.getEBoolean(), "technical", "false", 0, 1, RdbmsValueField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewIdentifierFieldEClass, RdbmsViewIdentifierField.class, "RdbmsViewIdentifierField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rdbmsConfigurationEClass, RdbmsConfiguration.class, "RdbmsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsConfiguration_Dialect(), ecorePackage.getEString(), "dialect", null, 1, 1, RdbmsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsConfiguration_Features(), this.getRdbmsFeature(), null, "features", null, 0, -1, RdbmsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsFeatureEClass, RdbmsFeature.class, "RdbmsFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsFeature_Name(), ecorePackage.getEString(), "name", null, 1, 1, RdbmsFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsTableAliasEClass, RdbmsTableAlias.class, "RdbmsTableAlias", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsTableAlias_Table(), this.getRdbmsTable(), null, "table", null, 1, 1, RdbmsTableAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsTableAlias_View(), this.getRdbmsView(), this.getRdbmsView_Tables(), "view", null, 1, 1, RdbmsTableAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsLabelExpressionEClass, RdbmsLabelExpression.class, "RdbmsLabelExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsLabelExpression_Text(), ecorePackage.getEString(), "text", null, 1, 1, RdbmsLabelExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsRelationExpressionEClass, RdbmsRelationExpression.class, "RdbmsRelationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsRelationExpression_Field(), this.getRdbmsViewAliasField(), null, "field", null, 1, 1, RdbmsRelationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewAliasFieldEClass, RdbmsViewAliasField.class, "RdbmsViewAliasField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewAliasField_Alias(), this.getRdbmsTableAlias(), null, "alias", null, 1, 1, RdbmsViewAliasField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsModifyTableOperationEClass, RdbmsModifyTableOperation.class, "RdbmsModifyTableOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsModifyTableOperation_CreateFieldOperations(), this.getRdbmsCreateFieldOperation(), null, "createFieldOperations", null, 0, -1, RdbmsModifyTableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModifyTableOperation_ModifyFieldOperations(), this.getRdbmsModifyFieldOperation(), null, "modifyFieldOperations", null, 0, -1, RdbmsModifyTableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModifyTableOperation_DeleteFieldOperations(), this.getRdbmsDeleteFieldOperation(), null, "deleteFieldOperations", null, 0, -1, RdbmsModifyTableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModifyTableOperation_PreviousTable(), this.getRdbmsTable(), null, "previousTable", null, 1, 1, RdbmsModifyTableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModifyTableOperation_NameChanged(), theXMLTypePackage.getBoolean(), "nameChanged", null, 0, 1, RdbmsModifyTableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsFieldOperationEClass, RdbmsFieldOperation.class, "RdbmsFieldOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsFieldOperation_Field(), this.getRdbmsField(), null, "field", null, 1, 1, RdbmsFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsFieldOperation_ReviewRequired(), ecorePackage.getEBoolean(), "reviewRequired", "false", 1, 1, RdbmsFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsCreateFieldOperationEClass, RdbmsCreateFieldOperation.class, "RdbmsCreateFieldOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rdbmsModifyFieldOperationEClass, RdbmsModifyFieldOperation.class, "RdbmsModifyFieldOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsModifyFieldOperation_TypeChanged(), ecorePackage.getEBoolean(), "typeChanged", "false", 0, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModifyFieldOperation_MandatoryChanged(), ecorePackage.getEBoolean(), "mandatoryChanged", "false", 0, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsModifyFieldOperation_PreviousField(), this.getRdbmsField(), null, "previousField", null, 1, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModifyFieldOperation_SizeChanged(), theXMLTypePackage.getBoolean(), "sizeChanged", null, 0, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModifyFieldOperation_NameChanged(), theXMLTypePackage.getBoolean(), "nameChanged", null, 0, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModifyFieldOperation_ChangedValueFieldToForeignKey(), theXMLTypePackage.getBoolean(), "changedValueFieldToForeignKey", null, 0, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsModifyFieldOperation_ChangedForeignKeyToValueField(), theXMLTypePackage.getBoolean(), "changedForeignKeyToValueField", null, 0, 1, RdbmsModifyFieldOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsDeleteFieldOperationEClass, RdbmsDeleteFieldOperation.class, "RdbmsDeleteFieldOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rdbmsViewRelationEClass, RdbmsViewRelation.class, "RdbmsViewRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewRelation_FromAlias(), this.getRdbmsTableAlias(), null, "fromAlias", null, 1, 1, RdbmsViewRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsViewRelation_ToAlias(), this.getRdbmsTableAlias(), null, "toAlias", null, 1, 1, RdbmsViewRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsViewRelation_Name(), ecorePackage.getEString(), "name", null, 1, 1, RdbmsViewRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsViewRelation_FromField(), this.getRdbmsIdentifierField(), null, "fromField", null, 1, 1, RdbmsViewRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsViewRelation_ToField(), this.getRdbmsIdentifierField(), null, "toField", null, 1, 1, RdbmsViewRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewTableFieldEClass, RdbmsViewTableField.class, "RdbmsViewTableField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewTableField_TableField(), this.getRdbmsField(), null, "tableField", null, 1, 1, RdbmsViewTableField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsViewTableField_Foreign(), ecorePackage.getEBoolean(), "foreign", "false", 1, 1, RdbmsViewTableField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewForeignIdentifierFieldEClass, RdbmsViewForeignIdentifierField.class, "RdbmsViewForeignIdentifierField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewForeignIdentifierField_ReferenceIdentifier(), this.getRdbmsViewIdentifierField(), null, "referenceIdentifier", null, 1, 1, RdbmsViewForeignIdentifierField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsIndexEClass, RdbmsIndex.class, "RdbmsIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsIndex_Table(), this.getRdbmsTable(), this.getRdbmsTable_Indexes(), "table", null, 1, 1, RdbmsIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsIndex_Fields(), this.getRdbmsField(), null, "fields", null, 1, -1, RdbmsIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRdbmsIndex_Unique(), ecorePackage.getEBoolean(), "unique", null, 1, 1, RdbmsIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewRecordEClass, RdbmsViewRecord.class, "RdbmsViewRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsViewRecord_Values(), this.getRdbmsViewRecordValue(), null, "values", null, 0, -1, RdbmsViewRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsViewRecord_View(), this.getRdbmsView(), null, "view", null, 1, 1, RdbmsViewRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsViewRecordValueEClass, RdbmsViewRecordValue.class, "RdbmsViewRecordValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRdbmsViewRecordValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, RdbmsViewRecordValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsViewRecordValue_IdentifierField(), this.getRdbmsViewIdentifierField(), null, "identifierField", null, 0, 1, RdbmsViewRecordValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsViewRecordValue_ValueField(), this.getRdbmsViewValueField(), null, "valueField", null, 0, 1, RdbmsViewRecordValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsTableOperationEClass, RdbmsTableOperation.class, "RdbmsTableOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsTableOperation_Table(), this.getRdbmsTable(), null, "table", null, 1, 1, RdbmsTableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rdbmsCreateTableOperationEClass, RdbmsCreateTableOperation.class, "RdbmsCreateTableOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rdbmsDeleteTableOperationEClass, RdbmsDeleteTableOperation.class, "RdbmsDeleteTableOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rdbmsOperationMetaEClass, RdbmsOperationMeta.class, "RdbmsOperationMeta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRdbmsOperationMeta_PreviousModel(), this.getRdbmsModel(), null, "previousModel", null, 1, 1, RdbmsOperationMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRdbmsOperationMeta_CurrentModel(), this.getRdbmsModel(), null, "currentModel", null, 1, 1, RdbmsOperationMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.obeo.fr/dsl/dnc/archetype
        createArchetypeAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.obeo.fr/dsl/dnc/archetype</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createArchetypeAnnotations() {
        String source = "http://www.obeo.fr/dsl/dnc/archetype";	
        addAnnotation
          (rdbmsValueFieldEClass, 
           source, 
           new String[] {
             "archetype", "MomentInterval"
           });
    }

} //RdbmsPackageImpl
