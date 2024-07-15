import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class bufferReader {
    // Working program using BufferedReader

// public class Main {
	public static void main(String[] args)
		throws IOException
	{

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
						

		StringTokenizer st= new StringTokenizer(br.readLine());
			              
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int count = 0;
		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (x % k == 0)
				count++;
		}
		System.out.println(count);
		System.out.println(m);

	}
}





