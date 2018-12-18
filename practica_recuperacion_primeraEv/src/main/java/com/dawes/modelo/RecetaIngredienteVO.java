package com.dawes.modelo;

import javax.persistence.*;

@Entity
@Table(name="recetaingredientes")
public class RecetaIngredienteVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrecetaingrediente;
	private float cantidad;
	
	@ManyToOne
	@JoinColumn(name="idreceta")
	private RecetaVO rec;
	
	@ManyToOne
	@JoinColumn(name="idingrediente")
	private IngredienteVO ing;

	public RecetaIngredienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecetaIngredienteVO(float cantidad, RecetaVO rec, IngredienteVO ing) {
		super();
		this.cantidad = cantidad;
		this.rec = rec;
		this.ing = ing;
	}

	public RecetaIngredienteVO(int idrecetaingrediente, float cantidad, RecetaVO rec, IngredienteVO ing) {
		super();
		this.idrecetaingrediente = idrecetaingrediente;
		this.cantidad = cantidad;
		this.rec = rec;
		this.ing = ing;
	}

	public int getIdrecetaingrediente() {
		return idrecetaingrediente;
	}

	public float getCantidad() {
		return cantidad;
	}

	public RecetaVO getRec() {
		return rec;
	}

	public IngredienteVO getIng() {
		return ing;
	}

	public void setIdrecetaingrediente(int idrecetaingrediente) {
		this.idrecetaingrediente = idrecetaingrediente;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public void setRec(RecetaVO rec) {
		this.rec = rec;
	}

	public void setIng(IngredienteVO ing) {
		this.ing = ing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cantidad);
		result = prime * result + idrecetaingrediente;
		result = prime * result + ((ing == null) ? 0 : ing.hashCode());
		result = prime * result + ((rec == null) ? 0 : rec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecetaIngredienteVO other = (RecetaIngredienteVO) obj;
		if (Float.floatToIntBits(cantidad) != Float.floatToIntBits(other.cantidad))
			return false;
		if (idrecetaingrediente != other.idrecetaingrediente)
			return false;
		if (ing == null) {
			if (other.ing != null)
				return false;
		} else if (!ing.equals(other.ing))
			return false;
		if (rec == null) {
			if (other.rec != null)
				return false;
		} else if (!rec.equals(other.rec))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecetaIngredienteVO [idrecetaingrediente=" + idrecetaingrediente + ", cantidad=" + cantidad + ", rec="
				+ rec + ", ing=" + ing + "]";
	}
	
	
}
