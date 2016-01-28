/* Artificial Intelligence Assignment 1
 * Professor Gupta
 * Written by Barret J. Nobel
 * January 27th, 2016
 * This program spits out DeMorgan's equivalencies
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Assignment1
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in ); //............... for user input

        System.out.print( "Enter an expression to test: "); //.. prompt user for input
        demorganThisString( in.nextLine() ); //................. capture full line input test the method
    }

    // Method to spit out the De Morgan equivalent
    // takes a String argument
    // prints out the De Morgan equivalent
    public static void demorganThisString( String input )
    {
        ArrayList<Object> queue = new ArrayList<>(); //.......................... the queue
        StringTokenizer string = new StringTokenizer( input ); //................ tokenizer to split up the string
        String toCheck; //....................................................... variable to hold the String stripped by tokenizer

        while( string.hasMoreElements() ) //..................................... loop through each element in String
        {
            toCheck = ( (String)string.nextElement() ).toUpperCase(); //......... capture the first element

            if( toCheck.equals("NOT") ) //....................................... if it equals NOT
            {
                while( string.hasMoreElements() ) //............................. loop through the remaining elements
                {
                    toCheck = ( (String)string.nextElement() ).toUpperCase(); //. capture the first element

                    switch( toCheck ) //......................................... drop captured element into switch
                    {
                        case "AND": //........................................... when it equals AND add OR to queue
                            queue.add( "OR " );
                            break;

                        case "OR": //............................................ when it equals OR add AND to queue
                            queue.add( "AND " );
                            break;

                        case "(":
                        case ")": //............................................. if its either paren
                            queue.add( String.format("%s ", toCheck) ); //....... add to queue
                            break;

                        default: //.............................................. if its anything else
                            queue.add( String.format("(NOT %s) ", toCheck) ); //. add NOT to it and toss onto queue
                            break;
                    }
                }

                for( Object item: queue ) System.out.print( item ); //........... empty queue and print elements
            }
            else System.out.print( String.format("%s ", toCheck) ); //........... print out the element
        }
    }
}