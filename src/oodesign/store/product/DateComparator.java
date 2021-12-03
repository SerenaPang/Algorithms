package oodesign.store.product;

import java.util.Comparator;

/**
 * comparator class to compare thr dates to help determine which date should be returned
 * for saerch by date
 * */
public class DateComparator implements Comparator<Date> {

    @Override
    public int compare(Date o1, Date o2) {
        if (o1.month < o2.month) {
            return -1;
        } else if (o1.month > o2.month){
            return 1;
        }
        return 0;
    }
}
