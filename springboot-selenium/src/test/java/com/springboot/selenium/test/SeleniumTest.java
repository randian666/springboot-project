package com.springboot.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author xun2.liu
 * @title: SeleniumTest
 * @projectName crawler_selenium_ctrip
 * @description: TODO
 * @date 2020/9/16 16:01
 */
public class SeleniumTest {
    private WebDriver driver;
    @Before
    public void beforeEach() throws IOException, URISyntaxException {
        //指定driver路径
        String path =  this.getClass().getClassLoader().getResource("").getPath()+"static/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // 设置Chrome不弹出界面
//        options.addArguments("--no-sandbox"); //Chrome在root权限下跑
//        options.addArguments("--disable-gpu"); // 禁用GPU加速
//        options.addArguments("--window-size=1920,1050");  //专门应对无头浏览器中不能最大化屏幕的方案
//        options.addArguments("--blink-settings=imagesEnabled=false"); // 不加载图片
//        options.addArguments("--start-maximized");// 启动就最大化
//        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11"); // 设置用户代理
        //初始化WebDriver
        driver = new ChromeDriver(options);

    }
    @After
    public void afterEach() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //打开地址
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");
        navigate.to("https://www.jd.com");
        Thread.sleep(5000);
        //后退
        navigate.back();
        Thread.sleep(2000);
        //前进
        navigate.forward();
        //刷新页面
        navigate.refresh();

        Thread.sleep(2000);
    }

    @Test
    public void test3() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");
        //通过ID查找
        WebElement kw = driver.findElement(By.id("kw"));
        kw.sendKeys("selenium");
//        Thread.sleep(2000);
        //清除input内容
//        kw.clear();
        //Submit()方法用于对指定元素所在的form元素进行提交操作。
//        kw.submit();

        //通过name查找
//        List<WebElement> tj_logins = driver.findElements(By.name("tj_login"));
//        System.out.println(tj_logins.size());

        //LinkText方法按链接的文本进行查找
//        WebElement baiduLoginElement = driver.findElement(By.linkText("登录"));
//        baiduLoginElement.click();
//
        // partialLinkText 方法查找
//        WebElement baiduLoginElement = driver.findElement(By.partialLinkText("登录"));
//        baiduLoginElement.click();

        // className方法进行查找
//        List<WebElement> s_ipts = driver.findElements(By.className("s_ipt"));
//        System.out.println(s_ipts.size());

        // tagName方法进行查找
//        List<WebElement> tagNameElemets = driver.findElements(By.tagName("a"));
//        System.out.println(tagNameElemets.size());

        //xpath方法进行查找
//        WebElement element = driver.findElement(By.xpath("//input[@id='kw']"));
//        element.sendKeys("selenium");

        //cssSelector方法进行查找
//        WebElement element = driver.findElement(By.cssSelector("#kw"));
//        element.sendKeys("selenium");

        Thread.sleep(5000);
    }

    /**
     * 获取页面及页面元素的内容
     * @throws InterruptedException
     */
    @Test
    public void test4() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");
        //getTitle()方法用于返回当前网页的标题。
        System.out.println(driver.getTitle());

        //getCurrentUrl()用于获取当前网页的URL。
        System.out.println(driver.getCurrentUrl());

        //getText ()用于存储某个元素的文本值，例如链接，纯文本等。
        WebElement head_wrapper = driver.findElement(By.id("head_wrapper"));
        System.out.println(head_wrapper.getText());
        System.out.println(head_wrapper.getTagName());

        WebElement su = driver.findElement(By.id("su"));
        //isEnabled()用于存储input等元素的可编辑状态
        System.out.println(su.isEnabled());
        //isDisplayed()才能验证该元素是否在页面上显示
        System.out.println(su.isDisplayed());

        //getAttribute( )方法用于获取指定属性的值
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        System.out.println(element.getAttribute("maxlength"));
    }

    /**
     * 获取页面及页面元素的内容
     * @throws InterruptedException
     */
    @Test
    public void test5() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("D:\\temp\\alert.html");

        WebElement btnAlert = driver.findElement(By.xpath("//input[1]"));
        btnAlert.click();
        Thread.sleep(2000);
        //getText()用于获取弹出对话框的文本内容。
        System.out.println(driver.switchTo().alert().getText());
        //accept()单击弹出对话框的确认按钮，可以同时对Alert、Confirmation以及Prompt使用。
        driver.switchTo().alert().accept();


        WebElement btnConfirm = driver.findElement(By.xpath("//input[2]"));
        btnConfirm.click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //单击弹出对话框的取消按钮，可以同时对Alert、Confirmation以及Prompt使用。
