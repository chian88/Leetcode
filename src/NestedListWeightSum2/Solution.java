package NestedListWeightSum2;
import java.util.*;

interface NestedInteger {
     // Constructor initializes an empty nested list.
     //public NestedInteger();

     // Constructor initializes a single integer.
     //public NestedInteger(int value);

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }


class Solution {
	public int depthSumInverse(List<NestedInteger> nestedList) {

		int maxDepth = 1;
		for (NestedInteger ni : nestedList) {
			maxDepth = Math.max(maxDepth, findMaxDepth(ni, 1));
		}

		int sum = 0;
		for (NestedInteger ni : nestedList) {
			sum += getSumList(ni, 1, maxDepth);
		}

		return sum;
	}


	private int findMaxDepth(NestedInteger ni, int depth) {
		if (ni.isInteger()) {
			return depth;
		} else {
			int maxDepth = depth;
			for (NestedInteger child : ni.getList()) {
				maxDepth = Math.max(maxDepth, findMaxDepth(child, depth + 1));
			}

			return maxDepth;
		}


	}

	private int getSumList(NestedInteger ni, int depth, int maxDepth) {

		if (ni.isInteger()) {
			int weight = maxDepth - depth + 1;

			return ni.getInteger() * weight;
		} else {
			int sum = 0;
			for (NestedInteger child : ni.getList()) {
				sum += getSumList(child, depth + 1, maxDepth);
			}

			return sum;
		}
	}
}