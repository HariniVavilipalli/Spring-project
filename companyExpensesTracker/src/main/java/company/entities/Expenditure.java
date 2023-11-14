package company.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "expenditures")
public class Expenditure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Hidden
	private int id;

	@Column(name = "catcode")
	private String catCode;

	@Column(name = "deptcode")
	private String deptCode;

	@Column(name = "amount")
	@PositiveOrZero(message = "Amount must be a positive number or zero")
	private double amount;

	@Column(name = "expdate")
	@PastOrPresent(message = "Expenditure date must be in the past or the present")
	private LocalDate expdate;

	@Column(name = "authorizedby")
	@NotBlank(message = "Authorized by is required")
	@Size(max = 50, message = "Authorized by must not exceed 50 characters")
	private String authorizedBy;

	@Column(name = "description")
	@Size(max = 50, message = "Description must not exceed 50 characters")
	private String description;

	@Column(name = "paymentmodecode")
	private String paymentmodecode;

	@Column(name = "remarks")
	@Size(max = 50, message = "Remarks must not exceed 50 characters")
	private String remarks;

	@ManyToOne
	@JoinColumn(name = "catcode", insertable = false, updatable = false)
	@JsonIgnore
	private Category category;

	@ManyToOne
	@JoinColumn(name = "paymentmodecode", insertable = false, updatable = false)
	@JsonIgnore
	private PaymentMode payment;

	@ManyToOne
	@JoinColumn(name = "deptcode", insertable = false, updatable = false)
	@JsonIgnore
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PaymentMode getPayment() {
		return payment;
	}

	public void setPayment(PaymentMode payment) {
		this.payment = payment;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public LocalDate getExpdate() {
		return expdate;
	}

	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}

	public String getPaymentmodecode() {
		return paymentmodecode;
	}

	public void setPaymentmodecode(String paymentmodecode) {
		this.paymentmodecode = paymentmodecode;
	}

}