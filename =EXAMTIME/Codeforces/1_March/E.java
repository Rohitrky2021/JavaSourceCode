import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class E {

    static class Pokemon {
        int[] attributes;
        int cost;

        public Pokemon(int[] attributes, int cost) {
            this.attributes = attributes;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] costs = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            List<Pokemon> pokemons = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int[] attributes = new int[m];
                for (int j = 0; j < m; j++) {
                    attributes[j] = Integer.parseInt(st.nextToken());
                }
                pokemons.add(new Pokemon(attributes, costs[i]));
            }

            int[] maxAttributes = new int[m];
            for (int i = 0; i < m; i++) {
                maxAttributes[i] = pokemons.get(0).attributes[i];
                for (int j = 1; j < n; j++) {
                    maxAttributes[i] = Math.max(maxAttributes[i], pokemons.get(j).attributes[i]);
                }
            }

            int minCost = Integer.MAX_VALUE;
            for (Pokemon pokemon : pokemons) {
                int cost = pokemon.cost;
                boolean feasible = true;
                for (int i = 0; i < m; i++) {
                    if (pokemon.attributes[i] < maxAttributes[i]) {
                        feasible = false;
                        break;
                    }
                }
                if (feasible) {
                    minCost = Math.min(minCost, cost);
                }
            }

            System.out.println(minCost);
        }
    }
}
