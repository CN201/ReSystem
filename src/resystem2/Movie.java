
package resystem2;
import java.util.Scanner;


public class Movie {

	public static void main (String[] args)
    {
        //Variables
        Scanner reader=new Scanner(System.in);
        Seat[][] seats=new Seat[5][6];
        int row, input, howmany, count = 0;
        String name;
        String menu = "Menu: "
            + "\n1: Book seats"
            + "\n2: View current seating"
            + "\n0: Quit program";
        //Assigns numbers to the seats.
        for (int i = 0; i<5; i++)
        {
            seats[i][0]=new Seat("1");
            seats[i][1]=new Seat("2");
            seats[i][2]=new Seat("3");
            seats[i][3]=new Seat("4");
            seats[i][4]=new Seat("5");
            seats[i][5]=new Seat("6");
        }
        do
        {
            //Asks the user what she wants to do
            System.out.println("\n"+menu);
            System.out.println("Input (1-2 or 0): ");
            input = Integer.parseInt(reader.next());
            reader.nextLine();
            switch(input)
            {
                case 1:
                //When all the 30 seats are booked, the program informs the user that the cinema is full.
                if(count == 30)
                {
                    System.out.println("\nThe cinema is fully booked.");
                }
                else
                {
                    do
                    {
                        System.out.print("How many seats would you like to book? ");
                        howmany = reader.nextInt();
                        if(howmany>5)
                        {
                            System.out.println("The maximum number of seats per booking is 5.");
                        }
                        if(howmany<1)
                        {
                            System.out.println("The minimum number of seats per booking is 1.");
                        }
                    }
                    while(howmany>5 || howmany<1);
                    for(int j=0;j<howmany;j++)
                    {
                        printArray(seats);
                        do
                        {
                            //Asks the user on what row he would like to book a seat
                            System.out.println("Where would person number "+(j+1)+" like to sit?");
                            do
                            {
                                System.out.print("Row: ");
                                row=reader.nextInt();
                                //If the user choses a nonexistent row
                                if(row>5)
                                {
                                    System.out.println("There are only 5 rows, please choose a new row.");
                                }
                            }
                            while(row>5);
                            //Asks what seat the user would like.
                            do
                            {
                                System.out.print("Seat: ");
                                name=reader.next();
                                //If the user choses a nonexistent seat
                                if(!name.equals("1") && !name.equals("2") && !name.equals("3") &&
                                !name.equals("4") && !name.equals("5") && !name.equals("6"))
                                {
                                    System.out.println("There are only 6 seats per row, please choose a new seat.");
                                }
                            }
                            while(!name.equals("1") && !name.equals("2") && !name.equals("3") &&
                            !name.equals("4") && !name.equals("5") && !name.equals("6"));
                        }
                        while(row>5);
                        for(int i=0;i<6;i++)
                        {
                            if(seats[row-1][i].getName().equalsIgnoreCase(name))
                            {
                                //If the seat is already taken, it informs the user about it
                                if(seats[row-1][i].getVisible()==false)
                                {
                                    System.out.println("\nThat seat is already taken, please select another one.\n");
                                    j--;
                                }      
                                //If the seat is free, the program books it and marks it as taken.
                                else
                                {
                                    seats[row-1][i].setVisible(false);
                                    count++;
                                }      
                            }
                        }
                    }
                }
                break;
 
                case 2:
                printArray(seats);
                break;
 
                case 0:
                System.out.println("Good bye!");
                break;
 
                default:
                //Informs the user that the input is not valid
                System.out.println("Invalid input.");
                break;
            }
        }
        while(input != 0);
    }
 
    //This method prints the current seating situation
    public static void printArray(Seat[][] a)
    {
        //Prints the rows
        System.out.println("-SCREEN-");
        for(int i=0;i<5;i++)
        {
            System.out.print(i+1+" ");
            //Prints the seats
            for(int j=0;j<6;j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.print(" ");
            System.out.println();
        }
    }
}
