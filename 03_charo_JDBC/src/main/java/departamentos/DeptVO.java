package departamentos;

public class DeptVO {
	int deptNO;
	String dname;
	String loc;

	public DeptVO() {
		super();
	}

	public DeptVO(int deptNO, String dname, String loc) {
		super();
		this.deptNO = deptNO;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptNO() {
		return deptNO;
	}

	public void setDeptNO(int deptNO) {
		this.deptNO = deptNO;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNO;
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
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
		DeptVO other = (DeptVO) obj;
		if (deptNO != other.deptNO)
			return false;
		if (dname == null) {
			if (other.dname != null)
				return false;
		} else if (!dname.equals(other.dname))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeptVO [deptNO=" + deptNO + ", dname=" + dname + ", loc=" + loc + "]";
	}

}
