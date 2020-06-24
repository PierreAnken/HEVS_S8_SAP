package connectors;
/*  
	RFC_destination
	- Serveur java local qui "ecoute" des modules SAP
	
	Creation du fonction module z_fm
	- param�tre import/export (pass by value)+ erreur 
	- aucun code n�cessaire (g�r� dans Java)
	
	Mise en place
	- Enregistrer un �couteur dans SAPServer
	- Impl�mentation de la m�thode dans HandlerZ_xxx
	
	Contenu du handler
	- Voir les param�tres du module dans SAP E37
	
	Tester fonction
	- D�marrer serveur Java
	- SE37 
		o RFC Target System : 2020_RFC_E80
	
	Acces user SAP au module:
	 - new program > test program
	 - appel function avec pattern + DESTINATION '2020_RFC_E80'

	
*/