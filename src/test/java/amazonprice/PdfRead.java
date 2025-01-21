package amazonprice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PdfRead {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String url="file:///C:/Users/V/Downloads/18.%20Synchronization.pdf";
		driver.get(url);
		
		URL pdfurl=new URL(url);
		InputStream is = pdfurl.openStream();
		PDDocument pdDocument = PDDocument.load(is);
		int count = pdDocument.getPages().getCount();
		System.out.println(count);
		PDFTextStripper pt=new PDFTextStripper();
		pt.setStartPage(1);
		pt.setEndPage(2);
		String text = pt.getText(pdDocument);
		
		System.out.println(text);



	}

}
