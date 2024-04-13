package br.com.Musics.sistema.Function;

	import java.io.BufferedInputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import javazoom.jl.player.Player;


	public class JLayer extends Thread{

		private File mp3;
		
		public void tocar (File mp3) {
			this.mp3 = mp3;
		}
		
		@Override
		public void run() {

			try {
				
				try(FileInputStream fileStrem = new FileInputStream(mp3)) {
					
					BufferedInputStream bufferedStream = new BufferedInputStream (fileStrem);
					
					Player player = new Player (bufferedStream);
					player.play();
					
					if(player.isComplete()) {
						player.close();
					}
				}
				
			} catch (Exception e) {
				System.err.println("Deu Erro vacilão 1");
			}
			

			
			
		}
		
	}
	
