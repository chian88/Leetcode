package NestedIterator;
import java.util.*;
interface NestedInteger {
	public boolean isInteger();
	public Integer getInteger();
	public List<NestedInteger> getList();
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
	List<Integer> result ;
	private int ptr = 0;
	public NestedIterator(List<NestedInteger> nestedList) {
		Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
		List<Integer> result = new ArrayList<>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			NestedInteger item = nestedList.get(i);

			stack.addFirst(item);
		}

		while (!stack.isEmpty()) {
			NestedInteger curr = stack.pollFirst();
			if (curr.isInteger()) {
				result.add(curr.getInteger());
			} else {
				List<NestedInteger> ls = curr.getList();
				for (int i = ls.size() - 1; i >= 0; i--) {
					NestedInteger item = ls.get(i);
					stack.addFirst(item);
				}
			}
		}
		this.result = result;
	}



	@Override
	public Integer next() {
		int res = result.get(ptr);
		this.ptr++;;
		return res;
	}

	@Override
	public boolean hasNext() {
		return ptr < result.size();
	}
}

//public class NestedIterator implements Iterator<Integer> {
//	List<Integer> result ;
//	private int ptr = 0;
//	public NestedIterator(List<NestedInteger> nestedList) {
//		List<Integer> result = new ArrayList<>();
//		for (int i = 0; i < nestedList.size(); i++) {
//			NestedInteger item = nestedList.get(i);
//
//			if (item.isInteger()) {
//				result.add(item.getInteger());
//			} else {
//				nestedIteratorHelper(item, result);
//			}
//		}
//
//		this.result = result;
//	}
//
//	public void nestedIteratorHelper(NestedInteger nestedList, List<Integer> result) {
//		List<NestedInteger> ls = nestedList.getList();
//		for (int i = 0; i < ls.size(); i++) {
//			NestedInteger item = ls.get(i);
//			if (item.isInteger()) {
//				result.add(item.getInteger());
//			} else {
//				nestedIteratorHelper(item, result);
//			}
//		}
//
//	}
//
//	@Override
//	public Integer next() {
//		int res = result.get(ptr);
//		this.ptr++;;
//		return res;
//	}
//
//	@Override
//	public boolean hasNext() {
//		return ptr < result.size();
//	}
//}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */