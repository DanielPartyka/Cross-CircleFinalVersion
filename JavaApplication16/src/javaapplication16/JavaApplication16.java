package javaapplication16;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Galan
 */
public class JavaApplication16 {

    final static int row = 3;
    final static int col = 3;
    final static String[][] board = new String[3][3];

    public static void main(String[] args) {
        play();
    }

    //inicjalizujemy pola planszy
    public static void initialize(int row, int col, String[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = " ";
            }
        }
    }

    //rysujemy plansze
    public static void printboard(int row, int col, String[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" | ");
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    //sprawdzczygraczwygral
    public static boolean playercompare(String[][] board) {
        if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) {
            return false;
        } else if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) {
            return false;
        } else if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) {
            return false;
        } else if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) {
            return false;
        } else if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) {
            return false;
        } else if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) {
            return false;
        } else if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            return false;
        } else if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
            return false;
        } else {
            return true;
        }
    }

    //sprawdz czy komputer wygral
    public static boolean computercompare(String[][] board) {
        if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) {
            return false;
        } else if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
            return false;
        } else if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
            return false;
        } else if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) {
            return false;
        } else if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) {
            return false;
        } else if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
            return false;
        } else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            return false;
        } else if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
            return false;
        } else {
            return true;
        }
    }

    //pierwszy ruch komputera ze wzgledu na ruch pierwszy ruch komputera
    public static void firstplayermove(String[][] board) {
        if (board[0][0].equals("X") || board[0][2].equals("X") || board[2][0].equals("X") || board[2][2].equals("X")) {
            board[1][1] = "O";
        } else if (board[1][1].equals("X")) {
            board[2][0] = "O";
        } else if (board[0][1].equals("X")) {
            board[0][0] = "O";
        } else if (board[1][0].equals("X")) {
            board[0][0] = "O";
        } else if (board[2][1].equals("X")) {
            board[2][0] = "O";
        } else if (board[1][2].equals("X")) {
            board[0][2] = "O";
        }
    }

    //atak komputera jezeli gracz popelni blad
    public static boolean AIwygraj(String[][] board) {
        if (board[0][0].equals(" ") && board[0][1].equals("O") && board[0][2].equals("O")) {
            board[0][0] = "O";
            return true;
        } else if (board[0][0].equals("O") && board[0][1].equals(" ") && board[0][2].equals("O")) {
            board[0][1] = "O";
            return true;
        } else if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals(" ")) {
            board[0][2] = "O";
            return true;
        } else if (board[1][0].equals(" ") && board[1][1].equals("O") && board[1][2].equals("O")) {
            board[1][0] = "O";
            return true;
        } else if (board[1][0].equals("O") && board[1][1].equals(" ") && board[1][2].equals("O")) {
            board[1][1] = "O";
            return true;
        } else if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals(" ")) {
            board[1][2] = "O";
            return true;
        } else if (board[2][0].equals(" ") && board[2][1].equals("O") && board[2][2].equals("O")) {
            board[2][0] = "O";
            return true;
        } else if (board[2][0].equals("O") && board[2][1].equals(" ") && board[2][2].equals("O")) {
            board[2][1] = "O";
            return true;
        } else if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals(" ")) {
            board[2][2] = "O";
            return true;
        } else if (board[0][0].equals(" ") && board[1][0].equals("O") && board[2][0].equals("O")) {
            board[0][0] = "O";
            return true;
        } else if (board[0][0].equals("O") && board[1][0].equals(" ") && board[2][0].equals("O")) {
            board[1][0] = "O";
            return true;
        } else if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals(" ")) {
            board[2][0] = "O";
            return true;
        } else if (board[0][1].equals(" ") && board[1][1].equals("O") && board[2][1].equals("O")) {
            board[0][1] = "O";
            return true;
        } else if (board[0][1].equals("O") && board[1][1].equals(" ") && board[2][1].equals("O")) {
            board[1][1] = "O";
            return true;
        } else if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals(" ")) {
            board[2][1] = "O";
            return true;
        } else if (board[0][2].equals(" ") && board[1][2].equals("O") && board[2][2].equals("O")) {
            board[0][2] = "O";
            return true;
        } else if (board[0][2].equals("O") && board[1][2].equals(" ") && board[2][2].equals("O")) {
            board[1][2] = "O";
            return true;
        } else if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals(" ")) {
            board[2][2] = "O";
            return true;
        } else if (board[0][0].equals(" ") && board[1][1].equals("O") && board[2][2].equals("O")) {
            board[0][0] = "O";
            return true;
        } else if (board[0][0].equals("O") && board[1][1].equals(" ") && board[2][2].equals("O")) {
            board[1][1] = "O";
            return true;
        } else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals(" ")) {
            board[2][2] = "O";
            return true;
        } else if (board[2][0].equals(" ") && board[1][1].equals("O") && board[0][2].equals("O")) {
            board[2][0] = "O";
            return true;
        } else if (board[2][0].equals("O") && board[1][1].equals(" ") && board[0][2].equals("O")) {
            board[1][1] = "O";
            return true;
        } else if (board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals(" ")) {
            board[0][2] = "O";
            return true;
        } else {
            return false;
        }
    }

    //obrona przez komputer
    public static void computermove(String[][] board) {

        if (board[0][0].equals(" ") && board[0][1].equals("X") && board[0][2].equals("X")) {
            board[0][0] = "O";
        } else if (board[0][0].equals("X") && board[0][1].equals(" ") && board[0][2].equals("X")) {
            board[0][1] = "O";
        } else if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals(" ")) {
            board[0][2] = "O";
        } else if (board[1][0].equals(" ") && board[1][1].equals("X") && board[1][2].equals("X")) {
            board[1][0] = "O";
        } else if (board[1][0].equals("X") && board[1][1].equals(" ") && board[1][2].equals("X")) {
            board[1][1] = "O";
        } else if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals(" ")) {
            board[1][2] = "O";
        } else if (board[2][0].equals(" ") && board[2][1].equals("X") && board[2][2].equals("X")) {
            board[2][0] = "O";
        } else if (board[2][0].equals("X") && board[2][1].equals(" ") && board[2][2].equals("X")) {
            board[2][1] = "O";
        } else if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals(" ")) {
            board[2][2] = "O";
        } else if (board[0][0].equals(" ") && board[1][0].equals("X") && board[2][0].equals("X")) {
            board[0][0] = "O";
        } else if (board[0][0].equals("X") && board[1][0].equals(" ") && board[2][0].equals("X")) {
            board[1][0] = "O";
        } else if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals(" ")) {
            board[2][0] = "O";
        } else if (board[0][1].equals(" ") && board[1][1].equals("X") && board[2][1].equals("X")) {
            board[0][1] = "O";
        } else if (board[0][1].equals("X") && board[1][1].equals(" ") && board[2][1].equals("X")) {
            board[1][1] = "O";
        } else if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals(" ")) {
            board[2][1] = "O";
        } else if (board[0][2].equals(" ") && board[1][2].equals("X") && board[2][2].equals("X")) {
            board[0][2] = "O";
        } else if (board[0][2].equals("X") && board[1][2].equals(" ") && board[2][2].equals("X")) {
            board[1][2] = "O";
        } else if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals(" ")) {
            board[2][2] = "O";
        } else if (board[0][0].equals(" ") && board[1][1].equals("X") && board[2][2].equals("X")) {
            board[0][0] = "O";
        } else if (board[0][0].equals("X") && board[1][1].equals(" ") && board[2][2].equals("X")) {
            board[1][1] = "O";
        } else if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals(" ")) {
            board[2][2] = "O";
        } else if (board[2][0].equals(" ") && board[1][1].equals("X") && board[0][2].equals("X")) {
            board[2][0] = "O";
        } else if (board[2][0].equals("X") && board[1][1].equals(" ") && board[0][2].equals("X")) {
            board[1][1] = "O";
        } else if (board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals(" ")) {
            board[0][2] = "O";
        } else if (board[1][1] != "X" && board[1][1] != "O") {
            board[1][1] = "O";
        } else if (board[0][0].equals("X") && board[2][1].equals("X")) {
            board[1][0] = "O";
        } else if (board[0][2].equals("X") && board[2][1].equals("X")) {
            board[1][2] = "O";
        } else if (board[2][2].equals("X") && board[0][1].equals("X")) {
            board[1][2] = "O";
        } else if (board[0][2].equals("X") && board[0][1].equals("X")) {
            board[1][0] = "O";
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = "O";
                        break;
                    }
                }
                break;
            }
        }

    }

    //sprawdza czy pole jest wolne
    public static boolean checkiffree(String[][] board, int x, int y) {
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[x][y].equals("X") || board[x][y].equals("O")) {
                    counter++;
                }
            }
        }
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    //sprawdz czy nie ma konca gry
    public static boolean checkifend(String board[][]) {
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j].equals(" ")) {
                    counter++;
                }
            }
        }
        if (counter == 0) {
            return false;
        } else {
            return true;
        }

    }

    //metoda odpowiadajaca za gre
    public static void play() {
        boolean game = true;
        initialize(row, col, board);
        printboard(row, col, board);
        int round = 0;
        while (game == true) {
            System.out.print("Podaj polozenie dla X po : ");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if (checkiffree(board, x, y) == true) {
                        board[x][y] = "X";
                        break;
                    } else {
                        System.out.println("Podano juz takie wspolrzedne");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Zle wspolrzedne");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Podales, zle wspolrzedne, zareks wynosi od 0-2");
                }
            }

            if (round == 0) {
                firstplayermove(board);
            } else if (AIwygraj(board) == false) {
                computermove(board);
            } else {
                AIwygraj(board);
            }
            printboard(row, col, board);
            if (playercompare(board) == false) {
                game = false;
                System.out.println("Gratulacje, wygrales");
            } else if (computercompare(board) == false) {
                game = false;
                System.out.println("Przykro mi, ale komputer wygral");
            } else if (checkifend(board) == false) {
                game = false;
                System.out.println("Koniec gry, remis");
            }
            round++;

        }

    }

}
