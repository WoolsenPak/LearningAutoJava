import java.util.Random;
import java.util.Scanner;

    /**
     * Created by Aleksandr Gladkov [Anticisco]
     * Date: 07.02.2025
     */

    public class HomeWork4 {

        public static Random random = new Random();
        public static Scanner scanner = new Scanner(System.in);

        public static final int moveUp = 8;
        public static final int moveLeft = 4;
        public static final int moveRight = 6;
        public static final int moveDown = 2;

        public static char[][] map;
        public static int mapWidth;
        public static int mapHeight;
        public static int minSizeMap = 3;
        public static int maxSizeMap = 6;
        public static char emptyCell = '_';
        public static char exitCell = '0';
        public static boolean isFoundExit = false;

        public static char player = '@';
        public static int playerPower = 10;
        public static int playerHealth = 100;
        public static int playerX;
        public static int playerY;

        public static char healthPack = '♥';
        public static int healthPackValue = 30;

        public static char enemy = 'E';
        public static int enemyHealth;
        public static int enemyPower;
        public static int enemyMinValue = 20;
        public static int enemyMaxValue = 50;
        public static int enemyCount;

        public static void main(String[] args) {
            createMap();
            createPlayer();
            createHealthPack();
            createEnemies();
            createExit();
            printMap();

            while (true) {
                directionPlayer();
                printMap();

                if (playerHealth <= 0) {
                    System.out.println("Player Loss!");
                    break;
                }
                if (isFoundExit) {
                    System.out.println("Player Win");
                    break;
                }
            }

            System.out.println("Game Over");

        }

        public static void directionPlayer() {
            int currentX = playerX;
            int currentY = playerY;
            int playerChooseMove;

            do {
                System.out.printf("Enter move: UP-%s, LEFT-%s, RIGHT-%s, DOWN-%s > ",
                        moveUp, moveLeft, moveRight, moveDown);
                playerChooseMove = scanner.nextInt();

                switch (playerChooseMove) {
                    case moveUp: {
                        playerY -= 1;
                        break;
                    }
                    case moveLeft: {
                        playerX -= 1;
                        break;
                    }
                    case moveRight: {
                        playerX += 1;
                        break;
                    }
                    case moveDown: {
                        playerY += 1;
                        break;
                    }
                    default: {
                        System.out.println("Wrong direction!");
                        map[playerX][playerY] = player;
                    }
                }
            } while (!isValidMove(currentX, currentY, playerX, playerY));

            playerNextMoveAction(currentX, currentY, playerX, playerY);
        }

        public static void playerNextMoveAction(int currentX, int currentY, int nextX, int nextY) {
            if(map[nextY][nextX] == healthPack) {
                playerHealth += healthPackValue;
                System.out.printf("Player HP +%s. Now hp is %s\n", healthPackValue, playerHealth);
            }
            if (map[nextY][nextX] == enemy) {
                playerHealth -= enemyPower;
                System.out.printf("Warning! Player HP -%s. Now hp is %s\n", enemyPower, playerHealth);
            }
            if (map[nextY][nextX] == exitCell) {
                isFoundExit = true;
                System.out.println("Player found exit!");
            }

            map[playerY][playerX] = player;
            map[currentY][currentX] = emptyCell;
        }

        public static boolean isValidMove(int currentX, int currentY, int nextX, int nextY) {
            if (nextY >= 0 && nextY < mapHeight && nextX >= 0 && nextX < mapWidth) {
                return true;
            }
            System.out.println("Sorry, your move is incorrect");
            playerX = currentX;
            playerY = currentY;
            return false;
        }

        public static void createMap() {
            mapWidth = getRandomValue(minSizeMap, maxSizeMap);
            mapHeight = getRandomValue(minSizeMap, maxSizeMap);
            map = new char[mapHeight][mapWidth];

            for (int i = 0; i < mapHeight; i++) {
                for (int j = 0; j < mapWidth; j++) {
                    map[i][j] = emptyCell;
                }
            }
//        System.out.println("Map created. Size " + mapHeight + "x" + mapWidth);
            System.out.printf("Map created. Size %sx%s\n", mapHeight, mapWidth);
        }

        public static void createPlayer() {
            playerX = getRandomValue(0, mapWidth - 1);
            playerY = getRandomValue(0, mapHeight - 1);
            map[playerY][playerX] = player;
            System.out.printf("Player spawn in [%s;%s]\n", playerY, playerX);
        }

        public static void createHealthPack() {
            int x;
            int y;
            int count = getRandomValue(1, (maxSizeMap + minSizeMap) / 4);

            for (int i = 0; i < count; i++) {
                do {
                    x = random.nextInt(mapWidth);
                    y = random.nextInt(mapHeight);
                } while (!isEmptyCell(y, x));
                map[y][x] = healthPack;
            }
            System.out.printf("HealthPacks spawn. Count: %s \n", count);
        }

        public static void createEnemies() {
            int x;
            int y;
            enemyHealth = getRandomValue(enemyMinValue, enemyMaxValue);
            enemyPower = getRandomValue(enemyMinValue, enemyMaxValue);
            enemyCount = getRandomValue(1, (maxSizeMap + minSizeMap) / 4);

            for (int i = 0; i < enemyCount; i++) {
                do {
                    x = random.nextInt(mapWidth);
                    y = random.nextInt(mapHeight);
                } while (!isEmptyCell(y, x));
                map[y][x] = enemy;
            }
            System.out.printf("Enemies spawn. Count: %s. Health: %s. Power: %s \n",
                    enemyCount,
                    enemyHealth,
                    enemyPower);
        }

        public static void createExit() {
            isFoundExit = false;
            int x;
            int y;
            do {
                x = random.nextInt(mapWidth);
                y = random.nextInt(mapHeight);
            } while (!isEmptyCell(y, x));
            map[y][x] = exitCell;
            System.out.println("Exit spawn");
        }

        public static boolean isEmptyCell(int y, int x) {
            return map[y][x] == emptyCell;
        }

        public static void printMap() {
            System.out.println("========== MAP ==========");
            for (int i = 0; i < mapHeight; i++) {
                for (int j = 0; j < mapWidth; j++) {
                    // System.out.print(map[i][j] + "|");
                    if (i == playerY && j == playerX) {
                        System.out.print(player + "|");
                    } else {
                        System.out.print(emptyCell + "|");
                    }
                }
                System.out.println();
            }
            System.out.println("=========================");
        }

        public static int getRandomValue(int minBound, int maxBound) {
            return random.nextInt(maxBound - minBound + 1) + minBound;
        }


    }

/*
1) Разобратся с кодом, как работает и как идут вызовы методов
2) Решить проблему в default метода directionPlayer - пользователь исчезает, если ввести некорректное передвижение
3)** скрыть все сущности с глаз пользователя, кроме Player.
4) Вопросы по домашке писать или в чат или в отдельный файл, прикрепить к репозиторию
 */


