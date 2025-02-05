package sdet;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PdfReading {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String path="file:///C:/Users/User01/Downloads/Manual%20testing%20notes.pdf";
		
		//URL pdfurl=new URL(path);
		//InputStream is = pdfurl.openStream();
		//PDDocument pdDocument = PDDocument.load(is);
		//int count = pdDocument.getPages().getCount();
		//System.out.println(count);
		//PDFTextStripper pt=new PDFTextStripper();
		//pt.setStartPage(1);
		//pt.setEndPage(2);
		//String text = pt.getText(pdDocument);
		
		//System.out.println(text);

	}

}
