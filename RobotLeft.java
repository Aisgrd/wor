public class RobotLeft extends Robot {
    private int direction;
    private int speed;

    /**
     * Constructor for objects of class RobotFlash
     */
    public RobotLeft(String name, int x, int y, WorldOfRobot worldR) {
        super(name, x, y, worldR);
        this.direction = 2; // Initial direction
        this.speed = 1; // Initial speed
        worldR.addRobot(this);
        super.showRobot();
    }

    /**
     * Moves the robot based on the direction and checks for collisions
     */
    @Override
    public void move() {
        int x = getX();
        int y = getY();
        x -= 1; // Move left
        setPosition(x, y);
        
        // Check for collisions with other robots
        if (checkCollision()) {
            jump();
        }
        super.showRobot();
    }

    /**
     * Checks if this robot collides with another robot in the world
     */
    public boolean checkCollision() {
        for (Robot otherRobot : getWorldR().getRobots()) {
            if (!otherRobot.equals(this)) {
                if (this.getX() == otherRobot.getX() && this.getY() == otherRobot.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Makes the robot "jump" when it collides with another robot
     */
    public void jump() {
        System.out.println("Collision detected, the robot jumps!");
        setPosition(getX(), getY() + 10); // Simulate the jump by changing the Y position
    }
}


