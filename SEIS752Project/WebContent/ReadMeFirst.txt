1. Download jars under WEB-INF/lib
	commons-fileupload-1.2.2
	commons-fileupload-1.2
	commons-is-1.3.1
	commons-lang-2.1
2. Add commons-fileupload-1.2.2.jar under Java Build Path -. Libraries
3. update WebContent/db.properties to point to your DB instance
   see your configuration in JAP Content/persistence.xml
	Note: leave the following properties with default 
		seis752.dir=out
		seis752.error=error.log
4. Create Folder c:\\apps\\seis752\\vault\\folder1 for file upload