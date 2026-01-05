package com.stackandqueue.stockspanproblem;

class StockSpanProblem {

    static int[] calculateStockSpan(int[] prices) {

        int numberOfDays = prices.length;
        int[] span = new int[numberOfDays];
        IndexStack stack = new IndexStack(numberOfDays);

        // First day span is always 1
        stack.push(0);
        span[0] = 1;

        for (int currentDay = 1; currentDay < numberOfDays; currentDay++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[currentDay]) {
                stack.pop();
            }

            span[currentDay] = stack.isEmpty()
                    ? currentDay + 1
                    : currentDay - stack.peek();

            stack.push(currentDay);
        }
        return span;
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateStockSpan(prices);

        for (int value : span) {
            System.out.print(value + " ");
        }
    }
}
