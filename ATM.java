//Nandkumar Sambhaji Chavan
//Task-3 ATM
//Java Development




package Task_3_ATM;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ATM{
	
	
		//Variables
	
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now =LocalDateTime.now();  
	    float bal=0f;
	    int trans=0;
	    String transHis="";
	    String name;
	    String userID="Nandkumar";
	    String password="12345678";
	    String act_no="987654321";
	    Scanner sc=new Scanner(System.in); 
	    
		
		
	    public boolean login(){
	        boolean isLogin=false;
	        while(!isLogin){
	            System.out.println("\nEnter username : ");
	            String usr=sc.nextLine();
	            if (usr.equals(userID)){
	                System.out.println("Enter password : ");
	                String pd=sc.nextLine();
	                while(!isLogin){
	                    if(pd.equals(password)){
	                        System.out.println("Logged-in Successfully!!");
	                        isLogin=true;
	                    }
	                    else{
	                        System.out.println("Invalid login!!");
	                        break;
	                    }
	                }
	            }
	            else{
	                System.out.println("Username not found!!");
	            }
	        }
	        return isLogin;
	    }
	    
	    
	    public void deposit(){
	        System.out.println("\nEnter amount to deposit : ");
	        float damount=sc.nextFloat();
	        try{
	            if(damount<=100000f){
	                bal+=damount;
	                trans+=1;
	                System.out.println("Successfully deposited Rs. "+damount+" at "+dtf.format(now));
	                String s="Rs "+damount+" deposited at "+dtf.format(now)+" .\n";
	                transHis=transHis.concat(s);
	            }
	            else{
	                System.out.println("Sorry!Can't deposit more than one lakh");
	            }
	        }
	        catch(Exception e){
	        }
	    }
	    
	    
	    public void withdraw(){
	        System.out.println("\nEnter amount to withdraw : ");
	        float wamount=sc.nextFloat();
	        try{
	            if (wamount<=bal){
	                bal-=wamount;
	                trans+=1;
	                System.out.println("Successfully withdrawn Rs. "+wamount+" at "+dtf.format(now));
	                String s="Rs "+wamount+" withdrawn at "+dtf.format(now)+" .\n";
	                transHis=transHis.concat(s);
	            }
	            else{
	                System.out.println("Sorry!Can't withdraw.Insufficient amount to withdraw..");
	            }
	        }
	        catch(Exception e){
	        }
	    }
	    
	    
	    
	    public void transfer(){
	    	Scanner in=new Scanner(System.in);
	        System.out.println("\nEnter the Who you want to transfer to : ");
	        String uname=in.nextLine();
	        System.out.println("Enter the amount to transfer");
	        float tamount=sc.nextFloat();
	        try{
	            if (tamount<=bal){
	                bal-=tamount;
	                trans+=1;
	                System.out.println("Successfully transferred Rs. "+tamount+" at "+dtf.format(now));
	                String s="Rs "+tamount+" transferred to "+uname+" account at "+dtf.format(now)+" .\n";
	                transHis=transHis.concat(s);
	            }
	            else{
	                System.out.println("Sorry!Can't transfer.Insufficient amount to transfer..");
	            }
	        }   
	        catch(Exception e){
	        }
	        in.close();
	    }
	    
	    
	    
	    public void transHistory(){
	        if(trans==0){
	            System.out.println("\nNo Transactions!!");
	        }
	        else{
	            System.out.println("\n"+transHis);
	        }
	    }
	    
	    
	    public void checkBal(){
	        System.out.println("\nBalance amount is : "+bal);
	    }
	

    
    public static void main(String args[]){
        System.out.println("WELCOME TO ATM!!!");
        System.out.println("\nSelect any one option!");
        Scanner sc=new Scanner(System.in);

            ATM OBJ=new ATM(); //Object Created
            while(true){
                System.out.println("\nSelect any one option!");
                System.out.println("1.LOGIN\n2.EXIT");
                System.out.println("Enter your option :");
                int op=sc.nextInt();
                if (op==1){
                    if(OBJ.login()){
                        boolean isFin=false;
                        while(!isFin){
                            System.out.println("\nSelect any option : ");
                            System.out.println("1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.EXIT");
                            System.out.println("Enter your option :");
                            int c=sc.nextInt();
                            switch(c){
                                case 1 : OBJ.deposit();
                                         break;
                                case 2 : OBJ.withdraw();
                                         break;
                                case 3 : OBJ.transfer();
                                         break;
                                case 4 : OBJ.transHistory();
                                         break;
                                case 5 : OBJ.checkBal();
                                         break;
                                case 6 : isFin=true;
                                         break;
                                default: System.out.println("Invalid option!!!! Try Again!!");
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                    System.out.print("Please Take Your Card :)");
                }
            }
        }
    }


