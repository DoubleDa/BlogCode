package com.dyx.rvap.callback;

import android.support.v7.util.DiffUtil;

import com.dyx.rvap.model.Person;

import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public class PersonDiffCallback extends DiffUtil.Callback {
    private List<Person> mOldPersonLists;
    private List<Person> mNewPersonLists;

    public PersonDiffCallback(List<Person> mOldPersonLists, List<Person> mNewPersonLists) {
        this.mOldPersonLists = mOldPersonLists;
        this.mNewPersonLists = mNewPersonLists;
    }

    @Override
    public int getOldListSize() {
        return mOldPersonLists.size();
    }

    @Override
    public int getNewListSize() {
        return mNewPersonLists.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldPersonLists.get(oldItemPosition).getName().equals(mNewPersonLists.get(newItemPosition).getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Person oldPerson = mOldPersonLists.get(oldItemPosition);
        Person newPerson = mNewPersonLists.get(newItemPosition);
        if (oldPerson.getName().equals(newPerson.getName()) && oldPerson.getAge() == newPerson.getAge() && oldPerson.isOnline() == newPerson.isOnline()) {
            return true;
        }
        return false;
    }
}
