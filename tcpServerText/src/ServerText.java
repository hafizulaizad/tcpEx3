import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerText {	
	public static void main(String args[]) throws Exception {
		
	int port = 5000;
	ServerSocket SerSocket;
	Socket socket ;
	String inputLine = null;
	
	 try {
		 
		//ServerTextFrame serverFrame = new ServerTextFrame();
		//serverFrame.setVisible(true);
		System.out.println("Server is listening on port " + port);
		
		SerSocket = new ServerSocket(port);
		
		while(true) {
			//serverFrame.updateServerStatus(false);
			socket = SerSocket.accept();
			
	        System.out.println("New client connected");
	        
	        BufferedReader in = new BufferedReader(
	 				new InputStreamReader(socket.getInputStream()));
	 
	        
	        PrintStream out = new PrintStream(
   	             new BufferedOutputStream(socket.getOutputStream()));
	        
	      
	        out.println("Please enter text:");
	        out.flush();
	        
	        while ((inputLine = in.readLine()) != null) {
    	 	    String outputLine = String.valueOf(wordcount(inputLine));
    	 	    out.println(outputLine + " words");
    	 	    out.flush();
    	 	    if (outputLine.equals("Bye."))
    	 	        break;
    	 		}
	        
	        socket.close();
			}
		

	 	} catch (IOException e) {
		    System.out.println("Accept failed: " + port + ", " + e);
		    System.exit(1);
		}
	}

	 static int wordcount(String text) {
		 int count=0;  
	      
         char ch[]= new char[text.length()];     
         for(int i=0;i<text.length();i++)  
         {  
             ch[i]= text.charAt(i);  
             if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                 count++;  
         }  
         return count;  
     }  
}
