package Bernardo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EjemploSelenium {

    public static void main(String[] args) throws InterruptedException {

        String rutaDriver = "C:\\Users\\bernardo.estrada\\OneDrive - TSOFT\\Escritorio\\BOOTCAMP\\SEMANA 1\\17 DE AGOSTO NIVELACION\\CODIGOS Y EJERCICIOS\\BC14\\app\\src\\test\\resources\\drivers\\chromedriver.exe";

  // Enlazar el Driver-----------------------------------------------------
  System.setProperty("webdriver.chrome.driver", rutaDriver);

  // Instanciar un objeto de tipo webdriver en google chrome-------------------------------------
  WebDriver driver = new ChromeDriver(); // Levanta Browser--------------------------------------

  driver.get("https://open.spotify.com/"); // Carga  url al browser------------------------------


        // LOCALIZAR EL ELEMENTO DEL HTML---------------------------------------------------------
        By localizadorBotonRegistrar = By.xpath("//button[contains(text(),'Registrarte')]");

        // CREAR EL ELEMENTO WEB------------------------------------------------------------------
       WebElement btnregistrar = driver.findElement(localizadorBotonRegistrar);


        // HACER CLICK EN EL BOTON----------------------------------------------------------------
        btnregistrar.click();

        // HACER ESPERAR------------------------------------------------------------------------
        Thread.sleep(3000);

        //EJEMPLO BUSQUEDA POR ID EN UNA SOLA LINEA------------------------------------------------
        driver.findElement(By.id("email")).sendKeys("admin@example.com");


        //EJEMPLO BUSQUEDA POR ID EN UNA SOLA LINEA------------------------------------------------
        driver.findElement(By.name("password")).sendKeys("12345678");

        //EJEMPLO BUSQUEDA POR ID EN UNA SOLA LINEA------------------------------------------------
        driver.findElement(By.id("displayname")).sendKeys("Bernardo Estrada");


        //-------------------------------------------------------------------------------------------

        //FORM DE DIA / MES / AÑO : --------------------------------------------------------------------


        //EJEMPLO BUSQUEDA POR XPATH EN UNA SOLA LINEA---------------"DIA"---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='DD']")).sendKeys("01");

        //FORMA DE SELECCIONAR EL DESPLEGABLE DE "MES" , PODEMOS SELECCIONAR POR VALUE, POR TEXTO VISIBLE Y OTRO MAS
        Select selectMes = new Select(driver.findElement(By.name("month")));
        selectMes.selectByValue("06");

        //AÑO--------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//input[@placeholder='AAAA']")).sendKeys("1988");

        //-----------------------------------------------------------------------------------------------------

        //-HACER SCROLL DEL BROWSER-HASTA QUE QUE ENCUENTRE LA LISTA DE DE GENEROS-----------------------------
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //-SELECCIONAR ENTRE VARIAS OPCCIONES-TIPO CHECKBOX----------------------------------------------------
        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender_option')]"));

        js.executeScript("arguments[0].scrollIntoView();", generos.get(0));


        Thread.sleep(1000);
        generos.get(0).click();// SON LISTAS "0" ES LA POSICION 1 DE LA LISTA "HOMBRE" EN ESTE CASO
        Thread.sleep(2000);
        generos.get(1).click();
        Thread.sleep(2000);
        generos.get(2).click();
        Thread.sleep(2000);
        generos.get(3).click();
        Thread.sleep(2000);
        generos.get(4).click();
        Thread.sleep(2000);
        generos.get(0).click();
        Thread.sleep(2000);


        //cajita no quiero recibir mensajes
        //cajita compartir mis datos

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));

        js.executeScript("arguments[0].scrollIntoView();", checks.get(0));

        checks.get(0).click();
        checks.get(1).click();
        Thread.sleep(2000);
        checks.get(0).click();
        checks.get(1).click();
        Thread.sleep(2000);
        checks.get(0).click();
        checks.get(1).click();

        //Boton Registrate
        driver.findElement(By.xpath("//button[@type='submit']")).click();





    }
}
