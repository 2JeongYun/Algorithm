package this_is_coding_test.ch13;

import java.util.ArrayList;

import java.util.*;

class MovingBlock {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static final int HORIZON = 0;
    static final int VERTICAL = 1;

    public Location location = new Location(0, 0);

    public int solution(int[][] board) {
        int[][] map = new int[board.length + 2][board.length + 2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == 0 || j == 0 || i == map.length - 1 || j == map.length - 1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = board[i - 1][j - 1];
                }
            }
        }

        Queue<Robot> que = new LinkedList<>();
        Robot robot = new Robot(new Location(1, 1), new Location(2, 1), 0);
        que.add(robot);

        Location end = new Location(board.length, board.length);

        boolean[][][] visit = new boolean[map.length][map.length][2];

        while (que.isEmpty() == false && robot.isArrive(end) == false) {
            robot = que.poll();
            Location base = robot.getBase();
            visit[base.y][base.x][robot.getAxis()] = true;

            for (int d = 0; d < dx.length; d++) {
                Location dl = new Location(dx[d], dy[d]);

                Robot tempBot = robot.getMovedBot(map, visit, dl);
                if (tempBot != null) {
                    que.add(tempBot);
                }
            }

            for (int r = 0; r < 4; r++) {
                Robot tempBot = robot.getRotatedBot(map, visit, r);
                if (tempBot != null) {
                    que.add(tempBot);
                }
            }
        }

        return robot.time;
    }

    class Robot {
        Location part1;
        Location part2;
        int time;

        Robot (Location part1, Location part2, int time) {
            this.part1 = part1;
            this.part2 = part2;
            this.time = time;
        }

        public boolean isArrive(Location end) {
            return (part1.isEqual(end) || part2.isEqual(end));
        }

        public Robot getMovedBot(int[][] map, boolean[][][] visit, Location dl) {
            Location movedPart1 = location.getAdd(part1, dl);
            Location movedPart2 = location.getAdd(part2, dl);

            if (canExist(map, visit, movedPart1, movedPart2)) {
                return new Robot(movedPart1, movedPart2, time + 1);
            }

            return null;
        }

        public Robot getRotatedBot(int[][] map, boolean[][][] visit, int rotate) {
            Location rotatedPart1 = null;
            Location rotatedPart2 = null;
            if (location.getAxis(part1, part2) == HORIZON) {
                switch (rotate) {
                    case 0:
                        rotatedPart1 = part1;
                        rotatedPart2 = new Location(part1.y + 1, part1.x);
                        break;
                    case 1:
                        rotatedPart1 = part1;
                        rotatedPart2 = new Location(part1.y - 1, part1.x);
                        break;
                    case 2:
                        rotatedPart1 = new Location(part2.y + 1, part2.x);
                        rotatedPart2 = part2;
                        break;
                    case 3:
                        rotatedPart1 = new Location(part2.y - 1, part2.x);
                        rotatedPart2 = part2;
                        break;
                }
            } else {
                switch (rotate) {
                    case 0:
                        rotatedPart1 = part1;
                        rotatedPart2 = new Location(part1.y, part1.x + 1);
                        break;
                    case 1:
                        rotatedPart1 = part1;
                        rotatedPart2 = new Location(part1.y, part1.x - 1);
                        break;
                    case 2:
                        rotatedPart1 = new Location(part2.y, part2.x + 1);
                        rotatedPart2 = part2;
                        break;
                    case 3:
                        rotatedPart1 = new Location(part2.y, part2.x - 1);
                        rotatedPart2 = part2;
                        break;
                }
            }

            Location diagonal;
            if (rotatedPart1.isEqual(part1)) {
                Location sum = location.getAdd(part2, rotatedPart2);
                diagonal = new Location(sum.x - part1.x, sum.y - part1.y);
            } else {
                Location sum = location.getAdd(part1, rotatedPart1);
                diagonal = new Location(sum.x - part2.x, sum.y - part2.y);
            }

            System.out.printf("%d %d\n", diagonal.y, diagonal.x);
            if (canExist(map, visit, rotatedPart1, rotatedPart2) && map[diagonal.y][diagonal.x] == 0) {
                return new Robot(rotatedPart1, rotatedPart2, time + 1);
            }
            return null;
        }

        private boolean canExist(int[][] map, boolean[][][] visit, Location part1, Location part2) {
            if (map[part1.y][part1.x] == 0 && map[part2.y][part2.x] == 0) {
                Location base = location.getBase(part1, part2);
                if (!visit[base.y][base.x][location.getAxis(part1, part2)]) {
                    return true;
                }
            }
            return false;
        }

        public Location getBase() {
            return location.getBase(part1, part2);
        }

        public int getAxis() {
            return location.getAxis(part1, part2);
        }
    }

    class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Location getAdd(Location a, Location b) {
            return new Location(a.x + b.x, a.y + b.y);
        }

        public Location getBase(Location a, Location b) {
            return (a.x < b.x || a.y < b.y) ? a : b;
        }

        public int getAxis(Location a, Location b) {
            return (a.y == b.y) ? HORIZON : VERTICAL;
        }

        public boolean isEqual(Location other) {
            return (x == other.x && y == other.y);
        }
    }
}
