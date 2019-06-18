package it.prova;
import java.io.*;
public class EsempioScritura  {
	public static void main(String[] args) {
		 try {
			   FileWriter w;
			    w=new FileWriter("scrittura.txt");

			    BufferedWriter b;
			    b=new BufferedWriter (w);

			    b.write("abcd\nefghi");

			    b.write("123");

			    b.flush();
			  }catch(IOException e) {
				  e.printStackTrace();
			  }
			}

	}

