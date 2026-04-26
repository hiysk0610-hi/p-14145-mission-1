package com;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

         int lastId = 0;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.println("명언: ");
                String wiseSayingContent = scanner.nextLine().trim();
                System.out.println("작가: ");
                String wiseSayingAuthor = scanner.nextLine().trim();

                int id = ++lastId;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            } //%d : 디지털 , .formatted(id) : 괄호 안(id)의 값이 %d로 치환되서 문자열 완성
        }
        scanner.close();
    }
    }


