package com.hiephuynh.testpundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Range;

import java.util.Random;

public class ClickButton {
    public static int randomNumber(int a){
        Intent myintent = new Intent();
        Random rd = new Random();
        int ranNum = rd.nextInt(a);
        return ranNum;
        Bundle mybundle = new Bundle();


    }
}
