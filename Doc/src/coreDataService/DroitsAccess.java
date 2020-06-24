package coreDataService;
/* 

Check access right - SAP GUI
	- transaction SU21

Access Controls - Eclipse
	- Create new access control in Core Data Services
	- right click on CDS > New > Access Control > ZDCL_xxx
	- copy code from ZDCL_CARRIER_E80
		o change view impacted / field / and autorization (03: view)
		
Vue ZDDL - Eclipse
	- voir exemple ZDDL_VIEW_RIGHT_E80
	- attention : @AccessControl.authorizationCheck: #CHECK 
	- #NOT_ALLOWED pour outrepasser les check pour des tests
		> sinon aucun check de droits
		
Programm - SAP GUI
	- créer un nouveau programme (il ne fait rien d'autre que d'appeller la vue)
		o ZPROG_xxxJ
		o [1] Executable Program
		o [T] Test Program
	- voir exemple code ZPROG_WORK_CDS_DCL_E80
	- créer text elements > clic droit > open > open other > text element

Adaptation des droits - SAP GUI
	- transaction PFCG
	- créer role simple
		o authorizations > créer profil (bouton à droite de profil name)
		o plus bas sur la page > Change autorization Data
			+ ajouter l'objet ZAO_xxx
			+ définir les autorisations (03?)
			+ définir les records autorisés
			+ sauvegarder et générer
		o user > ajouter l'utilisateur (pour tester mettre celui de connexion à SAP)
			+ user comparaison
			+ save

 */