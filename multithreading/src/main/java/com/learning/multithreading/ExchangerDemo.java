package com.learning.multithreading;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    static void main() {
        Exchanger<String> exc = new Exchanger<>();
        new Thread(new MakeString(exc)).start();
        new Thread(new UseString(exc)).start();
    }
    static class MakeString implements Runnable {
        Exchanger<String> exc;
        String str;
        MakeString(Exchanger<String> exc) {
            this.exc = exc;
            str = new String();
        }
        public void run() {
            char ch = 'A';
            for(int i=0; i<3; i++) {
                for(int j=0; j<5; j++)
                    str+=ch++;
                try {
                    str = exc.exchange(str);
                } catch(InterruptedException exc) {
                    System.out.println(exc);
                }
            }
        }
    }
    static class UseString implements Runnable {
        Exchanger<String> exc;
        String str;
        UseString(Exchanger<String> exc) {
            this.exc = exc;
        }
        public void run() {
            for(int i=0; i<3; i++) {
                try {
                    str = exc.exchange(new String());
                    System.out.println("GOT: "+str);
                } catch(InterruptedException exc) {
                    System.out.println(exc);
                }
            }
        }
    }
}
