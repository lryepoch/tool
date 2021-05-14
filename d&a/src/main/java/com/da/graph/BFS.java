package com.da.graph;

public class BFS {
	// 用来存储顶点的数组
	private Vertex vertexList[];
	// 用邻接矩阵来存储 边,数组元素0表示没有边界，1表示有边界
	private int adjMat[][];
	// 表示顶点的个数
	private final int MAX_VERTS = 20;
	// 顶点个数
	private int nVerts;
	// 用队列实现广度优先搜索
	private Queue queue;

	/**
	 * 顶点类
	 * 
	 * @author vae
	 */
	class Vertex {
		public char label;
		public boolean wasVisited;

		public Vertex(char label) {
			this.label = label;
			//wasVisited = false;
		}
	}
	// 对邻接矩阵初始化，都为零。
	public BFS() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		// 初始化顶点个数为0
		nVerts = 0;
		// 初始化邻接矩阵所有元素都为0，即所有顶点都没有边
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		queue = new Queue();
	}

	// 将顶点添加到数组中，是否访问标志置为wasVisited=false(未访问)
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	// 注意用邻接矩阵表示边，是对称的，两部分都要赋值
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	// 打印某个顶点表示的值
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	// 找到与某一顶点邻接且未被访问的顶点
	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < nVerts; i++) {
			// v顶点与i顶点相邻（邻接矩阵值为1）且未被访问 wasVisited==false
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 广度优先搜索算法：
	 * 1、用remove()方法检查栈顶的顶点 
	 * 2、试图找到这个顶点还未访问的邻节点 
	 * 3、 如果没有找到，该顶点出列 
	 * 4、如果找到这样的顶点，访问这个顶点，并把它放入队列中
	 */
	public void breadthFirstSearch() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.insert(0);
		int v2;

		while (!queue.isEmpty()) {
			int v1 = queue.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				queue.insert(v2);
			}
		}

		// 搜索完毕，初始化，以便于下次搜索
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}

	public static void main(String[] args) {
		BFS graph = new BFS();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');

		graph.addEdge(0, 1);// AB
		graph.addEdge(1, 2);// BC
		graph.addEdge(0, 3);// AD
		graph.addEdge(3, 4);// DE

		graph.breadthFirstSearch();// ABDCE
	}
}
