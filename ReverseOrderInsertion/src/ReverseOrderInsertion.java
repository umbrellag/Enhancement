/**
 * Reverse-order Insertion (逆序插入)
 * @version 1.0
 * Description (描述):
 * 1. insert the specific number of new random integers between 1 and 100 into an array
 *    添加指定数量的新随机数(1-100)到数组中
 * 2. the array remains in reverse order after each insertion
 *    插入随机数后，数组仍保持逆序
 * 3. first find the correct index of the new integer, then insert, instead of inserting before sorting
 *    先定位再插入，不是先插入再整体排序
 */

import java.util.Scanner;

/*  class ArrayExpansion involves the method used to expand arrays.
    ArrayExpansion类包含用于扩容数组的方法
    Let srcArray be the array that will be expanded, destArray be the result array.
    srcArray是将被扩容的数组，destArray是扩容后得到的数组
 */
class ArrayExpansion{
    // set the size of the expansion (设置扩容大小)
    public int expansionSize = 1;
    // expansion (扩容)
    public int[] intArrayExpansion(int[] srcArray){
        int[] destArray = new int[srcArray.length + expansionSize];
        //copy the elements in srcArray[] into destArray[] (复制原数组的元素到目的数组中)
        System.arraycopy(srcArray, 0, destArray, 0, srcArray.length);

        return destArray;
    }
}

/*  implement the reverse-order insertion
    在数组array中执行逆序插入
 */
public class ReverseOrderInsertion {
    public static int[] array;  // array[] to be inserted

    public static void Insertion(){
        //use tempArray to record the original value of array[] (用数组tempArray记录原来的值)
        int[] tempArray = new int[array.length];
        System.arraycopy(array, 0, tempArray, 0, array.length);

        int randomNum = (int)(Math.random() * 100) + 1; // generate a random number: randomNum
        int index = -1; // index of the new random number (index表示新随机数的下标)

        // determine the index's value (定位，确定新随机数在数组中的下标，即确定index的值)
        int i = 0;  // i denotes the index of array[]
        for(; i <= array.length; i++){
            if(array[i] <= randomNum){  //找到数组中第一个比新随机数小的数，把它的位置让给新随机数
                index = i;
                break;
            }
        }

        //insertion (插入新随机数)
        i = 0;
        int j = 0;  //j denotes the index of tempArray[]
        do{
            if(i != index){
                array[i] = tempArray[j];    //copy the original elements in order (按序复制原来的元素)
                j++;
            }else {
                array[i] = randomNum;   //insert
            }
            i++;
        }while(i < array.length);
    }

    public static void main(String[] args){
        //the value of variable "firstTime" indicates whether this is the first time to run
        // 第一次运行需要创建数组，其后只需要扩展数组
        boolean firstTime = true;
        ArrayExpansion arrayExpansion = new ArrayExpansion();
        char userContinue;  //record user's choice (记录用户的选择)

        do {
            System.out.println("Enter the number of random numbers to be added (请输入要添加的随机数的个数): ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            //if it is the first time to run, create the array, if not, expand the array
            if(firstTime){
                array =new int[number];
            }else{
                arrayExpansion.expansionSize = number;
                array = arrayExpansion.intArrayExpansion(array);
            }
            for(; number > 0; number--){
                ReverseOrderInsertion.Insertion();
            }
            firstTime = false;

            // print all elements in the array[] (打印数组array中的所有元素)
            for (int k : array) {
                System.out.print(k + " ");
            }

            // user chooses whether to continue or not (用户选择是否继续添加)
            System.out.print("\nPress N to end, otherwise continue (按N结束，否则继续): ");
            userContinue = scanner.next().charAt(0);
        }while (userContinue != 'n' && userContinue != 'N');    //如果用户不选择结束，则继续执行逆序插入循环

        // ending (结束提示)
        System.out.println("Welcome to use next time! (欢迎下次使用)");
    }
}
