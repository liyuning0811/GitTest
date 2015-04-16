package old;
import java.util.List;
import javabean.Patient;
import DAO.PatientDAO;

public class SelectSample {

	
	 public static void main(String[] args){
		 
		 PatientDAO patDAO=new PatientDAO();
		 List<Patient> patientList=patDAO.findAll();
		 
		 for(Patient pat:patientList){
			 System.out.println("ID:"+pat.getUserid());
			 System.out.println("NAME:"+pat.getFullname());
			 
		 }
	 }
}
