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
        Scanner in = new Scanner( System.in );

        System.out.print( "Enter an expression to test: ");
        testThisString( in.nextLine() );
    }

    public static void testThisString( String input )
    {
        ArrayList<Object> queue = new ArrayList<>();
        StringTokenizer string = new StringTokenizer( input );
        String toCheck;

        while( string.hasMoreElements() )
        {
            toCheck = ( (String)string.nextElement() ).toUpperCase();

            if( toCheck.equals("NOT") )
            {
                while( string.hasMoreElements() )
                {
                    toCheck = ( (String)string.nextElement() ).toUpperCase();

                    switch( toCheck )
                    {
                        case "AND":
                            queue.add( "OR " );
                            break;

                        case "OR":
                            queue.add( "AND " );
                            break;

                        case "(":
                        case ")":
                            queue.add( String.format("%s ", toCheck) );
                            break;

                        default:
                            queue.add( String.format("(NOT %s) ", toCheck) );
                            break;
                    }
                }

                for( Object item: queue ) System.out.print( item );
            }
            else System.out.print( String.format("%s ", toCheck) );
        }
    }
}