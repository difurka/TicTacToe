package tictactoe;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * подготавливаем массив
         */

        char[] s1 = new char[10];
        Arrays.fill(s1, 0, 9, '-');

        char[] s2 =  new char[5];
        Arrays.fill(s2, 0, 4, ' ');
        s2[0] = '|';
        s2[4] = '|';

        char[] s3 =  new char[5];
        Arrays.fill(s3, 0, 4, ' ');
        s3[0] = '|';
        s3[4] = '|';

        char[] s4 =  new char[5];
        Arrays.fill(s4, 0, 4, ' ');
        s4[0] = '|';
        s4[4] = '|';

        char[][] arr = {s2, s3, s4};

        /**
         * рисуем массив
         */
        for (char j : s1) {
            System.out.print(j);
        }
        System.out.println("");

        for (char[] eachRow : arr) {
            for (char j : eachRow) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        for (char j : s1) {
            System.out.print(j);
        }
        System.out.println("");

        boolean flagEmpty = false;
        boolean choise = true;
        boolean flagEnd = false;
        while (!flagEnd) {
            System.out.println("Enter the coordinates:");

            try {

                int n1 = scanner.nextInt();
                int n2 = scanner.nextInt();
                if (n1 > 3 || n1 < 0 || n2 > 3 || n2 < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (arr[n1 - 1][n2] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    arr[n1 - 1][n2] = choise ? 'X' : 'O';
                    choise = !choise;

                    /**
                     * рисуем массив
                     */
                    for (char j : s1) {
                        System.out.print(j);
                    }
                    System.out.println("");

                    for (char[] eachRow : arr) {
                        for (char j : eachRow) {
                            System.out.print(j + " ");
                        }
                        System.out.println("");
                    }
                    for (char j : s1) {
                        System.out.print(j);
                    }
                    System.out.println("");


                    /**
                     * по диагонали Х или О
                     */

                    if (arr[0][1] == arr[1][2] && arr [1][2] == arr[2][3] && arr[2][3] == 'X' || arr[0][3] == arr[1][2] && arr [1][2] == arr[2][1] && arr[2][1] == 'X' ) {
                        System.out.println("X wins");
                        flagEnd = true;
                    }
                    if (arr[0][1] == arr[1][2] && arr [1][2] == arr[2][3] && arr[2][3] == 'O' || arr[0][3] == arr[1][2] && arr [1][2] == arr[2][1] && arr[2][1] == 'O') {
                        System.out.println("O wins");
                        flagEnd = true;
                    }

                    /**
                     * один столбец Х
                     */

                    for (int i = 1; i<=3; i++) {
                        if ( arr[0][i] == arr[1][i] && arr [1][i] == arr[2][i] && arr[2][i] == 'X') {
                            System.out.println("X wins");
                            flagEnd = true;
                            break;
                        }
                    }

                    /**
                     * один столбец  О
                     */
                    for (int i = 1; i<=3; i++) {
                        if (arr[0][i] == arr[1][i] && arr [1][i] == arr[2][i] && arr[2][i] == 'O') {
                            System.out.println("O wins");
                            flagEnd = true;
                            break;
                        }
                    }

                    /**
                     * одна строка Х
                     */
                    for (int i = 0; i<=2; i++) {
                        if ( arr[i][1] == arr[i][2] && arr [i][2] == arr[i][3] && arr[i][3] == 'X') {
                            System.out.println("X wins");
                            flagEnd = true;
                            break;
                        }
                    }

                    /**
                     * одна строка О
                     */
                    for (int i = 0; i<=2; i++) {
                        if (arr[i][1] == arr[i][2] && arr [i][2] == arr[i][3] && arr[i][3] == 'O') {
                            System.out.println("O wins");
                            flagEnd = true;
                            break;
                        }
                    }

                    /**
                     * игра не закончена
                     */
                    flagEmpty = false;
                    for (int i = 0; i<=2; i++) {
                        for (int j = 1; j <= 3; j++) {
                                if (!flagEnd && arr[i][j] == ' ') {
                                flagEmpty = true;
                                break;
                            }
                        }
                        if (flagEmpty) {
                            break;
                        }
                    }
                    if (!flagEmpty && !flagEnd) {
                        System.out.println("Draw");
                        flagEnd = true;
                    }
                }


            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}