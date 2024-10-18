package com.kreitek.editor;

import java.util.ArrayList;

public class CareTaker {
    private ArrayList<Memento> mementoArrayList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoArrayList.add(state);
    }

    public Memento remove() {
        if (!mementoArrayList.isEmpty()) {
            return mementoArrayList.remove(mementoArrayList.size()-1);
        }
        return null;
    }
}
