package com.lv.admin;

import com.umeng.commonsdk.debug.D;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 345 QQ:1831712732
 * @name Demo
 * @package com.lv.library_core
 * @time 2020/11/10 20:37
 * @description
 */
public class Demo {


    int num = 1;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        Demo demo = new Demo();
        demo.sss(list, 0, (list.size() - 1));
    }

    void sss(List<Integer> list, int start, int end) {
        int temp = (start + end) / 2;
        if (list.get(temp) == num) {
            System.out.println("下标：" + temp + " 值：" + list.get(temp));
        } else {
            if (num > list.get(temp)) {
                sss(list, temp + 1, end);
            } else if (num < list.get(temp)) {
                sss(list, start, temp + 1);
            }
        }
    }
}
