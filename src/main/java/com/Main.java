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

        WiseSaying wiseSaying = null;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                if (wiseSaying == null) continue; //nullpointException 상황을 방지하기 위해 continue 사용

                System.out.println("%d / %s / %s".formatted(
                        wiseSaying.id,
                        wiseSaying.content,
                        wiseSaying.author
                ));
            }

            else if (cmd.equals("등록")) {
                System.out.println("명언: ");
                String wiseSayingContent = scanner.nextLine().trim();
                System.out.println("작가: ");
                String wiseSayingAuthor = scanner.nextLine().trim();

                int id = ++lastId;

                wiseSaying = new WiseSaying();
                wiseSaying.id = id;
                wiseSaying.content = wiseSayingContent;
                wiseSaying.author = wiseSayingAuthor;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            }
        }
        scanner.close();
    }
    }


