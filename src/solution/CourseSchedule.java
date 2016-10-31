package solution;

import java.util.*;

public class CourseSchedule {
	// DFS or BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		return canFinishBFS(numCourses, prerequisites);
	}
	
	// V = numCourses; E = prerequisites.length
	// Time O(V + E), Space O(V + E)
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0) return true;
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
			countVisited++;
			
			for (int i = 0; i < adj[current].size(); i++) {
				if (--nodeCount[adj[current].get(i)] == 0)
					que.add(adj[current].get(i));
			}
		}
		
		if (countVisited != numCourses)
			return false;
		
        return true;
    }
	
	// Avg & Worst Case Time O(V + E), Space O(V + E)
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0) return true;
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
				return false;
		}
		
		return true;
	}
	
	private boolean visit(final List<Integer> adj[], int current, int nodeMark[]) {
		if (nodeMark[current] == 1) return false;
		if (nodeMark[current] == 0) {
			nodeMark[current] = 1;
			for(int i = 0; i < adj[current].size(); i++) {
				if (!visit(adj, adj[current].get(i), nodeMark))
					return false;
			}
		}
		
		nodeMark[current] = 2;
		return true;
	}
}
