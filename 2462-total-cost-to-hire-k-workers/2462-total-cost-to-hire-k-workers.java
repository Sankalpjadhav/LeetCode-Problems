class Solution {
    // cost, index
  static final Comparator<int[]> comparator =
      (a, b) -> {
        int diff = Integer.compare(a[0], b[0]);
        if (diff == 0) {
          return Integer.compare(a[1], b[1]);
        }
        return diff;
      };

  public long totalCost(int[] costs, int k, int candidates) {
    final int n = costs.length;

    long result = 0;
    int start = 0;
    int end = n - 1;

    Queue<int[]> front = new PriorityQueue<>(comparator);
    Queue<int[]> tail = new PriorityQueue<>(comparator);
    for (int i = 0; i < k; i++) {
      while (front.size() < candidates && start <= end) {
        front.offer(new int[] {costs[start], start});
        start++;
      }

      while (tail.size() < candidates && start <= end) {
        tail.offer(new int[] {costs[end], end});
        end--;
      }

      if (front.isEmpty()) {
        result += tail.poll()[0];
        continue;
      }

      if (tail.isEmpty()) {
        result += front.poll()[0];
        continue;
      }

      if (front.peek()[0] > tail.peek()[0]) {
        result += tail.poll()[0];
      } else {
        result += front.poll()[0];
      }
    }

    return result;
  }
}