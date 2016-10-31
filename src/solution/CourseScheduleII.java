package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		return findOrderBFS(numCourses, prerequisites);
	}
	
	public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
		int res[] = new int[numCourses];
		if (prerequisites.length == 0) {
			while(--numCourses >= 0)
				res[numCourses] = numCourses;
			return res;
		}
		List<Integer> adj[] = new LinkedList[numCourses];
		int nodeCount[] = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<>();
		for (int i = 0; i < prerequisites.length; i++) {
			adj[prerequisites[i][0]].add(prerequisites[i][1]);
			nodeCount[prerequisites[i][1]]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < numCourses; i++)
			if (nodeCount[i] == 0)
				que.add(i);
		
		int countVisited = 0;
		while(!que.isEmpty()) {
			int current = que.poll();
			if (countVisited == numCourses)
				return new int[0];
			res[numCourses - 1 - countVisited] = current;
			countVisited++;
			
			for (int i = 0; i < adj[current].size(); i++) {
				if (--nodeCount[adj[current].get(i)] == 0)
					que.add(adj[current].get(i));
			}
		}
		
		if (countVisited != numCourses)
			return new int[0];
		
        return res;
    }
	
	// DFS
	private int[] res;
	private int count = 0;
	public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
		res = new int[numCourses];
		if (prerequisites.length == 0) {
			while(--numCourses >= 0)
				res[numCourses] = numCourses;
			return res;
		}
		List<Integer> adj[] = new LinkedList[numCourses];
		int nodeMark[] = new int[numCourses]; // 0 - not visited; 1 - tmp; 2 - visited
		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<>();
		for (int i = 0; i < prerequisites.length; i++) {
			adj[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		
		for(int i = 0; i < numCourses; i++) {
			if (nodeMark[i] != 0) continue;
			if (!visit(adj, i, nodeMark))
				return new int[0];
		}
		
		return res;
	}
	
	private boolean visit(final List<Integer> adj[], int current, int nodeMark[]) {
		if (nodeMark[current] == 1) return false;
		if (nodeMark[current] == 2) return true;
		if (nodeMark[current] == 0) {
			nodeMark[current] = 1;
			for(int i = 0; i < adj[current].size(); i++) {
				if (!visit(adj, adj[current].get(i), nodeMark))
					return false;
			}
		}
		
		nodeMark[current] = 2;
		res[count++] = current;
		return true;
	}
}
