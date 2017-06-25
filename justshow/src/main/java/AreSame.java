import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhangxuan on 16/11/3.
 */
public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (null==a||null==b) return false;
        if (b.length==0) return true;
        if (a.length==0) return false;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i<a.length;i++){
            res.add(a[i]*a[i]);
        }
        for (int bi:b){
            if (!res.contains(bi)) return false;
        }
        return true;
    }

    public static boolean comp1(final int[] a, final int[] b) {
        return a != null && b != null && a.length == b.length && Arrays.equals(Arrays.stream(a).map(i -> i * i).sorted().toArray(), Arrays.stream(b).sorted().toArray());
    }

    public static boolean comp2(int[] a, int[] b) {
        if (a == null || b == null || (a.length == 0 && b.length > 0)) {
            return false;
        }

        return Arrays.stream(b)
                .filter(i -> Arrays.stream(a)
                        .anyMatch(j -> (j * j) == i))
                .count() == a.length;
    }
}
