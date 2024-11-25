package kr.ac.kopo.ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Proverb {
    private List<String> list = new ArrayList<>();

    public Proverb(String saying) {
        StringTokenizer st = new StringTokenizer(saying);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
    }

    public List<String> getList() {
        return list;
    }
}

class TokenThread extends Thread {
    private Proverb proverb;
    private int index = 0;

    public TokenThread(Proverb proverb) {
        this.proverb = proverb;
    }

    @Override
    public void run() {
        while (true) {
                if (index >= proverb.getList().size()) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " : " + proverb.getList().get(index++));
        }
    }
}

public class ex05 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("속담 입력: ");
        String saying = input.nextLine();

        Proverb proverb = new Proverb(saying);

        TokenThread t1 = new TokenThread(proverb);
        TokenThread t2 = new TokenThread(proverb);

        t1.setName("속담1");
        t2.setName("속다2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
