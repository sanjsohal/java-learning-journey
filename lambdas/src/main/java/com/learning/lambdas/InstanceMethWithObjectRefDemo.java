package com.learning.lambdas;

public class InstanceMethWithObjectRefDemo {
    interface MyFunc<T> {
        boolean func(T v1, T v2);
    }
    static <T> int counter(T[] vals, MyFunc<T> func, T val) {
        var count = 0;
        for (T t : vals) {
            if (func.func(t, val)) count++;
        }
        return count;
    }
    static class HighTemp {
        private final int hTemp;
        HighTemp(int hTemp) {
            this.hTemp = hTemp;
        }
        boolean sameTemp(HighTemp highTemp) {
            return hTemp == highTemp.hTemp;
        }
        boolean lessThanTemp(HighTemp highTemp) {
            return hTemp < highTemp.hTemp;
        }
    }
    static void main() {
        int count;
        HighTemp[] weekDayHighs = {  new HighTemp(89), new HighTemp(82),
                                    new HighTemp(90), new HighTemp(89),
                                    new HighTemp(89), new HighTemp(91),
                                    new HighTemp(84), new HighTemp(83) };

        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println(count + " days had a a high of 89");

        HighTemp[] weekDayHighs2 = {    new HighTemp(32), new HighTemp(12),
                                        new HighTemp(24), new HighTemp(19),
                                        new HighTemp(18), new HighTemp(12),
                                        new HighTemp(-1), new HighTemp(13) };

        count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println(count + " days had a high of 12");

        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println(count + " days had a high less than 89");

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println(count + " days had a high of less than 19");

    }
}
