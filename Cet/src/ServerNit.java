import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerNit extends Thread {
	
	BufferedReader ulazniTokOdKlijenta=null;
	PrintStream izlazniTokKaKlijentu = null;
	Socket soketZaKom=null;
	
	ServerNit[] klijenti;
	
	public ServerNit(Socket soket, ServerNit[] klijent){
		this.soketZaKom = soket;
		this.klijenti=klijent;
	}
	
	public void run(){
		String linija;
		String ime;
		
		try {
			ulazniTokOdKlijenta = new BufferedReader(new  InputStreamReader(soketZaKom.getInputStream()));
			izlazniTokKaKlijentu = new PrintStream(soketZaKom.getOutputStream());
			
			izlazniTokKaKlijentu.println("Unesite ime.");
			ime = ulazniTokOdKlijenta.readLine();
			
			izlazniTokKaKlijentu.println("Dobrodosao/la "+ime+".\nZa izlaz unesite    /quit");
			for (int i = 0; i <=9; i++)
				if(klijenti[i]!=null && klijenti[i]!=this)
					klijenti[i].izlazniTokKaKlijentu.println("***Novi korisnik: "+ime+" je usao u chat sobu!!!***");
			while(true){
				linija = ulazniTokOdKlijenta.readLine();
				if(linija.startsWith("/quit"))
					break;
				for (int i = 0; i <=9; i++){
					if (klijenti[i]!=null && klijenti[i]==this){
						klijenti[i].izlazniTokKaKlijentu.println("<"+ime+">"+linija);
						int rezultat=0;
						if (linija.contains("+")){
							int t=linija.indexOf('+');
							String a1 = linija.substring(0, t);
							String b1 = linija.substring(t+1);
							int a=Integer.parseInt(a1);
							int b=Integer.parseInt(b1);
							rezultat = a+b;
						}
						if (linija.contains("/")){
							int t=linija.indexOf('/');
							String a1 = linija.substring(0, t);
							String b1 = linija.substring(t+1);
							int a=Integer.parseInt(a1);
							int b=Integer.parseInt(b1);
							rezultat = a/b;
						}
						if (linija.contains("-")){
							int t=linija.indexOf('-');
							String a1 = linija.substring(0, t);
							String b1 = linija.substring(t+1);
							int a=Integer.parseInt(a1);
							int b=Integer.parseInt(b1);
							rezultat = a-b;
						}
						if (linija.contains("*")){
							int t=linija.indexOf('*');
							String a1 = linija.substring(0, t);
							String b1 = linija.substring(t+1);
							int a=Integer.parseInt(a1);
							int b=Integer.parseInt(b1);
							rezultat = a*b;
						}
						klijenti[i].izlazniTokKaKlijentu.println("<"+ime+"> Odgovor: "+rezultat);
						
					}
				}
			}
			for (int i = 0; i <=9; i++)
				if(klijenti[i]!=null && klijenti[i]!=this)
					klijenti[i].izlazniTokKaKlijentu.println("*** Korisnik"+ime+" izlazi iz chat sobe!!! ***");
			izlazniTokKaKlijentu.println("*** Dovidjenja "+ime+" ***");
			soketZaKom.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		for (int i = 0; i <=9; i++)
			if(klijenti[i]==this)
				klijenti[i]=null;
	}
}
