package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Graph {

    int V, E;
    Vertex[] vertices;

    public Graph(int v, int e, Vertex[] vertices) {
        V = v;
        E = e;
        this.vertices = vertices;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    /**
     *
     * Format:
     * V E --> V nodes, E edges
     * x y --> for node n of V, starts at n=0
     * f t --> E edges from node f to node t
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

            // for positioned vertices...
            Vertex[] vertices = new Vertex[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()); // WTF
                vertices[i] = new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // realizing that things will be smoother with LinkedList instead of plain reference to next vertice...
            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine()); // WTF
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                Edge edge = new Edge(vertices[from], vertices[to]);
                vertices[from].getEdges().add(edge);
                vertices[to].getEdges().add(edge);
            }

            graph = new Graph(N, V, vertices);


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
