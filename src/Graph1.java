import java.util.*;
class Graph1<T> {
    private Map<T, List<T> > map = new HashMap<>();
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    public void addEdge(T source,
                        T destination,
                        boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == false) {
            map.get(destination).add(source);
        }
    }
    public void getVertexCount()
    {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }


    int out = 0;

    int maxIn = 0;//for determining decision node
    int maxOut = 0;//for determining decision node
    int maxT = 0; //for determining decision node
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        T temp =null;
        HashMap<Integer,Integer> tempNode = new HashMap<>();
        for (T v : map.keySet()) {
            out = 0;
            builder.append(v.toString() + ": "); //adds the current vertex
            for (T w : map.get(v)) {
                builder.append(w.toString() + " "); //adding the connected nodes
                int value = Integer.parseInt(w.toString());
                if (map.containsKey(value)) {
                    tempNode.put(value, tempNode.getOrDefault(value,0) + 1);
                } else {
                    tempNode.put(value, 1);
                }
                out++;
            }

            if(out >= maxOut){
                maxOut = out;
                temp = v;
            }

            System.out.println("the outdegree of " + v + " is " + out);
            builder.append("\n");
        }

        for(Integer key: tempNode.keySet()){
            Integer val = tempNode.get(key);
            System.out.println("in degree of " + key + " is " + val);
            if(val > maxIn){
                maxIn = val;
            }

        }
        maxT = maxOut + maxIn;
        System.out.println("The influential node is " + temp + " with " + maxT + " total combined in and out degrees\n");
        return (builder.toString());
    }


    public List<List<Integer>> getAllPaths(int start, int end) {
        List<List<Integer>> paths = new ArrayList<>();   //Array list for all of the available paths
        List<Integer> currentPath = new ArrayList<>();   //temp list for the current path
        Set<Integer> visited = new HashSet<>();          //for the visited nodes

        dfs(start, end, currentPath, paths, visited);    //calling the DFS to get all the paths

        return paths;
    }
    private void dfs(int current, int end, List<Integer> currentPath, List<List<Integer>> paths, Set<Integer> visited) {
        visited.add(current);               //marking the current node as visited
        currentPath.add(current);           //adding the current node to the temp path list

        if (current == end) {               //checking to see if the current node is our end location
            paths.add(new ArrayList<>(currentPath));    //adding the current path to the list of paths
        } else {
            for (T neighbor : map.getOrDefault(current, Collections.emptyList())) {//getting all neighbors of current node
                if (!visited.contains(neighbor)) {//checking if the current neighbor is in the visited list
                    dfs((Integer) neighbor, end, currentPath, paths, visited);//recalling itself to find the next path
                }
            }
        }

        visited.remove(current);
        currentPath.remove(currentPath.size() - 1);
    }
}