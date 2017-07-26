package com.dyx.aac.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dyx.aac.db.dao.BookDao;
import com.dyx.aac.vo.Book;

/**
 * project name：AndroidArtiCom
 * class describe：
 * create person：dayongxin
 * create time：2017/6/22 下午5:08
 * alter person：dayongxin
 * alter time：2017/6/22 下午5:08
 * alter remark：
 */
@Database(entities = {Book.class}, version = 1)
public abstract class ServerDb extends RoomDatabase {
    abstract public BookDao bookDao();
}
