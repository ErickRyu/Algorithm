package Algospot;

public class BoardCover_2017_10_27 {
    static char[][] board;
    static int yLen, xLen;
    static int[][][] coverType = {
            {{0, 0}, {1, 0}, {1, -1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {1, 0}}
    };
    public static void main(String[] args) {
//        String[] lines = {
//                "#.....#",
//                "#.....#",
//                "##...##"
//        };

        String[] lines = {
                "#.....#",
                "#.....#",
                "##..###"
        };
        BoardCover_2017_10_27 bc = new BoardCover_2017_10_27();
        int ret = bc.solution(3, 7, lines);
        System.out.println(ret);
    }
    public int solution(int y, int x, String[] lines){
        yLen = y;
        xLen = x;
        board = new char[yLen][xLen];
        for(int i = 0; i < y; i++){
            board[i] = lines[i].toCharArray();
        }
        return  cover();
    }


    public int cover(){
        int y = -1, x = -1;
        boolean full = true;
        outer:
        for(int i = 0; i < yLen; i++){
            for(int j = 0; j < xLen; j++){
                if(board[i][j] == '.'){
                    y = i;
                    x = j;
                    full = false;
                    break outer;
                }
            }
        }
        if(full) return 1;

        int ret = 0;

        for(int type = 0; type < 4; type++){
            boolean ok = true;
            for(int i = 0; i < 3; i++){
                int nextY = y + coverType[type][i][0];
                int nextX = x + coverType[type][i][1];
                if(board[nextY][nextX] == '#'){
                    ok = false;
                    break;
                }
            }
            if(ok){
                board[y][x] = '#';
                for(int i = 0; i < 3; i++){
                    int nextY = y + coverType[type][i][0];
                    int nextX = x + coverType[type][i][1];
                    board[nextY][nextX] = '#';
                }
                ret += cover();

                board[y][x] = '.';
                for(int i = 0; i < 3; i++){
                    int nextY = y + coverType[type][i][0];
                    int nextX = x + coverType[type][i][1];
                    board[nextY][nextX] = '.';
                }
            }

        }



        return ret;
    }
}