//        driver.switchTo().alert().dismiss();


        WebElement btnPrompt= driver.findElement(By.xpath("//input[3]"));
        btnPrompt.click();
        Thread.sleep(2000);
        //在弹出对话框中输入文本，该方法只对Prompt弹出对话框有效。
//        driver.switchTo().alert().sendKeys("请输入内容");
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
        Thread.sleep(5000);

    }

    @Test
    public void test6() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");
        WebElement lgElements = driver.findElement(By.id("lg"));
        lgElements.click();

        Set<String> windowHandles = driver.getWindowHandles();
        String[] handles=new String[windowHandles.size()];
        String[] handlesArr = windowHandles.toArray(handles);
        for (int i = 0; i < handlesArr.length; i++) {
            System.out.println("窗口句柄："+handlesArr[i]);
        }

        //新窗口弹出后，可以通过它的标识符（句柄）切换到该窗口，再对该窗口的元素进行操作。
        WebDriver childWindow = driver.switchTo().window(handlesArr[1]);
        WebElement kw = childWindow.findElement(By.id("kw"));
        kw.clear();
        kw.sendKeys("selenium1");
        Thread.sleep(2000);
        //切回父窗口
        WebDriver parentWindow = driver.switchTo().window(handlesArr[0]);
        WebElement pkw = parentWindow.findElement(By.id("kw"));
        pkw.clear();
        pkw.sendKeys("selenium2");

        Thread.sleep(5000);
    }

    @Test
    public void test7() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");
        //添加cookie
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,+1);
        Cookie newcookie = new Cookie("newcookie", "mycookie",".baidu.com","",calendar.getTime(),false);
        driver.manage().addCookie(newcookie);
        Thread.sleep(1000);
        //获取cookie
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("cookie名称："+cookie.getName());
            System.out.println("cookie值："+cookie.getValue());
            System.out.println("cookie所在域："+cookie.getDomain());
            System.out.println("cookie路径："+cookie.getPath());
            System.out.println("cookie过期时间："+cookie.getExpiry());
            System.out.println("");
        }
        //删除所有 cookie
        //driver.manage().deleteAllCookies();
        Thread.sleep(5000);
    }
    /**
     * @description: window
     * @author xun2.liu
     * @date 2020/9/16 21:44
     * @Param []
     * @return void
     **/
    @Test
    public void test8() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");

        WebDriver.Window window = driver.manage().window();
        System.out.println("最大化前，当前window在屏幕上的坐标"+window.getPosition().x+","+window.getPosition().y);
        System.out.println("最大化前，当前window在屏幕上的长宽"+window.getSize().width+","+window.getSize().height);
        System.out.println("");
        window.maximize();

        System.out.println("最大化后，当前window在屏幕上的坐标"+window.getPosition().x+","+window.getPosition().y);
        System.out.println("最大化后，当前window在屏幕上的长宽"+window.getSize().width+","+window.getSize().height);
        System.out.println("");
        Thread.sleep(5000);
    }

    @Test
    public void test9() throws InterruptedException {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.baidu.com");
        driver.manage().window().maximize();
        //设置隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement baiduLoginElement = driver.findElement(By.linkText("登录"));
        baiduLoginElement.click();
        //设置显式等待
        //最多等待10秒，如果超过时间，则会抛出TimeoutException。如果在10秒内找到了对应的元素，WebDriverWait默认每隔500毫秒就调用
        // ExpectedCondition来进行检查，直找到对应的元素。找到后，ExpectedCondition会返回一个bool值（ture）
        // 或所有不为空的其他ExpectedCondition类型值。
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("TANGRAM__PSP_11__footerULoginBtn")));
        driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
        driver.findElement(By.name("userName")).sendKeys("selenium");

        Thread.sleep(5000);
    }
}
