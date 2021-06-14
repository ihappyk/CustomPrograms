import java.util.Arrays;

public class ExtraElement
{
    public static void main(String args[]) {
        int a[] = {1,2,4,5,6};
        int b[] = {1,2,3,4,5,6};
    System.out.println(findExtraElement(a,b));
    }

    public static int findExtraElement(int a[], int b[]) {
        int SumA = Arrays.stream(a).sum();
        int SumB = Arrays.stream(b).sum();
        return Math.abs(SumA-SumB);
    }

//    public static int findExtraElement(int a[], int b[]) {
//        int sum = 0;
//
//    }
}
