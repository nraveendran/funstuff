package com.mine;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nidhish on 6/13/15.
 */

/*
4
10 200 3 40000 5

 */
public class FindMthtoLastElement {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("/home/nidhish/otherprojects/funstuff/src/test/java/inputfile.txt"));

        Scanner input = new Scanner(inputStream);



//	    String arraySizeAndInputSizeString = input.nextLine();

        String inputLengthString = input.nextLine();

        int indexToOutput = Integer.parseInt(inputLengthString.trim());


        String[] inputNumbersArray = input.nextLine().split(" ");



        int listSize = inputNumbersArray.length;

        if (listSize == 0 || listSize<indexToOutput) {
            System.out.println("NIL");
            return;
        }

        NodeList headNode = createNodeList(inputNumbersArray);

        NodeList currentNode = headNode;
        NodeList secondRunningNode = null;
        int currentIndex = 1;

        while  (currentNode!=null) {
            if (currentIndex == indexToOutput){
                secondRunningNode = headNode;
            } else if (secondRunningNode!=null){
                secondRunningNode = secondRunningNode.nextItem;
            }
            currentNode = currentNode.nextItem;
            currentIndex++;
        }

        System.out.printf(secondRunningNode.data);

    }


    public static class NodeList {
        public String data;
        public NodeList nextItem;
    }

    public static NodeList createNodeList(String[] inputNumbersArray){
        NodeList headNode = null;
        NodeList currentNode = null;

        for (int i = 0; i < inputNumbersArray.length; i++) {

            NodeList newNode = new NodeList();
            newNode.data = inputNumbersArray[i];

            if (headNode == null){
                headNode = newNode;
            }else {
                currentNode.nextItem = newNode;
            }
            currentNode = newNode;
        }
        return headNode;
    }

    private static int findSingleInputLength(String inputLengthString) {
        return Integer.parseInt(inputLengthString.trim());
    }

//            int allInputInt[] = fetchAllInput(inputLength, input);
//
//
//            int outputInt[] = processInput(allInputInt,inputLength);

//        readArraySizeAndInputSizeString(arraySizeAndInputSizeString);


//





    private static int[] fetchAllInput(int inputLength, Scanner input) {
        int[] allInput = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            allInput[i] = Integer.parseInt(input.next());
            System.out.println(allInput[i]);
        }
        return allInput;
    }



    private static void readArrayAndDoSomething(Scanner input, int lineNumber, int arraySize, int inputSize) {
        int[] inputArray = new int[inputSize];

        while (input.hasNext()) {
            String array = input.nextLine();
            String inputStringArray[] = array.split(" ");

            for (int i = 0; i < arraySize; i++) {
                inputArray[i] = Integer.parseInt(inputStringArray[i]);
            }

            System.out.println("Input array is ");

            for (int i = 0; i < inputSize; i++) {
                System.out.print(inputArray[i] + ", ");
            }
            System.out.println("");
            break;
        }

        while (input.hasNext() && lineNumber <= inputSize) {
            String problem = input.nextLine();
            String[] problemArray = problem.split(" ");
            int problemType = Integer.parseInt(problemArray[0]);
            int startIndex = Integer.parseInt(problemArray[1]) - 1;
            int lastIndex = Integer.parseInt(problemArray[2]) - 1;

//            System.out.println("Problem type is " + problemType + " startIndex = " + startIndex + " lastIndex = " + lastIndex);
            lineNumber++;


            /*
            [2,2] = 22
            [2,3] = 22 * 10 = 220
	    [2,4] = 22 * 10 * 12 = 2640
	    [3,3] = 10
	    [3,4] = 10 * 12 = 120
            [4,4] = 12
             */
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            int maxIndex = 0;

            if (problemType == 1) {

                int curentRangeStart = startIndex; //2
                int currentRangeEnd = startIndex;  //2
                int productofRange = 1;

                while (curentRangeStart <= lastIndex) {
                    while (currentRangeEnd <= lastIndex) {
                        int tempRangeStart = curentRangeStart;
                        int tempRangeEnd = currentRangeEnd;
                        while (tempRangeStart <= tempRangeEnd) {

                            productofRange = productofRange * inputArray[tempRangeStart];
                            tempRangeStart++;
                        }
                        if (minValue > productofRange) {
                            minValue = productofRange;
                            minIndex = curentRangeStart;
                            maxIndex = currentRangeEnd;
                        }
                        productofRange = 1;
                        currentRangeEnd++;
                    }
                    curentRangeStart++;
                }

//                System.out.println(" Min value is " + minValue + " min index is " + minIndex +  " max index is " +  maxIndex);

                System.out.println(minValue + " " + minIndex + " " + maxIndex);

                minValue = 0;
                maxIndex = 0;
                minIndex = 0;
            } else if (problemType == 2) {
                inputArray[startIndex] = lastIndex;
            }
        }
    }

    private static void readArraySizeAndInputSizeString(String arraySizeAndInputSizeString) {
        String[] arraySizeAndInputSizeArray = arraySizeAndInputSizeString.split(" ");
        int arraySize = Integer.parseInt(arraySizeAndInputSizeArray[0]);
        int inputSize = Integer.parseInt(arraySizeAndInputSizeArray[1]);


        System.out.println("Array size is " + arraySize);
        System.out.println("Input size is " + inputSize);
    }
}
