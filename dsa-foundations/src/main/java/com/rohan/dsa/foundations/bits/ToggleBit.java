package com.rohan.dsa.foundations.bits;

public class ToggleBit {
    public int toggle(int bitPattern, int index) {
        int mask = 1 << index;
        if ((bitPattern & mask) == 0) {
            bitPattern |= mask;
        } else {
            bitPattern &= ~mask;
        }
        return bitPattern;
    }
}
