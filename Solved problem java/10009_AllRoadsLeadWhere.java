import java.util.*;

/**
 * Created by Anton on 2017-10-27.
 */
public class AllRoadsLeadWhere {
    static Scanner scan;
    static boolean running;
    static HashMap<String, ArrayList<Road>> adjaList;
    static HashMap<String, Integer> distMap;
    static HashMap<String, City> prevMap;
    static int roads, queries;

    static class Query{
        String from;
        String to;

        public Query(String from, String to){
            this.from = from;
            this.to = to;
        }
    }

    static class Road{
        String from;
        String to;
        Road prev;

        public Road(String from, String to){
            this.from = from;
            this.to = to;
            this.prev = null;
        }

    }

    static class City{
        City prev;
        String name;

        public City(String name){
            this.name = name;
            this.prev = null;
        }

        @Override
        public String toString(){
            return prev.name;
        }


    }

    public static void main(String[] args){
        scan = new Scanner(System.in);
        int i = 0, testcases = Integer.parseInt(scan.nextLine());
        while(i < testcases){
            scan.nextLine(); // Blank Line
            roadsLeadWhere();
            if(i != testcases - 1)
                System.out.println("");
            i++;
        }
    }

    static void roadsLeadWhere() {
        adjaList = new HashMap<>();
        distMap = new HashMap<>();
        prevMap = new HashMap<>();
        int temp[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        roads = temp[0];
        queries = temp[1];
        Query[] queryArr = new Query[queries];



        for (int i = 0; i < roads; i++) {

            String cityConnection[] = scan.nextLine().split(" ");
            if (adjaList.get(cityConnection[0]) == null) {
                adjaList.put(cityConnection[0], new ArrayList<>());
            }

            if (adjaList.get(cityConnection[1]) == null) {
                adjaList.put(cityConnection[1], new ArrayList<>());
            }
            Road t = new Road(cityConnection[0], cityConnection[1]);
            Road t2 = new Road(cityConnection[1], cityConnection[0]);
            adjaList.get(cityConnection[0]).add(t);
            adjaList.get(cityConnection[1]).add(t2);
        }

        for (int i = 0; i < queries; i++) {
            String[] connection = scan.nextLine().split(" ");
            queryArr[i] = new Query(connection[0], connection[1]);
        }

        for (int i = 0; i < queryArr.length; i++) {
            bfs(queryArr[i].from, queryArr[i].to);
            City targetCity = prevMap.get(queryArr[i].to);
            String path =  "" + targetCity.name.charAt(0);
            while(targetCity.prev != null){
                path += "" + targetCity.prev.name.charAt(0);
                targetCity = targetCity.prev;
            }
            System.out.println(new StringBuilder(path).reverse().toString());
        }


    }



    static void bfs(String startNode, String stopNode){
        adjaList.keySet().forEach((key) -> {
            distMap.put(key, Integer.MAX_VALUE);
            prevMap.put(key, new City(key));
        });

        boolean notFound = true;


        Queue queue = new LinkedList();
        queue.add(startNode);
        distMap.put(startNode, 0);

        while(!queue.isEmpty() && notFound){
            String city = (String) queue.remove();
            int dist = distMap.get(city);

            ArrayList<Road> neighbours = adjaList.get(city);
            for (int i = 0; i < neighbours.size(); i++) {
                Road neighbour = neighbours.get(i);
                if(distMap.get(neighbour.to) == Integer.MAX_VALUE){
                    distMap.put(neighbour.to, dist + 1);
                    City c = prevMap.get(neighbour.to);
                    c.prev = prevMap.get(city);
                    if(neighbour.to.equals(stopNode)){
                        notFound = false;
                        break;
                    }
                    queue.add(neighbour.to);

                }

            }

        }


    }


}
