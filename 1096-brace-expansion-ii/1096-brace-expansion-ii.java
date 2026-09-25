class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.add(expression);
        Set<String> result = new HashSet<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            
            if (current.indexOf('{') == -1) {
                result.add(current);
                continue;
            }

          
            int i = 0, left = 0, right = 0;
            while (current.charAt(i) != '}') {
                if (current.charAt(i) == '{') {
                    left = i;
                }
                i++;
            }
            right = i;

            String before = current.substring(0, left);
            String after = current.substring(right + 1);
            String[] parts = current.substring(left + 1, right).split(",");

          
            for (String part : parts) {
                queue.add(before + part + after);
            }
        }

        // Convert the set to a list and sort it alphabetically
        List<String> sortedList = new ArrayList<>(result);
        Collections.sort(sortedList);
        return sortedList;
    }
}