package com.practice.general;

import java.util.Scanner;

public class MarksEvaluator {

    /**
     * This program takes inputs of a key and answer line for given number of questions.
     * Each Question has 5 Options. One of which is correct.
     *  The answer line for each question contains either X or O. X= marked answer, O= unselected answer.
     *  The Sample Input is:
     *
     *  5 - Number of Questions
     *  ADBCE - The Key for all questions
     *  OXOOO
     *  OOXOO
     *  OXOOO
     *  OOXOO
     *  OOOOX
     *
     *  The result should be in % of correct answers.
     * @param args
     */
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), ccnt=0;
        if(scanner.hasNextLine()) { scanner.nextLine(); }
        String k = scanner.nextLine();
        for(int i = 0; i < N; i++) {
            String answerLine = scanner.nextLine();
            if(answerLine.indexOf('X') >= 0 && answerLine.indexOf('X', answerLine.indexOf('X')+1) < 0) {
                int idx = answerLine.indexOf('X');
                switch(idx) {
                    case 4: if(k.charAt(i) == 'E' || k.charAt(i) == 'e') {ccnt++;} break;
                    case 3: if(k.charAt(i) == 'D' || k.charAt(i) == 'd') {ccnt++;} break;
                    case 2: if(k.charAt(i) == 'C' || k.charAt(i) == 'c') {ccnt++;} break;
                    case 1: if(k.charAt(i) == 'B' || k.charAt(i) == 'b') {ccnt++;} break;
                    case 0: if(k.charAt(i) == 'A' || k.charAt(i) == 'a') {ccnt++;} break;
                }
            }
        }

        System.out.println((1.0*ccnt)/(N*1.0)*100);
    }
}
