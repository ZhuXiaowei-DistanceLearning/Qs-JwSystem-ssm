package JW.pojo;

import java.util.List;

public class TSpecialty {
	private String id;

	private String name;

	private String collegeId;

	private String status = "0";

	private TCollege college;

	public TCollege getCollege() {
		return college;
	}

	public void setCollege(TCollege college) {
		this.college = college;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId == null ? null : collegeId.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
}