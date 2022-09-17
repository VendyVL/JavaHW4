package Sem4;
/*Волновой алгоритм...
 * Вообще выглядит довольно понятно
 */
public class Volny {
    public static int[][] gamefield(int a, int b) {/*Проблема 1 - на листочке в клеточку всё просто, а тут это как показать? */
        int[][] arr = new int[a][b];
        for (int i= 0; i < a; i++) {
            for (int j= 0; j < b; j++){
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    public static int[][] fieldstones(int arr[][]) {/*попробуем поставить препятствия*/
        for (int i= 0; i < (arr.length + arr[0].length)/3; i++) {/*количество камней */
            arr[(int)(Math.random()*arr.length)][(int)(Math.random()*arr[0].length)] = -1;
        }
        return arr;
    }
    static void printArray(int arr[][]){
        for (int i=0; i<arr.length; ++i){
            for (int j=0; j<arr[0].length; ++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(); 
        }
    }
    public static int[][] waveLee(int arr[][], int startA, int startB){
        if (arr[startA+1][startB]==0 && startA+1 < arr.length) arr[startA+1][startB] = 1;
        if (arr[startA][startB+1]==0 && startB+1 < arr[0].length) arr[startA][startB+1] = 1;
        if (arr[startA-1][startB]==0 && startA-1 >= 0) arr[startA-1][startB] = 1;
        if (arr[startA][startB-1]==0 && startB-1 >= 0) arr[startA][startB-1] = 1;/*Это можно бы как-то оптимизировать */
        arr[startA][startB] = -3;/*просто чтобы пометить точку */
        // while (arr[i][j] == 0){
            for(int i=0; i<arr.length-1; ++i){
                for (int j=0; j<arr[0].length-1; ++j){
                    if (arr[i][j] > 0){
                        if (arr[i+1][j]==0 && i+1 < arr.length) arr[i+1][j] = arr[i][j] + 1;
                        if (arr[i][j+1]==0 && j+1 < arr[0].length) arr[i][j+1] = arr[i][j] + 1;
                        if (arr[i-1][j]==0 && i-1 >= 0) arr[i-1][j] = arr[i][j] + 1;
                        if (arr[i][j-1]==0 && j-1 >= 0) arr[i][j-1] = arr[i][j] + 1;
                    }  /*В целом, оно делает то, что нужно, но только в направлении увеличения i и j. 
                    Не могу придумать, как поставить условие, чтобы оно проходило массив пока в нём не кончатся нули */
                }
            }
        // }
        return arr;
    }

    public static void main(String args[])
    {
        int[][] arr = fieldstones(gamefield(10,20));
        // int[][] arr = gamefield(6,8);        
        printArray(arr);
        System.out.println(" ");
        int[][] arr2 = waveLee(arr, 2, 4);
        printArray(arr2);
        int endpoint = arr2[9][15];
        System.out.printf("Требуется %d шагов", endpoint);
    }
}
