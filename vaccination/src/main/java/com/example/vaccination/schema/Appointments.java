package com.example.vaccination.schema;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import javax.persistence.*;
@Entity
public class Appointments {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String aid;
    private Date fromTime;
    private Date toTime;
    @OneToOne(targetEntity = Users.class)
    private String userId;
    @OneToOne(targetEntity = Vaccines.class)
    private String vaccineId;
    @OneToOne(targetEntity = Clinics.class)
    private String clinicId;
    private boolean isCheckedIn;

    public Appointments(String aid, Date fromTime, Date toTime, String userId, String vaccineId, String clinicId, boolean isCheckedIn) {
        this.aid = aid;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.userId = userId;
        this.vaccineId = vaccineId;
        this.clinicId = clinicId;
        this.isCheckedIn = isCheckedIn;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

}