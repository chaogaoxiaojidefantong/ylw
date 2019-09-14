import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class GoApp {
    public static void main(String[] args) {
        int []c={3,4,8,5,2,7,10,9};
        quickSort(c,0,7);
            //regTest("759646095@qq.com");
    }

    public static void quickSort(int a[], int l, int r) {
        if (l >= r)
            return;

        int i = l;
        int j = r;
        int key = a[l];//选择第一个数为key

        while (i < j) {

            while (i < j && a[j] >= key)//从右向左找第一个小于key的值
                j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < key)//从左向右找第一个大于key的值
                i++;

            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        //i == j
        a[i] = key;
        quickSort(a, l, i - 1);//递归调用
        quickSort(a, i + 1, r);//递归调用
    }


    public  static  Boolean regTest(String val){
        //String reg="/^[1]([3-9])[0-9]{9}$/";
        String reg2="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Boolean res=val.matches(reg2);
        return  res;
    }
}
