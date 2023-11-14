package company.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@NotBlank(message = "Department code is required")
	@Size(max = 10, message = "Department code must not exceed 10 characters")
	@Column(name = "deptcode")
	private String deptCode;

	@Column(name = "deptname")
	@NotBlank(message = "Department name is required")
	@Size(max = 50, message = "Department name must not exceed 50 characters")
	private String deptName;

	@Column(name = "hod")
	@Size(max = 50, message = "Head of Department name must not exceed 50 characters")
	private String hod;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	@JsonIgnore
	private List<Expenditure> expenditures = new ArrayList<Expenditure>();

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public List<Expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<Expenditure> expenditures) {
		this.expenditures = expenditures;
	}

}