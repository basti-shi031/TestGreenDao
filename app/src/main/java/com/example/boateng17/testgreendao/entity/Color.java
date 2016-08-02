package com.example.boateng17.testgreendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import cn.com.workshop7.factory.greendao.gen.DaoSession;
import cn.com.workshop7.factory.greendao.gen.ColorDao;
import cn.com.workshop7.factory.greendao.gen.CarDao;

/**
 * Created by Boateng17 on 2016/7/31.
 */
@Entity
public class Color {
    @Id
    private Long id;
    private int R;
    private int G;
    private int B;
    @ToOne
    private Car car;
    @Generated(hash = 491657048)
    private transient boolean car__refreshed;
    /** Used for active entity operations. */
    @Generated(hash = 1245647170)
    private transient ColorDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    public int getB() {
        return this.B;
    }
    public void setB(int B) {
        this.B = B;
    }
    public int getG() {
        return this.G;
    }
    public void setG(int G) {
        this.G = G;
    }
    public int getR() {
        return this.R;
    }
    public void setR(int R) {
        this.R = R;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
    @Generated(hash = 57480138)
    public void setCar(Car car) {
        synchronized (this) {
            this.car = car;
            car__refreshed = true;
        }
    }
    /** To-one relationship, returned entity is not refreshed and may carry only the PK property. */
    @Generated(hash = 1890744614)
    public Car peakCar() {
        return car;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 819551933)
    public Car getCar() {
        if (car != null || !car__refreshed) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CarDao targetDao = daoSession.getCarDao();
            targetDao.refresh(car);
            car__refreshed = true;
        }
        return car;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1758980682)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getColorDao() : null;
    }
    @Generated(hash = 458734565)
    public Color(Long id, int R, int G, int B) {
        this.id = id;
        this.R = R;
        this.G = G;
        this.B = B;
    }
    @Generated(hash = 1499471665)
    public Color() {
    }


}
