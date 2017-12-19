package com.bellidov.language;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class VowelKey implements Comparable<VowelKey>{

    private Set<String> uniqueKey = new TreeSet<>();
    private int totalVowelsCount = 0;

    public void add(String key) {
        if(key != null) {
            uniqueKey.add(key);
        }
    }

    public void setTotalVowelsCount(int totalVowelsCount) {
        this.totalVowelsCount = totalVowelsCount;
    }

    public int getTotalVowelsCount() {
        return this.totalVowelsCount;
    }

    @Override
    public int compareTo(VowelKey o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VowelKey)) return false;
        VowelKey vowelKey = (VowelKey) o;
        return Objects.equals(uniqueKey, vowelKey.uniqueKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueKey);
    }

    @Override
    public String toString() {
        return "{" + String.join(", ", uniqueKey) + "}";
    }
}
