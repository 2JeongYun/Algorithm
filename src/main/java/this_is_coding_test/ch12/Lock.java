package this_is_coding_test.ch12;

public class Lock {

    public boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int workSize = 2 * key.length - 2 + lock.length;
        int[][] workSpace = new int[workSize][workSize];

        for (int r = 0; r < 4; r++) {
            for (int y = 0; y <= workSize - keySize; y++) {
                for (int x = 0; x <= workSize - keySize; x++) {
                    clearWorkSpace(workSpace, lock, keySize);
                    addKey(workSpace, key, y, x);
                    if (check(workSpace, lock.length, keySize)) {
                        return true;
                    }
                }
            }
            key = rotate(key);
        }

        return false;
    }

    public void clearWorkSpace(int[][] workSpace, int[][] lock, int keySize) {
        for (int y = 0; y < lock.length; y++) {
            for (int x = 0; x < lock.length; x++) {
                workSpace[y + keySize - 1][x + keySize - 1] = lock[y][x];
            }
        }
    }

    public void addKey(int[][] workSpace, int[][] key, int yMove, int xMove) {
        for (int y = 0; y < key.length; y++) {
            for (int x = 0; x < key.length; x++) {
                workSpace[y + yMove][x + xMove] += key[y][x];
            }
        }
    }

    public int[][] rotate(int[][] arr) {
        int size = arr.length;
        int[][] ret = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                ret[y][x] = arr[size - x - 1][y];
            }
        }
        return ret;
    }

    public boolean check(int[][] workSpace, int lockSize, int keySize) {
        for (int y = 0; y < lockSize; y++) {
            for (int x = 0; x < lockSize; x++) {
                if (workSpace[y + keySize - 1][x + keySize - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lock l = new Lock();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(l.solution(key, lock));
    }
}
