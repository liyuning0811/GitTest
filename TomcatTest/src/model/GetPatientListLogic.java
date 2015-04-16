/**
 * 
 */
/**
 * @author liyuning
 *
 */
package model;

import java.util.List;

import javabean.Patient;
import DAO.PatientDAO;

public class GetPatientListLogic{
	
	public List<Patient> execute(){

		PatientDAO dao=new PatientDAO();
		List<Patient> patientList=dao.findAll();
		return patientList;
	
}
}