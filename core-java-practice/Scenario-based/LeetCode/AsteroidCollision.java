import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
                alive = false;
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision solver = new AsteroidCollision();
        int[] result = solver.asteroidCollision(new int[]{5, 10, -5});
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
