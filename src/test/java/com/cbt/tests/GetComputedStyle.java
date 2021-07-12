package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GetComputedStyle {
    static  WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws InterruptedException {
        getFontInfo2();


    }
    public static void getFontInfo2(){
        driver.get("https://tr.piliapp.com/cool-text/bold-italic/");
        WebElement oldEnglish = driver.findElement(By.id("label-old-english"));
        System.out.println("getStyleAttribute(driver,oldEnglish,\"font-family\") = " + getAnyStyleAttribute(driver, oldEnglish, "font-family"));
    }
    public static void getFontInfo(){

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/my202/Desktop/javascript-workspace/html%20sayfa%20dinamik/index.html");
        driver.findElement(By.id("tagName")).sendKeys("pre");
        driver.findElement(By.id("content")).sendKeys("Java is an Object Oriented Programming Language.");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.id("tagName")).clear();
        driver.findElement(By.id("tagName")).sendKeys("code");
        driver.findElement(By.id("content")).sendKeys("Java is an Object Oriented Programming Language.");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.id("tagName")).clear();
        driver.findElement(By.id("tagName")).sendKeys("h1");
        driver.findElement(By.id("content")).sendKeys("Java is an Object Oriented Programming Language.");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.id("tagName")).clear();
        driver.findElement(By.id("tagName")).sendKeys("quote");
        driver.findElement(By.id("content")).sendKeys("Java is an Object Oriented Programming Language.");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.id("tagName")).clear();

        WebElement pre = driver.findElement(By.tagName("pre"));
        System.out.println("getStyleAttribute(driver,pre,\"font-family\") = " + getStyleAttribute(driver, pre, "font-family"));
        System.out.println("getStyleAttribute(driver,pre,\"font-size\") = " + getStyleAttribute(driver, pre, "font-size"));
        WebElement code = driver.findElement(By.tagName("code"));
        System.out.println("getStyleAttribute(driver,code,\"font-family\") = " + getStyleAttribute(driver, code, "font-family"));
        System.out.println("getStyleAttribute(driver,code,\"font-size\") = " + getStyleAttribute(driver, code, "font-size"));
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println("getStyleAttribute(driver,h1,\"font-family\") = " + getStyleAttribute(driver, h1, "font-family"));
        System.out.println("getStyleAttribute(driver,h1,\"font-size\") = " + getStyleAttribute(driver, h1, "font-size"));
        WebElement quote = driver.findElement(By.tagName("quote"));
        System.out.println("getStyleAttribute(driver,quote,\"font-family\") = " + getStyleAttribute(driver, quote, "font-family"));
        System.out.println("getStyleAttribute(driver,quote,\"font-size\") = " + getStyleAttribute(driver, quote, "font-size"));



    }
    public static void changeElementColor() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://anonimid.github.io");
        Thread.sleep(2000);
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        Random random = new Random();
        for (int i = 25; i >= 0; i--) {
            Integer x = i * (random.nextInt(10)+1);
            Integer y = i * (random.nextInt(10)+1);
            Integer z = i * (random.nextInt(10)+1);
            jsExe.executeScript("document.getElementById('querybtn').style.backgroundColor='rgb("+x+","+y+","+z+")';");
            Thread.sleep(1000);
        }

    }
    public static void binanceFavorites() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://www.binance.com/en/trade/BOND_USDT?type=spot");
        driver.findElement(By.cssSelector("div.css-4rbxuz>svg")).click();
        Thread.sleep(1000);
        List<WebElement> favorites = driver.findElements(By.cssSelector("div.favorite>svg>path"));
        List<WebElement> coins = driver.findElements(By.cssSelector("span.item-symbol-ba"));

        for (int i = 0; i < favorites.size(); i++) {

            if (coins.get(i).getText().equals("ADA")) {
                HashMap<String, String> before = getAllStyles(driver, favorites.get(i));
                System.out.println("before = " + before);
                favorites.get(i).click();
                HashMap<String, String> after = getAllStyles(driver, favorites.get(i));
                ArrayList<String> keys = (ArrayList<String>) before.keySet().stream().collect(Collectors.toList());
                for (int j = 0; j < keys.size(); j++) {
                    if(!before.get(keys.get(j)).equals(after.get(keys.get(j)))){
                        System.out.println("before :"+keys.get(j)+" = " + before.get(keys.get(j)));
                        System.out.println("after :"+keys.get(j)+" = " + after.get(keys.get(j)));
                    }
                }
                System.out.println("after = " + after);

            }

        }
    }

    public static HashMap<String, String> getAllStyles(WebDriver driver, WebElement element) {
        HashMap<String, String> styles = new HashMap<String, String>();
        if (driver.toString().contains("null")) {
            styles.put("WebDriver is null", "WebDriver is null. Check your code!");
            return styles;
        }
        if (element.toString().contains("null")) {
            styles.put("Element is null", "WebElement is null. Check your code!");
            return styles;
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String createDummyElementToHoldData = "let dummyElement = document.createElement('p');dummyElement.id = 'dummyElement';dummyElement.style.visibility = 'hidden';document.body.appendChild(dummyElement)";
        js.executeScript(createDummyElementToHoldData);

        String[] cssStyleAttributes = {"align-content", "align-items", "align-self", "alignment-baseline", "animation-delay", "animation-direction", "animation-duration", "animation-fill-mode", "animation-iteration-count", "animation-name", "animation-play-state", "animation-timing-function",
                "appearance", "backdrop-filter", "backface-visibility", "background-attachment", "background-blend-mode", "background-clip", "background-color", "background-image", "background-origin", "background-position", "background-repeat", "background-size", "baseline-shift", "block-size",
                "border-block-end-color", "border-block-end-style", "border-block-end-width", "border-block-start-color", "border-block-start-style", "border-block-start-width", "border-bottom-color", "border-bottom-left-radius", "border-bottom-right-radius", "border-bottom-style",
                "border-bottom-width", "border-collapse", "border-end-end-radius", "border-end-start-radius", "border-image-outset", "border-image-repeat", "border-image-slice", "border-image-source", "border-image-width", "border-inline-end-color", "border-inline-end-style",
                "border-inline-end-width", "border-inline-start-color", "border-inline-start-style", "border-inline-start-width", "border-left-color", "border-left-style", "border-left-width", "border-right-color", "border-right-style", "border-right-width", "border-start-end-radius",
                "border-start-start-radius", "border-top-color", "border-top-left-radius", "border-top-right-radius", "border-top-style", "border-top-width", "bottom", "box-shadow", "box-sizing", "break-after", "break-before", "break-inside", "buffered-rendering", "caption-side", "caret-color",
                "clear", "clip", "clip-path", "clip-rule", "color", "color-interpolation", "color-interpolation-filters", "color-rendering", "column-count", "column-gap", "column-rule-color", "column-rule-style", "column-rule-width", "column-span", "column-width", "content", "cursor", "cx", "cy", "d",
                "direction", "display", "dominant-baseline", "empty-cells", "fill", "fill-opacity", "fill-rule", "filter", "flex-basis", "flex-direction", "flex-grow", "flex-shrink", "flex-wrap", "float", "flood-color", "flood-opacity", "font-family", "font-kerning", "font-optical-sizing", "font-size",
                "font-stretch", "font-style", "font-variant", "font-variant-caps", "font-variant-east-asian", "font-variant-ligatures", "font-variant-numeric", "font-weight", "grid-auto-columns", "grid-auto-flow", "grid-auto-rows", "grid-column-end", "grid-column-start", "grid-row-end",
                "grid-row-start", "grid-template-areas", "grid-template-columns", "grid-template-rows", "height", "hyphens", "image-orientation", "image-rendering", "inline-size", "inset-block-end", "inset-block-start", "inset-inline-end", "inset-inline-start", "isolation", "justify-content",
                "justify-items", "justify-self", "left", "letter-spacing", "lighting-color", "line-break", "line-height", "list-style-image", "list-style-position", "list-style-type", "margin-block-end", "margin-block-start", "margin-bottom", "margin-inline-end", "margin-inline-start", "margin-left",
                "margin-right", "margin-top", "marker-end", "marker-mid", "marker-start", "mask-type", "max-block-size", "max-height", "max-inline-size", "max-width", "min-block-size", "min-height", "min-inline-size", "min-width", "mix-blend-mode", "object-fit", "object-position", "offset-distance",
                "offset-path", "offset-rotate", "opacity", "order", "orphans", "outline-color", "outline-offset", "outline-style", "outline-width", "overflow-anchor", "overflow-clip-margin", "overflow-wrap", "overflow-x", "overflow-y", "overscroll-behavior-block", "overscroll-behavior-inline",
                "padding-block-end", "padding-block-start", "padding-bottom", "padding-inline-end", "padding-inline-start", "padding-left", "padding-right", "padding-top", "paint-order", "perspective", "perspective-origin", "pointer-events", "position", "r", "resize", "right", "row-gap", "ruby-position",
                "rx", "ry", "scroll-behavior", "scroll-margin-block-end", "scroll-margin-block-start", "scroll-margin-inline-end", "scroll-margin-inline-start", "scroll-padding-block-end", "scroll-padding-block-start", "scroll-padding-inline-end", "scroll-padding-inline-start",
                "shape-image-threshold", "shape-margin", "shape-outside", "shape-rendering", "speak", "stop-color", "stop-opacity", "stroke", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "stroke-width", "tab-size", "table-layout",
                "text-align", "text-align-last", "text-anchor", "text-decoration", "text-decoration-color", "text-decoration-line", "text-decoration-skip-ink", "text-decoration-style", "text-indent", "text-overflow", "text-rendering", "text-shadow", "text-size-adjust", "text-transform",
                "text-underline-position", "top", "touch-action", "transform", "transform-origin", "transform-style", "transition-delay", "transition-duration", "transition-property", "transition-timing-function", "unicode-bidi", "user-select", "vector-effect", "vertical-align", "visibility",
                "white-space", "widows", "width", "will-change", "word-break", "word-spacing", "writing-mode", "x", "y", "z-index", "zoom", "-webkit-app-region", "-webkit-border-horizontal-spacing", "-webkit-border-image", "-webkit-border-vertical-spacing", "-webkit-box-align",
                "-webkit-box-decoration-break", "-webkit-box-direction", "-webkit-box-flex", "-webkit-box-ordinal-group", "-webkit-box-orient", "-webkit-box-pack", "-webkit-box-reflect", "-webkit-font-smoothing", "-webkit-highlight", "-webkit-hyphenate-character", "-webkit-line-break",
                "-webkit-line-clamp", "-webkit-locale", "-webkit-mask-box-image", "-webkit-mask-box-image-outset", "-webkit-mask-box-image-repeat", "-webkit-mask-box-image-slice", "-webkit-mask-box-image-source", "-webkit-mask-box-image-width", "-webkit-mask-clip", "-webkit-mask-composite",
                "-webkit-mask-image", "-webkit-mask-origin", "-webkit-mask-position", "-webkit-mask-repeat", "-webkit-mask-size", "-webkit-print-color-adjust", "-webkit-rtl-ordering", "-webkit-tap-highlight-color", "-webkit-text-combine", "-webkit-text-decorations-in-effect",
                "-webkit-text-emphasis-color", "-webkit-text-emphasis-position", "-webkit-text-emphasis-style", "-webkit-text-fill-color", "-webkit-text-orientation", "-webkit-text-security", "-webkit-text-stroke-color", "-webkit-text-stroke-width", "-webkit-user-drag", "-webkit-user-modify", "-webkit-writing-mode"};

        for (int i = 0; i < cssStyleAttributes.length; i++) {
            js.executeScript("let styleList = window.getComputedStyle(arguments[0]); let propertyValue = styleList.getPropertyValue(arguments[1]);console.log(propertyValue);document.getElementById('dummyElement').innerHTML=propertyValue;", element, cssStyleAttributes[i]);
            String result = driver.findElement(By.id("dummyElement")).getAttribute("innerHTML");
            if (!result.equals("")) {
                styles.put(cssStyleAttributes[i], result);
            }
        }
        return styles;
    }

    public static String getStyleAttribute(WebDriver driver, WebElement element, String cssProperty) {
        if (driver.toString().contains("null")) {
            return "WebDriver is null. Check your code!";
        }
        if (element.toString().contains("null")) {
            return "WebElement parameter you entered is null";
        }
        String[] cssStyleAttributes = {"align-content", "align-items", "align-self", "alignment-baseline", "animation-delay", "animation-direction", "animation-duration", "animation-fill-mode", "animation-iteration-count", "animation-name", "animation-play-state", "animation-timing-function",
                "appearance", "backdrop-filter", "backface-visibility", "background-attachment", "background-blend-mode", "background-clip", "background-color", "background-image", "background-origin", "background-position", "background-repeat", "background-size", "baseline-shift", "block-size",
                "border-block-end-color", "border-block-end-style", "border-block-end-width", "border-block-start-color", "border-block-start-style", "border-block-start-width", "border-bottom-color", "border-bottom-left-radius", "border-bottom-right-radius", "border-bottom-style",
                "border-bottom-width", "border-collapse", "border-end-end-radius", "border-end-start-radius", "border-image-outset", "border-image-repeat", "border-image-slice", "border-image-source", "border-image-width", "border-inline-end-color", "border-inline-end-style",
                "border-inline-end-width", "border-inline-start-color", "border-inline-start-style", "border-inline-start-width", "border-left-color", "border-left-style", "border-left-width", "border-right-color", "border-right-style", "border-right-width", "border-start-end-radius",
                "border-start-start-radius", "border-top-color", "border-top-left-radius", "border-top-right-radius", "border-top-style", "border-top-width", "bottom", "box-shadow", "box-sizing", "break-after", "break-before", "break-inside", "buffered-rendering", "caption-side", "caret-color",
                "clear", "clip", "clip-path", "clip-rule", "color", "color-interpolation", "color-interpolation-filters", "color-rendering", "column-count", "column-gap", "column-rule-color", "column-rule-style", "column-rule-width", "column-span", "column-width", "content", "cursor", "cx", "cy", "d",
                "direction", "display", "dominant-baseline", "empty-cells", "fill", "fill-opacity", "fill-rule", "filter", "flex-basis", "flex-direction", "flex-grow", "flex-shrink", "flex-wrap", "float", "flood-color", "flood-opacity", "font-family", "font-kerning", "font-optical-sizing", "font-size",
                "font-stretch", "font-style", "font-variant", "font-variant-caps", "font-variant-east-asian", "font-variant-ligatures", "font-variant-numeric", "font-weight", "grid-auto-columns", "grid-auto-flow", "grid-auto-rows", "grid-column-end", "grid-column-start", "grid-row-end",
                "grid-row-start", "grid-template-areas", "grid-template-columns", "grid-template-rows", "height", "hyphens", "image-orientation", "image-rendering", "inline-size", "inset-block-end", "inset-block-start", "inset-inline-end", "inset-inline-start", "isolation", "justify-content",
                "justify-items", "justify-self", "left", "letter-spacing", "lighting-color", "line-break", "line-height", "list-style-image", "list-style-position", "list-style-type", "margin-block-end", "margin-block-start", "margin-bottom", "margin-inline-end", "margin-inline-start", "margin-left",
                "margin-right", "margin-top", "marker-end", "marker-mid", "marker-start", "mask-type", "max-block-size", "max-height", "max-inline-size", "max-width", "min-block-size", "min-height", "min-inline-size", "min-width", "mix-blend-mode", "object-fit", "object-position", "offset-distance",
                "offset-path", "offset-rotate", "opacity", "order", "orphans", "outline-color", "outline-offset", "outline-style", "outline-width", "overflow-anchor", "overflow-clip-margin", "overflow-wrap", "overflow-x", "overflow-y", "overscroll-behavior-block", "overscroll-behavior-inline",
                "padding-block-end", "padding-block-start", "padding-bottom", "padding-inline-end", "padding-inline-start", "padding-left", "padding-right", "padding-top", "paint-order", "perspective", "perspective-origin", "pointer-events", "position", "r", "resize", "right", "row-gap", "ruby-position",
                "rx", "ry", "scroll-behavior", "scroll-margin-block-end", "scroll-margin-block-start", "scroll-margin-inline-end", "scroll-margin-inline-start", "scroll-padding-block-end", "scroll-padding-block-start", "scroll-padding-inline-end", "scroll-padding-inline-start",
                "shape-image-threshold", "shape-margin", "shape-outside", "shape-rendering", "speak", "stop-color", "stop-opacity", "stroke", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "stroke-width", "tab-size", "table-layout",
                "text-align", "text-align-last", "text-anchor", "text-decoration", "text-decoration-color", "text-decoration-line", "text-decoration-skip-ink", "text-decoration-style", "text-indent", "text-overflow", "text-rendering", "text-shadow", "text-size-adjust", "text-transform",
                "text-underline-position", "top", "touch-action", "transform", "transform-origin", "transform-style", "transition-delay", "transition-duration", "transition-property", "transition-timing-function", "unicode-bidi", "user-select", "vector-effect", "vertical-align", "visibility",
                "white-space", "widows", "width", "will-change", "word-break", "word-spacing", "writing-mode", "x", "y", "z-index", "zoom", "-webkit-app-region", "-webkit-border-horizontal-spacing", "-webkit-border-image", "-webkit-border-vertical-spacing", "-webkit-box-align",
                "-webkit-box-decoration-break", "-webkit-box-direction", "-webkit-box-flex", "-webkit-box-ordinal-group", "-webkit-box-orient", "-webkit-box-pack", "-webkit-box-reflect", "-webkit-font-smoothing", "-webkit-highlight", "-webkit-hyphenate-character", "-webkit-line-break",
                "-webkit-line-clamp", "-webkit-locale", "-webkit-mask-box-image", "-webkit-mask-box-image-outset", "-webkit-mask-box-image-repeat", "-webkit-mask-box-image-slice", "-webkit-mask-box-image-source", "-webkit-mask-box-image-width", "-webkit-mask-clip", "-webkit-mask-composite",
                "-webkit-mask-image", "-webkit-mask-origin", "-webkit-mask-position", "-webkit-mask-repeat", "-webkit-mask-size", "-webkit-print-color-adjust", "-webkit-rtl-ordering", "-webkit-tap-highlight-color", "-webkit-text-combine", "-webkit-text-decorations-in-effect",
                "-webkit-text-emphasis-color", "-webkit-text-emphasis-position", "-webkit-text-emphasis-style", "-webkit-text-fill-color", "-webkit-text-orientation", "-webkit-text-security", "-webkit-text-stroke-color", "-webkit-text-stroke-width", "-webkit-user-drag", "-webkit-user-modify", "-webkit-writing-mode"};
        int count = 0;
        for (int i = 0; i < cssStyleAttributes.length; i++) {
            if (cssProperty.equals(cssStyleAttributes[i])) {
                count++;
                break;
            }
        }
        if (count == 0) {
            return "No such css property in css :" + cssProperty + "! Consider fixing this parameter value";
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String createDummyElementToHoldData = "let dummyElement = document.createElement('p');dummyElement.id = 'dummyElement';dummyElement.style.visibility = 'hidden';document.body.appendChild(dummyElement)";
        js.executeScript(createDummyElementToHoldData);
        js.executeScript("let styleList = window.getComputedStyle(arguments[0]); let propertyValue = styleList.getPropertyValue(arguments[1]);console.log(propertyValue);document.getElementById('dummyElement').innerHTML=propertyValue;", element, cssProperty);
        String result = driver.findElement(By.id("dummyElement")).getAttribute("innerHTML");
        if (result.equals(""))
            return "The css property :" + cssProperty + " of the element has no value ";
        return result;
    }

    public static String getAnyStyleAttribute(WebDriver driver, WebElement element, String cssProperty) {
        //This method doesn't check whether 'cssProperty' parameter is valid or not
        if (driver.toString().contains("null")) {
            return "WebDriver is null. Check your code!";
        }
        if (element.toString().contains("null")) {
            return "WebElement parameter you entered is null";
        }
        //This method combines Java, Selenium and Javascript to get the computed value of any given
        //style attribute of any element that is to be given as a parameter to this method

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String createDummyElementToHoldData = "let dummyElement = document.createElement('p');dummyElement.id = 'dummyElement';dummyElement.style.visibility = 'hidden';document.body.appendChild(dummyElement)";
        js.executeScript(createDummyElementToHoldData);
        js.executeScript("let styleList = window.getComputedStyle(arguments[0]); let propertyValue = styleList.getPropertyValue(arguments[1]);console.log(propertyValue);document.getElementById('dummyElement').innerHTML=propertyValue;", element, cssProperty);
        String result = driver.findElement(By.id("dummyElement")).getAttribute("innerHTML");
        if (result.equals(""))
            return "No such value";
        return result;
    }
}
