package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Graph {

    int N, V;
    Node[] nodes;

    public Graph(int n, int v, Node[] nodes) {
        N = n;
        V = v;
        this.nodes = nodes;
    }

    public int getN() {
        return N;
    }

    public int getV() {
        return V;
    }

    public Node[] getNodes() {
        return nodes;
    }

    /**
     *
     * Format:
     * N V --> N nodes, V vertices
     * x y --> for node n of N, starts at n=0
     * f t --> V vertices from node f to node t
     *
     * @param file
     * @return
     */
    public static Graph readFromFile(File file) {

        Graph graph = null;

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            StringTokenizer st = new StringTokenizer(br.readLine()); // entire damn file
            int N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // for positioned nodes...
            Node[] nodes = new Node[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()); // WTF
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // realizing that things will be smoother with LinkedList instead of plain reference to next vertice...
            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine()); // WTF
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                Vertex vertex = new Vertex(nodes[from], nodes[to]);
                nodes[from].getVertices().add(vertex);
                nodes[to].getVertices().add(vertex);
            }

            graph = new Graph(N, V, nodes);


        } catch (IOException | NumberFormatException | NoSuchElementException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException damnSeriousException) {
            System.err.println("what on Earth just happened");
            damnSeriousException.printStackTrace();
            System.err.println("good heavens would you look at the time");
        } catch (NullPointerException npe) {
            System.err.println("Failed to load yer file");
            npe.printStackTrace();
        }

        return graph;

    }

}
