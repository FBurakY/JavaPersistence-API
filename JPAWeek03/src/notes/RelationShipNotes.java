package notes;

public class RelationShipNotes {

}

// bir Entity Relationship icin;

// 1 - Role
// 2 - Directionality
// 3 - Cardinality
// 4 - Ordinality / Optionality


// ROLE
// bir iliskide 2 tarafin varligi gerekli/soz konusudur.
// her iliski icin 2 tane Entity vardir.
// Employee - Department

// DIRECTIONALITY
// - Unidirectional
// - BiDirectional

// bir iliskide , 2 entityden sadece birisi digerini gosteriyorsa/point bu durumda Unidirectionaldir.
// birbirlerini gosteriyorsa bidirectionaldir.


// CARDINALITY
// Cardinal -> onemli , asil , nicelik

// bir Employee/calisan , sadece 1 departmana bagli olabilir./calisir
// 1 departmanda N tane employee/calisan olabilir.

// 1 Employee N tane Phone olabilir.
// 1 Phone sadece 1 Employee ya aittir.

// 1 Employe N tane Project/projede calisabilir.
// 1 Project/projede M tane Employee/calsian olabilir.

// cardinality kavramindan kastimiz ;
// bir iliskideki su ifadelerdir;

// OneToOne
// OneToMany
// ManyToOne
// ManyToMany

// ORDINALITY / OPTIONALITY
// zorunlu/mandotary ya da secimlik/optional olup olmamasi ile ilgili bir kavramdir.

// Customer - BillingInfo
// her customer icin billinginfo olmak zorunda degildir.
// BillingInfo bizim icin zorunlu degil. optional/secimliktir.

// Single-valued RelationShip 
// @OneToOne
// @ManyToOne

// Collection-valued Relationship
// @ManyToMany
// @OneToMany
