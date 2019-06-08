package com.jackli.greendao.test;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jackli.greendao.Student;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT".
*/
public class StudentDao extends AbstractDao<Student, Long> {

    public static final String TABLENAME = "STUDENT";

    /**
     * Properties of entity Student.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StudentNo = new Property(1, int.class, "studentNo", false, "STUDENT_NO");
        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
        public final static Property TelPhone = new Property(3, String.class, "telPhone", false, "TEL_PHONE");
        public final static Property Sex = new Property(4, String.class, "sex", false, "SEX");
        public final static Property Name = new Property(5, String.class, "name", false, "NAME");
        public final static Property Address = new Property(6, String.class, "address", false, "ADDRESS");
        public final static Property SchoolName = new Property(7, String.class, "schoolName", false, "SCHOOL_NAME");
        public final static Property Grade = new Property(8, String.class, "grade", false, "GRADE");
    }

    private DaoSession daoSession;


    public StudentDao(DaoConfig config) {
        super(config);
    }
    
    public StudentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"STUDENT_NO\" INTEGER NOT NULL UNIQUE ," + // 1: studentNo
                "\"AGE\" INTEGER NOT NULL ," + // 2: age
                "\"TEL_PHONE\" TEXT," + // 3: telPhone
                "\"SEX\" TEXT," + // 4: sex
                "\"NAME\" TEXT," + // 5: name
                "\"ADDRESS\" TEXT," + // 6: address
                "\"SCHOOL_NAME\" TEXT," + // 7: schoolName
                "\"GRADE\" TEXT);"); // 8: grade
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getStudentNo());
        stmt.bindLong(3, entity.getAge());
 
        String telPhone = entity.getTelPhone();
        if (telPhone != null) {
            stmt.bindString(4, telPhone);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(5, sex);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
 
        String schoolName = entity.getSchoolName();
        if (schoolName != null) {
            stmt.bindString(8, schoolName);
        }
 
        String grade = entity.getGrade();
        if (grade != null) {
            stmt.bindString(9, grade);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getStudentNo());
        stmt.bindLong(3, entity.getAge());
 
        String telPhone = entity.getTelPhone();
        if (telPhone != null) {
            stmt.bindString(4, telPhone);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(5, sex);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
 
        String schoolName = entity.getSchoolName();
        if (schoolName != null) {
            stmt.bindString(8, schoolName);
        }
 
        String grade = entity.getGrade();
        if (grade != null) {
            stmt.bindString(9, grade);
        }
    }

    @Override
    protected final void attachEntity(Student entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Student readEntity(Cursor cursor, int offset) {
        Student entity = new Student( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // studentNo
            cursor.getInt(offset + 2), // age
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // telPhone
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sex
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // address
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // schoolName
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // grade
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Student entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStudentNo(cursor.getInt(offset + 1));
        entity.setAge(cursor.getInt(offset + 2));
        entity.setTelPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSex(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddress(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSchoolName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setGrade(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Student entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Student entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Student entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
