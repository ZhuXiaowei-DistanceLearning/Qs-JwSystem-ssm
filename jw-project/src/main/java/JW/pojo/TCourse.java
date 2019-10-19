package JW.pojo;

import java.util.List;

public class TCourse {
    private String id;

    private String name;

    private Integer credit;

    private String classroom;

    private Integer people = 0;

    private String sectionId;

    private String weekId;

    private String teacherId;

    private String natureId;

    private Integer totalpeople;

    private String teamId;

    private Integer totalTime;

    private Integer point;

    private String wayId;

    private String cstatusId;

    private String status;

    private Integer isexam;

    private String collegeId;

    private TSection section;

    private TWeek week;

    private TNature nature;

    private TTeacher teacher;

    private List<TStudent> student;

    private TCollege college;

    private TExamway examway;
    private TCstatus cstatus;
    private TTeam team;

    public TExamway getExamway() {
        return examway;
    }

    public void setExamway(TExamway examway) {
        this.examway = examway;
    }

    public TCstatus getCstatus() {
        return cstatus;
    }

    public void setCstatus(TCstatus cstatus) {
        this.cstatus = cstatus;
    }

    public TTeam getTeam() {
        return team;
    }

    public void setTeam(TTeam team) {
        this.team = team;
    }

    public TCollege getCollege() {
        return college;
    }

    public void setCollege(TCollege college) {
        this.college = college;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getWayId() {
        return wayId;
    }

    public void setWayId(String wayId) {
        this.wayId = wayId;
    }

    public String getCstatusId() {
        return cstatusId;
    }

    public void setCstatusId(String cstatusId) {
        this.cstatusId = cstatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsexam() {
        return isexam;
    }

    public void setIsexam(Integer isexam) {
        this.isexam = isexam;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getWeekAnsection() {
        return section.getSectionTime() + "{" + week.getTime() + "}";
    }

    public String getShowpeople() {
        return people + "/" + totalpeople;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId == null ? null : sectionId.trim();
    }

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId == null ? null : weekId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getNatureId() {
        return natureId;
    }

    public void setNatureId(String natureId) {
        this.natureId = natureId == null ? null : natureId.trim();
    }

    public Integer getTotalpeople() {
        return totalpeople;
    }

    public void setTotalpeople(Integer totalpeople) {
        this.totalpeople = totalpeople;
    }

    public TSection getSection() {
        return section;
    }

    public void setSection(TSection section) {
        this.section = section;
    }

    public TWeek getWeek() {
        return week;
    }

    public void setWeek(TWeek week) {
        this.week = week;
    }

    public TNature getNature() {
        return nature;
    }

    public void setNature(TNature nature) {
        this.nature = nature;
    }

    public TTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(TTeacher teacher) {
        this.teacher = teacher;
    }

    public List<TStudent> getStudent() {
        return student;
    }

    public void setStudent(List<TStudent> student) {
        this.student = student;
    }

}