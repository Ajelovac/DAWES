package com.dawes.ejercicio1;

public class Racional {
	
	private Integer num;
	private Integer den;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getDen() {
		return den;
	}
	public void setDen(Integer den) {
		this.den = den;
	}
	public Racional(Integer num, Integer den) {
		super();
		this.num = num;
		this.den = den;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((den == null) ? 0 : den.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
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
		Racional other = (Racional) obj;
		if (den == null) {
			if (other.den != null)
				return false;
		} else if (!den.equals(other.den))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	

}
