package org.example;


import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1316">https://acm.timus.ru/problem.aspx?space=1&num=1316</a>
     */
    public Double getProfit(List<String> actionList) {
        Treap<Double> bids = new Treap<>();
        double totalProfit = 0.0;

        for (String action : actionList) {
            String[] parts = action.split(" ");
            String command = parts[0];

            switch (command) {
                case "BID":
                    bids.add(Double.valueOf(parts[1]));
                    break;

                case "SALE":
                    double saleAmount = Double.parseDouble(parts[1]);
                    int quantity = Integer.parseInt(parts[2]);
                    totalProfit += bids.getProfit(quantity, saleAmount);
                    break;

                case "DEL":
                    bids.remove(Double.valueOf(parts[1]));
                    break;
            }
        }
        return totalProfit;
    }


    /**
     * <h1>Задание 2.</h1>
     * Решить задачу <br/>
     * <a href="https://informatics.msk.ru/mod/statements/view.php?id=1974&chapterid=2782#1">https://informatics.msk.ru/mod/statements/view.php?id=1974&chapterid=2782#1</a><br/>
     */
    public List<Integer> getLeaveOrder(List<String> actionList) {
        Treap<Integer> treap = new Treap<>();
        List<Integer> order = new ArrayList<>();
        int result = 0;
        for (String action : actionList) {
            String[] parts = action.split(" ");
            String command = parts[0];
            switch (command) {
                case "+": {
                    double value = (result + Integer.parseInt(parts[1])) % Math.pow(10, 9);
                    treap.add((int) value);
                    result = 0;
                    break;
                }
                case "?": {
                    result = treap.next(Integer.parseInt(parts[1]), -1);
                    order.add(result);
                    break;
                }
            }
        }
        return order;
    }

}
