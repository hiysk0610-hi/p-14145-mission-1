package com;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int lastId = 0;
    WiseSaying[] wiseSayings = new WiseSaying[100];
    int wiseSayingLastIndex = -1;

    void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.equals("등록")) {
                actionWrite();
            }
        }
        scanner.close();
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] forListwiseSayings = findForList();

        for (WiseSaying wiseSaying : forListwiseSayings) { //향상된 for 문
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    void actionWrite() {
        System.out.println("명언: ");
        String content = scanner.nextLine().trim();
        System.out.println("작가: ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying = write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));
    }

    int getSize() {
        return wiseSayingLastIndex + 1; //현재 명언이 몇개인지
    }

    WiseSaying[] findForList(){
        WiseSaying[]  forListWiseSaying = new WiseSaying[wiseSayingLastIndex + 1];

        int forListWiseSayingIndex = -1;

        for (int i = wiseSayingLastIndex; i >=0; i--) {
            forListWiseSaying[++forListWiseSayingIndex] = wiseSayings[i];
        }
        return forListWiseSaying;
    }

    WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = ++lastId;
        wiseSaying.content = content;
        wiseSaying.author = author;

        wiseSayings[++wiseSayingLastIndex] = wiseSaying;

        return wiseSaying;
    }
}







