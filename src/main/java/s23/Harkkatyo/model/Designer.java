package s23.Harkkatyo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Designer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long designerId;
	@NotEmpty(message = "Designer name must be provided")
	@Size( min = 1, max = 200)
	@Column(unique=true, nullable=false)
	private String designerName;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="designer")
	@JsonIgnore
	private List<Perfume> perfumes;
	
	public Designer() {
		
	}
	
	public Designer(String designerName) {
		this.designerName = designerName;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	
	public Long getDesignerId() {
		return this.designerId;
	}
	
	public void setDesignerId(Long designerId) {
		this.designerId = designerId;
	}
	
	public List<Perfume> getPerfumes() {
		return perfumes;
	}
	
	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}
}

