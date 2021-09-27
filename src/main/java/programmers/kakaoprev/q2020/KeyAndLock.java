package programmers.kakaoprev.q2020;

public class KeyAndLock {

    public boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int mapSize = lockSize * 3;
        int[][] map = new int[mapSize][mapSize];

        for (int y = lockSize; y < 2 * lockSize; y++) {
            for (int x = lockSize; x < 2 * lockSize; x++) {
                map[y][x] = lock[y - lockSize][x - lockSize];
            }
        }

        for (int y = 0; y < mapSize - lockSize; y++) {
            for (int x = 0; x < mapSize - lockSize; x++) {
                if (isMatch(map, key, y, x, lockSize))
                    return true;
            }
        }

        return false;
    }

    private boolean isMatch(int[][] originMap, int[][] key, int y, int x, int lockSize) {
        for (int d = 0; d < 4; d++) {
            key = rotate(key);
            int[][] map = copyMap(originMap);

            if (insertKey(map, key, y, x)) {
                if (isCorrect(map, lockSize))
                    return true;
            }
        }

        return false;
    }

    private boolean isCorrect(int[][] map, int lockSize) {
        for (int y = lockSize; y < 2 * lockSize; y++) {
            for (int x = lockSize; x < 2 * lockSize; x++) {
                if (map[y][x] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean insertKey(int[][] map, int[][] key, int y, int x) {
        for (int dy = 0; dy < key.length; dy++) {
            for (int dx = 0; dx < key.length; dx++) {
                map[dy + y][dx + x] += key[dy][dx];

                if (map[dy + y][dx + x] >= 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] copyMap(int[][] map) {
        int[][] copy = new int[map.length][map.length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    private int[][] rotate(int[][] key) {
        int[][] ret = new int[key.length][key.length];
        for (int y = 0; y < key.length; y++) {
            for (int x = 0; x < key.length; x++) {
                ret[x][key.length - 1 - y] = key[y][x];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        KeyAndLock kl = new KeyAndLock();
        System.out.println(kl.solution(new int[][] {
                {0, 0, 0}, {1, 0, 0}, {0, 1, 1}
        }, new int[][] {
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        }));
    }
}
