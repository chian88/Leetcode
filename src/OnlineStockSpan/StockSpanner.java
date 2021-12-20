package OnlineStockSpan;

import java.util.*;

class Stock {
	int price;
	int count;

	Stock(int price, int count) {
		this.price = price;
		this.count = count;
	}
}

class StockSpanner {
	ArrayDeque<Stock> stack;
	public StockSpanner() {
		this.stack = new ArrayDeque<>();

	}

	public int next(int price) {
		if (stack.isEmpty()) {
			stack.addFirst(new Stock(price, 1));
			return 1;
		} else {
			int res = 1;

			while (!stack.isEmpty() && stack.peekFirst().price <= price) {
				res += stack.removeFirst().count;
			}

			stack.addFirst(new Stock(price, res));
			return res;
		}
	}

	public static void main(String[] args) {
		StockSpanner test = new StockSpanner();

		test.next(100);
		test.next(80);
		test.next(60);
		test.next(70);
		test.next(60);
		test.next(75);
		test.next(85);

	}
}
