package leetcode.order;

public class LeetCode2502Allocator {

    class Allocator {
        private int n;
        private int[] memory;

        public Allocator(int n) {
            this.n = n;
            this.memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int count = 0;
            for (int i = 0; i < n; ++i) {
                if (memory[i] != 0) {
                    count = 0;
                } else {
                    ++count;
                    if (count == size) {
                        for (int j = i - count + 1; j <= i; ++j) {
                            memory[j] = mID;
                        }
                        return i - count + 1;
                    }
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int count = 0;
            for (int i = 0; i < n; ++i) {
                if (memory[i] == mID) {
                    ++count;
                    memory[i] = 0;
                }
            }
            return count;
        }
    }

}
