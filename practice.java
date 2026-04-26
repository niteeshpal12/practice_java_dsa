import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}


class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}


class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}





class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}


class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}



class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}



class MergeLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}




class DetectCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}



class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}







class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}







class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}






class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offer(i);

            if (i >= k - 1) {
                res[idx++] = nums[dq.peek()];
            }
        }
        return res;
    }
}




class MaxDepthTree {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}





class LevelOrder {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}


 

class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}



 

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}



class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}



class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class practice {

    public static void main(String[] args) {

        // ---------- ARRAY ----------
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        System.out.println("Two Sum: " + java.util.Arrays.toString(ts.twoSum(nums, 9)));

        MaxSubarray ms = new MaxSubarray();
        System.out.println("Max Subarray: " + ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        MoveZeroes mz = new MoveZeroes();
        int[] arr = {0,1,0,3,12};
        mz.moveZeroes(arr);
        System.out.println("Move Zeroes: " + java.util.Arrays.toString(arr));

        // ---------- STRING ----------
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println("Palindrome: " + vp.isPalindrome("A man, a plan, a canal: Panama"));

        LongestSubstring ls = new LongestSubstring();
        System.out.println("Longest Substring: " + ls.lengthOfLongestSubstring("abcabcbb"));

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println("LCP: " + lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));

        // ---------- LINKED LIST ----------
        ReverseLinkedList rll = new ReverseLinkedList();
        ReverseLinkedList.ListNode head = rll.new ListNode(1);
        head.next = rll.new ListNode(2);
        head.next.next = rll.new ListNode(3);

        ReverseLinkedList.ListNode rev = rll.reverseList(head);
        System.out.print("Reversed List: ");
        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
        System.out.println();

        // ---------- STACK ----------
        ValidParentheses vp2 = new ValidParentheses();
        System.out.println("Valid Parentheses: " + vp2.isValid("()[]{}"));

        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(2);
        System.out.println("MinStack Min: " + minStack.getMin());

        // ---------- QUEUE ----------
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println("Queue Peek: " + q.peek());

        SlidingWindow sw = new SlidingWindow();
        System.out.println("Sliding Window: " +
                java.util.Arrays.toString(sw.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

        // ---------- TREE ----------
        MaxDepthTree mdt = new MaxDepthTree();
        MaxDepthTree.TreeNode root = mdt.new TreeNode(1);
        root.left = mdt.new TreeNode(2);
        root.right = mdt.new TreeNode(3);

        System.out.println("Tree Depth: " + mdt.maxDepth(root));

        // ---------- HASHMAP ----------
        SubarraySum ss = new SubarraySum();
        System.out.println("Subarray Sum: " + ss.subarraySum(new int[]{1,2,3}, 3));

        GroupAnagrams ga = new GroupAnagrams();
        System.out.println("Group Anagrams: " +
                ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

        // ---------- DP ----------
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println("Climbing Stairs: " + cs.climbStairs(5));

        // ---------- GRAPH ----------
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = {
                {'1','1','0'},
                {'1','0','0'},
                {'0','0','1'}
        };
        System.out.println("Number of Islands: " + noi.numIslands(grid));
    }
}