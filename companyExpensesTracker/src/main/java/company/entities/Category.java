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
@Table(name = "categories")
public class Category {
	@Id
	@NotBlank(message = "abc")
	@Column(name = "catcode")
	private String catCode;

	@Column(name = "catname")
	@NotBlank(message = "Category name is required")
	@Size(max = 50, message = "Category name must not exceed 50 characters")
	private String catName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnore
	private List<Expenditure> expenditures = new ArrayList<Expenditure>();

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<Expenditure> expenditures) {
		this.expenditures = expenditures;
	}

}