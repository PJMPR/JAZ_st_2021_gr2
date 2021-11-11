package org.example.caching;

public class CacheItem<T> {
    String dataSet;
    T data;

    public CacheItem(String dataSet, T data) {
        this.dataSet = dataSet;
        this.data = data;
    }

    public String getDataSet() {
        return dataSet;
    }

    public T getData() {
        return data;
    }
}
