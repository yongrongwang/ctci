package chapter3;

import java.util.ArrayList;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型
 * （猫或狗），并收养该种动物中最早进入收容所的。给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1，
 * 则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收
 * 养方式，若为1，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作
 * 忽略。
 */
public class Question3_7 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 100;
        int[][] ope = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                int number = AsSortedMethods.randomIntInRange(1, n);
                ope[i][0] = 1;
                if (i % 2 == 0) {
                    ope[i][1] = number;
                } else {
                    ope[i][1] = -number;
                }
            } else {
                ope[i][0] = 2;
                if (i % 2 == 0) {
                    ope[i][1] = 1;
                } else {
                    ope[i][1] = -1;
                }
            }
            System.out.print("[" + ope[i][0] + " " + ope[i][1] + "], ");
        }
        System.out.println();
        System.out.println(asylum(ope));
    }

    /**
     * 一个input数组表示有动物进入收容所，一个output数组表示有人收养动物
     * @param ope 操作序列
     * @return 收养动物的数组
     */
    public static ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < ope.length; i++) {
            // 有动物进入收容所
            if (ope[i][0] == 1) {
                input.add(ope[i][1]);
            }
            // 有人收养动物
            if (ope[i][0] == 2) {
                // 第一种收养方式
                if (ope[i][1] == 0) {
                    output.add(input.remove(0));
                }
                // 指定收养狗
                if (ope[i][1] == 1) {
                    for (int j = 0; j < input.size(); j++) {
                        if (input.get(j) > 0) {
                            output.add(input.remove(j));
                            break;
                        }
                    }
                }
                // 指定收养猫
                if (ope[i][1] == -1) {
                    for (int j = 0; j < input.size(); j++) {
                        if (input.get(j) < 0) {
                            output.add(input.remove(j));
                            break;
                        }
                    }
                }
            }
        }
        return output;
    }
}