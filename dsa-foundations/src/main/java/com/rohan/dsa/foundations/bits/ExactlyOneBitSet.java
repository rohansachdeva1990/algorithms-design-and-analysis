package com.rohan.dsa.foundations.bits;

public class ExactlyOneBitSet {

    public boolean isSet(int bitPattern){
        return (bitPattern & (bitPattern - 1)) == 0;
    }

}
