package packlab1;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FitxeroakIrakurri {
	
	private static FitxeroakIrakurri nireFitxeroakIrakurri = null;
	
	private FitxeroakIrakurri(){
		
	}
	
	public static FitxeroakIrakurri getNireFitxeroakIrakurri(){
		if(nireFitxeroakIrakurri==null){
			nireFitxeroakIrakurri=new FitxeroakIrakurri();
		}
		return nireFitxeroakIrakurri;
	}
	
	
	public listaAktoreak listaAktoreakLortu(String pFitxeroa) {
		//TODO
	}
	
	public listaFilmak listaFilmakSortu(String pFitxeroa) {
		//TODO
	}
}