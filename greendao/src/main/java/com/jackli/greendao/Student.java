package com.jackli.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.jackli.greendao.test.DaoSession;
import com.jackli.greendao.test.CreditCardDao;
import com.jackli.greendao.test.StudentDao;

@Entity
public class Student {
    @Id(autoincrement = true)
    Long id;
    @Unique
    int studentNo;
    int age;
    String telPhone;//手机号
    String sex; //性别
    String name;//姓名
    String address;//家庭住址
    String schoolName;//学校名字
    String grade;//几年级

    @ToMany(referencedJoinProperty="id")
    List<CreditCard> cardList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;

    @Generated(hash = 1071002287)
    public Student(Long id, int studentNo, int age, String telPhone, String sex,
            String name, String address, String schoolName, String grade) {
        this.id = id;
        this.studentNo = studentNo;
        this.age = age;
        this.telPhone = telPhone;
        this.sex = sex;
        this.name = name;
        this.address = address;
        this.schoolName = schoolName;
        this.grade = grade;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStudentNo() {
        return this.studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelPhone() {
        return this.telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 258405486)
    public List<CreditCard> getCardList() {
        if (cardList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CreditCardDao targetDao = daoSession.getCreditCardDao();
            List<CreditCard> cardListNew = targetDao._queryStudent_CardList(id);
            synchronized (this) {
                if (cardList == null) {
                    cardList = cardListNew;
                }
            }
        }
        return cardList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1886690552)
    public synchronized void resetCardList() {
        cardList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNo=" + studentNo +
                ", age=" + age +
                ", telPhone='" + telPhone + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", grade='" + grade + '\'' +
                ", cardList=" + cardList +
                '}';
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
}
