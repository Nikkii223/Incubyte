public class GSpacecraft {
    private int x;
    private int y;
    private int z;
    private char direction; 
    private char prevDir;

    public GSpacecraft(int x, int y, int z, char direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void commands(char command) {
        switch (command) {
            case 'f':
                moveForward();
                break;
            case 'b':
                moveBackward();
                break;
            case 'l':
                turnLeft();
                break;
            case 'r':
                turnRight();
                break;
            case 'u':
                turnUp();
                break;
            case 'd':
                turnDown();
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
            case 'U':
                z++;
                break;
            case 'D':
                z--;
                break;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case 'N':
                y--;
                break;
            case 'S':
                y++;
                break;
            case 'E':
                x--;
                break;
            case 'W':
                x++;
                break;
            case 'U':
                z--;
                break;
            case 'D':
                z++;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;

            case 'U':
            direction = prevDir;
            turnLeft();
            break;

            case 'D':
            direction = prevDir;
            turnLeft();
            break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;

            case 'U':
            direction = prevDir;
            turnRight();
            break;

            case 'D':
            direction = prevDir;
            turnRight();
            break;
        
        }
    }

    private void turnUp() {
          prevDir = direction;
        if (direction != 'U') {
            direction = 'U';
        }
    }

    private void turnDown() {
        prevDir = direction;
        if (direction != 'D') {
            direction = 'D';
        }
    }

    public String getPosition() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public char getDirection() {
        return direction;
    }

    public static void main(String[] args) {
        GSpacecraft spacecraft = new GSpacecraft(0, 0, 0, 'N');
        char[] commands = {'f', 'r', 'u', 'b', 'l'};

        for (char command : commands) {
            spacecraft.commands(command);
            System.out.println(command + " - Position: " + spacecraft.getPosition() + " - Direction: " + spacecraft.getDirection());
        }
        System.out.println("Final position : " +spacecraft.getPosition());
        System.out.println("Final Direction: " +spacecraft.getDirection());
    }
}
