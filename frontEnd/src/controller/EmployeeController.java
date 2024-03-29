package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import service.EmployeeEJB;
import model.Employee;

@ManagedBean(name = "employeecontroller")
@SessionScoped
public class EmployeeController {
	
	@EJB
	private EmployeeEJB employeeEJB;
	
	//from form ...NB
  	@ManagedProperty(value="#{employee}")
    private Employee employee;
  	
  	private List<Employee> employeeList = new ArrayList<>();
  	
  	public List<Employee> getEmployeeList() {
        // employeeList = employeeEJB.findEmployees();
         return employeeList;
     }
  	
  	public String viewEmployee(){
        return "employeeList.xhtml";
    }
  	
  	 public String addNewEmployee() {
         employeeEJB.addNew(employee.getEntity());
      //  employeeList = employeeEJB.findEmployees();
        return "employeeList.xhtml";
    }
  	 
  	public Employee getEmployee() {
		return employee;
	}
  	
  	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
}
