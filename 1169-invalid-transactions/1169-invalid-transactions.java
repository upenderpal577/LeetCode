import java.util.*;

class Solution {

    public List<String> invalidTransactions(String[] transactions) {

        int n = transactions.length;

        String[][] data = new String[n][4];
        boolean[] invalid = new boolean[n];

        // Step 1: Split every transaction
        for (int i = 0; i < n; i++) {

            data[i] = transactions[i].split(",");

            int amount = Integer.parseInt(data[i][2]);

            // Rule 1: amount > 1000
            if (amount > 1000) {
                invalid[i] = true;
            }
        }

        // Step 2: Compare every pair
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                String name1 = data[i][0];
                String name2 = data[j][0];

                int time1 = Integer.parseInt(data[i][1]);
                int time2 = Integer.parseInt(data[j][1]);

                String city1 = data[i][3];
                String city2 = data[j][3];

                if (name1.equals(name2)
                        && Math.abs(time1 - time2) <= 60
                        && !city1.equals(city2)) {

                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        // Step 3: Add invalid transactions to result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (invalid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }
}