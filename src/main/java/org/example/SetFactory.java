package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetFactory {

    static final  String NO_SORTING = "none";
    static final  String DEFAULT_SORT = "sort";
    static final  String ALTERNATIVE_SORT = "alt";

    public static Set<Mage> createSet(String sortingType)
    {
        Set<Mage> mags;
        if (sortingType.equals(DEFAULT_SORT)) {
            mags = new TreeSet<Mage>();
        }
        else if(sortingType.equals(ALTERNATIVE_SORT)) {
            mags = new TreeSet<Mage>(new LevelCompare());
        }
        else {
            mags = new HashSet<Mage>();
        }

        return mags;
    }
}
