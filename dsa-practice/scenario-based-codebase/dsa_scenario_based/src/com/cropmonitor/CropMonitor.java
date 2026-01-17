package com.cropmonitor;

class CropMonitor {
    private Reading[] data;
    private int count;

    public CropMonitor(int max) {
        data = new Reading[max];
        count = 0;
    }

    public void add(Reading r) {
        if (count < data.length) {
            data[count] = r;
            count++;
        }
    }

    public void quickSort() {
        sort(0, count - 1);
    }

    private void sort(int low, int high) {
        if (low < high) {
            int p = partition(low, high);
            sort(low, p - 1);
            sort(p + 1, high);
        }
    }

    private int partition(int low, int high) {
        Reading pivot = data[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (!data[j].isAfter(pivot)) {
                i++;
                Reading temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        Reading temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1;
    }

    public void print() {
        System.out.println("Sorted by time:");
        for (int i = 0; i < count; i++) {
            data[i].show();
        }
    }
}