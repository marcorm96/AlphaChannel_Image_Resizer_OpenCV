package rpa.main;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Main {
						
	//metodo che legge l'immagine passata come argomento,
	//la ridimensiona e la salva su disco	
	public static void resizer(String pathImgOriginale){
		//leggo l'immagine con il flag IMREAD_UNCHANGED che permette di mantenere il canale alpha
		Mat imgDefault=Highgui.imread(pathImgOriginale,Highgui.IMREAD_UNCHANGED);
		if(imgDefault.empty()){
			//l'immagine non esiste
			return;
		}
		//ottengo le dimensioni dell'immagine originale e le divido per 2 (per esempio)
		Size s=new Size(imgDefault.width()/2,imgDefault.height()/2);
		//ridimensiono l'immagine di default con le nuove dimensioni e scrivo il risultato in una nuova Mat		
		Mat dst=new Mat();
		Imgproc.resize(imgDefault, dst, s);						
		//creo il path della nuova immagine prendendo il nome originale senza estensione ed aggiungendo _resized_ e l'estensione
		String pathResized=pathImgOriginale.substring(0, pathImgOriginale.indexOf('.'))+"_resized_.png";		
		//salvo l'immagine ridimensionata					
		Highgui.imwrite(pathResized, dst);		
	}			
	

	public static void main(String args[]){
		//Leggo la libreria di opencv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
		resizer(args[0]);
	}
}
