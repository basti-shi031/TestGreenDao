package com.example.boateng17.testgreendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import cn.com.workshop7.factory.greendao.gen.DaoSession;
import cn.com.workshop7.factory.greendao.gen.CarDao;
import cn.com.workshop7.factory.greendao.gen.ColorDao;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Boateng17 on 2016/7/31.
 */
@Entity
public class Car {

    @Id
    private Long id;
    private String name;
    private long colorId;

    @ToOne(joinProperty = "colorId")
    private Color color;

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

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1707584682)
    public void setColor(@NotNull Color color) {
        if (color == null) {
            throw new DaoException(
                    "To-one property 'colorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.color = color;
            colorId = color.getId();
            color__resolvedKey = colorId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1353942434)
    public Color getColor() {
        long __key = this.colorId;
        if (color__resolvedKey == null || !color__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ColorDao targetDao = daoSession.getColorDao();
            Color colorNew = targetDao.load(__key);
            synchronized (this) {
                color = colorNew;
                color__resolvedKey = __key;
            }
        }
        return color;
    }

    @Generated(hash = 2062663027)
    private transient Long color__resolvedKey;

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 679603784)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCarDao() : null;
    }

    /** Used for active entity operations. */
    @Generated(hash = 709963916)
    private transient CarDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public long getColorId() {
        return this.colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 583558927)
    public Car(Long id, String name, long colorId) {
        this.id = id;
        this.name = name;
        this.colorId = colorId;
    }

    @Generated(hash = 625572433)
    public Car() {
    }
}
