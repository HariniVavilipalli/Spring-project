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
@Table(name = "paymentmodes")
public class PaymentMode {
	
	@Id
	@NotBlank(message = "Payment mode code is required")
	@Size(max = 10, message = "Payment mode code must not exceed 10 characters")
	@Column(name = "paymentmodecode")
	private String paymentmodecode;

	@Column(name = "paymentname")
	@NotBlank(message = "Payment name is required")
	@Size(max = 50, message = "Payment name must not exceed 50 characters")
	private String paymentname;

	@Column(name = "paymentremarks")
	@Size(max = 50, message = "Payment remarks must not exceed 50 characters")
	private String paymentremarks;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
	@JsonIgnore
	private List<Expenditure> expenditures = new ArrayList<Expenditure>();

	public String getPaymentmodecode() {
		return paymentmodecode;
	}

	public void setPaymentmodecode(String paymentmodecode) {
		this.paymentmodecode = paymentmodecode;
	}

	public String getPaymentname() {
		return paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}

	public String getPaymentremarks() {
		return paymentremarks;
	}

	public void setPaymentremarks(String paymentremarks) {
		this.paymentremarks = paymentremarks;
	}

	public List<Expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<Expenditure> expenditures) {
		this.expenditures = expenditures;
	}

}