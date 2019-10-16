package JW.pojo;

public class TClasses {
	private String id;

	private String classname;

	private String specialtyId;

	private TSpecialty tSpecialty;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TSpecialty gettSpecialty() {
		return tSpecialty;
	}

	public void settSpecialty(TSpecialty tSpecialty) {
		this.tSpecialty = tSpecialty;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname == null ? null : classname.trim();
	}

	public String getSpecialtyId() {
		return specialtyId;
	}

	public void setSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId == null ? null : specialtyId.trim();
	}
}