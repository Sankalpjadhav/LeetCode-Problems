class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();
                }

                if(!stack.isEmpty()  && stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                    continue;
                }
                else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroids[i]);
                }
            }
        }

        int [] result = new int[stack.size()];

        for(int i=result.length-1;i>=0;i--){
            result[i] = stack.pop();
        }

        return result;
    }
}

/*
Brute force solution:

public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        boolean [] contenders = new boolean[n];
        Arrays.fill(contenders, true);

        for(int i=0;i<n;i++){
            if(asteroids[i] > 0){
                // Skip the asteroids going right
                continue;
            }
            // Asteroids going left
            int currentAsteroid = Math.abs(asteroids[i]);
            boolean willSurvive = true;
            for(int j=i-1;j>=0;j--){
                if(contenders[j] == true && asteroids[j] > 0){
                    // will consider only the contenders that are not destroyed and going right
                    if(currentAsteroid == asteroids[j]){
                        contenders[j] = false;
                        willSurvive = false;
                        break;
                    }
                    else if(currentAsteroid < asteroids[j]){
                        willSurvive = false;
                        break;
                    }
                    else{
                        // currentAsteroid > asteroids[j]
                        contenders[j] = false;
                    }
                }
            }

            if(willSurvive == false){
                contenders[i] = false;
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(contenders[i] == true){
                count++;
            }
        }

        int [] result = new int[count];
        int index = 0;
        for(int i=0;i<n;i++){
            if(contenders[i] == true){
                result[index++] = asteroids[i];
            }
        }

        return result;
    }
*/