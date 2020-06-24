package sapconnector;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.Environment;

public class SAPDestination {
	
	//Variable
	private String _destination ;
	
	//Constructor
	public SAPDestination(String sapsid)
	{
		this._destination = sapsid ;
		
		//Destination Provider
		ProviderRFCDestination _rfcdestination = new ProviderRFCDestination(sapsid) ;
		Environment.registerDestinationDataProvider(_rfcdestination);
	}
	
	//Remote Function Module STFC_CONNECTION
	public void testRFCConnection(String txt)
	{
		try
		{
			//Create SAP connection & Get function module metadata
			JCoDestination destination = JCoDestinationManager.getDestination(this._destination);
			JCoFunction function = destination.getRepository().getFunction("STFC_CONNECTION");
			if(function == null)
				throw new RuntimeException("STFC_CONNECTION not found in SAP.");
			
			//Set import parameters
			function.getImportParameterList().setValue("REQUTEXT", txt);
			
			//Execute function
			function.execute(destination);
			
			//Get export parameters
			String echo = function.getExportParameterList().getString("ECHOTEXT");
			String resp = function.getExportParameterList().getString("RESPTEXT");
			
			//Display result
			System.out.println("STFC_CONNECTION finished");
			System.out.println(echo);
			System.out.println(resp);
		}
		catch (AbapException e)
		{
		System.out.println(e.toString());
		}
		catch (JCoException e)
		{
		System.out.println(e.toString());
		}
		catch (Exception e)
		{
		System.out.println(e.toString());
		}
	}
	
	//Remote Function Module Z_FM_RFCDEST_VARIABLE_E80
	public void divide(int number1, int number2)
	{
		try
		{
			//Create SAP connection & Get function module metadata
			JCoDestination destination = JCoDestinationManager.getDestination(this._destination);
			JCoFunction function = destination.getRepository().getFunction("Z_FM_RFCDEST_VARIABLE_E80");
			if(function == null)
				throw new RuntimeException("Z_FM_RFCDEST_VARIABLE_E80 not found in SAP.");
			
			//Set import parameters
			function.getImportParameterList().setValue("IV_NUMBER01", number1);
			function.getImportParameterList().setValue("IV_NUMBER02", number2);

			//Execute function
			function.execute(destination);
			
			//Get export parameters
			String resp = function.getExportParameterList().getString("EV_RESULT");
			
			//Display result
			System.out.println(resp);
		}
		catch (AbapException e)
		{
		System.out.println(e.toString());
		}
		catch (JCoException e)
		{
		System.out.println(e.toString());
		}
		catch (Exception e)
		{
		System.out.println(e.toString());
		}
	}
	
	//Remote Function Module Z_FM_RFCDEST_STRUCTURE_E80
	public void displayEmployee(String carrier, int idemployee)
	{
		try
		{
			//Create SAP connection & Get function module metadata
			JCoDestination destination = JCoDestinationManager.getDestination(this._destination);
			JCoFunction function = destination.getRepository().getFunction("Z_FM_RFCDEST_STRUCTURE_E80");
			if(function == null)
				throw new RuntimeException("Z_FM_RFCDEST_STRUCTURE_E80 not found in SAP.");
			
			//Set import parameters
			function.getImportParameterList().setValue("IV_CARRIER", carrier);
			function.getImportParameterList().setValue("IV_IDEMPLOYEE", idemployee);

			//Execute function
			function.execute(destination);
			
			//Get export parameters
			JCoStructure employee = function.getExportParameterList().getStructure("ES_EMPLOYEE");
			

			//Display result
			System.out.println(employee);
		}
		catch (AbapException e)
		{
		System.out.println(e.toString());
		}
		catch (JCoException e)
		{
		System.out.println(e.toString());
		}
		catch (Exception e)
		{
		System.out.println(e.toString());
		}
	}
	
	//Remote Function Module Z_FM_RFCDEST_TABLE_E80
	public void displayEmployees(String carrier)
	{
		try
		{
			//Create SAP connection & Get function module metadata
			JCoDestination destination = JCoDestinationManager.getDestination(this._destination);
			JCoFunction function = destination.getRepository().getFunction("Z_FM_RFCDEST_TABLE_E80");
			if(function == null)
				throw new RuntimeException("Z_FM_RFCDEST_TABLE_E80 not found in SAP.");
			
			//Set import parameters
			function.getImportParameterList().setValue("IV_CARRIER", carrier);

			//Execute function
			function.execute(destination);
			
			//Get export parameters
			JCoTable employeeTable =  function.getExportParameterList().getTable("ET_EMPLOYEES");
			
			//Display result
			System.out.println(employeeTable);
		}
		catch (AbapException e)
		{
		System.out.println(e.toString());
		}
		catch (JCoException e)
		{
		System.out.println(e.toString());
		}
		catch (Exception e)
		{
		System.out.println(e.toString());
		}
	}
}
