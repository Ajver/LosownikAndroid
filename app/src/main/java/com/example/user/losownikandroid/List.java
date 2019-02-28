package com.example.user.losownikandroid;

public class List {

    private int[] tab;

    // size of tab
    private int size = 0;

    public List() {}

    public void add(int a) {
        int[] tempTab = new int[size + 1];

        // Copping tab
        for (int i = 0; i < size; i++)
            tempTab[i] = tab[i];

        // Pushing undefinding digit to tab (on the last place)
        tempTab[size] = a;

        // Updating tab
        tab = tempTab;
        size++;
    }

    public boolean remove(int a) {
        for(int i=0; i<size; i++) {
            if(tab[i] == a) {
                int[] tempTab = tab;
                tab = new int[size-1];

                int counter = 0;

                for(int j=0; j<size; j++) {
                    if(j != i) {
                        tab[counter] = tempTab[j];
                        counter++;
                    }
                }

                size--;

                return true;
            }
        }

        return false;
    }

    public void sort() {

    }

    public int get(int i) {
        if(i >= 0 && i < size)
            return tab[i];

        return -999999;
    }

    public int size() {
        return size;
    }

    public boolean findIn(int a) {
        for(int i=0; i<size; i++) {
            if(tab[i] == a)
                return true;
        }

        return false;
    }
}
